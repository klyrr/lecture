autoscale: true
footer: Tina Umlandt, 2015
slidenumbers: true

---

#[fit] Wiederholung
### *(unter anderem)*

---

# ER-Modelle

---

# Aufgabe

Erstellen Sie ein ER-Modell aus folgenden Relationen

```
Haus = ({Strasse, Hausnummer, Stockwerk, HausId}, {HausId})
Stock = ({StockId, Name, Etage, HausID}, {StockId})
Zimmer = ({Name, StockId, ZimmerId, Fensteranzahl}, {ZimmerId})
Flur = ({FlurId, StockId, Name}, {FlurId})
Zimmer_Flur = ({ZimmerId, FlurId}, {ZimmerId, FlurId})
```

Wird `*Id` in einer anderen Relation benutzt, liegt hier eine Fremdschlüsselbeziehung vor

---

# `PL-SQL`

---

#Beispiel
Das Gehalt der Mitarbeiter einer Verkaufsabteilung setzt sich aus einem Festgehalt (aktuell 3000 €) und einem variablen Anteil (aktuell 0,987% des Monatsumsatzes) zusammen. Zwei Tabellen sind eingerichtet:

`T_UMSATZ` mit einer Spalte `umsatz`
`T_GEHALT` mit den Spalten `umsatz` und `gehalt`

---

```
DECLARE
  festgehalt constant pls_integer := 3000;
  prozentualer_anteil constant number(7,5) := 0.00987;
  umsatz pls_integer;
  gehalt number(10,2);
BEGIN
  umsatz := 90000;
  gehalt := festgehalt + prozentualer_anteil * umsatz;
  INSERT INTO T_GEHALT VALUES (umsatz, gehalt);
END;
/
```

---

```
SELECT *
FROM T_GEHALT

 umsatz | gehalt
---------------
  90000 | 3888,30
```

---

```
DECLARE
  < Deklarationsteil>
BEGIN
  <Ausführungsteil>
EXCEPTION
  < Ausnahmebehandlung>
END;

```

^ Deklarationsteil: Ausführungsteil:
Ausnahmebehandlung:
Definition und Initialisierung der im Block benutzten Variablen und Cursors
Wertzuweisungen, Operationen und Kontrollflussanweisungen liefert eine speziell angepasste Fehlerbehandlung

---

## Datentypen

---

```
BOOLEAN           Wahrheitswerte, zulässig sind TRUE, FALSE oder NULL

BINARY-INTEGER/   Integer-Werte zwischen -2147483647 bis 2147483647
PLS_INTEGER                   

NATURAL           Integer-Werte zwischen 0 bis 2147483647

POSITIVE          Integer-Werte zwischen 1 bis 2147483647

VARCHAR2(n)       String
```

---

```
DECLARE
  meine_zahl pls_integer;
  der_text VARCHAR2(50);
```

---

## impliziter Datentyp

---

```
DECLARE
  nummer personal.pnr%type;
```

^ Vorteil dieser Art der Typ-Definition liegt in ihrer Flexibilität.

---

# Initialisierung

```
DECLARE
  nummer personal.pnr%type;
  zahl integer := 167;
  info varchar2(50) := 'hahn';

BEGIN
  SELECT PNR
  INTO nummer
  FROM PERSONAL
  WHERE NACHNAME="Euler"
END;
/
```

---

##[fit] Kontrollflussanweisungen

---

### `IF`

---

```
IF Bedingung_1 THEN
    Anweisung 1;
    Anweisung 2;
    ...
ELSIF Bedingung_2 THEN
    Anweisung 3;
ELSE
    Anweisung 4;
    Anweisung 5;
END IF;

```

---

```
IF gehalt > 6000 THEN
    anweisung_1
ELSIF gehalt < 4000 THEN
    anweisung_2
ELSE
    anweisung_3
END IF;

```

---

### `FOR` - Schleife

---

```
FOR Zähler IN [REVERSE] Untergrenze..Obergrenze LOOP
    Anweisungsblock;
END LOOP;

for i in reverse 1..100 LOOP
    block;
END LOOP;
```

---

```
DECLARE
i integer;
BEGIN
  FOR i IN 300..399 LOOP
    INSERT INTO personal_neu (pnr, datum ) VALUES (i, SYSDATE);
  END LOOP;
END;
/
```

---

### `WHILE` - Schleife

---

```
WHILE Bedingung LOOP
    Anweisungsblock;
END LOOP;
```

---

### `NULL` - Anweisung

