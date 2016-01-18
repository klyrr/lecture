-- 1. Der Trigger soll alle Änderungen an Personen, die den Vornamen ändern, abbrechen.

CREATE OR REPLACE trigger vorname_aenderung
BEFORE UPDATE OF VORNAME ON PERSONAL
FOR EACH ROW
BEGIN
  :new.VORNAME := :old.vorname;
END;
/

-- 2. Der Trigger soll eine Erhöhung um mehr als 10% an den Beträgen der Tabelle Gehalt verhindern.

CREATE OR REPLACE TRIGGER gehalt_veraenderung
BEFORE UPDATE OF BETRAG ON GEHALT
FOR EACH ROW
DECLARE
  diff number;
BEGIN
  diff := :new.BETRAG / :old.BETRAG;
  IF diff > 1.1 THEN
    -- :new.BETRAG := :old.BETRAG * 1.1;
    raise_application_error(-20666, 'Erhoehung zu gross.');
  END IF;
END;
/

-- 3. Der Trigger soll eine Erfolgsmeldung in den DBMS - Outout schreiben, wenn eine Tabelle erfolgreich angelegt wurde.

CREATE OR REPLACE TRIGGER create_table_erfolg
AFTER CREATE ON SCHEMA
BEGIN
  dbms_output.put_line('YEAH \o\/');
END;
/

4. Der Trigger soll eine zusätzliche Prämie von 50,- eintragen, wenn die Prämie unter 100,- ist. Ist die Prämie über 200,-, soll der Betrag auf 200,- gedeckelt werden.

CREATE OR REPLACE TRIGGER max_praemie_trigger
BEFORE INSERT ON PRAEMIE
FOR EACH ROW
DECLARE
  max_praemie NUMBER :=200;
  min_praemie NUMBER := 100;
  additional_praemie NUMBER := 50;
BEGIN
IF :new.P_BETRAG < min_praemie THEN
  INSERT INTO PRAEMIE VALUES (:new.PNR, additional_praemie, :new.DATUM);
ELSIF :new.P_BETRAG > max_praemie THEN
  :new.P_BETRAG := max_praemie;
END IF;
  NULL;
END;
/

5. Der Trigger soll verhindern, dass Personen, die Kinder haben, unter die Gehaltsklasse 'it2' aktualisiert werden können.

CREATE OR REPLACE TRIGGER person_kind
BEFORE UPDATE OF GEH_STUFE ON PERSONAL
FOR EACH ROW
DECLARE
  anzahl_kinder pls_integer;
BEGIN
  SELECT count(*)
  INTO anzahl_kinder
  FROM KIND
  WHERE PNR=:new.PNR;

  IF :new.GEH_STUFE = 'it1' THEN
    IF anzahl_kinder > 0 THEN
      :new.GEH_STUFE := :old.GEH_STUFE;
    END IF;
  END IF;
END;
/
