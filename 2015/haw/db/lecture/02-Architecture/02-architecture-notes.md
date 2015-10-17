autoscale: true
footer: Tina Umlandt. Datenbanken. 2015
slidenumbers: true

---

> "Good spelling, punctuation, and formatting are essentially the on-line equivalent of bathing." 

^ -- Elf Sternberg

---

# [fit] Wiederholung 
# <br> 
# [fit] Themen der letzten Vorlesung

---

## Geschichte

^ wo kommen wir her?
^ wie hat man angefangen
^ was waren die Probleme

---

 - Dateisysteme
 - Dateiverwaltungssysteme
 - Datenbanken

---

## Typische Merkmale von DBMS

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

^ 1. Integration    Verhindern von Redundanz
^ 2. Operationen     Spezifikationen von Datentypen/ Manipulation der Daten
^ 3. Katalog         Metadaten
^ 4. Benutzersichten         eigene Perspektiven (Views) auf Daten
^ 5. Konsistenzüberwachung       Konsistenzbedingungen
^ 6. Datenschutz        Rechtevergabe und Zugriffsprotokoll
^ 7. Transaktionen       Zusammenfassen von Einzelaktionen
^ 8. Synchronisation        Verhinderung der Beeinflussung und Schreibkonflikten
^ 9. Datensicherung       automatisch und regelmaessig

---

## Entwicklungszyklus für Datenbank-Anwendungen

---

1.  Datenbank logisch entwerfen
2.  Datenbank systemtechnisch entwerfen
3.  Datenbankprogramme entwickeln
4.  Datenbank aufbauen
5.  Datenbank betreiben

--- 

# Los geht's `\o/`

---

# [fit] Architektur

---

> Das Wort Architektur bezeichnet im weitesten Sinne die Auseinandersetzung des Menschen mit gebautem Raum. 
> Das planvolle Entwerfen, Gestalten und Konstruieren von Bauwerken ist der zentrale Inhalt der Architektur.
-- wikipedia

---

![right fit](../images/Penrose-dreieck-colored.png)

> Das Wort Architektur bezeichnet im weitesten Sinne die Auseinander-setzung des Menschen mit gebautem Raum. 
> Das planvolle Entwerfen, Gestalten und Konstruieren von Bauwerken ist der zentrale Inhalt der Architektur.
-- wikipedia

Wo sehen Sie Zusammenhänge zur Informatik?
<br>
5 Minuten

---

## [fit] Verwendungen

---

### Unternehmens-IT-Architektur

^ regelt die Organisation der Unternehmens-IT (Unternehmensarchitektur, IT-Architektur)

---

### Rechnerarchitektur
#### Prozessorarchitektur

^ Aufbau von Computersystemen als ganzes
^ die Rechnerarchitektur: Teil der Informatik auf die Operationsprinzipien und die Hardwarestruktur von Computern bezieht 
^ Funktionsweise der Kernkomponente, eines Prozessors der Mikroelektronik, die Prozessorarchitektur

---

### Systemarchitektur

^ für die Beschreibung/Darstellung von (Computer-) Systemkonfigurationen und ihre Beziehung zueinander

---

### Informationsarchitektur

^ möglichen Interaktionen
^ der An- und Zuordnung und der Benennung der in dem System enthaltenen Informationseinheiten und Funktionen

---

### Netzwerkarchitektur

^ Aufbau eines informationstechnischen Netzwerkes
^ Netzwerktopologie

---

### Softwarearchitektur

^ die Funktionsweise von Computerprogrammen und deren Zusammenspiel, die Softwarearchitektur, die im Rahmen der Softwareentwicklung diese Beziehungen für ein Softwaresystem aufstellt

---

### Sicherheitsarchitektur

^ die Teile eines IT-Systems, die sich auf Informationssicherheit beziehen

---

### Referenzarchitektur

^ Vorlage für die Entwicklung

---

---

# [fit] Systemarchitektur 
## vs 
# [fit] Softwarearchitektur

---

## Systemarchitektur

^ Systeme und die in ihnen zusammenwirkenden Komponenten

---

## Softwarearchitektur

^ beschreibt die grundlegenden Komponenten und deren Zusammenspiel innerhalb eines Softwaresystems.
^ Eine Architekturbeschreibung umfasst etwa im Falle einer Web-Anwendung den Aufbau des Systems aus Datenbanken, Web-/Application-Servern, E-Mail- und Cachesystemen

---

![fit](../images/jimdo-architecture-Complete.png)

