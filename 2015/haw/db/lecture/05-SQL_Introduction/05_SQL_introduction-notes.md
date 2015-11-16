autoscale: true
footer: Tina Umlandt, 2015
slidenumbers: true

---

# Wiederholung

---

# Funktionale 
# [fit] Abhāngigkeiten

^ Abhaengigkeit der Werte der Attribute

---

`Sei V eine Attributmenge, X, Y ⊆ V und r ∈ Rel(V)`

`Dann ist Y funktional abhängig von X, notiert als X → Y, wenn und nur wenn jeder X-Wert von r genau einen eindeutigen Y-Wert in r bestimmt.  `

^ wenn jeder Wert von X einen eindeutigen Wert aus Y hat.

---

Finden Sie die Funktionalen Abhāngigkeiten.

```
|----|----|----|----|
|  a |  b |  c |  d |   
|----|----|----|----|
| a1 | b1 | c1 | d1 |       
|----|----|----|----|
| a1 | b1 | c2 | d2 |       
|----|----|----|----|
| a2 | b1 | c1 | d3 |     
|----|----|----|----|
| a2 | b1 | c3 | d4 |     
|----|----|----|----|
```

^ I. a→b
II. c→b
III. d→abc
IV. ac→d

---

Welche dieser Zeilen dürfen eingefügt werden?

```
|----|----|----|----|
|  a |  b |  c |  d |       1.   a5 b6 c7 d8
|----|----|----|----|
| a1 | b1 | c1 | d1 |       2.   a2 b2 c1 d8
|----|----|----|----|
| a1 | b1 | c2 | d2 |       3.   a3 b1 c4 d3  
|----|----|----|----|
| a2 | b1 | c1 | d3 |       4.   a1 b1 c2 d5
|----|----|----|----|
| a2 | b1 | c3 | d4 |       
|----|----|----|----|
```

^ (1) OK
(2) geht nicht (a→b, c→b, ac→d)
(3) geht nicht (d→abc)
(4) geht nicht (ac→d)

---

# Normalformen

---

# 1NF

^ atomare Werte

---

# 2NF

^ Alle Attribute nur von ganzem schluessel abhaengig

---

# 3NF

^ außerhalb des Primärschlüssels ist direkt abhängig vom Primärschlüssel (insbesondere keine transitiven Abhängigkeiten)

---

![fit](../images/Vorlesung_05_Aufgabe_NF.png)

---

---

# Los geht's `\o/`

---

# [fit] Anfragesprachen

---

## Kriterien 
## für Anfragesprachen

---

## *- Ad-Hoc-Formulierung*

^ Keine Programme
^ Anfragen

---

## *- Deskriptivität*

^ „Was will ich haben“, nicht „Wie bekomme ich es“

---

## *- Mengenorientierung*

^ Viele Daten gleichzeitig, nicht nur ein Tupel
^ jede Operation soll auf Mengen von Daten gleichzeitig arbeiten, nicht navigierend nur auf einzelnen Elementen („one-tuple-at-a-time“)

---

## *- Abgeschlossenheit*

^ Alle Ergebnisse sind Relationen und können deshalb selbst wieder abgefragt werden

---

## *- Adäquatheit*

^ Alle Konstrukte des Datenmodells werden unterstützt
^ alle Konstrukte des zugrundeliegenden Datenmodells werden unterstützt

---

## *- Orthogonalität*

^ Es gibt wenige voneinander unabhängige Befehle, und die lassen sich kombinieren
^ Sprachkonstrukte sind in ähnlichen Situationen auch ähnlich anwendbar

---

## *- Optimierbarkeit*

^ Die Sprache ist so umformbar, dass der Benutzer einfache Anfragen stellen und das System daraus „schnelle“ bauen kann

---

## *- Effizienz*

^ Jede Operation ist effizient ausführbar (z.B. O(n²) im RDM)

---

## *- Sicherheit*

^  Alle Anfragen liefern endliche Ergebnisse in endlicher Zeit
^ keine Anfrage, die syntaktisch korrekt ist, darf in eine Endlosschleife geraten oder ein unendliches Ergebnis liefern

---

## *- Vollständigkeit*

^ Alles, was überhaupt abfragbar ist, lässt sich formulieren

---

# [fit] Anfragealgebra
# und
# [fit] Anfragekalkül

---

## Anfragealgebra

