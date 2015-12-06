
# Wiederholung

---

# *`INSERT`*

```sql
INSERT INTO PERSONAL VALUES(167,' Krause','Gustav','it3',' d12',' dak');

INSERT INTO PERSONAL (PNR, NAME, VORNAME) VALUES (777, ‘Graf’,’Gerd’);

INSERT INTO tbl_name (a,b,c) VALUES(1,2,3),(4,5,6),(7,8,9);

```

---

# *`UPDATE`*

```sql
UPDATE PERSONAL
SET KRANKENKASSE=’TKK’, GEH_STUFE='it5'
WHERE NAME=’Graf’;


UPDATE GEHALT
SET BETRAG=BETRAG * 1.07;

```

---

# *`DELETE`*

```sql
DELETE FROM PERSONAL
WHERE PNR = 167;
```

---

# *`DROP TABLE`*

```sql
CREATE TABLE KAFFEE_MASCHINE (
  ID INT PRIMARY KEY,
  NAME VARCHAR(20)
);

DROP TABLE KAFFEE_MASCHINE;
```

---

# *Sequences*

```sql
CREATE SEQUENCE maschine_seq START WITH 30;

INSERT INTO MASCHINE VALUES (maschine_seq.nextval, 'Diamantbohrer', 133, '01-nov-15', 34000, 34000);

```

---

# *`ALTER TABLE`*

```sql
ALTER TABLE PERSONAL ADD V_NR number(4);

ALTER TABLE PERSONAL MODIFY (KRANKENKASSE char(5));
```

---

# *Aufgaben*

1. Ändern Sie die Tabelle Abteilung so, dass der neue Titel fuer "Forschung/ Bildung" mit "Forschung und allgemeine Weiterbildung" eingetragen werden kann.

2. Fügen Sie den Tabellen `Kind` und `Praemie` einen künstlichen Schlüssel hinzu und aktualisieren Sie dazu die Tabelleneinträge.

3. Erstellen Sie für alle vorhandenen Tabellen eine Sequence, die zur Erstellung ihrer Primärschlüssel benutzt werden kann.

4. Fügen Sie nun für jede Tabelle, einen neuen Datensatz ein, indem Sie in dem `INSERT` - Statement die Sequence benutzen.

---

*1 . Ändern Sie die Tabelle Abteilung so, dass der neue Titel fuer "Forschung/ Bildung" mit "Forschung und allgemeine Weiterbildung" eingetragen werden kann.*

---

> 1 . Ändern Sie die Tabelle Abteilung so, dass der neue Titel fuer "Forschung/ Bildung" mit "Forschung und allgemeine Weiterbildung" eingetragen werden kann.

```sql
ALTER TABLE Abteilung MODIFY NAME VARCHAR(50);

UPDATE Abteilung SET NAME='Forschung und allgemeine Weiterbildung' WHERE NAME='Forschung/ Bildung';
```

---

*2 . Fügen Sie den Tabellen `Kind` und `Praemie` einen künstlichen Schlüssel hinzu und aktualisieren Sie die schon bestehenden Tabelleneinträge.*

---

> 2 . Fügen Sie den Tabellen `Kind` und `Praemie` einen künstlichen Schlüssel hinzu und aktualisieren Sie die schon bestehenden Tabelleneinträge.

```sql
ALTER TABLE KIND ADD KIND_ID INT;

CREATE SEQUENCE KIND_SEQ;

UPDATE KIND SET KIND_ID=KIND_SEQ.NEXTVAL;

ALTER TABLE KIND DROP CONSTRAINT SYS_C006996;

ALTER TABLE KIND ADD CONSTRAINT KIND_PK PRIMARY KEY(KIND_ID);
```

---

```
SQL> SELECT constraint_name, constraint_type, column_name
FROM user_constraints NATURAL JOIN user_cons_columns
WHERE table_name = 'KIND';

CONSTRAINT_NAME        C     COLUMN_NAME
---------------------- ------------------
SYS_C006996		       P     PNR
SYS_C006996		       P     K_NAME
SYS_C006996		       P     K_VORN
SYS_C006997		       R     PNR
```
^ P (primary key)
R (referential integrity)

---