^ Verdeutlichen der Wichtigkeit der Softwareplanung
^ und auch Architekturen
^ Sicherheiten

---

# [fit] Softwareentwicklung
---

1. Wasserfallmodell

2. Spiralmodell

4. Feature Driven Development (FDD)

5. Prototyping

3. Extreme Programming (XP)

6. Agiler Entwicklungsprozess

---

## Beispiel: *Honigshop*

---

# [fit] *Wasserfallmodell*

^ lineares (nicht iteratives) Vorgehensmodell, 
^ vordefinierte Start- und Endpunkte mit eindeutig definierten Ergebnissen

---

![fit](../images/WaterfallModel.png)

---

## Vorteile

^ Klare Abgrenzung der Phasen
^ Einfache Möglichkeiten der Planung und Kontrolle
^ Bei stabilen Anforderungen und klarer Abschätzung von Kosten und Umfang sehr effizientes Modell

---

## Nachteile

^ Unflexibel gegenüber Änderungen und im Vorgehen (Phasen müssen sequenziell abgearbeitet werden)
^ Einführung des Systems sehr spät nach Beginn des Entwicklungszyklus, deshalb ein später Return on Investment
^ Fehler werden unter Umständen spät erkannt (Big Bang) und müssen mit erheblichem Aufwand entfernt werden.
^ Da größere Softwareprojekte meist auch eine sehr lange Laufzeit haben, kann es vorkommen, dass die neue Software bereits zum Zeitpunkt ihrer Einführung inhaltlich veraltet ist.

---

# *Spiralmodell*

^ Fundamental für das Spiralmodell ist der Begriff des Risikos. 
^ Ein Vorgehensmodell sollte sicherstellen, dass Risiken erkannt und möglichst früh im Projekt bekämpft werden.

---

![fit](../images/spiralmodell2.png)

---

## Vorteile

^ Falls das Problem unlösbar ist, stellt sich dies in der Regel rasch heraus.

---

## Nachteile

^ Projekt nach dem Spiralmodell kann nicht vollständig geplant werden

---

# [fit] *Feature Driven Development*
## *(FDD)*

---

# *Prototyping*

^ Throwaway prototyping
^ Evolutionary prototyping

---

![fit](../images/prototyping.png)

---

## Vorteile

^ Die Anforderungen der Anwender können laufend präzisiert und verifiziert werden. Damit sinkt das Risiko einer Fehlentwicklung.
^ Unbeabsichtigte Wechselwirkungen zwischen einzelnen Komponenten des Produkts können früher erkannt werden.
^ Der Fertigstellungsgrad ist besser verifizierbar.
^ Die Qualitätssicherung kann frühzeitig eingebunden werden.

---

## Nachteile

^ Prototyping verführt oft dazu, Anforderungen weder korrekt zu erheben noch sauber zu dokumentieren. Der Entwicklungsprozess kann sich dadurch erheblich verlangsamen.
^ Es entstehen während der Entwicklung zusätzliche Kosten, weil der Prototyp nur als Basis für die folgende eigentliche Entwicklung des Produktes dient. Diese Kosten und Zeitaufwand können durch weniger Nacharbeit am Endprodukt wieder ausgeglichen werden.

---

# [fit] *Extreme Programming*
## *(XP)*

^ siehe auch Scrum, agiles Vorgehensmodell, das gut mit XP harmoniert
^ Vorgehen: User-Storys

---

# *Agiler*
# [fit] *Entwicklungsprozess*

^ Lean 
^ Wert: Spezifiziere präzise den Wert deines Produktes
^ Perfektion: Verbessere die Dinge kontinuierlich

---

![fit](../images/extremeProgramming.png)

---

## Vorteile

^ fortlaufende Iterationen und den Einsatz mehrerer Einzelmethoden strukturierendes Vorgehensmodell
^ XP folgt einem strukturierten Vorgehen und stellt die Teamarbeit, Offenheit und stete Kommunikation zwischen allen Beteiligten in den Vordergrund. 
^ Kommunikation ist dabei eine Grundsäule.
^ Im Laufe eines Projektes ändern sich nicht selten Prioritäten und Gewichte. 
^ Bei einer konsequenten Ausrichtung an XP soll die zu erstellende Software schneller bereitgestellt werden

---

## Nachteile

^ Der ideale Kunde
^ Der ideale Programmierer
^ XP stellt zahlreiche Anforderungen an die beteiligten Programmierer.
^ Die Anforderungen zeigen, dass XP nicht auf beliebige Teams angewandt werden kann.
^ Ein weiterer häufiger Kritikpunkt ist, dass XP für Festpreisprojekte nicht geeignet sei. 
^ Feste Fertigstellungstermine

