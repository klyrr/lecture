autoscale: true
footer: Tina Umlandt, 2015
slidenumbers: true

---

# Wiederholung

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

---

# *`SELECT`*

---

``` sql
SELECT DISTINCT Name
FROM Person

SELECT Buch.ISBN
FROM Buch, Bestellung

SELECT Buch.ISBN AS "ISBN-Nummer"
FROM Buch, Bestellung

```

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

- Einfache Operatoren: `=`, `<=`, `>=`, `<>`, `<`, `>`
- Bedingungen mit `AND`, `OR`, `NOT`
- `IN` - Operator
- `BETWEEN` - Operator
- `LIKE` - Operator
- `NULL` - Operator

---

``` sql
SELECT *
FROM Person
WHERE Name LIKE "_A%"
   AND LIEBLINGSFARBE IN ( 'rot', 'blau', 'schwarz', 'weiss')
   OR GROESSE BETWEEN 150 AND 170
   AND LIEBLINGSFACH IS NOT NULL

```
---

# Los geht's `\o/`

---

# Verbund (join)

^ beiden hintereinander ausgeführten Operationen kartesisches Produkt und Selektion

---
```
 Autor                       Buch
|------|-------------|      |-----|-------|-----------------|---------|
|   Nr |        Name |      |  Id | Preis |           Titel | AutorId |
|------|-------------|      |-----|-------|-----------------|---------|
| 1201 |      Goethe |      | 302 | 13.99 |          Hamlet |    1202 |
|------|-------------|      |-----|-------|-----------------|---------|
| 1202 | Shakespeare |      | 306 | 14.99 |           Faust |    1201 |
|------|-------------|      |-----|-------|-----------------|---------|
| 1203 |       Kafka |      | 310 | 44.99 | Die Verwandlung |    1203 |
|------|-------------|      |-----|-------|-----------------|---------|

```
---

Frage: Wie heißt der Autor, der "Hamlet" geschrieben hat?

---
Erster Schritt:

```sql
SELECT *
FROM Autor, Buch
```

---

```
|------|-------------|-----|-------|-----------------|---------|
|   Nr |        Name |  Id | Preis |           Titel | AutorId |
|------|-------------|-----|-------|-----------------|---------|
| 1201 |      Goethe | 302 | 13.99 |          Hamlet |    1202 |
|------|-------------|-----|-------|-----------------|---------|
| 1201 |      Goethe | 306 | 14.99 |           Faust |    1201 |
|------|-------------|-----|-------|-----------------|---------|
| 1201 |      Goethe | 310 | 44.99 | Die Verwandlung |    1203 |
|------|-------------|-----|-------|-----------------|---------|
| 1202 | Shakespeare | 302 | 13.99 |          Hamlet |    1202 |
|------|-------------|-----|-------|-----------------|---------|
| 1202 | Shakespeare | 306 | 14.99 |           Faust |    1201 |
|------|-------------|-----|-------|-----------------|---------|
| 1202 | Shakespeare | 310 | 44.99 | Die Verwandlung |    1203 |
|------|-------------|-----|-------|-----------------|---------|
| 1203 |       Kafka | 302 | 13.99 |          Hamlet |    1202 |
|------|-------------|-----|-------|-----------------|---------|
| 1203 |       Kafka | 306 | 14.99 |           Faust |    1201 |
|------|-------------|-----|-------|-----------------|---------|
| 1203 |       Kafka | 310 | 44.99 | Die Verwandlung |    1203 |
|------|-------------|-----|-------|-----------------|---------|
```
---

Zweiter Schritt:

```sql
SELECT *
FROM Autor, Buch
WHERE Buch.Titel="Hamlet"
```

---
```
|------|-------------|-----|-------|-----------------|---------|
|   Nr |        Name |  Id | Preis |           Titel | AutorId |
|------|-------------|-----|-------|-----------------|---------|
| 1201 |      Goethe | 302 | 13.99 |          Hamlet |    1202 |
|------|-------------|-----|-------|-----------------|---------|
| 1202 | Shakespeare | 302 | 13.99 |          Hamlet |    1202 |
|------|-------------|-----|-------|-----------------|---------|
| 1203 |       Kafka | 302 | 13.99 |          Hamlet |    1202 |
|------|-------------|-----|-------|-----------------|---------|
```
---