```
SQL> SELECT constraint_name, constraint_type, column_name
FROM user_constraints NATURAL JOIN user_cons_columns
WHERE table_name = 'KIND';

CONSTRAINT_NAME        C     COLUMN_NAME
---------------------- ------------------
KIND_PK 		       P     KIND_ID
SYS_C006997		       R     PNR
```

---

*3 . Erstellen Sie für alle vorhandenen Tabellen eine Sequence, die zur Erstellung ihrer Primärschlüssel benutzt werden kann.*

---

> 3 . Erstellen Sie für alle vorhandenen Tabellen eine Sequence, die zur Erstellung ihrer Primärschlüssel benutzt werden kann.

```sql
CREATE SEQUENCE PERSONAL_SEQ START WITH 200;
CREATE SEQUENCE MASCHINE_SEQ START WITH 30;
CREATE SEQUENCE KIND_SEQ START WITH 10;
CREATE SEQUENCE PRAEMIE_SEQ START WITH 15;

```

---

*4 . Fügen Sie nun für jede Tabelle, einen neuen Datensatz ein, indem Sie in dem `INSERT` - Statement die Sequence benutzen.*

---

> 4 . Fügen Sie nun für jede Tabelle, einen neuen Datensatz ein, indem Sie in dem `INSERT` - Statement die Sequence benutzen.

```sql
INSERT INTO PERSONAL VALUES
	(PERSONAL_SEQ.NEXTVAL, 'Adele', 'Goldberg', 'it5', 'abt11', 'bek');
INSERT INTO MASCHINE VALUES
 	(MASCHINE_SEQ.NEXTVAL, 'Dampfmaschine', 123, '01-dec-15', 120000, 90000);
INSERT INTO KIND VALUES
	(161, 'Fowler', 'Marissa', '21-nov-15', KIND_SEQ.NEXTVAL);
INSERT INTO PRAEMIE VALUES
	(173, 399, '22-jan-15', PRAEMIE_SEQ.NEXTVAL);
```

---

> Tabellenbeschreibung

```
SQL> DESCRIBE PERSONAL;

 Name					   Null?    Type
 ------------------------- -------- --------------
 PNR					   NOT NULL NUMBER(38)
 VORNAME					    	VARCHAR2(20)
 NACHNAME					    	VARCHAR2(20)
 GEH_STUFE					    	VARCHAR2(5)
 ABT_NR 					    	VARCHAR2(5)
 KRANKENKASSE					    VARCHAR2(3)
```

---

# *Aufgaben, Teil II*

1. Legen Sie eine Tabelle an, in der Sie Materialien für die Maschinen verwalten. Folgende Daten müssen gespeichert werden können: Name, zugehörige Maschine, Menge, letztes Einkaufsdatum

2. Fügen Sie drei Materialien ein

3. Geben Sie alle Maschinennamen aus, für die es Material gibt.

4. Geben Sie alle Mitarbeiter aus, die nicht an Maschinen arbeiten.

5. Überlegen Sie sich, wie und wo Sie speichern können, wieviel Material wann für welche Maschine benutzt wurde. Legen Sie entsprechende Tabellen an oder ändern Sie bestehende. Fügen Sie dazu fünf Datensätze ein.

6. Geben Sie eine Übersicht aus, wieviel die einzelnen Maschinen an Material verbraucht haben.

7. Wie muss die Tabelle in 1) geändert werden, wenn ein Material für verschiedene Maschinen benutzt werden kann? Formulieren Sie das dazugehörige SQL.

> Schreiben Sie für alle Punkte das entsprechende SQL. Wenn nötig, benutzen Sie Sequences zum Einfügen neuer Datensätze.

^ siehe separate SQL Datei: solution-tasks.sql

---

# Los geht's `\o/`

---

#[fit] Transaktion

^ bisher: jede Operationen die alleinige logische Einheit

---

> Eine Folge von Datenbankoperationen, die insbesondere bezüglich der Datenbankkonsistenz als logische Einheit (atomar) angesehen wird.

-- Transaktion

^ Definition
---

Ablauf einer Transaktion

![fit left](../AblaufEinerTransaktion.png)

---

Beispiel:

- Reisebuchung: Hotelzimmer und Flugbuchung
- Neue Maschine und neuer Mitarbeiter

---

Warum?