---

---

## [fit] Zwei-Schichten-Architektur
## [fit] *Client-Server-Architektur*

^ two tier architecture
^ niedrigere Schicht ein Dienstanbieter (engl. Server) 
^ Client-Server-Architektur
^ Architektur von Datenbankanwendungen typischerweise auf Basis des Client-Server-Modells
^ Server ≡ Datenbanksystem

---

## [fit] Drei-Schichten-Architektur

^ three tier architecture
^ softwareseitig drei Schichten
^ Präsentationsschicht (client tier) – Diese, auch Front-End bezeichnet, ist für die Repräsentation der Daten, Benutzereingaben und die Benutzerschnittstelle verantwortlich.
^ Logikschicht (application-server tier, Businessschicht, Middle Tier oder Enterprise Tier) – Sie beinhaltet alle Verarbeitungsmechanismen. Hier ist die Anwendungslogik vereint.
^ Datenhaltungsschicht (data-server tier, back end) – Sie enthält die Datenbank und ist verantwortlich für das Speichern und Laden von Daten.

---

---

# Schema-Architekturen

^ Schema vs Schicht
^ Schicht -> tier

---

## Drei-Ebenen-Schema-Architektur

^ drei Schichten gibt es auch in der DB
^ Modellierung erfordert formale Sprache

---

## Sicht der Daten auf drei Ebenen naheliegend:

- physische Dateiorganisation
- logische Gesamtsicht der Daten
- Benutzersicht

---

## in Datenbanken stehen statische Gegebenheiten

- Welche Objekte gibt es?
- Welche Eigenschaften haben diese Objekte?
- Welche Beziehungen bestehen zwischen den Objekten?

^ logischen Datenbankentwurf oder logischer Datenorganisation

---

## [fit] ANSI-SPARC-Architektur

^ Architektur wurde 1975 vom Standards Planning and Requirements Committee (SPARC) des American National Standards Institute (ANSI)
^ Betrachtung erfolgt auf 3 Abstraktionsebenen

---

![fit](../images/ansisparc.png)

---

# Vorteil:
# <br>
## [fit] Datenunabhängigkeit

^ zentrales Entwurfsprinzip für Datenbanken.
^ Weiteres Kriterium für den Entwicklungszyklus
^ Datenbanksysteme sollen lange zugreifbar bleiben, und zwar oftmals länger als die typische Laufzeit einer Anwendung oder einer Hardware. 
^ Dies sind die Hauptgründe für die Anforderung nach Datenunabhängigkeit in Datenbanksystemen
^ Vermeidung einer engen Kopplung zwischen Programm, Daten und unterliegenden Systemen 

---

## Physische Datenunabhängigkeit
### *Implementierungsunabhängigkeit*

^ interne von der konzeptionellen und externen Ebene getrennt ist
^ Beispiel: Oracle heute, nächstes Jahr PostgreSQL
^ Die konzeptuelle Sicht auf eine Datenbank bleibt gleich, auch wenn sich die für die Speicherung der Daten gewählte Struktur bzw. Technologie ändert
^ Beispiel: Hinzufügen oder Entfernen eines Index
^ Beispiel: Repräsentation der Daten auf der Festplatte

---

## Logische Datenunabhängigkeit
### *Anwendungsunabhängigkeit*

^ konzeptionelle und die externe Ebene getrennt sind
^ Entkopplung der Datenbank von Änderungen und Erweiterungen der Anwendungsschnittstellen.
^ Hinzufügen eines Attributs

---

---

## *Beispiel:*
## [fit] Buchbestandsverwaltung

---

### Buchbestand wird verwaltet durch Kartei mit folgenden Aufbau

```
1. Zeile: Inventarnummer
2. Zeile: ISBN
3. Zeile: Autor
4. Zeile: Titel
5. Zeile: Fachgebiet
6. Zeile: Verlag
7. Zeile: Ort, Jahr
8. Zeile: Auflage
9. Zeile: Preis
```

---

### *Interne Ebene/ Physische Organisation*
## <br>
### Kartei mit Karten aller Bücher, sortiert nach Autor

---

### *Konzeptionelle Ebene*
## <br>
### beschreibt die Angaben, welche die Zeilen einer Karteikarte enthalten

----

### *Externen Ebene/ Benutzersicht*
## <br>
### z.B. Autor und Titel aller Bücher des Gebietes Datenbanken.