^ Mathematik: Algebra definiert durch Wertebereich und auf diesem definierte Operatoren
^ Inhalte der Datenbank sind Werte, und Operatoren definieren Funktionen zum Berechnen von Anfrageergebnissen

---

## Relationale Algebra

^ Wertebereich ist der Inhalt der Datenbank, 
Operationen sind Funktionen zum Berechnen der Anfrageergebnis

---

### Projektion `π`

^ Spalten ausblenden

---

```
Person                    π[Name](Pers)
|------|-----------|      |-----------|
|   Nr |      Name |      |      Name |
|------|-----------|      |-----------|
| 1201 |  Lovelace |      |  Lovelace |
|------|-----------|      |-----------|
| 1202 | Descartes |      | Descartes |
|------|-----------|      |-----------|
| 1203 |     Euler |      |     Euler |
|------|-----------|      |-----------|

```
^ Angeben, welche Spalten im Ergebnis vorhanden sein sollen

---

### Selektion `σ`

^ Zeilen ausblenden 

---

```
Person                    σ[Nr < 1203](Pers)
|------|-----------|      |------|-----------|
|   Nr |      Name |      |   Nr |      Name |
|------|-----------|      |------|-----------|
| 1201 |  Lovelace |      | 1201 |  Lovelace |
|------|-----------|      |------|-----------|
| 1202 | Descartes |      | 1202 | Descartes | 
|------|-----------|      |------|-----------|
| 1203 |     Euler |      
|------|-----------|      

```
^ Angeben, welche Tupel einen interessieren
^ komplexe Ausdrücke (Verknüpfungen) erlaubt. 

---

### Kartesisches Produkt `x`

---

```
Person                    Buch
|------|-----------|      |-----|-------|-----------------|
|   Nr |      Name |      |  Id | Preis |           Titel |
|------|-----------|      |-----|-------|-----------------|
| 1201 |  Lovelace |      | 302 | 13.99 |          Hamlet |
|------|-----------|      |-----|-------|-----------------|
| 1202 | Descartes |      | 306 | 14.99 |           Faust |
|------|-----------|      |-----|-------|-----------------|
| 1203 |     Euler |      | 310 | 44.99 | Die Verwandlung |
|------|-----------|      |-----|-------|-----------------|

```

___

```
Person  x  Buch
|------|-----------|-----|-------|-----------------|
|   Nr |      Name |  Id | Preis |           Titel |
|------|-----------|-----|-------|-----------------|
| 1201 |  Lovelace | 302 | 13.99 |          Hamlet |
|------|-----------|-----|-------|-----------------|
| 1201 |  Lovelace | 306 | 14.99 |           Faust |
|------|-----------|-----|-------|-----------------|
| 1201 |  Lovelace | 310 | 44.99 | Die Verwandlung |
|------|-----------|-----|-------|-----------------|
| 1202 | Descartes | 302 | 13.99 |          Hamlet |
|------|-----------|-----|-------|-----------------|
| 1202 | Descartes | 306 | 14.99 |           Faust |
|------|-----------|-----|-------|-----------------|
| 1202 | Descartes | 310 | 44.99 | Die Verwandlung |
|------|-----------|-----|-------|-----------------|
| 1203 |     Euler | 302 | 13.99 |          Hamlet |
|------|-----------|-----|-------|-----------------|
| 1203 |     Euler | 306 | 14.99 |           Faust |
|------|-----------|-----|-------|-----------------|
| 1203 |     Euler | 310 | 44.99 | Die Verwandlung |
|------|-----------|-----|-------|-----------------|

```

^ Zwei Tabellen miteinander verknüpfen
^ Jedes Tupel mit jedem Tupel der anderen Relation kombinieren 

---

### Verbund (Join) `⨝`

^ zwei Tabellen miteinander verknüpfen 

---
```
Person                    Buch
|------|-----------|      |-----|------|-------|-----------------|
|  PNr |      Name |      |  Id |  PNr | Preis |           Titel |
|------|-----------|      |-----|------|-------|-----------------|
| 1201 |  Lovelace |      | 302 | 1201 | 13.99 |          Hamlet |
|------|-----------|      |-----|------|-------|-----------------|
| 1202 | Descartes |      | 306 | 1202 | 14.99 |           Faust |
|------|-----------|      |-----|------|-------|-----------------|
| 1203 |     Euler |      | 310 | 1202 | 44.99 | Die Verwandlung |
|------|-----------|      |-----|------|-------|-----------------|

```
---