- Datenbank muss vor und nach einer Transaktion im zulässigen Zustand sein
- Weiterhin unterstützt ein DBMS viele Benutzer, die Transaktionen gleichzeitig starten
- parallele Ausführung von Transaktionen ohne Anomalien
- Fehler im System (Stromausfall, Plattenfehler, Absturz der Software)

^ Warum Konsistenz?

---

# `ACID`

^ Bei der Ausführung von Transaktionen muss das Transaktionssystem die ACID-Eigenschaften garantieren:
Atomicity Consistency Isolation Durability

---

# *A* wie Atomicity

Transaktionen werden ganz oder gar nicht ausgeführt

^ Transaktionen sind also „unteilbar“

---

```
BOT
  Buche das Hotelzimmer
  Buche den Flug
COMMIT

BOT
  Buche das Hotelzimmer
  IF Hotelzimmer nicht moeglich THEN ROLLBACK
  Buche den Flug
COMMIT

```

^ BOT begin of transaction

---

# SQL und Transaktionen

- `ROLLBACK` zum Abbrechen der Transaktion
- `COMMIT` zum erfolgreichen Beenden der Transaktion

^ Start einer Transaktion gibt es keinen Befehl
jede beendete Transaktion startet automatisch eine neue
auto commit modus, beginTransaction (fuer JDBC)

---

# *C* wie Consistency

Transaktionen überführen die Datenbank von einem konsistenten Zustand in einen anderen

^ siehe Flug und Hotlebuchungsdaten

---

# *I* wie Isolation

Transaktionen werden so ausführt, als wenn sie alleine auf der Datenbank operieren würden

---

# *D* wie Durability

Transaktionen sind nach erfolgreichem Abschluss dauerhaft und gehen auch durch Fehler nicht mehr verloren

---

# [fit] Zustandsübergänge
# [fit] einer Transaktion

---

![fit](../ZustandsuebergaengeTransaktionen.png)

---

![left fit](../ZustandsuebegaengeTransaktionen.png)

*potentiell*: TA ist codiert und wartet darauf aktiv zu werden.

*aktiv*: Die aktiven TAs konkurrieren um Betriebsmittel.

*wartend*: Bei Überlast können aktive TAs verdrängt werden. Nach der Überlast werden sie wieder eingebracht.

^ Betriebsmittel aka Hauptspeicher, CPU

---

![left fit](../ZustandsuebergaengeTransaktionen.png)

*abgeschlossen*: Durch `commit` wird aktive TA beendet. Vorm Schreiben müssen aber eventuelle Konsistenzbedingungen geprüft werden.

*persistent*: Abgeschlossene TAs werden durch festschreiben dauerhaft geschrieben. TA ist persistent. Dies ist einer von zwei möglichen Endzuständen.

---

![left fit](../ZustandsuebergaengeTransaktionen.png)

*gescheitert*: TA kann aufgrund vieler Ereignisse scheitern (Beispiel: Nutzer benutzt selbst `abort` oder Systemfehler treten auf). Oder Konsistenzverletzungen werden festgestellt.

*wiederholbar*: Wirkung zurücksetzen und nochmal aktivieren.

*aufgegeben*: gescheiterte TA, die aufgegeben wird. Wirkung wird zurückgesetzt.

---

#[fit] Transaktionsverwaltung

---

### - Konsistenzsicherung
### - Recovery
##[fit] - Mehrbenutzersynchronisation

---

# Recovery und Fehlerfall

---

> Bei Transaktionsfehlern garantiert das Transaktionskonzept, dass entweder alle Befehle der Transaktion durchgeführt werden oder keiner

---

## Transaktionsfehler

^ Bei einem Transaktionsfehler ist nur genau eine Transaktion betroffen. Beispiel: Eine Transaktion führt eine Division durch null aus und wird dadurch beendet

---

## Systemfehler

^ Bei einem Systemfehler sind alle gerade laufenden Transaktionen betroffen. Beispiel: Der Strom fällt aus oder das Betriebssystem stürzt ab.

---

## Medienfehler

^ Bei einem Medienfehler tritt ein Fehler auf einem dauerhaften Speichermedium (Festplatte, CD, Band) auf. Beispiel: Die Festplatte ist defekt
Stand der Datenbank von einer Sicherungskopie eingespielt

---

# Logbuch zur Sicherung

