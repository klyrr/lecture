package com.haw.praktikum.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.haw.praktikum.Main;

public class DatabaseConnector {

    private static final String DB_PROPERTIES_FILENAME = "db.properties";
    
    private final Properties defaultProps = new Properties();

    public DatabaseConnector() throws IOException {
        initProperties(defaultProps);
    }

    /**
     * Erstellt eine Verbindung zur Datenbank.
     * 
     * @return die Verbindung
     * @throws SQLException 
     */
    public Connection create() throws SQLException {

        final String username = defaultProps.getProperty("DB_USERNAME");
        final String password = defaultProps.getProperty("DB_PASSWORD");

        return DriverManager.getConnection("jdbc:oracle:thin:@ora14.informatik.haw-hamburg.de:1521:inf14", username, password);
    }

    /**
     * Initialisiert die Properties mit den gegebenen Eintraegen.
     * 
     * @param defaultProps
     * @throws IOException
     */
    private void initProperties(final Properties defaultProps) throws IOException {

        final InputStream propertiesInputStream = Main.class.getClassLoader().getResourceAsStream(DB_PROPERTIES_FILENAME);
        defaultProps.load(propertiesInputStream);
        propertiesInputStream.close();
    }
}
