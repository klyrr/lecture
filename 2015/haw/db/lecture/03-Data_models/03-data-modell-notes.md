autoscale: true
footer: Tina Umlandt, 2015
slidenumbers: true

---

# Wiederholung

---

# [fit] Systemarchitektur 
## vs 
# [fit] Softwarearchitektur

---

## [fit] Zwei-Schichten-Architektur
## [fit] *Client-Server-Architektur*

---

## [fit] Drei-Schichten-Architektur

---

## [fit] ANSI-SPARC-Architektur

---

1. Interne Ebene/ Schema
2. Konzeptionelle Ebene
3. Externe Ebene

--- 

# Los geht's `\o/`

---

1. Grundlagen: Was sind Datenbankmodelle
2. Entity-Relationship-Modell
3. Relationenmodell
4. Hierarchisches Modell
5. Netzwerkmodell
6. Objektorientierte Modelle
7. Objektrelationale Modelle
8. XML-basierende Modelle

---

# [fit] Datenbankmodelle

---

## Statischen Eigenschaften

^ wie z.B. Objekte und Beziehungen oder Tabellen.

---

## Dynamischen Eigenschaften 
^ wie Operationen und Beziehungen zwischen Operationen

---

Unterscheidung zwischen Objekten (Datenbankschema oder Datenbank) und Konzepten zu deren Darstellung (Datenbankmodell). 

---

## dreistufige Beziehung

```
| Enthält                  |                   | Beispiel                  |
| ------------------------ | ----------------- | ------------------------- |
| Konzepte zur Darstellung | *Datenbankmodell* | Relationen                |
| ------------------------ | ----------------- | ------------------------- |
| Objekte                  | *Datenbankschema* | Relation "Vorlesung"      |
| ------------------------ | ----------------- | ------------------------- |
| Daten                    | *Datenbank*       | "Analysis", "Compilerbau" |
| ------------------------ | ----------------- | ------------------------- |
```
---

## Warum gibt es mehrere Datenbankmodelle?

^ Erster Grund: Historische Entwicklung 
^ Zweiter Grund: Unterschiedliche Anforderungen führen zu unterschiedlichen Datenmodellen

---

## Welche Modelle sind wichtig?

^ Relationales Modell: In den DBMS realisiert
^ Entity-Relationship-Modell: Modellierung von Anwendungen

---

# Entity-Relationship-Modell

^ sehr einfach und anschaulich
^ Schwäche: Es ist nicht fundiert und erlaubt beispielsweise keine Qualitätsaussagen über Modelle

---

# *Entity*

^ die zu modellierende Informationseinheit

---

# *Relationship* 

^ Beziehungen zwischen Entitäten

---

# *Attribute* 

^ Eigenschaften von Entitäten oder Beziehungen

---

# Beispiel

---

![fit](../images/er-modell.png)

^ Entitäten sind Objekte der realen oder Vorstellungswelt, über die Informationen zu speichern sind.
^ Entitätentypen werden als Rechteck dargestellt (Professor, Veranstaltung)
^ Beziehungstypen werden als Raute dargestellt
^ Beziehungen werden zwischen mindestens zwei Entitäten definiert
^ Attribute modellieren Eigenschaften von Entitätstypen oder Beziehungstypen und werden als Rechtecke mit abgerundeten Ecken dargestellt 

---

![fit](../images/er-modell-erweitert.png)

---

## *Schlüssel*

^ Menge von identifizierenden Attributen
^ grafischen Darstellung wird der Schlüssel unterstrichen.

---

![fit](../images/er-modell-schluessel.png)

---

## *Kardinalitäten*

^  schränkt die möglichen Teilnahmen von Entitäten an einer Beziehung ein, indem ein minimaler und ein maximaler Wert angegeben wird.

---

![fit](../images/er-modell-kardinalitaet.png)

---

