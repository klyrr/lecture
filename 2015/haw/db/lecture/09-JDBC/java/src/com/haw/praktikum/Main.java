package com.haw.praktikum;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Properties;

import com.haw.praktikum.model.Gehaltsstufe;
import com.haw.praktikum.model.Personal;

public final class Main {

    private static final String DB_PROPERTIES_FILENAME = "db2.properties";
    
    public static void main(final String[] args) {

        try {
            final Properties defaultProps = new Properties();
            final InputStream propertiesInputStream = Main.class.getClassLoader().getResourceAsStream(DB_PROPERTIES_FILENAME);
            defaultProps.load(propertiesInputStream);
            propertiesInputStream.close();
            
            
            
            final String username = defaultProps.getProperty("DB_USERNAME");
            final String password = defaultProps.getProperty("DB_PASSWORD");

            final Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@ora14.informatik.haw-hamburg.de:1521:inf14", username, password);
            
            
            
            printAllPersonal(connection);

            System.out.println("-----------------");

            printAllPersonalWithGivenGehaltsstufe(connection, Gehaltsstufe.IT2);

            System.out.println("-----------------");
            
            insertGehaltsstufe(connection, Gehaltsstufe.IT6, 4242);

            System.out.println("Done.");
        } catch (final Exception e) {
            System.err.print(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Gibt alle Eintraege der Tabelle PERSONAL auf der Konsole aus.
     * 
     * @param connection
     * @throws SQLException
     */
    private static void printAllPersonal(final Connection connection) throws SQLException {
        
        final ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM PERSONAL");
        while (resultSet.next()) {
            final String vorname = resultSet.getString("VORNAME");
            final String nachname = resultSet.getString("NACHNAME");
            final String gehaltsstufeAsString = resultSet.getString("GEH_STUFE");
            
            final Gehaltsstufe gehaltsstufe = Gehaltsstufe.create(gehaltsstufeAsString);
            final Personal personal = new Personal(vorname, nachname, gehaltsstufe);
            
            System.out.println(personal);
        }
    }

    /**
     * Gibt alle Mitarbeiter einer Gehaltsstufe mit Vorname und Nachname und der Gehaltsstufe aus.
     * 
     * @param connection
     * @param gehaltsstufe
     * @throws SQLException
     */
    private static void printAllPersonalWithGivenGehaltsstufe(final Connection connection, final Gehaltsstufe gehaltsstufe) throws SQLException {
        
        final String selectStatement = String.format("SELECT * FROM PERSONAL NATURAL JOIN GEHALT WHERE GEH_STUFE=\'%s\' order by 1", gehaltsstufe.toString());
        
        System.out.println(selectStatement);
        
        final ResultSet resultSet = connection.createStatement().executeQuery(selectStatement);

        while (resultSet.next()) {
            System.out.println(String.format("%s %s - %s", 
                    resultSet.getString("VORNAME"), 
                    resultSet.getString("NACHNAME"),
                    resultSet.getString("GEH_STUFE")));
        }
    }

    /**
     * Fuegt eine neue Gehaltsstufe in die Datenbank ein.
     * 
     * @param connection
     * @param gehaltsstufe
     * @param betrag
     * @throws SQLException
     */
    private static void insertGehaltsstufe(final Connection connection, final Gehaltsstufe gehaltsstufe, final int betrag) throws SQLException {
        
        final String insertNewValue = String.format("INSERT INTO GEHALT VALUES(\'%s\', %s)", gehaltsstufe.toString(), betrag);
  
        try {
            final int rowCount = connection.createStatement().executeUpdate(insertNewValue);
            if (rowCount == 1) {
                System.out.println("Erfolgreich.");
            } else {
                System.err.println("Fehler");
            }
        } catch (final SQLIntegrityConstraintViolationException e) {
            System.err.println("Den Eintrag gibt es schon.");
        }   
    }
}
