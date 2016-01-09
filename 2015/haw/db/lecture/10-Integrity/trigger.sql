-- 1. Schreiben Sie einen Trigger, der bei einer Änderung des Zeitwerts der Maschinen den Verlust in Prozent auf der Console ausgibt

CREATE OR REPLACE TRIGGER ZEITWERT_CHANGE
AFTER UPDATE ON MASCHINE
FOR EACH ROW
DECLARE
  percent number;
BEGIN
  percent := 1 - (:new.ZEITWERT / :old.ZEITWERT);
  dbms_output.put_line('Änderung Zeitwert: ' || (percent * 100));
END;
/

-- 2. Wenn einem Mitarbeiter ein Kind hinzugfügt wird, soll sie automatisch eine Prämie in Höhe von 300,- bekommen.

CREATE OR REPLACE TRIGGER MITARBEITER_KIND
AFTER INSERT ON KIND
FOR EACH ROW
BEGIN
  INSERT INTO PRAEMIE VALUES(:new.PNR, 300, sysdate);
END;
/

-- 3. Alle Updates der Zeitwerte der Tabelle `MASCHINE` sollen in einer neuen Tabelle `MASCHINE_LOG` protokoliert werden: alter und neuer Wert und Datum

CREATE SEQUENCE MASCHINE_LOG_SEQUENCE;

CREATE TABLE MASCHINE_LOG (
  ID INT PRIMARY KEY,
  OLD_ZEITWERT INT,
  NEW_ZEITWERT INT,
  MNR INT,
  CHANGED_ON DATE default sysdate
);

CREATE OR REPLACE TRIGGER MASCHINE_ZEITWERT_LOGGER
AFTER UPDATE OF ZEITWERT ON MASCHINE
FOR EACH ROW
BEGIN
  INSERT INTO MASCHINE_LOG (ID, OLD_ZEITWERT, NEW_ZEITWERT, MNR) VALUES(MASCHINE_LOG_SEQUENCE.NEXTVAL, :old.ZEITWERT, :new.ZEITWERT, :old.MNR);
END;
/