^ Weiterhin wird ein „Logbuch“ (Log, Journal) aller vorgenommen Änderungen geführt, in der auch der Status der Transaktion ("hat Commit durchgeführt") notiert ist.
Auftritt eines Systemfehlers wird garantiert, dass alle vorher erfolgreich abgeschlossenen Transaktionen auch nachher in der Datenbank nachvollziehbar sind.

---

## Savepoints

^ fuer lange Transaktionen: zwischenzeitlich eine Sicherung durchführen
stellen Zwischenstationen innerhalb einer Transaktion dar, die wie ein „kleines Commit“ wirken. Insbesondere kann man zu dem Zustand vor dem Savepoint zurückkehren.
Keine Garantie einer erfolgreichen Durchführung der Transaktion

---

#[fit] Mehrbenutzer-
# fähigkeit

^ folgende moeglichkeiten: seriell oder parallel/ verschachtelt

---

## Serielle Ausführung

---
Serielle Ausführung

```

---------------------------------------------------------> Zeitachse
  T1 |---   ---   ---|
                  T2 |---    ---   ---|
                                   T3 |---   ---     ---|

  T2 |---    ---   ---|
                   T3 |---   ---     ---|  
                                     T1 |---   ---   ---|   


  T1, T2, T3    T1, T3, T2
  T2, T3, T1    T2, T1, T3
  T3, T1, T2    T3, T2, T1                              
```


^ es gibt n! Ausführungsabläufe

---

## Parallele Ausführung

---

Mehrbenutzerbetrieb (parallel)

```
---------------------------------------------------------> Zeitachse
  T1 |---        ---     ---|
    T2 |---         ---          ---|
            T3 |---      ---   ---|

```
^ was faellt auf
parallel ist schneller
Fokus auf Eigenschaft: Isolation
 als ob TA die einzige Anwendung ist

---

## [fit] Anomalien bei
## [fit] unkontrolliertem
## [fit] Mehrbenutzerbetrieb

---

## Problem
## *Lost Update*

---

```
Zeit	Transaktion 1		  Transaktion 2
----------------------------------------------
1		Lese Betrag         -
2		-				 	          Lese Betrag
3 	Erhöhe Betrag um 2	-
4		-					          Erhöhe Betrag um 1
5		Commit				      -
6		- 					        Commit

```

^ Was ist hier das Problem?
-> Betrag wird nur einmal erhoeht, andere Erhoehung geht verloren

---

```
Zeit	Transaktion 1		 Transaktion 2
----------------------------------------------
1		Lese Betrag			   -
2		-				 	         Lese Betrag
3 	Erhöhe Betrag um 2 -                    -> geht verloren
4		-					         Erhöhe Betrag um 1  
5		Commit				     -
6		- 					       Commit

```

---

## Problem
## *Uncommitted Dependency (Dirty Read)*

---

```
Zeit	Transaktion 1		 Transaktion 2
------------------------------------------
1		Lese Betrag		   	 -
2 	Erhöhe Betrag um 1 -
3		-					         Lese Betrag
4		Rollback			     -
```

^ Was ist hier das Problem?
-> falscher Betrag wird gelesen

---

```
Zeit	Transaktion 1		  Transaktion 2
------------------------------------------
1		Lese Betrag			    -
2 	Erhöhe Betrag um 1	-
3		-					          Lese Betrag    -> falscher Betrag
4		Rollback			      -
```

---

## Problem
## *Inconsistency Read (Nonrepeatable Read)*

---

```
Zeit	Transaktion 1		Transaktion 2
-----------------------------------------------
1		Lese Haben_Konto	-
2 	-					        Ändere Soll_Konto  
3		-					        Ändere Haben_Konto
4		-					        Commit
5		Lese Soll_Konto		-
6		Commit			    	-
```

^ Was ist hier das Problem?
-> falsch gelesene eigentlich synchrone daten

---

```
Zeit	Transaktion 1		Transaktion 2
-----------------------------------------------
1		Lese Haben_Konto	-
2 	-				        	Ändere Soll_Konto    -> Verletzung Isolation
3		-					        Ändere Haben_Konto
4		-					        Commit
5		Lese Soll_Konto		-
6		Commit				    -
```

---

## Problem
## *Phantomdaten*

---

