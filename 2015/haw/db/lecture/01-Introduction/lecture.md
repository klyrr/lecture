autoscale: true
footer: Tina Umlandt, 2015
slidenumbers: true

# Welcome 

---

## Tina Umlandt

---

## (sehr) kurzer CV 

 - Lehrauftrag
 - seit bald 10 Jahren Developer
 - angefangen in einer Agentur
 - aktuell als Shop Developer bei Jimdo

^ Beispiele von unserem System

---

## Ablauf dieser Vorlesung

---

### Ansprechpartner
  Tina Umlandt
  christina.umlandt@haw-hamburg.de
  
  <br>

  Michael Brodersen
  michael.brodersen@haw-hamburg.de  

---

## Klausur

---

 - am Ende des Semesters 90-120 Minuten
 	→ Termin wird noch bekannt gegeben
 - Voraussetzung: 
 	→ Bestehen aller Übungszettel

---

## Übung/ Praktikum

---

 - Insgesamt 7 Zettel
 - Abgabe alle zwei Wochen
 - Fangen nächste Woche an 
   - 8:15 - 9:45
   - 10:00 - 11:30

^ erste Gruppe hat für den ersten Zettel nur eine Woche Zeit

---

 - Lösen der Übungen zu zweit, in festen Gruppen
 - Abgabe der Übungszettel spätestens am jeweiligen Termin
 - beide Gruppenteilnehmer müssen erklären können

---

## Vorlesung

---

### https://github.com/klyrr/lecture

---

## Termine und Themen
KW40 1.10.2015 - Einführung
KW41 8.10.2015 - Architektur
KW42 15.10.2015 - Datenmodelle
KW43 22.10.2015 - Relationale Datenbankdesign
KW45 5.11.2015 - SQL - Einführung
KW46 12.11.2015 - SQL - Komplexere Abfragen
KW47 19.11.2015 - Programmierung
KW49 3.12.2015 - Transaktionen
KW50 10.12.2015 - DBMS
KW1 7.1.2016 - Integrität
KW2 14.1.2016 - NoSQL
KW3 21.1.2016 - Datenschutz / Klausurvorbereitung

^ später noch detaillierte Erklärung

