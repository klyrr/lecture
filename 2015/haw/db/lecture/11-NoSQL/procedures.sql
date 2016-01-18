-- 1. Schreiben Sie eine Anweisung, die alle Nachnamen in der `KIND`-Tabelle groß schreiben

UPDATE KIND set NACHNAME = UPPER(NACHNAME);

-- 2. Schreiben Sie eine Anweisung, die den Zeitwert aller Maschinen um 10% verringert

UPDATE MASCHINE SET ZEITWERT = ZEITWERT * 0.9;

-- 3. Tragen Sie einen neuen Mitarbeiter ein, der in der Abteilung 'Verkauf' ist

DECLARE
  abt_nr PERSONAL.ABT_NR%type
BEGIN
  SELECT ABT_NR
  INTO abt_nr
  FROM ABTEILUNG
  WHERE name = 'Verkauf';

  INSERT INTO PERSONAL VALUES (777, 'Douglas', 'Adams', 'it1', abt_nr, 'aok');
END;
