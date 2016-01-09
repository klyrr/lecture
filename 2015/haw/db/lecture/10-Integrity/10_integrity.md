autoscale: true
footer: Tina Umlandt, 2015
slidenumbers: true

---

# *Fragen*
# [fit] *zur Probeklausur*

---

# Wiederholung

---

```
CREATE VIEW BOHRMASCHINEN (NR, EINKAUFSWERT, AKTUELLER_WERT)
AS
SELECT MNR, NEUWERT, ZEITWERT
FROM MASCHINE
WHERE NAME='Bohrmaschine';

SELECT *
FROM BOHRMASCHINEN WHERE AKTUELLER_WERT > 16000;
```

---

# Aufgaben

1. Erstellen Sie eine View, die nur Maschinen enthält, deren Zeitwert weniger als 60% des Neuwerts ist

2. Erstellen Sie eine View mit Mitarbeitern, die mehr als 3000,- verdienen

---

# Los geht's `\o/`

---

# Integrität

---

# Integrität und `ACID`

^ Art der Integrität vs Transaktionseigenschaft

---

##  Semantische Integrität

### C (Consistency, Konsistenz)

^ realisierende DBS-Komponente: (Semantische) Integritätskontrolle
anwendungsspezifische Bedingungen von Datenbankänderungen respektiert werden und wie auf Verletzungen der Integritätsbedingungen reagiert wird

---

## Physische Integrität
### D (Dauerhaftigkeit)
### A (Atomarität)

^ realisierende DBS-Komponente: Logging, Recovery

----

## Ablaufintegrität
### I (Isolation)

^ realisierende DBS-Komponente: Synchronisation (z. B. Sperrverwaltung)

---

## [fit] Integritätsbedingungen

^ ergeben sich aus den Geschäftsregeln der Datenbanknutzer

---

# Beispiele

---

> Überziehungen der Girokonten von Studenten sind nur bis 10.000 EUR gestattet

---

> Die Summe aller Konten ist stets null

---

> Änderungen von Konten sind pro Transaktion auf 10 Mio. begrenzt

---

# [fit] Integritätssicherungskomponente

^ Für die Überwachung der Integrität

---

# Möglichkeiten

^ als Komponente in der Systemarchitektur

---

# [fit] *1. Programmcode*

---

![fit](../images/Integritaet1.png)

---

## *Vorteile*

---

### Flexibilität der Programmiersprache

---

### Unabhängig vom DBMS

---

## *Nachteile*

---

### keine zentrale Kontrolle

^ mehrere Anwendungen greifen auf DB zu
schlechte Wartbarkeit

---

### Redundanz

---

# *2. DBMS*

---

![fit](../images/Integritaet2.png)

^ direkt in der DBMS zusätzlich angeordnete Komponente (Monitor)
implementierungsunabhängigen Sprache des DBMS

---

## *Vorteile*

---

### Anwendungsunabhängig

---

### Redundanzfrei

---

## *Nachteil*

---

### Abhängig von Sprachmitteln des DBMS

^ Problem bei Migration

---

# [fit] *3. Schnittstelle*

---

![fit](../images/Integritaet3.png)

^ Kapselung der Integritätslogik
in „sicheren Transaktionsprogrammen“ integriert

---

## *Vorteile*

---

### Anwendungsunabhängig

---

### Redundanzfrei

---

### unabhängig vom DBMS

---

## *Nachteil*

---

### Gefahr, dass an Kapselung  „vorbeiprogrammiert“ wird

---

# Klassifikation

^ der Integritätsbedingungen

---

## > Granularität

^ Formulierung über ein Tupel, eine Relation, eine Datenbank usw.

---

## > Ausdrucksfähigkeit der Sprache

^ Berechnungsvollständige Sprache oder eingeschränkte Sprache (z.B. direkt in SQL formuliert)

---

## > Anzahl der betrachteten Datenbankzustände

^ Wird nur der aktuelle Datenbankzustand referenziert, oder werden (z.B.) sowohl der Datenbankzustand vor als auch nach einer Änderung referenziert?

---

## > Zeitpunkt der Überprüfung

^ Gelten die Integritätsbedingungen immer, also nach jeder Operation, oder nur z.B. am Ende jeder Transaktion?

---

## > Reaktion

^ Werden die integritätsverletzenden Transaktionen abgebrochen oder wird flexibel reagiert?