```
Person ⨝ Buch
|-----|------|-------|-----------------|-----------|
|  Id |  PNr | Preis |           Titel |      Name |
|-----|------|-------|-----------------|-----------|
| 302 | 1201 | 13.99 |          Hamlet |  Lovelace |
|-----|------|-------|-----------------|-----------|
| 306 | 1202 | 14.99 |           Faust | Descartes |
|-----|------|-------|-----------------|-----------|
| 310 | 1202 | 44.99 | Die Verwandlung | Descartes |
|-----|------|-------|-----------------|-----------|

```

^ Hier der „natürliche Verbund“, der gleiche Attributnamen verschmilzt
^ Es gibt unterschiedliche Arten des Verbundes, später mehr dazu im Kapitel „SQL“

---

### Umbenennung `β`

^ Spalte bekommt neuen Namen 

---

```
Person                    β[Personalnummer<-Nr](Pers)
|------|-----------|      |----------------|-----------|
|   Nr |      Name |      | Personalnummer |      Name |
|------|-----------|      |----------------|-----------|
| 1201 |  Lovelace |      |           1201 |  Lovelace |
|------|-----------|      |----------------|-----------|
| 1202 | Descartes |      |           1202 | Descartes |
|------|-----------|      |----------------|-----------|
| 1203 |     Euler |      |           1203 |     Euler |
|------|-----------|      |----------------|-----------|

```
---

## Kardinalität

^ Anzahl fuer "drucke ich mal eben aus“
^ Dauer 
^ Reihenfolge der Operationen

---

### *Kardinalität einer Projektion*

^ Projektion: Spalten ausblenden
^ Obergrenze: Anzahl der Tupel in der projizierten Relation
^ Untergrenze: 1 (bei nicht-leerer Ausgangsrelation)
^ Regel: Wenn die projizierten Attribute einen Schlüsselkandidaten darstellen, dann ist die Kardinalität des Ergebnisses gleich der Tupelanzahl

---

### *Kardinalität einer Selektion*

^ Selektion: Zeilen ausblenden
^ Die Kardinalität der Selektion hängt von der Selektionsbedingung ab
^ Obergrenze: Anzahl der Tupel
^ Untergrenze: 0
^ Selektion dient gerade zur Begrenzung der Tupelanzahl, d.h. in der Praxis ist die Obergrenze selten anzutreffen

---

### *Kardinalität eines Kartesischen Produkt*

^ Kardinalität ist das Produkt der Kardinalitäten der beteiligten Relationen
^ Folglich ist das kartesische Produkt immer eine sehr "teure" Operation

---

### *Kardinalität eines Joins*

^ Obergrenze: Produkt der Kardinalitäten der beteiligten Relationen
Untergrenze: 0
Folglich kann auch der Join eine sehr „teure“ Operation sein

---

## Anfragekalkül

^ Kalkül: eine formale logische Sprache zur Formulierung von Aussagen
Ziel: Einsatz eines derartigen Kalküls zur Formulierung von Datenbank-Anfragen
PNR > 300
Prädikatenlogik

---

```
42 > Preis
Einkaufspreis < Verkaufspreis

```

---

# SQL

^ von ANSI und ISO standardisierte Sprache für Relationale Datenbanksysteme

---

```sql
CREATE TABLE PERSONAL (
  PNR INT PRIMARY KEY,
  VORNAME VARCHAR(20),
  NACHNAME VARCHAR(20),
  GEH_STUFE VARCHAR(5),
  ABT_NR VARCHAR(5),
  KRANKENKASSE VARCHAR(3)
);
```
---

```sql
CREATE TABLE MASCHINE (
  MNR INT PRIMARY KEY,
  NAME VARCHAR(20),
  PNR INT,
  ANSCH_DATUM DATE,
  NEUWERT INT,
  ZEITWERT INT,
  FOREIGN KEY (PNR) REFERENCES PERSONAL(PNR)
);
```
---

```
SQL> describe MASCHINE;
 Name               Null?      Type
 ------------------ ---------- ------------------
 MNR                NOT NULL   NUMBER(38)
 NAME                          VARCHAR2(20)
 PNR                           NUMBER(38)
 ANSCH_DATUM                   DATE
 NEUWERT                       NUMBER(38)
 ZEITWERT                      NUMBER(38)
 ```

