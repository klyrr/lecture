package com.haw.praktikum.database;

/**
 * Eine Datei mit Konstanten fuer die Datenbankzugriffen.
 */
public interface DBConstants {

    /**
     * Konstanten fuer die PERSONAL - Tabelle und die dazugehoerige Sequence.
     */
    interface Personal {
        String TABLE_NAME = "PERSONAL";
        String SEQUENCE_NAME = "PERSONAL_SEQ";
        
        String COLUMN_VORNAME = "VORNAME";
        String COLUMN_NACHNAME = "NACHNAME";
        String COLUMN_GEH_STUFE = "GEH_STUFE";

        String SELECT_ALL = String.format("select * from %s order by 1", TABLE_NAME);
    }
    
    /**
     * Konstanten fuer die GEHALT - Tabelle
     */
    interface Gehalt {
        String TABLE_NAME = "GEHALT";
        String COLUMN_GEH_STUFE = "GEH_STUFE";
        String COLUMN_BETRAG = "BETRAG";
    }
}