Dritter Schritt:

```sql
SELECT *
FROM Autor, Buch
WHERE Buch.Titel="Hamlet"
   AND Autor.Nr=Buch.AutorId
```

---
```
|------|-------------|-----|-------|-----------------|---------|
|   Nr |        Name |  Id | Preis |           Titel | AutorId |
|------|-------------|-----|-------|-----------------|---------|
| 1202 | Shakespeare | 302 | 13.99 |          Hamlet |    1202 |
|------|-------------|-----|-------|-----------------|---------|
```

---
Vierter Schritt:

```sql
SELECT Name
FROM Autor, Buch
WHERE Buch.Titel="Hamlet"
   AND Autor.Nr=Buch.AutorId
```

---
```
|-------------|
|        Name |
|-------------|
| Shakespeare |
|-------------|
```
---

---

# Tabellen anlegen

```
tabelle.sql
inhalt.sql
```

---

#[fit] `CROSS JOIN` 

^ kartesisches produkt

---

```sql
SELECT *
FROM PERSONAL, ABTEILUNG;

SELECT * 
FROM PERSONAL CROSS JOIN ABTEILUNG;

```

---

#[fit] `(INNER) JOIN` 

### `Equi-Join`

^ bei dem ein Wert in beiden Tabellen vorhanden ist
Wichtig: in beiden !!1 (auf NULL aufmerksamm machen)

---
```sql
SELECT *
FROM PERSONAL, ABTEILUNG
WHERE PERSONAL.ABT_NR=ABTEILUNG.ABT_NR;

SELECT * 
FROM PERSONAL JOIN ABTEILUNG ON PERSONAL.ABT_NR=ABTEILUNG.ABT_NR;

```

---

```
SQL> SELECT * FROM PERSONAL JOIN ABTEILUNG ON PERSONAL.ABT_NR=ABTEILUNG.ABT_NR;

       PNR VORNAME		NACHNAME	     GEH_S ABT_N KRA ABT_N NAME
---------- -------------------- -------------------- ----- ----- --- ----- ---
       123 Ada			Lovelace	     it5   abt13 dek abt13 Produktion
       124 Leonhard		Euler		     it2   abt11 aok abt11 Verwaltung
       126 Ren??		Descartes	     it1   abt12 dek abt12 Projektierung
       127 Alan 		Turing		     it2   abt14 dek abt14 Lagerung
       132 Grace		Hopper		     it4   abt15 dek abt15 Verkauf
       145 Marie		Curie		     it4   abt15 dek abt15 Verkauf
       147 Hedy 		Lamarr		     it5   abt11 dek abt11 Verwaltung
       133 Radia		Perlman 	     it3   abt12 dek abt12 Projektierung
       161 Martin		Fowler		     it2   abt13 dek abt13 Produktion
       163 Erich		Gamma		     it1   abt14 dek abt14 Lagerung

10 rows selected.
```

---

```
SQL> SELECT * FROM PERSONAL, ABTEILUNG WHERE PERSONAL.ABT_NR=ABTEILUNG.ABT_NR;

       PNR VORNAME		NACHNAME	     GEH_S ABT_N KRA ABT_N NAME
---------- -------------------- -------------------- ----- ----- --- ----- ---
       123 Ada			Lovelace	     it5   abt13 dek abt13 Produktion
       124 Leonhard		Euler		     it2   abt11 aok abt11 Verwaltung
       126 Ren??		Descartes	     it1   abt12 dek abt12 Projektierung
       127 Alan 		Turing		     it2   abt14 dek abt14 Lagerung
       132 Grace		Hopper		     it4   abt15 dek abt15 Verkauf
       145 Marie		Curie		     it4   abt15 dek abt15 Verkauf
       147 Hedy 		Lamarr		     it5   abt11 dek abt11 Verwaltung
       133 Radia		Perlman 	     it3   abt12 dek abt12 Projektierung
       161 Martin		Fowler		     it2   abt13 dek abt13 Produktion
       163 Erich		Gamma		     it1   abt14 dek abt14 Lagerung

10 rows selected.
```
---
#[fit] `NATURAL JOIN`