^ Die DB bekommt die Anweisung, nichts zu tun

---

```
IF i = 0 THEN
  i := i + 1;
ELSE
  NULL;
END IF;
```

---

# Aufgaben

1. Schreiben Sie eine Anweisung, die alle Nachnamen in der `KIND`-Tabelle groß schreiben

2. Schreiben Sie eine Anweisung, die den Zeitwert aller Maschinen um 10% verringert

^ https://docs.oracle.com/cd/E11882_01/appdev.112/e25519/controlstatements.htm#LNPLS388

---

# Trigger

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

## Exceptions werfen

---

```
raise_application_error(
      error_number, message[, {TRUE | FALSE}]);
```

*error_number*: Eine negative Zahl zwischen -20000 ... -20999
*message*: String bis zu 2048 Bytes

---

```
DECLARE
   num_tables NUMBER;
BEGIN
   SELECT COUNT(*) INTO num_tables FROM USER_TABLES;
   IF num_tables < 1000 THEN
      raise_application_error(-20101, 'Mindestens 1000 Tabellen erwartet.');
   ELSE
      NULL;
   END IF;
END;
/
```

---

# Aufgaben

1. Der Trigger soll alle Änderungen an Personen, die den Vornamen ändern, abbrechen.

2. Der Trigger soll eine Erhöhung um mehr als 10% an den Beträgen der Tabelle Gehalt verhindern.  

3. Der Trigger soll eine Erfolgsmeldung in den DBMS - Outout schreiben, wenn eine Tabelle erfolgreich angelegt wurde.

4. Der Trigger soll eine zusätzliche Prämie von 50,- eintragen, wenn die Prämie unter 100,- ist. Ist die Prämie über 200,-, soll der Betrag auf 200,- gedeckelt werden.

5. Der Trigger soll verhindern, dass Personen, die Kinder haben, unter die Gehaltsklasse 'it2' aktualisiert werden können.

6. Der Trigger soll verhindern, dass in der Gehaltstabelle der Betrag für `it5` mehr als das Doppelte von `it1` werden kann.

7. Der Trigger soll verhindern, dass die Tabelle `Maschine` geändert werden kann.

---

# Aufgaben zu SQL

1. Der Schlüssel der Abteilungen soll umbenannt werden und durch einen numerischen Schlüssel ersetzt werden. Erstellen Sie die notwendigen SQL - Statements.

2. Löschen Sie alle volljährigen Kinder aus der Datenbank und schreiben Sie zusätzlich einen Trigger, der verhindert, dass volljährige Kinder in der Tabelle stehen können.

---

# Los geht's `\o/`

---

# *CAP*-Theorem

^ https://de.wikipedia.org/wiki/CAP-Theorem

---

## *C* - Konsistenz

^ (C consistency)
 Die Konsistenz der gespeicherten Daten. In verteilten Systemen mit replizierten Daten muss sichergestellt sein, dass nach Abschluss einer Transaktion auch alle Replikate des manipulierten Datensatzes aktualisiert werden. Diese Konsistenz sollte nicht verwechselt werden mit der Konsistenz aus der ACID-Transaktionen, die nur die innere Konsistenz eines Datenbestandes betrifft.

---

## *A* - Verfügbarkeit

^ (A availability)
Die Verfügbarkeit im Sinne akzeptabler Antwortzeiten. Alle Anfragen an das System werden stets beantwortet.

---

## [fit] *P* - Partitionstoleranz

^ (P partition tolerance)
Die Ausfalltoleranz der Rechner-/Servernetze. Das System arbeitet auch bei Verlust von Nachrichten, einzelner Netzknoten oder Partition des Netzes weiter.

---

> In verteilten Systemen können nur zwei dieser drei Anforderungen gleichzeitig vollständig erfüllt werden
-- Brewer's Vermutung

![right fit](../images/CAP-theorem.png)

---

## *AP*

^ Domain Name System (DNS) oder Cloud Computing
Die Verfügbarkeit ist extrem hoch, ebenso Toleranz gegenüber dem Ausfall einzelner DNS-Server.
availability + Ausfalltoleranz

---

## *CA*

^ Relationales Datenbank Management System (RDBMS)
RDBMS-Cluster fällt meistens in die Kategorie CA
 Verfügbarkeit und Konsistenz aller Knote
 consistency + availability

---

## *CP*

^ Banking-Anwendungen
Konsistenz der Daten oberstes Gebot:
 Verfügbarkeit zweitrangig