---

![right fit](../images/Penrose-dreieck-colored.png)

## Beispiel
## Rezeptbuch / CD-Sammlung

---

## Abstraktionsebenen

---

1. Interne Ebene/ Schema
2. Konzeptionelle Ebene
3. Externe Ebene

^ Das interne Schema beschreibt die systemspezifische Realisierung der Datenbank, also z.B. die Speicherorte und die DBMS-spezifische Art des Zugriffs auf die Daten.
^ Das konzeptuelle Schema (auch als logisches Schema bezeichnet) beinhaltet eine DBMS-unabhängige Modellierung der gesamten Datenbank.
^ Basierend auf dem konzeptuellen Schema können für verschiedene Anwendungen oder verschiedene Benutzer mehrere externe Schemata definiert werden. In diesen Schemata werden zumeist anwendungsspezifische Ausschnitte aus dem gesamten Datenbestand bereitgestellt. 

---

## Interne Ebene

---

- Informationen über Art und Aufbau der verwendeten Datenstrukturen
- Informationen über die Organisation der Sätze im logischen Adreßraum
- spezielle Zugriffsmechanismen auf die Daten

^  Die interne Sicht der Daten („interne Records“, (Datensätze) ) wird im internen Schema festgelegt:

---

## Konzeptionelle Ebene

---

- logische Gesamtsicht der Daten in der Datenbank im konzeptionellen Schema dargestellt
- Schema ist frei von Datenstruktur- und Zugriffsaspekten

^ Das konzeptionelle Schema beinhaltet ausschließlich eine Definition des Informationsgehaltes der Datenbank
^ Zur Entwicklung eines konzeptionelle Schemas verwendet man Datenmodelle.
^ Zur Implementation steht die „Sprache“ des gewählten Datenmodells zur Verfügung (DDL des konkreten DBMSs)

---

## Externe Ebene

---

- umfasst alle individuellen Sichten (Views) der Nutzer
- Sichten werden in einem eigenen externen Schema beschrieben

^ enthält genau den Ausschnitt der konzeptionellen Sicht, den der Nutzer sehen möchte /darf.

--- 

![fit](../images/3EbenenArchitektur.png)

---

---

## *Beispiel:*
## Data-Warehouse

---

### *Interne Ebene*
## <br>
### Basis-Tabellen 

^ oft in denormalisierter Form erstellt
^ um performance-günstige Zugriffe auf die gespeicherten Daten zu ermöglichen. Zusätzlich werden oft Aggregationstabellen eingerichtet

---

### *konzeptionelle Ebene*
## <br>
### redundanzfreie Basis-Tabellen als Dimensions-, Fakten- und Lookup-Tabellen

---

### *Externen Ebene*
## <br>
### Definition der Aggregationen 

^ umfangreiche Aggregationen
^ deren Berechnung sehr zeitaufwändig ist

---

## *Beispiel:*
## [fit] "Implementation" der Buchkartei

---

### Interne Ebene: Lineare Liste

--- 

### Datenstruktur
  - Bücher nach Autoren sortiert
  - Listenelement vom `record` - Datentyp
  - Zeiger auf Kopf der Liste und Hilfsvariable zum sequentiellen Durchlaufen der Liste

---

- *Physisch* besteht die Datenbank aus einer *einfach verketteten Liste*, welche sequentiell verarbeitet werden kann
- Die *Bearbeitung* einer Anfrage erfolgt *satzorientiert*
- *Einfügen* eines neuen Datensatzes erfordert:
  1. Stelle lokalisieren, an der der Datensatz eingefügt werden soll und
  2. Ändern der Verkettung zu den Nachbarrecords.

---

### Konzeptionelle Ebene

---

- Im Mittelpunkt steht die *Information* über die Objekte
- Buchbestand ergibt sich als *Set von Records*
- Die Verarbeitung von Anfragen erfolgt *mengenorientiert*

---

### Externe Sicht: „Fachgebiet Datenbank“ in der Sprache des DBMS

---

```
type s1 = if bb.department = ’DB’
            then record bb.author, 
                        bb.title
          end;

view1 = set of s1;
```

---

---

## Die System-Architektur 

^ beschreibt die Komponenten eines Datenbanksystems, d.h. die Bestandteile eines DBMS aus der Sicht des Realisierers eines DBMS.

---

### Beispiel: ANSI-Definition eines DBMS

^ American National Standards Institute (ANSI) 

---