^ setzt sich zusammen aus dem Equi-Join und einer zusätzlichen Ausblendung der duplizierten Spalten (Projektion)
Attribute (Spalten) die in beiden Relationen die gleiche Bezeichnung 
keine gemeinsamen Attribute, so ist das Ergebnis des natürlichen Verbundes das kartesische Produkt.

---
```sql
SELECT *
FROM PERSONAL NATURAL JOIN ABTEILUNG;

```

---

```
SQL> SELECT * FROM PERSONAL NATURAL JOIN ABTEILUNG;

ABT_N	     PNR VORNAME	      NACHNAME		   GEH_S KRA NAME
----- ---------- -------------------- -------------------- ----- ---------
abt13	     123 Ada		      Lovelace		   it5	 dek Produktion
abt11	     124 Leonhard	      Euler		 	   it2	 aok Verwaltung
abt12	     126 Ren??		      Descartes 	   it1	 dek Projektierung
abt14	     127 Alan		      Turing		   it2	 dek Lagerung
abt15	     132 Grace		      Hopper		   it4	 dek Verkauf
abt15	     145 Marie		      Curie			   it4	 dek Verkauf
abt11	     147 Hedy		      Lamarr		   it5	 dek Verwaltung
abt12	     133 Radia		      Perlman		   it3	 dek Projektierung
abt13	     161 Martin 	      Fowler		   it2	 dek Produktion
abt14	     163 Erich		      Gamma			   it1	 dek Lagerung

10 rows selected.
```

---

#[fit] `OUTER JOIN`

^ does not require each record in the two joined tables to have a matching record
Every row from the "right/ left" table (B) will appear in the joined table at least once

---

*`LEFT`* OUTER JOIN
--

```sql
SELECT *
FROM PERSONAL LEFT OUTER JOIN ABTEILUNG ON PERSONAL.ABT_NR=ABTEILUNG.ABT_NR;
```

^ Every row from the "right" table (B) will appear in the joined table at least once

---

```
SQL> SELECT * FROM PERSONAL LEFT OUTER JOIN ABTEILUNG ON PERSONAL.ABT_NR=ABTEILUNG.ABT_NR;

       PNR VORNAME		NACHNAME	     GEH_S ABT_N KRA ABT_N NAME
---------- -------------------- -------------------- ----- ----- --- ----- -------------
       147 Hedy 		Lamarr		     it5   abt11 dek abt11 Verwaltung
       124 Leonhard		Euler		     it2   abt11 aok abt11 Verwaltung
       133 Radia		Perlman 	     it3   abt12 dek abt12 Projektierung
       126 Ren??		Descartes	     it1   abt12 dek abt12 Projektierung
       161 Martin		Fowler		     it2   abt13 dek abt13 Produktion
       123 Ada			Lovelace	     it5   abt13 dek abt13 Produktion
       163 Erich		Gamma		     it1   abt14 dek abt14 Lagerung
       127 Alan 		Turing		     it2   abt14 dek abt14 Lagerung
       145 Marie		Curie		     it4   abt15 dek abt15 Verkauf
       132 Grace		Hopper		     it4   abt15 dek abt15 Verkauf
       173 Richard		Helm		     it1	 	 dek

11 rows selected.
```
---

*`RIGHT`* OUTER JOIN
--

```sql
SELECT *
FROM PERSONAL RIGHT OUTER JOIN ABTEILUNG ON PERSONAL.ABT_NR=ABTEILUNG.ABT_NR;

```
---

```
SQL> SELECT * FROM PERSONAL RIGHT OUTER JOIN ABTEILUNG ON PERSONAL.ABT_NR=ABTEILUNG.ABT_NR;

       PNR VORNAME		NACHNAME	     GEH_S ABT_N KRA ABT_N NAME
---------- -------------------- -------------------- ----- ----- --- ----- ---------------
       123 Ada			Lovelace	     it5   abt13 dek abt13 Produktion
       124 Leonhard		Euler		     it2   abt11 aok abt11 Verwaltung
       126 Ren??		Descartes	     it1   abt12 dek abt12 Projektierung
       127 Alan 		Turing		     it2   abt14 dek abt14 Lagerung
       132 Grace		Hopper		     it4   abt15 dek abt15 Verkauf
       145 Marie		Curie		     it4   abt15 dek abt15 Verkauf
       147 Hedy 		Lamarr		     it5   abt11 dek abt11 Verwaltung
       133 Radia		Perlman 	     it3   abt12 dek abt12 Projektierung
       161 Martin		Fowler		     it2   abt13 dek abt13 Produktion
       163 Erich		Gamma		     it1   abt14 dek abt14 Lagerung
								     					 abt16 Forschung

11 rows selected.
```
---