```
Zeit	Transaktion 1		Transaktion 2
------------------------------------------------
1		Lese Kontostand		-
2 	-				        	Ändere Kontostand
4		-					        Commit
5		Lese Kontostand		-
6		Commit				    -
```

^ Kontostand aendern hat phantomdatensatz erzeugt

---

```
Zeit	Transaktion 1		Transaktion 2
-----------------------------------------------
1		Lese Kontostand		-
2 	-					        Ändere Kontostand   -> Veränderung des Datenbestandes
4		-					        Commit
5		Lese Kontostand		-
6		Commit				    -
```

---

# Lösung: Locks

^ Sperre ist ein Recht, auf ein Datenbankobjekt zuzugreifen
Bevor auf ein Objekt zugegriffen wird, muss man eine Sperre erwerben
Concurrency problem

---

## Read locks

^ Lesen können mehrere Transaktionen gleichzeitig

---

## Write locks

^  Änderungen darf immer nur eine Transaktion ausführen (und keine andere darf währenddessen lesen)

---

## Problem
## *Lost Update*

^ gleichzeitiges Lesen und Schreiben

---

```
Zeit	Transaktion 1		  Transaktion 2
----------------------------------------------
1		Lese Betrag			    -
2		-				 	          Lese Betrag
3 	Erhöhe Betrag um 1	-
4		-					          Erhöhe Betrag um 1
5		Commit				      -
6		- 					        Commit

```
---

## Lösung
## *Lost Update*

---

```
Zeit	Transaktion 1					Transaktion 2
-------------------------------------------------------------
1		Lese Betrag 						-
		  	(Lese-Sperre erteilt)
2		-				 					      Lese Betrag			
												         (Lese-Sperre erteilt)
3 	Erhöhe Betrag um 1					-
        (wartet auf Schreib-Sperre)		 
4		-									      Erhöhe Betrag um 1		
												          (wartet auf Schreib-Sperre)
5		wartet							   	wartet
6		wartet 								  wartet
```

^ zwei oder mehr Transaktionen im Wartezustand sind und jede auf die Freigabe einer Sperre durch eine andere Transaktion wartet, wird als Deadlock bezeichnet
Ansatz für ihre Behandlung ist der Abbruch (und damit die Freigabe der Sperren) einer der beteiligten Transaktionen

---

```
Zeit	Transaktion 1						Transaktion 2
-------------------------------------------------------------
1		Lese Betrag 						-
		  	(Lese-Sperre erteilt)
2		-				 					      Lese Betrag			
												         (Lese-Sperre erteilt)
3 	Erhöhe Betrag um 1					-
        (wartet auf Schreib-Sperre)		 
4		-									      Erhöhe Betrag um 1		
												          (wartet auf Schreib-Sperre)
5		wartet							   	wartet                           -> Deadlock
6		wartet 								  wartet                           -> Deadlock
```
---

## Deadlock

---

#[fit] Serialisierbarkeit

^ Nachteil der seriellen Verarbeitung: dauert lange
Vorteil: keine Beeinflussung

---

> Vereinigung der Vorteile der seriellen Verarbeitung - Isolation - und des Mehrbenutzerbetriebs - erhöhter Durchsatz

---

Definition:
Eine parallele Ausführung mehrerer Transaktionen heißt *serialisierbar*, wenn ihr Effekt identisch mit dem Effekt einer (beliebig gewählten) seriellen Ausführung dieser Transaktionen ist.

^ Eine Ausführungsreihenfolge der Operationen einer Menge von Transaktionen heißt serialisierbar, wenn sie äquivalent zu irgendeiner nichtparallelen Ausführungsreihenfolge der Transaktionsmenge ist
Mit anderen Worten:
Die Transaktionen werden alle ausgeführt
Es gibt keine besonderen Effekte durch die parallele Ausführung
Die Reihenfolge der Transaktionsausführung wird vom System bestimmt

---

## Read locks
## (shared)

^ Lesen können mehrere Transaktionen gleichzeitig

---

## Write locks
## (exclusive)

^  Änderungen darf immer nur eine Transaktion ausführen (und keine andere darf währenddessen lesen)

---

#[fit] Zwei-Phasen-
#[fit] Sperrprotokoll
## 2PL

