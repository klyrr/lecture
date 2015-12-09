package com.haw.praktikum;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.haw.praktikum.database.DBConstants;
import com.haw.praktikum.database.DatabaseConnector;
import com.haw.praktikum.model.Gehaltsstufe;
import com.haw.praktikum.model.Personal;

public final class Main {

    public static void main(final String[] args) {

        try {
            final DatabaseConnector connector = new DatabaseConnector();
            final Connection connection = connector.create();

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
        final ResultSet resultSet = connection.createStatement().executeQuery(DBConstants.Personal.SELECT_ALL);
        while (resultSet.next()) {
            final String vorname = resultSet.getString(DBConstants.Personal.COLUMN_VORNAME);
            final String nachname = resultSet.getString(DBConstants.Personal.COLUMN_NACHNAME);
            final Gehaltsstufe gehaltsstufe = Gehaltsstufe.create(resultSet.getString(DBConstants.Personal.COLUMN_GEH_STUFE));
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
        final ResultSet resultSet = connection.createStatement().executeQuery(String.format("select * from %s NATURAL JOIN %s WHERE %s=\'%s\' order by 1", DBConstants.Personal.TABLE_NAME,
                DBConstants.Gehalt.TABLE_NAME, DBConstants.Personal.COLUMN_GEH_STUFE, gehaltsstufe.toString()));

        while (resultSet.next()) {
            System.out.println(String.format("%s %s - %s", 
                    resultSet.getString(DBConstants.Personal.COLUMN_VORNAME), 
                    resultSet.getString(DBConstants.Personal.COLUMN_NACHNAME),
                    resultSet.getString(DBConstants.Gehalt.COLUMN_GEH_STUFE)));
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
        
        final String insertNewValue = String.format("INSERT INTO %s VALUES(\'%s\', %s)", DBConstants.Gehalt.TABLE_NAME, gehaltsstufe.toString(), betrag);
  
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