*`FULL`* OUTER JOIN
-- 

```sql
SELECT *
FROM PERSONAL FULL OUTER JOIN ABTEILUNG ON PERSONAL.ABT_NR=ABTEILUNG.ABT_NR;

```
---

```
SQL> SELECT * FROM PERSONAL FULL OUTER JOIN ABTEILUNG ON PERSONAL.ABT_NR=ABTEILUNG.ABT_NR;

       PNR VORNAME		NACHNAME	     GEH_S ABT_N KRA ABT_N NAME
---------- ------------ ---------------- ----- ----- --- ----- --------------------------
       123 Ada			Lovelace	     it5   abt13 dek abt13 Produktion
       124 Leonhard		Euler		     it2   abt11 aok abt11 Verwaltung
       126 Ren??		Descartes	     it1   abt12 dek abt12 Projektierung
       127 Alan 		Turing		     it2   abt14 dek abt14 Lagerung
       132 Grace		Hopper		     it4   abt15 dek abt15 Verkauf
       145 Marie		Curie		     it4   abt15 dek abt15 Verkauf
       147 Hedy 		Lamarr		     it5   abt11 dek abt11 Verwaltung
       133 Radia		Perlman 	     it3   abt12 dek abt12 Projektierung
       161 Martin		Fowler		     it2   abt13 dek abt13 Produktion
       163 Erich		Gamma		     it1   abt14 dek abt14 Lagerung
       173 Richard		Helm		     it1	 	 dek
								     					 abt16 Forschung

12 rows selected.
```
---

# Self join

---
```sql
SELECT *
FROM PERSONAL p1 INNER JOIN PERSONAL p2 ON p1.ABT_NR=p2.ABT_NR
WHERE p1.PNR < p2.PNR;
```
---
```
SQL> SELECT * FROM PERSONAL p1 INNER JOIN PERSONAL p2 ON p1.ABT_NR=p2.ABT_NR WHERE p1.PNR < p2.PNR;

       PNR VORNAME	    NACHNAME	     GEH_S ABT_N KRA	 PNR VORNAME 	     NACHNAME	 GEH_S ABT_N KRA
---------- ------------ ----------------------- ----- ----- ---------- -------------------- -----------------
       132 Grace		Hopper		     it4   abt15 dek    145 Marie		     Curie		  it4	abt15 dek
       124 Leonhard		Euler		     it2   abt11 aok    147 Hedy		     Lamarr		  it5	abt11 dek
       126 Ren??		Descartes	     it1   abt12 dek    133 Radia		     Perlman	  it3	abt12 dek
       123 Ada			Lovelace	     it5   abt13 dek    161 Martin		     Fowler		  it2	abt13 dek
       127 Alan 		Turing		     it2   abt14 dek    163 Erich		     Gamma		  it1	abt14 dek

```

---

*Aufgabe*

Probieren Sie die verschiedenen `join` Arten mit verschiedenen Tabellen aus.

1. Schreiben Sie auf, was Sie feststellen. 
2. Mit welchen Tabellenkombinationen und Spalten geht es nicht? 
3. Auf was muss man achten, wenn man mehr als zwei Tabellen nimmt? 
4. Konstruieren Sie zu 3) ein Beispiel.

^ zu 3) fuer jede Tabellenkombination muss eine Gleichheitsbedingung gefunden werden

---

#[fit] Aggregatsfunktionen

^ nur im SELECT oder HAVING
bezieht auf alle Zeilen bzw Elemente in der Gruppe

---

# `COUNT`

--- 

- Zählt die Anzahl der verschiedenen Werte
- Nullwerte werden nicht mitgezählt.
- zählt Anzahl der Zeilen im Zwischenergebnis oder alle

---

