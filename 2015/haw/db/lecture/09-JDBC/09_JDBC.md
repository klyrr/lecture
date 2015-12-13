autoscale: true
footer: Tina Umlandt, 2015
slidenumbers: true


---

# Wiederholung

---

#[fit] Transaktion

^ Operationen werden als Einheit betrachtet

---

# `ACID`

^ Bei der Ausführung von Transaktionen muss das Transaktionssystem die ACID-Eigenschaften garantieren:
Atomicity Consistency Isolation Durability

---

#[fit] Transaktionsverwaltung

---

### - Konsistenzsicherung
### - Recovery
##[fit] - Mehrbenutzersynchronisation
---

## [fit] Anomalien bei
## [fit] unkontrolliertem
## [fit] Mehrbenutzerbetrieb

---

## *Lost Update*

```
Zeit	Transaktion 1		Transaktion 2
----------------------------------------------
1		Lese Betrag			-
2		-				 	Lese Betrag
3 		Erhöhe Betrag um 1	-
4		-					Erhöhe Betrag um 1
5		Commit				-
6		- 					Commit

```

---

## *Uncommitted Dependency (Dirty Read)*

```
Zeit	Transaktion 1		Transaktion 2
------------------------------------------
1		Lese Betrag			-
2 		Erhöhe Betrag um 1	 -
3		-					Lese Betrag
4		Rollback			-
```

---

## *Inconsistency Read (Nonrepeatable Read)*

```
Zeit	Transaktion 1		Transaktion 2
-----------------------------------------------
1		Lese Haben_Konto	-
2 		-					Ändere Soll_Konto  
3		-					Ändere Haben_Konto
4		-					Commit
5		Lese Soll_Konto		-
6		Commit				-
```

---

## *Phantomdaten*

```
Zeit	Transaktion 1		Transaktion 2
------------------------------------------------
1		Lese Kontostand		-
2 		-					Ändere Kontostand
4		-					Commit
5		Lese Kontostand		-
6		Commit				-
```
---

# Locks

---

## Read locks
## (shared)

^ Lesen können mehrere Transaktionen gleichzeitig

---

## Write locks
## (exclusive)

^ Schreiben darf nur eine Transaktion gleichzeitig

---

#[fit] Zwei-Phasen-
#[fit] Sperrprotokoll

^ Regeln, wie Transaktionen sich Locks holen

---

# Los geht's `\o/`

---

# `CREATE VIEW`

^ Fuer haeufige Suchabfragen
aus einer Basistabelle abgeleitete virtuelle Tabelle

---

```
CREATE VIEW
   SELECT - Anweisung;

REPLACE VIEW
   SELECT - Anweisung;

CREATE OR REPLACE VIEW view_name AS SELECT - Anweisung;

```

---

Beispiel:

```
CREATE VIEW PERSONAL_IT1 AS
	SELECT *
	FROM PERSONAL WHERE GEH_STUFE='it1';

SELECT *
FROM PERSONAL_IT1;
```

^ Integrität wird automatisch gewährleistet, da Views jeweils neu berechnet werden, wenn sie benötigt werden.

---

Schachteln von Views:

```
CREATE VIEW PERSONAL_IT1_AOK AS
SELECT *
FROM PERSONAL_IT1
WHERE KRANKENKASSE = 'aok';
```
---

Spalten umbenennen:

```
CREATE VIEW BOHRMASCHINEN (NR, NWERT, ZWERT)
AS
SELECT MNR, NEUWERT, ZEITWERT
FROM MASCHINE
WHERE NAME='Bohrmaschine';

SELECT *
FROM BOHRMASCHINEN WHERE ZWERT > 16000;
```

---

```
DROP VIEW view_name;

DROP VIEW PERSONAL_IT1;
```

> Es werden keine Daten in Relationen gelöscht.

---

> Aufgaben

1. Erstellen Sie einen View für alle Mitarbeiter, die in einer Abteilung arbeiten, die mit 'P' anfängt

2. Erstellen Sie einen View für Mitarbeiter und die Summe ihrer Prämien.