---

> Beispiel für Klassifikation von Integritätsbedingungen

---

> Überziehungen der Girokonten von Studenten sind nur bis 10.000 EUR gestattet

Granularität: Tupel
Ausdrucksfähigkeit: SQL
ein DB-Zustand
Zeitpunkt: immer
Reaktion: Abbrechen

---

> Die Summe aller Konten ist stets Null.

Granularität: Relation
Ausdrucksfähigkeit: SQL
ein DB-Zustand
Zeitpunkt: Transaktionsende
Reaktion: Abbrechen

---

> Änderungen von Konten sind pro Transaktion auf 10 Mio. begrenzt

Granularität: Tupel
Ausdrucksfähigkeit: SQL
zwei DB-Zustände
Zeitpunkt: Transaktionsende
Reaktion: abbrechen

---

# [fit] Formulierung
# [fit] von Integritätsbedingungen

---

## Inhärente
## [fit] Integritätsbedingungen

^ Inhärente: implizit

---

### > Typintegrität

^ Attributen werden Typen zugeordnet

---

### > Schlüsselintegrität

^ Jede Relation hat genau einen Primärschlüssel

----

### > Referentielle Integrität

^ Die Angabe eines Fremdschlüssels ist möglich

---

## Explizite
## [fit] Integritätsbedingungen

---

### > `NULL` / `NOT NULL`

^ Für jedes Attribut kann angegeben werden, ob `NULL` verboten ist (`NOT NULL`)

---

### > `PRIMARY KEY`

^ erlaubt die Angabe eines Primärschlüssels pro Relation

---

### > `FOREIGN KEY (<Attribute>) REFERENCES <tabelle> (<Attribute>)`

^ erlaubt die Angabe einer Fremdschlüsselbedingung
Einträge dürfen nur existieren, wenn sie in der andern Tabelle auch da sind

---

### > `CHECK (Suchbedingung)`

^ erlaubt die Angabe einer attributspezifischen Bedingung
Beispiel

---

```
CREATE TABLE divisions  
   (div_no    NUMBER  CONSTRAINT check_divno
              CHECK (div_no BETWEEN 10 AND 99)
              DISABLE,
    div_name  VARCHAR2(9)  CONSTRAINT check_divname
              CHECK (div_name = UPPER(div_name))
              DISABLE,
    office    VARCHAR2(10)  CONSTRAINT check_office
              CHECK (office IN ('DALLAS','BOSTON',
              'PARIS','TOKYO'))
              DISABLE);

```
oracle[^1]

[^1]: https://docs.oracle.com/cd/B19306_01/server.102/b14200/clauses002.htm#i1002719

---

# Trigger

^ siehe Klassifikationen
Regeln, die in der Datenbank gespeichert werden
werden automatisch beim Eintritt von Ereignissen angewandt
ECA-Regeln (Event-Condition-Action)
Beim Eintreten des Ereignisses wird die Bedingung überprüft, und wenn diese „wahr“ ergibt, wird die Aktion ausgeführt.

---

```
CREATE OR REPLACE TRIGGER Print_maschine_changes
  BEFORE DELETE OR INSERT OR UPDATE ON maschine
  FOR EACH ROW
WHEN (new.ZEITWERT > 0)
DECLARE
    zeitwert_diff number;
BEGIN
    zeitwert_diff := :new.ZEITWERT  - :old.ZEITWERT;
    dbms_output.put_line('Alter Zeitwert: ' || :old.ZEITWERT);
    dbms_output.put_line('Neuer Zeitwert: ' || :new.ZEITWERT);
    dbms_output.put_line(' -> Differenz: ' || zeitwert_diff);
END;
/
```

^ https://stackoverflow.com/questions/1079949/when-do-i-need-to-use-a-semicolon-vs-a-slash-in-oracle-sql

---

## *Ereignisse*

---

### `INSERT, UPDATE, DELETE`

^ DML - data manipulation language

---

### `CREATE, ALTER, DROP`

^ DDL - data definition language

---

```
CREATE OR REPLACE TRIGGER drop_trigger
   BEFORE DROP ON KIND
   BEGIN
      RAISE_APPLICATION_ERROR (
         num => -20000,
         msg => 'Cannot drop KIND table!!11elf');
   END;
/
```

---

### Datenbankinterne Ereignisse

^ wie Start der DB, Logon eines Benutzer etc.