```sql
SELECT COUNT(*) AS "PERSONALANZAHL"
FROM PERSONAL;

SELECT COUNT(*) AS "Anzahl", ABT_NR
FROM PERSONAL
GROUP BY ABT_NR
HAVING COUNT(*) > 1
ORDER BY 1 DESC;
```
---

```
SQL> SELECT COUNT(*) AS "PERSONALANZAHL" FROM PERSONAL;

PERSONALANZAHL
--------------
	    12

SQL> SELECT COUNT(*) AS "Anzahl", ABT_NR FROM PERSONAL GROUP BY ABT_NR HAVING COUNT(*) > 1 ORDER BY 1 DESC;
    Anzahl ABT_N
---------- -----
	 	 3 abt13
	 	 2 abt12
	 	 2 abt14
	 	 2 abt15
	 	 2 abt11
```

---

# *Aufgaben*

1. Welcher Mitarbeiter hat wie viele Kinder?
1. Wieviele Mitarbeiter haben schon mal eine Prämie bekommen?

---

# `MIN` - und `MAX`

---

- damit wird der kleinste / größte Wert in jeder Gruppe der angegebenen Spalte bestimmt
- kann auch der `NULL`-Wert sein.

---

```sql
SELECT MAX(P_BETRAG)
FROM PRAEMIE;

SELECT ABT_NR
FROM PERSONAL
GROUP BY ABT_NR
HAVING MAX (PNR) > 160;
```
---

```
SQL> SELECT MAX(P_BETRAG) FROM PRAEMIE;

MAX(P_BETRAG)
-------------
	 2300

SQL> SELECT ABT_NR FROM PERSONAL GROUP BY ABT_NR HAVING MAX (PNR) > 160;

ABT_N
-----
abt13
abt14
```
---

# *Aufgaben*

1. Welche Maschine hat den höchsten Neuwert?
1. Was war die niedrigste Prämie?

---

# `SUM`

---

- berechnet die Summe aller Werte in jeder Gruppe der angegebenen Spalte
- ist nur für Spalten mit numerischen Datentyp zugelassen
- bei `DISTINCT` werden mehrfach auftretende gleiche Werte zu einem summiert (nur einmal gezählt)
- die Summe von nur `NULL`-Werten ist `NULL`

^nur für Spalten mit numerischen Datentyp zugelassen
Summe von nur NULL-Werten ist NULL
berechnet die Summe aller Werte in jeder Gruppe der angegebenen Spalte

---

```sql
SELECT SUM(P_BETRAG) 
FROM PRAEMIE;

SELECT PNR
FROM PRAEMIE
GROUP BY PNR
HAVING SUM(P_BETRAG) > 1000;
```

---

```
SQL> SELECT SUM(P_BETRAG) FROM PRAEMIE;

SUM(P_BETRAG)
-------------
	 6700

SQL> SELECT PNR FROM PRAEMIE GROUP BY PNR HAVING SUM(P_BETRAG) > 1000;

       PNR
----------
       123
```

---

# *Aufgaben*

1. Wie viel sind alle Maschinen zusammen zum aktuellen Zeitpunkt wert?
2. Wer arbeitet an Maschinen, die zusammen einen Neuwert von mehr als 60.000 EUR haben?

---

# `AVG`

^ berechnet das arithmetische Mittel der Werte in jeder Gruppe der angegebenen Spalte
nur für Spalten mit einem numerischen Datentyp zugelassen

---

- berechnet das arithmetische Mittel der Werte in jeder Gruppe der angegebenen Spalte
- ist nur für Spalten mit einem numerischen Datentyp zugelassen
- bei `DISTINCT` werden mehrfach auftretende gleiche Werte nur einmal berücksichtigt
- sind in einer Spalte nur `NULL`-Werte, ist das Ergebnis `NULL`, ansonsten werden `NULL`-Werte von der Berechnung ausgeklammert.

---

```sql
SELECT PNR, AVG (P_BETRAG)
FROM PRAEMIE
GROUP BY PNR
HAVING AVG (P_BETRAG) > 500;
```

---