![left fit](../images/ANSIArchitektur2.png)

 - *Plattenzugriff*: Das Hardware-abhängige Modul zum Zugriff auf Speicher
 - *Auswertung*: Hier werden die Plattendaten in Benutzerdaten (z.B. Tabellen) und Objektanfragen in Plattendatenzugriffe übersetzt
 - *Optimierung*: Hier werden Operationen in äquivalente, aber „billigere“ umgeformt

---

![left fit](../images/ANSIArchitektur2.png)

 - *Data-Dictionary*: Das zentrale Modul nimmt die Daten aus den Schemadefinitionen auf und stellt diese den anderen Modulen zur Verfügung

^ Menge von Tabellen und Ansichten
^ zentrale Komponente
^ ist ein Katalog von Metadaten
^ konzeptionellen/logischen Datenmodellierung gehören: Definition der Entitäten, Datenelemente und der Beziehungen zwischen den Entitäten
^  physischen Datenmodellierung:
^ Tabellen und Datenfeldern
^   Primär- und Fremdschlüsselbeziehungen

---

![left fit](../images/ANSIArchitektur2.png)

 - *Dateiorganisation*: Dient zur Definition des internen Schemas
 - *Datendefinition*: Dient zur Definition des konzeptuellen Schemas
 - *Sichtdefinition*: Dient zur Definition des externen Schemas

---

![left fit](../images/ANSIArchitektur2.png)

 - *Masken*: Erlaubt die Erstellung einer grafischen Oberfläche
 - *Einbettung*: Ermöglicht die Nutzung von DB-Operationen in anderen  Programmiersprachen als SQL
 - *DB-Operationen*: Operationen für die Veränderung/Anfrage auf dem DBS

---

![left fit](../images/ANSIArchitektur2.png)

 - *Anwendungsprogramme*: Die Programme für den Endbenutzer
 - *Änderungen*: Ad hoc, d.h. ungeplante Änderungen in dem DBS
 - *Anfragen*: Ad hoc, d.h. ungeplante Anfragen auf dem DBS

---

![fit](../images/vereinfachtANSIArchitektur2.png)

^ *Plattenzugriff*: Das Hardware-abhängige Modul zum Zugriff auf Speicher
^ *Auswertung*: Hier werden die Plattendaten in Benutzerdaten (z.B. Tabellen) und Objektanfragen in Plattendatenzugriffe übersetzt
^ *Optimierung*: Hier werden Operationen in äquivalente, aber „billigere“ umgeformt.
^ *Data-Dictionary*: Das zentrale Modul nimmt die Daten aus den Schemadefinitionen auf und stellt diese den anderen Modulen zur Verfügung
^ *Dateiorganisation*: Dient zur Definition des internen Schemas
^ *Datendefinition*: Dient zur Definition des konzeptuellen Schemas
^ *Sichtdefinition*: Dient zur Definition des externen Schemas
^ *Masken*: Erlaubt die Erstellung einer grafischen Oberfläche
^ *Einbettung*: Ermöglicht die Nutzung von DB-Operationen in anderen  Programmiersprachen als SQL
^ *DB-Operationen*: Operationen für die Veränderung/Anfrage auf de

---

---

## Komponenten eines DBMS

---

![fit](../images/ArchitekturDBMS2.png)

---

![left](../images/ArchitekturDBMS2.png)

Hauptspeicher: das *DBMS*

Auf Sekundärspeichern drei Datenbestände:

- *Datenbank*
- Schemainformationen im *Data Dictionary*
- (internes) *Logbuch* der Datenbank

^ Data Dictionary: Katalog von Metadaten, read only
^ Logbuch: 
^    Um gegen Stromausfall gesichert zu sein
^    die Schreib-Operationen, bevor sie in der Datenbank ausgeführt werden.
^     Daten: 
^           Transaktions-Start , Transaktions-Commit oder Transaktions-Abort
^           Bei Schreib-Operationen: alter Wert der veränderten oder gelöschten Tupel und neuer Wert der eingefügten oder veränderten Tupel.

---

![left](../images/ArchitekturDBMS2.png)

## Ebene Benutzersprache

*I/O-Prozessor:* Benutzer zugeordnet

^ I/O Prozessor:
^    nimmt Kommandos entgegen,
^    liefert Antworten oder Fehlermeldungen,
^    ist häufig ein Monitor, ruft andere Komponenten auf bzw. stößt Prozesse an.

*Parser*: syntaktische Analyse

*Precompiler*: Muss bei eingebetteten Kommandos aufgerufen werden

Beide Kommandoarten erfordern die Ausführung einer *Autorisierungskontrolle*