---

 - Folien auf [github](https://github.com/klyrr/lecture)
 - Wiederholung der letzten Vorlesung am Anfang
 - 12:30 - 15:45 mit 15 Minuten Pause: 
 	12:30 - 14:00 und 14:15 - 15:45
 - Insgesamt 12 Vorlesungstermine (hier können sich die Termine eventuell noch ändern)
   
^ mit Unterbrechung: Denken und Ausprobieren

---

## Begleitliteratur

^ Wikipedia
^ Das Internet (TM)

---

## Ablauf

^ Ich habe mich an den Themen orientiert, die in den letzten Jahren hier vorgetragen wurden 

---

1 . Einführung `(heute)`

2 . Architektur

3 . Datenmodelle

4 . Relationaler Datenbankentwurf

5 . SQL - Einführung

6 . SQL - Abfragen

---

7 . PL-SQL/ Programmierung

8 . Transaktionen

9 . DBMS

10 . Integrität

11 . NoSQL

12 . Datenschutz/ Sicherheit

---

## Ziele

---

 - Verständnis der Basiskonzepte von Datenbanksystemen
 - Verständnis für die Entwicklung von datenbankgestützten Anwendungssystemen
 - SQL anwenden und verstehen

---

## Haben Sie noch Fragen?

---

## Fragen an Sie

---
 
## Wer hat schon mal mit Datenbanken gearbeitet?

### Wer arbeitet aktuell mit Datenbanken?

---

# Los geht's `\o/`

---

![right fit](../images/Penrose-dreieck-colored.png)

## Wozu genau braucht man denn Datenbanken?
### 5 min

---

## Geschichte

^ Warum braucht man Datenbanken
^ was war die Intention

---

![original 80%](../graphics/dateisysteme.png)

^ Funktioniert gut, solange die Anzahl der Anwendungen gering ist und die Anwendungen möglichst wenig von anderen Dateien nutzen
^ 60er Jahre

---


![original 80%](../graphics/dateiverwaltungssysteme.png)

^ Assoziative Dateiverwaltung
^ quasi ein Suchsystem dazwischen
^ Funktioniert besser, Sortieren
^ 70er Jahre
^ Bestandteil des Betriebssystems

---

![original 80%](../graphics/datenbanksysteme.png)

^ eine Software verwaltet alle Daten

---

# Begriffe

^ als nächstes Definitionen

---

## Datenbank (DB)[^1]

[^1]: https://de.wikipedia.org/wiki/Datenbank

^ eine große Menge von Daten, die in einem Computer nach bestimmten Kriterien organisiert sind und komplexe Abfragen zulassen.

---

## Datenbankmanagement-system (DBMS)[^1]

^ Eine Datenbanksystem ist ein System zur elektronischen Datenverwaltung. 

---

> Die wesentliche Aufgabe eines DBS ist es, große Datenmengen effizient, widerspruchsfrei und dauerhaft zu speichern und benötigte Teilmengen in unterschiedlichen, bedarfsgerechten Darstellungsformen für Benutzer und Anwendungsprogramme bereitzustellen.
-- Wikipedia[^1]

---

### Widerspruchsfrei? 
### Dauerhaft?
### Teilmengen?

#### Was genau bedeutet das? 

# 5 min

![right fit](../images/Penrose-dreieck-colored.png)

^ Die wesentliche Aufgabe eines DBS ist es, große Datenmengen effizient, widerspruchsfrei und dauerhaft zu speichern und benötigte Teilmengen in unterschiedlichen, bedarfsgerechten Darstellungsformen für Benutzer und Anwendungsprogramme bereitzustellen.

---

## Structured Query Language (SQL)[^2]


[^2]: https://de.wikipedia.org/wiki/SQL

^ SQL ist eine Datenbanksprache zur Definition von Datenstrukturen in relationalen Datenbanken sowie zum Bearbeiten und Abfragen von darauf basierenden Datenbeständen

---

## Basisfunktionen an ein DBS (nach Edgar F. Codd)

^ später OLAP 12 Kriterien nach Codd (abweichen)
^ Online Analytical Processing (OLAP) wird zu den Methoden der analytischen Informationssysteme gezählt

---

1. Integration
2. Operationen
3. Katalog
4. Benutzersichten
5. Konsistenzüberwachung
6. Datenschutz
7. Transaktionen
8. Synchronisation
9. Datensicherung

---

## 1. Integration

---

 - Verhindern von Redundanz
 - einheitliche Schnittstelle an die Daten
 - Daten werden nur einmal gespeichert
 - einheitliche Verwaltung der Daten
 - Querbezüge möglich

---

## 2. Operationen

---

 - Spezifikationen von Datentypen
 - Anlage, Speichern, Löschen von Daten
 - Manipulation der Daten

^ Datentypen: text, date, bool, number

---

## 3. Katalog

---

 - Metadaten
 - Struktur der DB wird in der DB gespeichert

---

## 4. Benutzersichten

---

 - jeder Benutzer kann eigene Perspektiven (Views) auf Daten erstellen
 - Teilmengen aber auch Berechnungen

---

## [fit] 5. Konsistenzüberwachung

---

 - Plausibiliät und Konsistenz der Daten
 - Benutzer kann Konsistenzbedingungen erstellen

---

## 6. Datenschutz

---

 - Benutzer werden unterschieden
 - Zugriff nach Operationen werden unterschieden
 - Rechtevergabe und Zugriffsprotokoll

---

## 7. Transaktionen

---

 - Zusammenfassen von Einzelaktionen
 - werden vollständig oder gar nicht ausgeführt
 - Transaktionen führen von einem konsistenten Zustand in den nächsten

^ siehe: rollback

---

## 8. Synchronisation

---

 - konkurrierende Transaktionen müssen synchronisiert werden
 - Verhinderung der Beeinflussung und von Schreibkonflikten

---

## 9. Datensicherung

---

 - Regelmäßige Snapshots des Bestandes
 - automatisch

^ Snapshot = Momentaufnahme eines Systems oder Objekts

---

# Relationen-modell 

^ das waren die Kriterien an DBS

---

 - von Codd eingeführt (Turing-Award)
 - ER-Modell für den konzeptionellen Entwurf, das Relationenmodell für die Realisierung

^ ER Modell beschaeftigen wir uns später
^ ER = Entity Relationship Modell

---

![fit](../images/relation.png)

---

```

mysql> select * from student;
+------------+-----------+----------+------------+
| student_id | firstname | lastname | birthday   |
+------------+-----------+----------+------------+
|         42 | Arthur    | Dent     | 1970-01-01 |
+------------+-----------+----------+------------+
1 row in set (0.00 sec)

```

---

```

mysql> explain student;
+------------+-------------+------+-----+---------+-------+
| Field      | Type        | Null | Key | Default | Extra |
+------------+-------------+------+-----+---------+-------+
| student_id | int(11)     | NO   | PRI | NULL    |       |
| firstname  | varchar(20) | YES  |     | NULL    |       |
| lastname   | varchar(20) | YES  |     | NULL    |       |
| birthday   | date        | YES  |     | NULL    |       |
+------------+-------------+------+-----+---------+-------+
4 rows in set (0.00 sec)

```

---

```
mysql> explain product;
+-------------------------------------+------------------------+------+-----+---------+----------------+
| Field                               | Type                   | Null | Key | Default | Extra          |
+-------------------------------------+------------------------+------+-----+---------+----------------+
| product_id                          | bigint(20) unsigned    | NO   | PRI | NULL    | auto_increment |
| module_id                           | bigint(20) unsigned    | NO   | MUL | NULL    |                |
| title                               | varchar(255)           | NO   |     | NULL    |                |
| description                         | text                   | YES  |     | NULL    |                |
| short_description                   | text                   | YES  |     | NULL    |                |
| price                               | decimal(12,3) unsigned | YES  |     | NULL    |                |
| price_gross                         | decimal(12,3) unsigned | YES  |     | NULL    |                |
| has_old_price                       | tinyint(1) unsigned    | NO   |     | 0       |                |
| old_price                           | decimal(12,3) unsigned | YES  |     | NULL    |                |
| vat_rate                            | decimal(6,4) unsigned  | YES  |     | NULL    |                |
| weight                              | decimal(8,3) unsigned  | YES  |     | NULL    |                |
| shipping_calculation_type           | tinyint(1) unsigned    | NO   |     | 0       |                |
| pool                                | int(11) unsigned       | YES  |     | NULL    |                |
| item_number                         | varchar(255)           | YES  |     | NULL    |                |
| modes                               | int(11) unsigned       | NO   |     | 16      |                |
| options                             | text                   | YES  |     | NULL    |                |
| visible                             | tinyint(1) unsigned    | NO   |     | 1       |                |
| ordered                             | int(11) unsigned       | YES  |     | 0       |                |
| delivery_time                       | tinyint(1) unsigned    | YES  |     | NULL    |                |
| website_id                          | int(10) unsigned       | NO   | MUL | NULL    |                |
| hash_value                          | varchar(255)           | NO   |     | a1b2d3  |                |
| download_module_id                  | bigint(20) unsigned    | YES  |     | NULL    |                |
+-------------------------------------+------------------------+------+-----+---------+----------------+
22 rows in set (0.00 sec)
```

^ Katalog (Darstellung der Tabellenstruktur)
^ verschiedene Datentypen
^ erkennt ihr hier schon Probleme
^ wenn wir spaeter nochmal ueber Relationen und so sprechen, bringe ich das Beispiel nochmal mit

---
```
mysql> select * from product limit 1;
+------------+------------+-------+------------------------------------------+-------------------+---------+-------------+---------------+-----------+----------+----------+------------------------+----------------+------------------------------+-----------------------+-------------------------------------+--------+---------------------------+------+-------------+-------+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+---------+---------+---------------+------------+-------------------------------------------------+--------------------+
| product_id | module_id  | title | description                              | short_description | price   | price_gross | has_old_price | old_price | vat_rate | weight | shipping_calculation_type | pool | item_number | modes | options                                                                                                                                                                                                                                                                | visible | ordered | delivery_time | website_id | hash_value                                      | download_module_id |
+------------+------------+-------+------------------------------------------+-------------------+---------+-------------+---------------+-----------+----------+----------+------------------------+----------------+------------------------------+-----------------------+-------------------------------------+--------+---------------------------+------+-------------+-------+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+---------+---------+---------------+------------+-------------------------------------------------+--------------------+
|   33187584 | 6356026884 | Super | <p>
    Lorem ipsum dolor sit amet.
</p> |                   | 149.000 |     149.000 |             0 |   179.000 |  19.0000 |     0.000 |                         0 |   10 |             |    17 | [{"label":"fast","price":149,"grossPrice":149,"pool":6,"deliveryTime":1,"itemNumber":"","ordered":4,"oldPrice":179,"weight":2},{"label":"very fast","price":149,"grossPrice":149,"pool":10,"deliveryTime":1,"itemNumber":"","ordered":null,"oldPrice":179,"weight":3}] |       1 |       0 |             1 |    6561055 | hashv1-4fad80f2a629efba65e7d2db3eb74499fc562096 |                  0 |
+------------+------------+-------+------------------------------------------+-------------------+---------+-------------+---------------+-----------+----------+----------+------------------------+----------------+------------------------------+-----------------------+-------------------------------------+--------+---------------------------+------+-------------+-------+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+---------+---------+---------------+------------+-------------------------------------------------+--------------------+
1 row in set (0.00 sec)
```
```
mysql> select * from product limit 1\G
*************************** 1. row ***************************
                         product_id: 33187584
                          module_id: 6356026884
                              title: Super
                        description: <p>
    Lorem ipsum dolor sit amet.
</p>
                  short_description: 
                              price: 149.000
                        price_gross: 149.000
                      has_old_price: 0
                          old_price: 179.000
                           vat_rate: 19.0000
                             weight: 0.000
          shipping_calculation_type: 0
                               pool: 10
                        item_number: 
                              modes: 17
                            options: 
                            visible: 1
                            ordered: 0
                      delivery_time: 1
                         website_id: 6561055
                         hash_value: hashv1-4fad80f2a629efba65e7d2db3eb74499fc562096
                 download_module_id: 0
1 row in set (0.00 sec)
```

---

# [fit] Entwicklungszyklus

^ Zyklus einer Software/ Datenbank
^ meistens der `tricky part`
^ kann nur schlecht geändert werden
^ Migrationen vermeiden

---

![fit](../graphics/entwicklungszyklus.png)

^ Anwendung kann sein: Webservice, mehrere Services, die auf einem Rechner laufen, etc

---

1.  Datenbank logisch entwerfen
2.  Datenbank systemtechnisch entwerfen
3.  Datenbankprogramme entwickeln
4.  Datenbank aufbauen
5.  Datenbank betreiben

---

## 1. Datenbank logisch entwerfen 
### (Was soll in die Datenbank?)

---

## 2. Datenbank systemtechnisch entwerfen 
### (Wie soll es in die DB?)

---

## 3. Datenbankprogramme entwickeln
### (Wie werden die Daten verarbeitet?)

---

## 4. Datenbank aufbauen 
### (Wie kommen die Daten in die DB?)

---

## 5. Datenbank betreiben
### (Betriebskonzept, Einspielen von Updates, etc.)

---

# [fit] Datenunabhängigkeit

^ Weiteres Kriterium für den Entwicklungszyklus
^ Datenbanksysteme sollen lange zugreifbar bleiben, und zwar oftmals länger als die typische Laufzeit einer Anwendung oder einer Hardware. 
^ Anders als bei vielen Programmen wird bei Datenbanksystemen darauf geachtet, mit Änderungen in der Betriebsumgebung umgehen zu koennen. 
^ Dies sind die Hauptgründe für die Anforderung nach Datenunabhängigkeit in Datenbanksystemen
^ Datenunabhängigkeit bezeichnet die Vermeidung einer engen Kopplung zwischen Programm, Daten und unterliegenden Systemen 

---

## Physische Datenunabhängigkeit
### Implementierungsunabhängigkeit

^ Beispiel: Oracle heute, nächstes Jahr PostgreSQL
^ Die konzeptuelle Sicht auf eine Datenbank bleibt gleich, auch wenn sich die für die Speicherung der Daten gewählte Struktur bzw. Technologie ändert

---

## Logische Datenunabhängigkeit
### Anwendungsunabhängigkeit

^ Entkopplung der Datenbank von Änderungen und Erweiterungen der Anwendungsschnittstellen.

---

# Das war's für heute 
# `#scnr`
![fit](../images/Rainbow_Dash.png)



