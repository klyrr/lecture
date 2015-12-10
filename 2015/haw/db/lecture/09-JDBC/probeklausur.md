# Musterklausur 
Materialien (Zettel, keine digitalen Geräte: Handy, Tablett, EBook-Reader) sind zur Klausur zugelassen.

Fragen besprechen am 7.1.2016

# Aufgabe 1
### a) Erläutern Sie, was die Drei-Schichten-Architektur für die Software-Entwicklung bedeutet.

### b) Aus welchen Bestandteilen besteht das ER-Modell? Geben Sie für jeden Bestandteil ein Beispiel.

### d) Wozu benoetigt man Primaerschluessel?

### e) Nennen Sie drei verschiedene Datenmodelle und erlaeutern Sie diese kurz.

# Aufgabe 2

### a) Gegeben seien folgende FD. Finden Sie drei weitere:

```
A -> B, A,B -> C, B -> D, C -> A,B
```

### b) Wann liegt eine Tabelle in der 3NF vor?

### c) In welcher Normalform liegt folgende Tabelle vor? Warum?

```
Bestellung                                    
 
KundenNr | Kundenname | Geburtsdatum | Bestellnummer | Artikelname |
--------------------------------------------------------------------
       1 |   Frühling |   01.03.2000 |             1 |        Hund | 
--------------------------------------------------------------------
       2 |     Sommer |   01.06.2000 |             2 |        Hund |
--------------------------------------------------------------------
       3 |     Herbst |   01.09.2000 |             3 |        Hund |
--------------------------------------------------------------------
       1 |   Frühling |   01.03.2000 |             4 |     Elefant |
--------------------------------------------------------------------
       4 |     Winter |   01.12.2000 |             5 |        Hase |
--------------------------------------------------------------------

```


# Aufgabe 3

Gegeben seien die beiden folgenden Tabellen „Kunde“ und „Bewertung“. Primärschlüssel für `Kunde` sei `KundenNr`, Primärschlüssel für `Bewertung` die Kombination `(KundeNr, Quelle)`.

```
Kunde                                    Bewertung
 
KundenNr | Kundenname | Geburtsdatum |  | KundenNr | Note | Quelle |
--------------------------------------  ----------------------------
       1 |   Frühling |   01.03.2000 |  |        1 |    4 | Schufa |
--------------------------------------  ----------------------------
       2 |     Sommer |   01.06.2000 |  |        1 |    2 |  Staat |
--------------------------------------  ----------------------------
       3 |     Herbst |   01.09.2000 |  |        2 |    3 | Schufa |
--------------------------------------  ----------------------------
       4 |     Winter |   01.12.2000 |  |        3 |    1 |  Euler |
--------------------------------------  ----------------------------

```
 Erstellen Sie für a) - e) SQL-Anweisungen, die folgende Anfragen beantworten bzw. Änderungsoperationen durchführen. 
 Bei f) ist es andersrum: Was ist das Ergebnis der Anfrage?

### a) Wie viele Kunden sind in der Tabelle „Kunde“ gespeichert? 
### b) Wie viele Bewertungen stammen aus der Quelle „Schufa“?

### c) Fügen Sie eine neue Bewertung für den Kunden "Winter" ein.

### d) Löschen Sie aus der Tabelle Bewertung alle Tupel, bei denen die Note 4 oder 5 ist.

### e) Fügen Sie der Tabelle `Bewertung` eine Spalte hinzu, in die man eine Bemerkung eintragen kann.

### f) Wie lautet das Ergebnis des folgenden SQL-Befehls basierend auf obigem Tabelleninhalt: 
 `SELECT KundenNr, AVG(Note) FROM Bewertung GROUP BY KundenNr` 

### g) Schreiben Sie das `CREATE TABLE` für die Tabellen `Kunde` und `Bewertung`

# Aufgabe 4 
### a) Was sind Transaktionen?

### b) Welche Eigenschaften haben Transaktionen?



# Aufgabe 5
### a) Erklären Sie kurz, wofür die einzelnen Buchstaben des CAP-Theorems stehen