---

![fit](../images/CAP.png)

---

## Lösung

---

> Basically Available, Soft State, Eventually Consistent (BASE)

^ eventual consistency, die besagt, dass ein Datensatz irgendwann konsistent sein wird, sofern nur eine hinreichend lange Zeit ohne Schreibvorgänge und Fehler vorausgesetzt werden kann.

---

> Konsistenz der Verfügbarkeit unterordnen

---



---

# *NoSQL*

^ Not only SQL
2009

---

## Typen

---

### Key-Value-Store

---

```
shop.settings.vat=19

shop.country="de_DE"
```

---

### *Beispiel: Redis*

^ https://github.com/antirez/redis

---

```
redis> ping
PONG
redis> set foo bar
OK
redis> get foo
"bar"
redis> incr mycounter
(integer) 1
redis> incr mycounter
(integer) 2
redis> get mycounter
"2"
```

---

### *Eigenschaften*

---

> Struktur der Daten ist nicht vorgegeben (schemalos)

---

> Datentyp ist nicht vorgegeben

---

> Queries sind auf Schlüssel begrenzt

---

> Einfache Skalierbarkeit

---

### Column store
### (Spaltenorientierte DB)

---

### *Eigenschaften*

---

> Inhalte spaltenweise statt zeilenweise abspeichert

---

```
001:10,Smith,Joe,40000;
002:12,Jones,Mary,50000;
003:11,Johnson,Cathy,44000;
004:22,Jones,Bob,55000;

```

^ zeilenorientiert, wie die meisten bekannten Datenbanksystem

---

```
10:001,12:002,11:003,22:004;
Smith:001,Jones:002,Johnson:003,Jones:004;
Joe:001,Mary:002,Cathy:003,Bob:004;
40000:001,50000:002,44000:003,55000:004;
```

---

> Performance-Vorteil bei Datenaggregationen

```
SELECT SUM(Gehalt) FROM PERSONAL_GEHALT;
UPDATE tabelle SET Gehalt = Gehalt * 1.03;
```

---

> Kompression der Daten

^ Spaltendaten haben immer einen einheitlichen Typ

---

### Graph databases

^ benutzt, um stark vernetzte Informationen darzustellen und abzuspeicher

---

### *Eigenschaften*

---

> Daten = Knoten
> Beziehungen der Daten zueinander = Kanten

---

> keine standardisierte Abfragesprache

---

![fit](../images/cypher-match-graph.png)

---

```
MATCH (movie:Movie)
RETURN movie
```

^ all the movies in the database
Beispiel von neo4j und cypher
http://neo4j.com/docs/snapshot/query-match.html

---

```
movie
-------------------------------------------------------------------------
Node[3]{title:"The American President",name:"TheAmericanPresident"}
-------------------------------------------------------------------------
Node[4]{name:"WallStreet",title:"Wall Street"}
-------------------------------------------------------------------------
2 rows

```

---

### Dokumenten-Orientiert

---
## Beispiel: CouchDB-Dokument
```
{
	"_id" : "00a271787f89c0ef2e10e88a0c0001f4"
	"_rev": "5509377776",
	"name": "Peter Lustig",
	"address": {
		"street": "Teststr.",
		"city": "Hamburg"
   }
}
```

---

### *Eigenschaften*

---

> Daten sind Dokumente, die nach einem bestimmten Datenformat (XML, JSON, etc) strukturiert sind

---

> Es kann auch nach Inhalten gesucht werden

---

> Anfragesprache abhängig vom Datenformat

---

^
Column: Accumulo, Cassandra, Druid, HBase, Vertica
Document: Apache CouchDB, Clusterpoint, Couchbase, DocumentDB, HyperDex, Lotus Notes, MarkLogic, MongoDB, OrientDB, Qizx, RethinkDB
Key-value: Aerospike, CouchDB, Dynamo, FairCom c-treeACE, FoundationDB, HyperDex, MemcacheDB, MUMPS, Oracle NoSQL Database, OrientDB, Redis, Riak
Graph: Allegro, InfiniteGraph, MarkLogic, Neo4J, OrientDB, Virtuoso, Stardog
Multi-model: Alchemy Database, ArangoDB, CortexDB, FoundationDB, MarkLogic, OrientDB

---

## *Nachstes* (und letztes) *Mal*

- Datenschutz
- Letzte Fragen zur Klausur

---

# Das war's für heute
# `#scnr`
![fit](../images/Rainbow_Dash.png)