- *1* heißt genau eins
- *n* (oder *m*) heißt eins oder mehrere
- *c* heißt optional und kann mit *1* und *n*/*m* kombiniert werden.

![right fit](../images/er-modell-kardinalitaet-II.png)

---

# [fit] Many-to-Many-Beziehung 
### (n:m-Beziehung)

---

# [fit] Many-to-One-Beziehung 
### (n:1-Beziehung)

---

# [fit] One-to-One-Beziehung 
### (1:1-Beziehung)

---

---

Aufgabe als ER-Modell - *15 Min*

- Es sollen die Informationszusammenhänge für ein Flugbuchungssystem einer Fluggesellschaft modelliert werden
- Flüge werden durch eine Flugnummer identifiziert, die für Flüge am selben Tag eindeutig ist
- Passagiere können einen Flug reservieren, was durch eine Reservationsnummer bestätigt wird. Eine Reservierung wird zu einer festen Buchung, indem man ein Ticket kauft
- Bei der Reservierung oder später können Passagiere auch eine Sitzplatzreservierung vornehmen
- Für Teilnehmer des Vielfliegerprogramms ist die gesamte mit der Fluggesellschaft geflogene Kilometerzahl von Bedeutung
- Flüge fliegen von einem bestimmten Flugsteig ab
- Passagiere müssen vor dem Abflug eine Check-in-Prozedur durchlaufen. Dabei können sie auch Gepäckstücke aufgeben. 

^ wir brauchen das spaeter noch haeufiger

---

![fit](../images/er-modell-aufgabe.png)

---

---

# UML

^ Unified Modeling Language
^ Modellierungssprache zur Spezifikation, Konstruktion und Dokumentation von Software-Teilen und anderen Systemen
^ Dokument werden Konzepte wie die Klasse, die Assoziation oder die Multiplizität eines Attributs spezifizierta

---

# Benutzung
## UML vs. ERM

^  ERDhow the tables should connect, what fields are going to be on each table, the tables connection, if many-to-many, one-to-many.

^ UML sequence diagram, state diagram, more for the funcionality of the application (what user can do, who does it, when he does it, before what step, what table he use to do it) other then the tables description.

^ ERD to describe database relation and 
^ UML to describe operations, time, actions, e

---

## UML
### Klassendiagramm

^ kann als Ersatz zu ERM benutzt

---

Beispiel fuer Klassendiagramm


![right fit](../images/klassendiagrammUML.png)

---

![fit](../images/UML-Assoziation.png)


---

![fit](../images/UML-Komposition.png)

---

![fit](../images/UML-Vererbung.png)

---

## *Aufgabe*
### Flughafenverwaltung als UML (Klassendiagramm)

---

## UML 
### Sequenzdiagramm

---

![fit](../images/uml-sequence.png)

---

![fit](../images/IMG_20151015_140238.jpg)

---

---

# *Datenmodelle*

^ Unterstützung bei der Übertragung des konzeptionellen Datenmodells in das physische und systemabhängige 
Datenmodell. 
^ Es ist dennoch unabhängig von der Implementierung.

---

![fit](../images/overviewDataModells.png)

---

# [fit] *Relationenmodell*

^ entwickelt 1970 von Codd
^ Modell basiert auf Relationen
^ also Teilmengen eines kartesischen Produkts.

---

```
Messdaten | Tier    | Groesse | Gewicht |
--------- | ------- | ------- | ------- |
          | Tiger   | 265 cm  | 140 kg  |
--------- | ------- | ------- | ------- |
          | Tiger   | 230 cm  | 120 kg  |
--------- | ------- | ------- | ------- |
          | Leopard | 120 cm  | 40 kg   |
--------- | ------- | ------- | ------- |
          | Jaguar  | 165 cm  | 88 kg   | 
--------- | ------- | ------- | ------- |
          | Jaguar  | 142 cm  | 78 kg   | 
--------- | ------- | ------- | ------- |
```

---

# [fit] Relationenschemata

^ Objekte und Beziehungen der zu modellierenden Anwendungswelt durch Relationenschemata beschrieben
^ besteht aus Attributen
^ Attribute haben Wertebereich
^ Datenbankschema besteht (vorerst) aus einer Menge von Relationenschemata.

---

# Relation

^ Relation stellt die zu einem Relationenschema passenden und aktuell vorhandenen Daten dar.
^ Menge aller Relationen heißt Datenbank

---

# Tupel 

^ Element einer Relation heißt Tupel

---

```
| Attribute | Wertebereiche |
| --------- | ------------- |
| Tier      | String        |
| Groesse   | Float         |
| Gewicht   | Float         |

```

![right fit](../images/relationenschema.png)

---

Mathematisch:

Relation Tier  String x Float x Float

^ Kartesisches Produkt

---

# [fit] Integritätsbedingungen

^ Relation ist eine Menge, d.h. es sind keine zwei Tupel mit identischen Werten erlaubt
^ alle Tupel erlaubt, solange sie den Wertebereichen entsprechen
^ Die Reihenfolge der Attribute ist irrelevant (Menge!)

---

# Schlüssel

^ notwendig, für jede Relation einen Schlüssel, d.h. eine identifizierende Attributkombination 
^ Oftmals gibt es in Relationen einen „natürlichen“ Schlüssel (z.B. Matrikelnummer für Studenten)
^ angeblich „natürlichen“ Schlüssel wurden jedoch zumeist gerade wegen ihrer Schlüsseleigenschaft neu eingeführt 
^ keinen „natürlichen“ Schlüssel gibt, muss ein neues Attribut eingeführt oder eine Attributkombination ausgezeichnet 
^ Eine Relation kann mehrere Schlüssel haben
^ mehrere mögliche Schlüssel gibt, so spricht man von verschiedenen Schlüsselkandidaten
^ Primärschlüssel
^ Einführung eines Schlüssels ist immer eine Entwurfsentscheidung
^ besonderen Datentyp : Datentyp ist eine (große) Zahl, automatische Erhöhung, je DB unterschiedlich

---

### [fit] Schlüsselkandidat > Primaerschluessel

^ Jede Relation muss einen Primärschlüssel besitzen. Er ist aus der Menge der Schlüsselkandi­ daten auszuwählen.
^ wichtige Aufgaben eines Primärschlüssels ist das zeitlich schnelle auffinden von Datensätzen. 
^ Auch hier gilt: je kleiner der Primärschlüssel, desto performanter können Daten­ sätze gefunden werden.

---

## Beispiel zu Schlüsseln

---

### Tabelle *Literatur*

```

ISBN	Autor	Buchtitel
0001	Hans	V
0002	Lutz	W
0003	Peter	X
0004	Peter	Y
0005	Ralf	Z

```

---

### Tabelle *Kunde*
```
Name	                Geburtstag	Wohnort	
Heinz Hoffmann      	01.08.1966	Norden, BBS	
Alf Appel	            08.11.1957	Mömlingen	
Sebastian Sonnenschein	04.08.1979	Hamburg	
Klaus Kleber    	    15.04.1970	Frankfurt	
Barbara Bachmann    	17.10.1940	Kirchheim
```
---

### Tabelle *IstChefVon*
```
Vorgesetzter	Untergebener
002				104
030				512
115				516
234				993
234				670
```
---

## *fachliche* Schlüssel

^ inhaltsbezogene Attribute bezeichnet, die Schlüssel sind und z.B. auch im ER-Modell dargestellt wurden

---

## *technische* Schlüssel

^ künstlich hinzugefügte Attribute bezeichnet, die nur wegen der Schlüsseleigenschaft existieren (ID)

---

## Fremdschlüssel


![right fit](../images/fremdschluessel.png)

^ Integritätsbedingungen
^  Attributskombination A in einem Relationenschema R heißt Fremdschlüssel, wenn es in einem Relationenschema R2 den Primärschlüssel P gibt und A = P gilt.
^ Tupel aus R schaut man sich die Attribute A an. Dann gibt es in R2 jeweils ein Tupel, das die entsprechende Werte aus A enthält.
^ Einfügen, Ändern und Löschen von Daten, auf denen Fremdschlüsselbeziehungen definiert sind, muss besonders berücksichtigt werden
^ Mehrere Tupel unterschiedlicher Relationen gehören „inhaltlich“ zusammen und müssen gemeinsam manipuliert werden
^ DBMS bieten besondere Konstrukte nicht nur für die Definition von Fremdschlüsseln, sondern auch für die Modifikation von an Fremdschlüsselbeziehungen beteiligten Tupeln

---

# [fit] Transformation 
# ERM -> RM

![right fit](../images/fremdschluessel-ERM-RM.png)

---

- Jeder Entitätstyp wird auf eine Relation abgebildet
	- Die Attribute der des Entitätstyps werden den Attributen der Relation zugeordnet
- Es muss ein Primärschlüssel gewählt werden 
- Abschließend werden die Beziehungen transformiert
	- Beziehungstyp innerhalb des ER­Modells wird mittels eines eigenen Fremdschlüssels im Relationenmodell abgebildet
	- NM bzw. N:MC­ - Beziehungen werden in zwei 1:N bzw. 1:NC­ - Beziehungen aufgelöst.

---

## Aufgabe

Nehmen Sie Ihre obige Lösung zum ER-Modell (Flughafen) und wenden Sie das Relationenmodell für Beispieldatensätze (die sich ausdenken) an. 

Falls Ihnen auffällt, dass Ihnen etwas in Ihrem ER-Modell fehlt, ergänzen Sie es in beiden Modellen.

---

## Operationen im Relationenmodell

^ Es gibt im Relationenmodell eine Reihe von vordefinierten Operationen, die immer verfügbar und immer sinnvoll sind. 

---

## Selektion

^ : Die Selektion wählt Tupel (Zeilen) aus einer Relation aus. Dazu wird eine Selektionsbedingung genutzt. 
^ Beispiel: Selektiere alle Tupel aus Prof, bei denen der Raum „3.202“ ist.

---

## Projektion

^: Die Projektion wählt Spalten aus einer Relation aus. Dazu ist eine Angabe der ausgewählten Attributmenge erforderlich.
^  Beispiel: Projektion auf das Attribut „Name“ in der Relation Prof.

---

## Verbund / Join

^ : Beim Verbund werden zwei Relationen verknüpft. Das Ergebnis ist eine neue Relation, in der alle Attribute aus beiden Relationen enthalten sind.

---

## Mengenoperationen

^ Die üblichen Mengenoperationen wie Vereinigung, Schnitt und Differenz können auf Relationen angewendet werden.

---

## Umbenennung

^: Mit dieser Operation ist es möglich, ein Attribut umzubenennen. 

---

# Vergleich 
# [fit] mit dem ER-Modell

---

## Beziehungen

^ Im ER-Modell werden Entitätstypen und Beziehungstypen strikt getrennt
^ Im relationalen Modell werden sowohl Entitätstypen als auch Beziehungstypen durch Relationen dargestellt

---

## Operationen

^ Das ER-Modell enthält keine Möglichkeit, Operationen auszudrücken
^ Das relationale Modell bietet Standardoperationen zur Anfrage von Daten und zur Änderung von Daten

---

## [fit] Integritätsbedingungen

^ Das ER-Modell bietet nur wenige Integritätsbedingungen
^ Das relationale Modell bietet beliebige Integritätsbedingungen

---

## Präsentation

^ Das ER-Modell ist grafisch
^ Das relationale Modell ist eher textorientiert

---

# [fit] Hierarchisches Modell

^ Gut geeignet, um hierarchische Daten darzustellen
^ Nicht-hierarchische Daten sind nur über Umwege modellierbar
^ Die Bäume legen das Schema fest
^ Verknüpfungen werden über Eltern-Kind-Beziehungen 
^ Das hierarchische Modell ist eng mit den Implementierungen verbunden (insbesondere IMS von IBM)
^ Es gibt keine interaktive Sprache für Datendefinition oder –abfrage
^ Die Interaktion erfolgt über Programme (zumeist COBOL)
^ Die wesentliche Operation in einer hierarchischen Datenbank ist der Durchlauf durch den Baum
^ Der Durchlauf funktioniert von oben nach unten und von links nach rechts
^ diese Baumstruktur lassen sich nur 1:1 und 1:n-Beziehungen darstellen
^ bekannteste hierarchisch organisierte Datenbanksystem ist IMS/DB der Firma IBM.
^ Mangelhafte Datenunabhängigkeit

---

![right fit](../images/hierarchischesModell.png)

- Durchlauf von Prof ausgehend zu Veranstaltung, dann zu Buch und dann zu Student
- Was nicht funktioniert: Direkt zu Student
- Deshalb: Guter Entwurf der Bäume wichtig!

---

![fit](../images/hierarchisches_datenbankmodell_beispiel.jpg)

---

![fit](../images/hierarchischesModell1.png)

---

![fit](../images/hierarchischesModell2.png)

---

# [fit] *Netzwerkmodell*

^ Nach dem hierarchischen Modell hat man sich überlegt, wie man Datenmodelle allgemeiner fassen kann. 
^ In der Mathematik kennt man als Verallgemeinerung von Bäumen den 
^ keine strenge Hierarchie und kann deswegen auch m:n-Beziehungen abbilden -> ein Datensatz kann mehrere Vorgänger haben
^ Verallgemeinerung des hierarchischen Datenbankmodells

---

![fit](../images/netzwerkmodell.png)

^ Datensätzen (Record), welche aus verschiedenen Feldern (Data Item) bestehen. 
^ Ein Feld hat einen Namen und einen Wert. 
^ Jeder Satz beschreibt eine Person, ein Objekt oder ein Ereignis (event).

^ Ein Netzwerk-Datenbankmanagementsystem (DBMS) bearbeitet Datensätze. 
^ Ein Satz, oder genauer die Ausprägung eines Satzes (record occurrence) kann als Ganzes in die Datenbank gespeichert (STORE), verändert (MODIFY) und wieder gelöscht (DELETE) werden.
^ Beziehungen nur 2-stellig
^ Mangelhafte Datenunabhängigkeit

---

# [fit] *Objekt-Orientiertes Modell*

^ DBMS implementieren direkt ein objektorientiertes Datenmodell
^ Herkunft zumeist aus dem Programmiersprachenbereich
^ Konsequenz: Kaum Unterscheidung zwischen Datenbankschema und Programm, d.h. wenig (im Idealfall keine) Transformation erforderlich
^ Konsequenz: geringe Anwendungsunabhängigkeit, da das Datenbankschema häufig genau für eine Anwendung optimiert ist
^ Versuch der Standardisierung durch Object Data Management Group (ODMG) als Herstellervereinigung von OO-DBMS 

---

## ODMG-Standard

^ kommt auf den naechsten Folien

---

### Objektmodell

^ (angelehnt an C++, mit Objektidentität, Vererbung, Methoden, Typkonstrukturen (set, list, tuple, bag))

---

### Datenbankdefinitionssprache *ODL*

^ (basiert auf Objektmodell)

---

### Datenabfragesprache *OQL*

^ (Mächtige, auf SQL basierende Sprache zur Abfrage objektorientierter Daten)

---

### Spracheinbettungen für Programmiersprachen (C++, Smalltalk, Java)

^ Nutzung objektorientierter DBMS hat sich bisher in betrieblichen Informationssystemen _nicht_ durchgesetzt

---

### Verhalten
^ als Definition von Methoden
^ Methoden können Parameter haben mit Schlüsselworten:
	- IN als Übergabeparameter, 
	- OUT als Rückgabeparameter und 
	- INOUT als kombinierte Parameter. 

---

### Strukturierte Typkonstruktoren 

^ Menge (set)
^ Multimenge (bag)
^ Liste (list)
^ Tupel (tuple)
^ Aufzählung

---

### Atomare Datentypen
^ Integer 
^ Float 
^ Character
^ Boolean

---

## Beispiel

```
interface  Auto: KFZ {
	extent autos;
	key fahrgestell_Nr;
	attribute string autoArt;
	relationship MotorTyp autoMotor inverse MotorTyp::eingebaut_in;
	void verkaufen (IN Person) raises (Schrottreif);
};
```
^ Programmiersprachenunabhängige Modellierung in ODL
^ wird in konkrete Programmiersprache durch Präcompiler übersetzt

---

## Beispiel

```
Query q = new Query (
	Employee.class,
	"manager.salary < salary");
Collection<Employee> result = q.select(employees);
```

```
SELECT EMP.ID, EMP.NAME 
FROM EMPLOYEE EMP, EMPLOYEE BOSS
WHERE EMP.BOSS = BOSS.ID AND BOSS.SALARY < EMP.SALARY
```

---

## Aufgabe

Nehmen Sie Ihre obige Lösung zum ER-Modell (Flughafen) und wenden Sie das Object-Orientierte Modell an. 

Falls Ihnen auffällt, dass Ihnen etwas in Ihrem ER-Modell fehlt, ergänzen Sie es in beiden Modellen.

---

# [fit] *Objekt-Relationales Modell*

^ Relational model extended: nested relations, references, sets, row types, abstract types, functions 
^ Add new data functionality to relational: User-Defined Types (UDTs): can be used in table cell or as row of a table

---

![fit](../images/objectrelationalModell.png)

---

## UDT

^ User defined types

---

## Distinct Types

^  is a user-defined data type that shares its internal representation with a built-in data type (its source type), but is considered to be a separate and incompatible data type for most operations.

---

```
CREATE TYPE Aepfel AS integer NOT FINAL; 
CREATE TYPE Birnen AS Integer FINAL; 
```
^ Äpfel und Birnen sind nicht kompatibel, obwohl beide auf Integer basieren 
^ FINAL besagt (wie in Java), dass es keine Untertypen von Birnen geben darf

---

## Structured Types

^ basieren auf Typkonstrukturen, um neue komplexe Typen zu definieren

---

```
CREATE TYPE Adresse AS
	( PLZ integer, 
	  Strasse varchar(50),
	  Nummer varchar (15)
    ) not final;

```

---

## Arrays

```
CREATE TYPE Noten AS  INTEGER ARRAY[25];

ARRAY[ ] 
ARRAY[<Werteliste>] 
ARRAY[<SQL-Anfrage>]
```
---

## Objektorientierte Merkmale

---

### `FINAL` oder `NOT FINAL`

^ für Erbbarkeit

---

### `NOT INSTANTIABLE`

^ für abstrakte Typen

---

### Methoden

```
CREATE TYPE Aepfel ... NOT FINAL 

METHOD ernten() returns integer; 

CREATE METHOD ernten () FOR Aepfel <Methodenrumpf>

```

^ (unterschieden in ändernde und nichtändernde (Mutator- vs. Observer-Methoden)) lassen sich definieren (auch als Klassenmethoden (STATIC) und Konstruktoren (CONSTRUCTOR)) 

---

## Einfachvererbung

```
CREATE TYPE Boskop UNDER Aepfel AS ... INSTANTIABLE NOT FINAL 

OVERRIDING METHOD ernten () returns integer;
```

^ ist möglich 
^ Hierbei wird Boskop als Untertyp von Äpfel definiert und die Ernte-Methode überladen
^ Eine gleichnamige Methode mit unterschiedlicher Signatur ist nicht gestattet

---

### Tabellen auf UDT

```
CREATE TABLE Apfeltabelle OF Aepfel

CREATE TABLE Boskoptabelle OF Boskop UNDER Apfeltabelle

```

---

Aufgabe:

Nehmen Sie Ihre obige Lösung zum ER-Modell (Flughafen) und wenden Sie das Object-Relationale Modell an. 

Falls Ihnen auffällt, dass Ihnen etwas in Ihrem ER-Modell fehlt, ergänzen Sie es in beiden Modellen.

---

#[fit] *XML-basierendes Modell*

^ XML-Daten sind semistrukturiert, d.h. es wird eine „lockere“ Struktur vorgegeben, 
^ Semistrukturierte Daten sind weniger strukturiert als z.B. relationale Daten
^ Semistrukturierte Daten sind stärker strukturiert als z.B. Word-Dokumente
^ semistrukturierte Daten werden zwar oftmals Schemata angegeben, aber die Daten müssen den Schemata nicht zwingend genügen
^ XML-Dokumente („Datensätzen“) alternative Strukturen spezifiziert werden und die spezifizierte Struktur sogar missachtet werden
^ Datensätze sind strukturtragend (=selbstbeschreibend)

---

```
<Buch> 
	<Autor>
		<Name>Sunzi</Name>
		<Geburtsjahr>534 v.Chr</Geburtsjahr>
		<Sterbejahr>453 v.Chr</Sterbejahr>
	</Autor>   
	<Titel>Kunst des Krieges</Titel>
	<Kapitel>Planung</Kapitel>
	<Kapitel>Über die Kriegskunst</Kapitel>
	<Kapitel>Taktik</Kapitel>
</Buch>

```
^ Probleme?

---

## Anfragesprache Xquery

^ vom W3C standardisiert

---

Aufgabe 1: Was liefert das Statement zurück?

```
for $x in doc('books.xml')/bookstore
	where $x/price > 30
	order by $x/title
return $x/title
```

Aufgabe 2: Wie muss das zugehörige XML aussehen?

---

Aufgabe:

Nehmen Sie Ihre obige Lösung zum ER-Modell (Flughafen) und wenden Sie das XML-Basierte Modell an. 

Falls Ihnen auffällt, dass Ihnen etwas in Ihrem ER-Modell fehlt, ergänzen Sie es in beiden Modellen.

---

# *NoSQL-Datenmodelle*

---

## Key-Value-Store

^ direkte Suche nach Werten ist nicht möglich
^ vorhersagbaren Reihenfolge über alle Key-Value-Paare zu iterieren.
^ bilden Schlüssel (Keys) auf Werte (Values) ab
^ globalen Namensraum in verschiedene Keyspaces (auch Segmente oder Buckets genannt) 

---

```
shop.settings.vat=19

shop.country="de_DE"

```

^ Redis: 100.000 Schreibvorgänge und ca. 80.000 Lesevorgänge pro Sekunde

---

##[fit] Dokumentendatenbanken

^ speichern Daten in Form von Dokumente als JSON 

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

#[fit] *Zusammenfassung*

^ nicht ein „bestes“ Modell, sondern nur Modelle, die bestimmte Anforderungen besser oder schlechter erfüllen
^ werden mehrere Modelle in unterschiedlichen Entwicklungs-phasen genutzt, wobei das relationale Modell, eventuell mit objekt-relationalen Erweiterungen zumeist als Implementierungsmodell dient

---

# Das war's für heute 
![fit](../images/Rainbow_Dash.png)