^ VARCHAR2
NUMBER vs INT

---

```sql
insert into PERSONAL values (123, 'Ada', 'Lovelace', 'it5', 'abt42', 'dek');
insert into MASCHINE values (1, 'Bohrmaschine', 1, '01-feb-14', 30000, 15000);
```

^ 
insert into PERSONAL values (124, 'Leonhard', 'Euler', 'it3', 'abt29', 'aok');
insert into PERSONAL values (126, 'René', 'Descartes', 'it4', 'abt42', 'dek');
insert into MASCHINE values (2, 'Bohrmaschine', 124, '01-jul-07', 30000, 18000);
insert into MASCHINE values (11, 'Hobelmaschine', 123, '15-jan-07', 29000, 19000);
insert into MASCHINE values (12, 'Drehbank', 126, '01-aug-14', 31000, 21000);

---

```
SQL> select * from Personal;

       PNR VORNAME      NACHNAME         GEH_S ABT_N KRA
---------- ------------ ---------------- ----- ----- ---
       123 Ada          Lovelace         it5   abt42 dek


SQL> select * from MASCHINE;

MNR   NAME                PNR   ANSCH_DAT   NEUWERT   ZEITWERT
----- ------------------- ----- --------- --------- ----------
    1 Bohrmaschine        123   01-FEB-14     30000      15000
```
^ case insensitive

---

```sql
SELECT [ALL|DISTINCT] ausdruck
FROM {tabellenname|viewname}[aliasname]
     [,{tabellenname|viewname}[ aliasname], ...]
[WHERE suchbedingungen]
[GROUP BY nicht aggregierender ausdruck 
          [,nicht aggregierender ausdruck]...]
[HAVING suchbedingungen]
[ORDER BY {spaltenname | nummer in spaltenliste} [{ASC|DESC}]
          [,{spaltenname|nummer in spaltenliste} [{ASC|DESC}]]...]
```

^ vollstāndige SELECT-Anweisung
ausdruck:
*|spaltenname[,spaltenname][,"echter" ausdruck]
spaltenname:
Spaltenname | tabellenname.Spaltenname | viewname.Spaltenname

---
```
|-----|---------------|-----|-------------|---------|----------|
| MNR |          NAME | PNR | ANSCH_DATUM | NEUWERT | ZEITWERT |
|-----|---------------|-----|-------------|---------|----------|
|   1 |  Bohrmaschine | 123 |   01-feb-14 |   30000 |    15000 |
|-----|---------------|-----|-------------|---------|----------|
|   2 |  Bohrmaschine | 123 |   01-jul-07 |   30000 |    18000 |
|-----|---------------|-----|-------------|---------|----------|
|   3 | Fraesmaschine | 124 |   04-jan-13 |   40000 |    10000 |
|-----|---------------|-----|-------------|---------|----------|
|  11 | Hobelmaschine | 127 |   15-jan-07 |   29000 |    19000 |
|-----|---------------|-----|-------------|---------|----------|
|  12 |      Drehbank | 126 |   01-aug-14 |   31000 |    21000 |
|-----|---------------|-----|-------------|---------|----------|
|  14 | Hobelmaschine | 123 |   01-nov-13 |   32000 |    22000 |
|-----|---------------|-----|-------------|---------|----------|
|  16 |      Drehbank | 134 |   25-nov-06 |   32000 |    23000 |
|-----|---------------|-----|-------------|---------|----------|
|  17 |  Bohrmaschine | 127 |   01-feb-08 |   31000 |    25000 |
|-----|---------------|-----|-------------|---------|----------|
```
---

Gesucht sind die Personalnummern derjenigen Mitarbeiter, die an mehr als einer Maschine arbeiten, von denen jede einen größeren Zeitwert als 17.000,- € hat. 
Ergebnis ist absteigend sortiert auszugeben.

---

```sql
SELECT PNR
FROM MASCHINE
WHERE ZEITWERT > 17000
GROUP BY PNR
HAVING COUNT(ZEITWERT) > 1
ORDER BY PNR DESC;
```
^ Jede Komponente liefert als Zwischenergebnis eine Tabelle

---

## `FROM`-Komponente

### `FROM MASCHINE`

^ Ergebnis: Kopie der Tabelle MASCHINE

---