---

## *Zeitpunkte*

---

### `before` / `after`

^ Trigger können vor (before), nach (after) des Ereignisses reagieren

---

### `instead of`

^ Anstatt-Trigger (instead of) führen den Aktionsteil des Triggers statt des ursprünglichen Befehls aus (Horror beim „Debugging“...)

---

## *Eigenschaften*

---

### `referencing (new|old) as`

^ Man kann in dem Trigger auf den Wert von Attributen vor und nach einer Änderung zugreifen

---

## *Level*

^ Anweisung vs Reihe

---

### `for each (statement|row)`

^ einmal pro DML-Anweisung / einmal pro betroffenen Tupel

---

```
CREATE TRIGGER gehalt_neu_upd_bef
BEFORE update on GEHALT
for each row
when (new.BETRAG / old.BETRAG > 1.1 ) BEGIN
	insert into GEHALT_ALT
	values (:old.GEH_STUFE, :old.BETRAG);
END;
```

^ Es sollen alle Gehaltserhöhungen kontrolliert werden, die über 10% ausfallen.

---

# Reihenfolge

---

> 1 . Ausführung von `BEFORE` - Anweisungstrigger

---

> 2 . Ausführung von `BEFORE` - Zeilentrigger

---

> 3 . Ausführung des eigentlichen SQL-Statements

---

> 4 . Abarbeitung der `AFTER` - Zeilentrigger für jede Zeile

---

*Die Punkte 2. bis 4. wiederholen sich jetzt so oft wie Zeilen betroffen sind*

---

> 5 . Ausführung der `AFTER` - Anweisungstrigger

---

# Syntax

---

```
CREATE [OR REPLACE] TRIGGER [user.]triggername
{BEFORE |AFTER| INSTEAD OF}
{INSERT | UPDATE [OF column [, column] ... ] | DELETE}
[OR {INSERT | UPDATE [OF column [, column] ... ] | DELETE} ]
ON [user. ] {TABLE | VIEW}
[FOR EACH {ROW | STATEMENT}]
[WHEN Bedingung]
Anweisungsblock
```

---

```
CREATE TRIGGER gehalt_upd_ins
BEFORE insert OR update on GEHALT
for each row
BEGIN
  IF INSERTING THEN
    insert into GEHALT_ALT
    values (:new.GEH_STUFE, :new.BETRAG);
  ELSE -- not inserting, then we are updating BETRAG
    insert into GEHALT_ALT
    values (:old.GEH_STUFE, :old.BETRAG);
  END IF;
END;
/
```

---

# Mehr Beispiele

---

```
CREATE TABLE verlauf (
datum   date ,
pnr number(4),
pnr_neu number(4)
);

CREATE OR REPLACE TRIGGER verlauf_tr
BEFORE UPDATE ON personal
FOR EACH ROW
BEGIN
  INSERT INTO verlauf (datum, pnr, pnr_neu)
  VALUES (sysdate, :old.pnr, :new.pnr);
END;
/
```

---


```
SELECT *
FROM verlauf;

UPDATE PERSONAL
SET PNR=500 WHERE PNR=177;

SELECT *
FROM verlauf;
```

---

```
ALTER TABLE personal ADD  geh_betrag int;
UPDATE PERSONAL SET geh_betrag = (
	SELECT betrag FROM gehalt WHERE gehalt.geh_stufe=PERSONAL.geh_stufe
);

CREATE OR REPLACE TRIGGER personal_gehalt
BEFORE UPDATE ON personal
FOR EACH ROW
DECLARE
  neuer_betrag number;
BEGIN
  SELECT betrag
  into neuer_betrag
  FROM gehalt
  WHERE geh_stufe=:NEW.geh_stufe;
  :NEW.geh_betrag := neuer_betrag;
END;
/
```

---

# Aufgaben

1. Schreiben Sie einen Trigger, der bei einer Änderung des Zeitwerts der Maschinen den Verlust in Prozent angibt
2. Wenn einem Mitarbeiter ein Kind hinzugfügt wird, soll sie automatisch eine Prämie in Höhe von 300,- bekommen.
3. Alle Updates der Zeitwerte der Tabelle `MASCHINE` sollen in einer neuen Tabelle `MASCHINE_LOG` protokoliert werden: alter und neuer Wert und Datum

---

# Das war's für heute
![fit](../images/Rainbow_Dash.png)