^ in gruen
^ Precompiler:  uebersetzt SQL-Anweisungen
^ Autorisierungskontrolle:   überwacht Zugriffsberechtigung für die Datenbank 
^ Parser:   übersetzt Anfragen nach syntaktischer und semantischer Überprüfung in eine interne Form 

---

![left](../images/ArchitekturDBMS2.png)

## Ebene Anfrageverarbeitung I

*Query-Prozessor:* Übersetzt eine Anfrage in das konzeptionelle Schema

*Optimierer:* Erzeugt eine äquivalente Anfrage, die kostengünstiger sein soll

*Update-Operation:* an Integritätsbedingungen gebunden

^ Ergebnis von Schritt davor: Benutzerauftrag in einer „internen Form“
^ Query-Prozessor: 
^      Ersetzung von Komponenten der externen Schemata durch entsprechende Komponenten des logischen Schemas
^      Vereinfachung der Anfrage

^ Update-Prozessor
^      Bearbeitung von Update-Operationen
^      interne Zwischenform wird unter Zuhilfenahme der Integritätsprüfung erweitert

^ Optimierer
^     Umformung der Anfrage in eine "bessere" Form
^     Auswahl des "günstigsten" Zugriffsplans
^     verwendet statistische Daten über die Datenbank 

---

![left](../images/ArchitekturDBMS2.png)

## Ebene Anfrageverarbeitung II

*Integritätsprüfung:*     Sicherstellung von Integritätsbedingungen bei Updates

*Zugriffsplanerstellung:* Feststellung der auf die auszuwählenden Daten verfügbaren Zugriffsstrukturen und Auswahl eines effizienten Zugriffspfades

^ Integritätsprüfung     Sicherstellung von Integritätsbedingungen bei Updates
^ Erstellung eines Zugriffsplans (Ausführungsplans) für eine Anfrage
^     Auswahl geeigneter Indexstrukturen
^     Auswahl geeigneter Implementierungen von Operationen

---

![left](../images/ArchitekturDBMS2.png)

## Ebene Codeerzeugung

*Codeerzeugung:* Code - Generierung für den Benutzerauftrag

^ Codeerzeugung     Erzeugung einer Repräsentation des Zugriffsplans, die unmittelbar ausführbar ist 

---

![left](../images/ArchitekturDBMS2.png)

## Ebene Synchronisation paralleler Zugriffe

*Scheduler:* Verzahnt und synchronisiert Transaktionen miteinander

*Transaktionsmanager:* Überwacht die Einhaltung der ACID – Eigenschaften für jede Transaktion

*Recovery-Manager:* ist für den Wiederanlauf der Datenbank zuständig

^ Scheduler (Concurrency-Control-Manager)
^          lässt mehrere Transaktionen parallel ablaufen 
^ Transaktionsmanager
^            Datenbank erscheint für jeden Nutzer als ein exklusiv verfügbares Betriebsmittel.
^ Recovery-Manager
^        setzt die Datenbank in einen konsistenten Ausgangszustand zurück.
^       ist für den Wiederanlauf der Datenbank zuständig
^     übernimmt Transaktionen, die nicht erfolgreich beendet werden können.
^      verwendet das Logbuch der Datenbank, indem alle Veränderungen aufgezeichnet sind.
^      setzt die Datenbank in den Zustand zurück, der vor Start der Transaktionbestand.
^      macht alle bereits durchgeführten Veränderungen in der Datenbank rückgängig

---

![left](../images/ArchitekturDBMS2.png)

## Ebene Speicherverwaltung 

*Buffer-Manager:*  verwaltet den Systempuffer

*File-Manager:* realisiert Zugriff auf Dateien

^ File-Manager: und Zugriffsstrukturen (Indexstrukturen) 

---

Beispiel:

```
select title, price
from product
where price > 4
order by price
```

---

### *Parser* erzeugt interne Repräsentation

```
sort (product, price) | select (price > 2000) 
```

---

### *Optimierer* formt die Anfrage um

```
select (product, price > 2000) | sort (price) 
```

---

### *Zugriffsplanerstellung*
```
scan (product, price > 2000) | quicksort (price) 
```
---

### *Codeerzeugung* formt Ausdruck in ausführbare Form um 

<br>

---

### *Transaction-Manager* und *Scheduler* verhindern Konflikte bei gleichzeitig ausgeführten Aktualisierung

<br>

---

# Das war's für heute 
# `#scnr`
![fit](../images/Rainbow_Dash.png)