## `WHERE`-Komponente
### `WHERE ZEITWERT > 17000`

---

```
|-----|---------------|-----|-------------|---------|----------|
| MNR |          NAME | PNR | ANSCH_DATUM | NEUWERT | ZEITWERT |
|-----|---------------|-----|-------------|---------|----------|
|   2 |  Bohrmaschine | 123 |   01-jul-07 |   30000 |    18000 |
|-----|---------------|-----|-------------|---------|----------|
|  11 | Hobelmaschine | 127 |   15-jan-07 |   29000 |    19000 |
|-----|---------------|-----|-------------|---------|----------|
|  12 |      Drehbank | 126 |   01-aug-14 |   31000 |    21000 |
|-----|---------------|-----|-------------|---------|----------|
|  14 | Hobelmaschine | 123 |   01-nov-13 |   32000 |    22000 |
|-----|---------------|-----|-------------|---------|----------|
|  16 |      Drehbank | 134 |   25-nov-06 |   32000 |    23000 |
|-----|---------------|-----|-------------|---------|----------|
|  17 |  Bohrmaschine | 127 |   01-feb-08 |   31000 |    25000 |
|-----|---------------|-----|-------------|---------|----------|
```

^ Tupel, deren Spalte ZEITWERT die Bedingung erfüllt

---

## `GROUP BY` - Komponente

### `GROUP BY PNR`

^ Tupel zusammenzufassen

---

```
|-----|---------------|-----|-------------|---------|----------|
| MNR |          NAME | PNR | ANSCH_DATUM | NEUWERT | ZEITWERT |
|-----|---------------|-----|-------------|---------|----------|
|   2 |  Bohrmaschine | 123 |   01-jul-07 |   30000 |    18000 |
|  14 | Hobelmaschine |     |   01-nov-13 |   32000 |    22000 |
|-----|---------------|-----|-------------|---------|----------|
|  11 | Hobelmaschine | 127 |   15-jan-07 |   29000 |    19000 |
|  17 |  Bohrmaschine |     |   01-feb-08 |   31000 |    25000 |
|-----|---------------|-----|-------------|---------|----------|
|  12 |      Drehbank | 126 |   01-aug-14 |   31000 |    21000 |
|-----|---------------|-----|-------------|---------|----------|
|  16 |      Drehbank | 134 |   25-nov-06 |   32000 |    23000 |
|-----|---------------|-----|-------------|---------|----------|
```
^ Ausnahme der Spalte PNR können alle anderen Spalten mehrere Werte

---

## `HAVING`-Komponente

### `HAVING COUNT(ZEITWERT) > 1`

^ bezieht sich auf das gruppierte Zwischenergebnis der GROUP BY-Komponente, wirkt wie WHERE-Komponente

---

```
|-----|---------------|-----|-------------|---------|----------|
| MNR |          NAME | PNR | ANSCH_DATUM | NEUWERT | ZEITWERT |
|-----|---------------|-----|-------------|---------|----------|
|   2 |  Bohrmaschine | 123 |   01-jul-07 |   30000 |    18000 |
|  14 | Hobelmaschine |     |   01-nov-13 |   32000 |    22000 |
|-----|---------------|-----|-------------|---------|----------|
|  11 | Hobelmaschine | 127 |   15-jan-07 |   29000 |    19000 |
|  17 |  Bohrmaschine |     |   01-feb-08 |   31000 |    25000 |
|-----|---------------|-----|-------------|---------|----------|
```
---

## `SELECT`-Komponente

### `SELECT PNR` 

^ wählt genannte Spalten aus

---

```
|-----|
| PNR |
|-----|
| 123 |
|-----|
| 127 |
|-----|
```
---

## `ORDER BY`-Komponente

### `ORDER BY PNR DESC`

^ sortiert die Tupel in die gewünschte Reihenfolge

---

```
|-----|
| PNR |
|-----|
| 127 |
|-----|
| 123 |
|-----|
```
---

---

```sql
SELECT Vorname, Nachname
FROM Personen
WHERE postleitzahl = '38855'

SELECT * 
FROM Personen, Bücher
WHERE Personen.Name = Bücher.Name
```
^ SELECT = Projektion
^ FROM = Relattion
^ WHERE = Selektion
^ SELECT = alles projezieren
^ FROM = Relattion
^ WHERE = Verbund/ Join

---

# *`SELECT`*