```
SQL> SELECT PNR, AVG (P_BETRAG) FROM PRAEMIE GROUP BY PNR HAVING AVG (P_BETRAG) > 300;

       PNR AVG(P_BETRAG)
---------- -------------
       123	    1500
       124	     350
       132	    1000
       133	     600
       145	     500
       147	     400
       161	     500

7 rows selected.
```
^ nicht sortiert!

---

# *Aufgaben*

1. Wer arbeitet an Maschinen, deren durchschnittlicher Zeitwert weniger als 20.000 EUR wert ist?
2. Was ist der durchschnittliche Anschaffungswert einer Maschine?

---

### Funktionen in der `SELECT`-Komponente

---

```sql
SELECT GEH_STUFE, BETRAG * 1.06 AS "Gehaltserhoehung"
FROM GEHALT;
```
---

```
SQL> SELECT GEH_STUFE, BETRAG * 1.06 AS "Gehaltserhöhung" FROM GEHALT;

GEH_S Gehaltserhöhung
----- ----------------
it1	       2674.38
it2	       3045.38
it3	       3208.62
it4	       3541.46
it5	       4008.92
```

---

# `UNION`

---

# *Regeln:*

- alle `SELECT`-Anweisungen besitzen die gleiche Anzahl Spalten
- die Spalten besitzen die gleichen Datentypen
- nur die letzte `SELECT`-Anweisung darf die `ORDER BY`-Komponente enthalten, sortiert wird auf der Grundlage des Endergebnisses
- doppelte Zeilen werden automatisch gelöscht, `DISTINCT` darf nicht vorkommen.

---

```sql
SELECT NACHNAME, VORNAME
FROM PERSONAL
WHERE PNR=132
UNION
SELECT NACHNAME, VORNAME
FROM PERSONAL
WHERE PNR=163
UNION
SELECT NACHNAME, VORNAME
FROM PERSONAL
WHERE PNR=173
ORDER BY 1;

SELECT NACHNAME, VORNAME
FROM PERSONAL
WHERE PNR=132 OR PNR=163 OR PNR=173
ORDER BY 1;
```

---

```
SQL> SELECT NACHNAME, VORNAME FROM PERSONAL WHERE PNR=132
UNION
SELECT NACHNAME, VORNAME FROM PERSONAL WHERE PNR=163
UNION
SELECT NACHNAME, VORNAME FROM PERSONAL WHERE PNR=173
ORDER BY 1; 

NACHNAME	     VORNAME
-------------------- --------------------
Gamma		     Erich
Helm		     Richard
Hopper		     Grace
```

---

# Subquery

---

- vollständige `SELECT`-Anweisung, die als rechtsseitiger Ausdruck in einer `WHERE`-Bedingung verwendet wird.

- bei Operatoren wie `IN`, `ANY`, `ALL`, `EXISTS`:
  -- `SELECT`-Komponente darf nur einen Spaltenausdruck enthalten
  -- `DISTINCT` nicht erlaubt − `ORDER BY` nicht erlaubt

- Attributnamen gelten in der `SELECT`-Anweisung, in der ihre Relation angegeben ist, und in allen zugehoerigen Unterabfragen.

---

### Wie oft wurde der minimale Prämienbetrag gezahlt ?

```sql
SELECT COUNT(*)
FROM PRAEMIE
WHERE P_BETRAG =
    (SELECT MIN(P_BETRAG) 
     FROM PRAEMIE);
```

---

```
SQL> SELECT COUNT(*) FROM PRAEMIE WHERE P_BETRAG = (SELECT MIN(P_BETRAG) FROM PRAEMIE);

  COUNT(*)
----------
	 1
```

---

# `ORDER BY` 

---

- sortiert die Zeile auf der Grundlage der angegebenen Attribute
- die Attribute werden durch ihre Namen oder durch die Angabe der Spaltennummer gekennzeichnet
- Nummer muss stehen, wenn Spaltenausdruck aus einer Funktion, einer Konstanten oder einem numerischen Ausdruck besteht
- standardmäßig aufsteigend (ASC) sortiert
- absteigend sortiert bei Angabe von DESC

----

# [fit] *Aufgabenblatt*

## `anfragen.sql`

---

# `ALTER TABLE`

---

# `UPDATE TABLE`

---

# `INSERT TABLE`

---

# Das war's für heute 
![fit](../images/Rainbow_Dash.png)