3. Erstellen Sie einen View für Mitarbeiter, die Kinder haben. Und dann eine View für Mitarbeiter, die mindestens zwei Kinder haben.

> Nicht bezogen auf Views:

I. Fügen Sie jedem Mitarbeiter eine Prämie von 500,- hinzu, der ein Kind hat.
Ia. Fügen Sie jedem Mitarbeiter eine Prämie von 500,- pro Kind hinzu.

---


---

# JDBC

^ Java Database Connectivity

---

## Aufgaben

- Datenbankverbindungen aufbauen und verwalten,
- SQL-Anfragen an die Datenbank weiterleiten und die
- Ergebnisse in eine für Java nutzbare Form umzuwandeln

---

> JDBC ist Teil des JDK

`java.sql` und `javax.sql`

---

> Jede Datenbank hat eigene Treiber

---

```
package java.sql;

/**
 * The interface that every driver class must implement.
 *
 * ...
 *
 */
public interface Driver {
...

```

---

```
public class oracle.jdbc.driver.OracleDriver implements java.sql.Driver {
	...
}
```

---

```

package java.sql;


/**
 * <P>The basic service for managing a set of JDBC drivers.<br>
 *
 * ...
 *
 */
public class DriverManager {

```

---

```
final Connection connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@ora14.informatik.haw-hamburg.de:1521:inf14", username, password);
```

^ thin <drivertype>
1521 port
 inf14 SID

---

#[fit] `java.sql.Connection`

---

```
connection.setAutoCommit(autoCommit);
```

---

```
connection.commit();
```

---

```
connection.rollback();
```

---

```
connection.setReadOnly(readOnly);
```

---

```
connection.setTransactionIsolation(level);
```

---

```
connection.setSavepoint(name)
connection.rollback(savepoint);
connection.releaseSavepoint(savepoint);
```
---

```
Statement createStatement();
```

---

#[fit] `java.sql.Statement`

---

```
connection.createStatement().executeQuery(sql);
```

^ fuer select

---

```
connection.createStatement().executeUpdate(sql)
```

^ fuer INSERT, UPDATE, DELETE

---

# JDO

^ Java Data Objects
 standard way to access persistent data in databases
 POJO

---

```
<table name="PERSONAL">
    <column name="PNR" type="INTEGER" required="true" primaryKey="true"
    	autoIncrement="true"/>
    <column name="VORNAME" type="VARCHAR" size="50" required="true"/>
    <column name="NACHNAME" type="VARCHAR" size="50" required="true"/>
    <column name="GEH_STUFE" type="VARCHAR" size="5"/>
    <column name="ABT_NR" type="VARCHAR" size="5"/>
    <column name="KRANKENKASSE" type="VARCHAR" size="3"/>
    <foreign-key foreignTable="GEHALT">
        <reference local="GEH_STUFE" foreign="GEH_STUFE"/>
    </foreign-key>
    <foreign-key foreignTable="ABTEILUNG">
        <reference local="ABT_NR" foreign="ABT_NR"/>
    </foreign-key>
</table>
```

---

> Code-Beispiel

---

# Oracle JDBC-Treiber

http://www.oracle.com/technetwork/database/enterprise-edition/jdbc-112010-090769.html

---

# *Aufgabe 1*

Fügen Sie die restlichen Felder der Klasse `Personal` hinzu und ergänzen Sie die `toString` - Funktion

---

# *Aufgabe 2*

Erstellen Sie die Struktur für `PERSONAL` analog für die Tabelle `MASCHINE`:
   - Legen Sie eine neue Klasse an
   - Geben Sie alle Maschinen mit allen Attributen auf der Kommandozeile aus

---

# *Aufgabe 3*

Fügen Sie eine neue Abteilung hinzu

---

# *Aufgabe 4*

Fügen Sie eine neue Maschine und einen neuen Mitarbeiter hinzu. Bauen Sie diese Funktion so, dass wenn ein `INSERT` fehlschlägt, keine der beiden Einträge in der Datenbank stehen (siehe `rollback`)

---

#[fit] Nächste Vorlesung
# *7.1.2016*


---

# Das war's für heute
![fit](../images/Rainbow_Dash.png)