^ Serialisierbarkeit ist gewaehrleistet bei Einhaltung des 2PL

---

1. Jedes Objekt, das von einer TA benutzt werden soll, muss vorher entsprechend gelockt werden

2. Eine TA fordert ein Lock, das sie schon hat, nicht erneut an

3. Eine TA muss die Locks anderer TA beachten. Kann ein Lock nicht gewährt werden, wird gewartet.

4. Es gibt zwei Phasen:
	4.a *Wachstumsphase*
	4.b. *Schrumpfungsphase*

5. Bei Transaktionsende muss die TA alle ihre Locks abgeben.

---

# Spezialfälle des 2PL

---

# Konservative 2PL

---

> am Anfang werden alle Locks auf einmal gesetzt

---

## Vorteile

- keine Deadlocks
- Freigabe gesperrter Objekte vor Ende der Transaktion

---

## Nachteile

- hoher Verlust an Parallelität
- es muss bekannt sein, welche Locks benötigt werden

---

# Strikte 2PL

---

> alle gesetzten Write-Locks werden am Ende der Transaktion gelöst

---

## Vorteile

- verhindert Schneeballeffekt von kaskadierenden sich beeinflussenden TAs

---

## Nachteile

- Locks werden länger gehalten als nötig
- Wartezeit von blockierten TA wird erhöht

---

# isolation level

^ Transaktionsisolationsebenen

---

```
SET TRANSACTION <Isolation_level>
```

- Serialisable
- Repeatable Read
- Read committed
- Read uncommitted


^ Standard laut SQL-92
^ Diese vier Isolationlevel verursachen zunehmend mehr "Probleme", erhöhen jedoch gleichzeitig die mögliche Parallelität der Transaktionen und somit den Durchsatz des Gesamtsystems
Konsequenz: Für Transaktionen überlegen, ob man Serialisierbarkeit benötigt oder ob andere Korrektheitskriterien genügen

---

## Read Uncommitted

- Leseoperationen ignorieren Locks
- meiste DBMS haben eine Ebene, die mindestens Lost Updates verhindert

---

## Read Committed

- setzt Schreibsperren auf Objekten, die verandert werden sollen, Lesesperren aber nur kurz

---

## Repeatable Read

- Sicher gestellt, dass wiederholtes Lesen dieselben Ergebnisse haben. Locks sorgen dafür, dass bis auf Phantom Reads keine Anomalien auftreten können

---

## Serialisable

- höchste Isolationsebene
- Wirkung paraller TAs ist die gleiche wie seriell
- kann zu Abbrüchen kommen

---

#[fit] Isolation level
## und
#[fit] Anomalien

---

```
Isolation Level  | Dirty Read | Nonrepeatable Reads | Phantom Reads | Lost updates
---------------------------------------------------------------------------------
Read uncommitted	   YES	   		  YES		   		            	YES 			   YES
Read committed		   no	   	   	  YES		   			            YES 	       no
Repeatable Read 	   no	   	  	  no		   		            	YES 		   	 no
Serialisable		     no	   	  	  no	   	   	             	no 				    sno
```

^ Drei Problemklassen werden von SQL benannt:
Dirty Read: Transaktion 1 liest etwas von Transaktion 2, aber Transaktion 2 wird anschließend zurückgesetzt
Nonrepeatable Read: Transaktion 1 liest einen Wert, Transaktion 2 ändert genau diesen Wert, Transaktion 1 liest den Wert erneut
Phantoms: Transaktion 1 liest eine Menge von Tupeln, die einer Bedingung genügen. Transaktion 2 fügt ein Tupel ein. Transaktion 1 liest die Menge von Tupeln erneut ein, und erhält das zusätzliche Tupel (das Phantom)

---

## Zugriffsmodus
## einer Transaktion

---

### `read only`

^ nur SELECT Anweisungen
Schnellere Bearbeitung

---

### `read write`

^ INSERT/UPDATE/DELETE-Statement)
default

---

Syntax

```
SET TRANSACTION READ ONLY
SET TRANSACTION READ WRITE
```

---

JDBC

```java
try {
	con.setAutoCommit(false);
	// Hier jetzt Änderungsoperationen
	con.commit();
} catch (final SQLException e) {
	con.rollback();
}
```

^ Nächstes Mal JDBC