^ Projektionsliste, d.h. die angegebenen Attribute sind in der Ergebnisrelation enthalten
^ Stern steht für alle Attribut
^ Arithmetische Ausdrücke und Aggregatsfunktionen sind möglich

---

``` sql
SELECT DISTINCT Name
FROM Person

SELECT Buch.ISBN
FROM Buch, Bestellung

```

^ Gibt nur unterschiedliche Namen zurück, ohne DISTINCT alle! 
^ Qualifizierung über Relation
^ Bezug ist gegeben

---

# *`FROM`*

^ alle Relationen angegeben, auf die man zugreifen möchte

---

```sql
SELECT * 
FROM Buch, Prof

SELECT * 
FROM Buch CROSS JOIN Prof

SELECT * 
FROM Buch quelle, Buch ziel
```

^ kartesische Produkt von Buch und Prof 

---

# *`WHERE`*

---
## einfacher Vergleich
### Operator (=, <=, >=, <>, <, >)
---

```sql
SELECT NAME, VORNAME 
FROM PERSONAL 
WHERE PNR > 200;

SELECT MNR, NAME
FROM MASCHINE
WHERE ZEITWERT+10000<NEUWERT;
```

---

## Bedingungen 
### mit `AND`, `OR`, `NOT`

---

```sql
SELECT NAME, VORNAME 
FROM PERSONAL
WHERE GEH_STUFE=’it3’ AND KRANKENKASSE=’AOK’;

SELECT NAME, VORNAME
FROM PERSONAL
WHERE NOT KRANKENKASSE = ’AOK’;

```

---

## `IN`-Operator

---

```
A IN (B,C,D)
⇔ (A=B) OR (A=C) OR (A=D)

A NOT IN (B,C,D)
⇔ NOT(A IN (B,C,D)
⇔ (A<>B) AND (A<>C) AND (A<>D)

```
^ A sei Ausdruck; B, C, D, seien Konstanten

---

```sql
SELECT NAME, VORNAME, KRANKENKASSE 
FROM PERSONAL
WHERE KRANKENKASSE IN (‘AOK’, ‘KKH’, ‘TKK’);
```
---

## `BETWEEN`-Operator

---

```
A BETWEEN B AND C
⇔ ( A>=B) AND (A<=C)

```
---

```sql
SELECT MNR, NAME, ZEITWERT FROM MASCHINE
WHERE ZEITWERT
BETWEEN 20000 AND 24000;
```

---

## `LIKE`-Operator

---

*%* steht für kein, ein oder mehrere Zeichen, 
*_* steht für genau ein Zeichen.

---


```sql
SELECT MNR, NAME
FROM MASCHINE
WHERE NAME LIKE ‘%maschine’

SELECT MNR, NAME
FROM MASCHINE
WHERE NAME LIKE ‘_r%’

SELECT MNR, NAME
FROM MASCHINE
WHERE NAME LIKE ‘Drehbank’
```

---

## `NULL`-Operator

---

```sql
SELECT MNR, NAME 
FROM MASCHINE 
WHERE TEL IS NULL
```

---

# *Beispiel*

---

1. Legen Sie eine Tabelle an, in der Sie Personen speichern können (Denken Sie an Primārschlüssel)
  - Vorname
  - Nachname
  - Herkunfsland

2. Legen Sie eine Tabelle an, die Ereignisse speichern kann (Denken Sie an Primārschlüssel)
  - Name
  - Jahr
  - Person

---

# *3.* Fügen Sie folgende Eintrāge Ihren Tabellen hinzu:
 - Entdeckung des Frequenzsprungverfahren, 1942, Hedy Lamarr, geb. in Österreich-Ungarn
 - Entdeckung der Röntgenstrahlung, 1895 , Marie Curie geb. in Polen
 - erste Programmiererin, 1842, Ada Lovelace geb. in Großbritanien
 - Erfindung des Spanning Tree Protocol, 1990, Radia Perlman geb. in USA

---

# *4.* Finden Sie die `SELECT`-Anweisungen für folgende Fragen:

 - Ordnen Sie die Ereignisse nach Jahr absteigend
 - Geben Sie die Vornamen der Personen aus, die an Ereignisse vor 1900 beteiligt waren
 - Geben Sie alle Herkunftslānder aus

---

# Das war's für heute 
# `#scnr`
![fit](../images/Rainbow_Dash.png)
