# Aufgabenzettel 6

Abgabe: _17.12.2015_ bzw. _7.1.2016_

[Hinweise für die Abgabe](https://github.com/klyrr/lecture/blob/master/2015/haw/db/README.md)

## Aufgaben 6.1

Die Aufgaben basieren auf den Daten aus der Vorlesung: [SQL-Dateien](https://github.com/klyrr/lecture/tree/master/2015/haw/db/lecture/06-SQL_Queries).

`tabellen.sql` legt die Tabellen an und `inhalt.sql` füllt diese.

a) Informieren Sie sich in der Oracle Online-Hilfe über das Konzept des `INDEX`. Lesen Sie die Dokumentation zu dem Kommando `CREATE INDEX`.

b) Überlegen Sie, welche Indexe in unserem Schema sinnvoll sind. Dokumentieren Sie Ihre Entscheidung.

c) Erzeugen Sie die Indexe, die Sie vorher als sinnvoll eingeschätzt haben.

d) Schreiben Sie zwei Abfragen, die ihre neu erstellten Indices benutzen.

## Aufgabe 6.2

Gegeben seien folgende Tabellenstruktur:

```
Student = {_Matrikelnummer_, Vorname, Nachname, Geburtstag}
Dozent = {_DozentID_, Vorname, Nachname}
Fach = {_FachID_, Titel, Kategorie}
Dozent_Fach = {_DozentID_, _FachID_}
Student_Fach = {_Matrikelnummer_, _FachID_}
```
Zusatzinformationen:
Die Primärschlüssel der Tabellen sind mit `_<spaltenname>_` gekennzeichnet, z.B. : `Matrikelnummer` ist der Primärschlüssel der Tabelle Student.
Wenn der Name eines Primärschlüssels in einer anderen Tabelle vorkommt, ist es ein Fremdschluessel, z.B. : Das Vorkommen von `Matrikelnummer` in der Tabelle `Student_Fach` heisst, dass hier ein Fremdschlüssel auf die Tabelle `Student` vorliegt.

a) Schreiben Sie die `SELECT`-Anweisungen:

i) Geben Sie alle Studenten (Vorname, Nachname) aus, die das Fach `Funktionale Analysis` belegen.

ii) Geben Sie aus, wie viele unterschiedliche Dozenten ein Fach unterrichten, das `Mathe` in seinem Titel hat.

iii) Wie viele 23-jährige Studenten gibt es?

iv) Geben Sie alle Dozenten (Vorname, Nachname) aus, die mehr als zwei Vorlesungen halten.

v) Geben Sie alle Vornamen der Studenten und Dozenten aus. Jeder Vorname soll nur einmal im Ergebnis vorkommen. Es soll alphabetisch sortiert sein.

vi) Geben Sie alle Studenten (Vorname, Nachname) aus, die eine Vorlesung der Dozentin "Nancy Lynch" besuchen.

b) Was wird hier abgefragt?

```
SELECT Student.Matrikelnummer
FROM Dozent, Fach, Dozent_Fach, Student_Fach
WHERE Dozent.DozentID=Dozent_Fach.DozentID AND Fach.FachID=Dozent_Fach.FachID AND Student_Fach.FachID=FachID AND Fach.Kategorie="OOP"
GROUP BY Student.Matrikelnummer
HAVING COUNT(*) > 1

```
Geht das eventuell auch einfacher?