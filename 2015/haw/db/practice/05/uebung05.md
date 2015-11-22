# Aufgabenzettel 5

Abgabe: _2.12._ bzw. _9.12._

[Hinweise für die Abgabe](https://github.com/klyrr/lecture/blob/master/2015/haw/db/README.md)

Die Aufgaben basieren auf den Daten aus der Vorlesung: [SQL-Dateien](https://github.com/klyrr/lecture/tree/master/2015/haw/db/lecture/06-SQL_Queries).

`tabellen.sql` legt die Tabellen an und `inhalt.sql` füllt diese.

## Aufgaben 5.1

Erstellen Sie `INSERT`-Anweisungen, um folgende Datensätze hinzuzufügen:

- Marie Curie hat ein Kind mit Namen Pierre bekommen, dass am 1.11.2015 geboren wurde.
- Es hat ein neuer Mitarbeiter angefangen: Linus Pauling. Er ist bei der AOK und fängt in der Abteilung Verkauf an. Seine Gehaltsstufe ist die mittlere.
- Jade Raymond ist eine weitere neue Angestellte. Sie faengt in der Produktion an und bekommt die höchste Gehaltsstufe. Ihre Krankenkasse ist die TKK.
- Es wurde eine neue Maschine gekauft. Bitte suchen Sie sich hier selber Name, Datum und Neu- und Zeitwert aus. Einer der neuen Mitarbeiter bedient diese Maschine.
- Jeder Mitarbeiter der Abteilung Verkauf hat Anfang November eine 300 EUR Prämie bekommen.

Falls ich Informationen vergessen haben sollte, ergänzen Sie sie bitte nach bestem Wissen.

## Aufgaben 5.2

Es fehlt eine Tabelle, um die Reparaturen an den Maschinen zu speichern. Folgende Daten müssen gespeichert werden können:
- um welche Maschine handelt es sich
- wann wurde sie repariert
- wie teuer war die Reparatur
- welcher Mitarbeiter hat die Reparatur durchgeführt
- eine kurzer Text, was gemacht wurde

Erstellen Sie diese Tabelle und denken Sie sich drei Datensätze dazu aus und fügen Sie diese Ihrer Tabelle hinzu.


## Aufgabe 5.3

Beantworten Sie die folgenden Fragen, in dem Sie die entsprechenden `SELECT`-Anfragen erzeugen:

a. Geben Sie für jeden Mitarbeiter, der mindestens zwei Prämien erhalten hat, die Personalnummer und die Summe der Prämien an.

b. Geben Sie alle Mitarbeiter aus, deren Kinder nach 2010 geboren sind.

c. Geben Sie alle Mitarbeiter aus, die Mitglied bei der AOK sind.

d. Geben Sie alle Abteilungen aus, die Mitarbeiter mit der Gehaltsstufe 'it5' haben.

e. Geben Sie alle Abteilungen aus, deren Mitarbeiter zusammen mehr als 6.000 EUR Monatsgehalt haben.
	
f. Geben Sie alle Maschinen aus, die nur noch weniger als die Hälfte ihres Neuwerts wert sind.

g. Geben Sie alle Mitarbeiter aus, die weniger als 3000 EUR im Monat verdienen.

h. Bezogen auf `g.`: Wenn es eine Gehaltserhöhung um 15% geben wurde, welche Mitarbeiter waeren das dann

i. Geben Sie alle Maschinen aus, die von Mitarbeitern bedient werden, die in einer Abteilung arbeiten, die mit P anfaengt.

j. Geben Sie den Namen des Mitarbeiters und der Maschinen aus, die schon einmal repariert wurden.

