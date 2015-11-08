autoscale: true
footer: Tina Umlandt, 2015
slidenumbers: true

---

#[fit] Nāchestes Mal:
## Oracle

---

---

# Wiederholung

---

## Warum gibt es verschiedene Datenmodelle?

^ erfuellen unterschiedliche Aufgaben

---

# Entity-Relationship-Modell

---

![fit](../images/er-modell-erweitert.png)

---

## Aufgabe: 

Sie sollen eine ToDo-App mit einem ER-Modell modellieren. Folgende Regeln:

- Todo hat immer Text
- kann mehrere Bilder enthalten
- hat mindestens einen Autor
- man muss herausfinden koennen, wann die ToDos erstellt und geaendert wurden

--- 

# UML

---

![fit](../images/klassendiagrammUML.png)

^ Assoziation: besitzt
^ Komposition: besteht aus
^ Vererbung: 

---

# [fit] Relationenschemata

---

# Transformation: 
## ERM -> Relationenschema
- Jeder Entitätstyp wird auf eine Relation abgebildet
  - Die Attribute der des Entitätstyps werden den Attributen der Relation zugeordnet
- Es muss ein Primärschlüssel gewählt werden 
- Abschließend werden die Beziehungen transformiert
  - Beziehungstyp innerhalb des ER­M wird mittels eines eigenen Fremdschlüssels im Relationenmodell abgebildet
  - NM bzw. N:MC­ - Beziehungen werden in zwei 1:N bzw. 1:NC­ - Beziehungen aufgelöst.

---

![fit](../images/ERModell2Relationenschema.png)

---

# Schlüssel

---

## Superschlüssel

^ Menge von Attributen (Feldern) in einer Relation (Tabelle), die die Tupel (Zeilen) in dieser Relation eindeutig identifizieren
^ trivialer Superschlüssel wäre zum Beispiel die Menge aller Attribute einer Relation gemeinsam 

---

## Schlüsselkandidat

^ Teilmenge der Attribute eines Superschlüssels

---

Aufgabe: Bestimmen der Superschlüssel

```
|---------|--------|-------------|
|    Name | Nummer |  Königshaus | 
|---------|--------|-------------|
|  Edward |     II | Plantagenet |
|---------|--------|-------------|
|  Edward |    III | Plantagenet |
|---------|--------|-------------|
| Richard |    III | Plantagenet |
|---------|--------|-------------|
|   Henry |     IV |   Lancaster |
|---------|--------|-------------|

```
^ Aufstellen aller Attributkombinationen aka Superschluessel
^ {Monarch Name, Monarch Number} (Candidate Key)
^ {Monarch Name, Monarch Number, Royal House}

---

## Primārschlüssel

^ Unterscheidung: Schluesselkandidaten
^ fachlich vs technische Schluessel
^ ausgewählte Schlüsselkandidat

---

```
Buch

| BuchId |  ISBN |           Titel |
|--------|-------|-----------------|
| 1      | 4FA33 |          Hamlet |
|--------|-------|-----------------|
| 2      | E5B11 | Die Verwandlung |

```
^ fachlich vs technisch

---

## Fremdschlüssel

---

```
| BuchId |  ISBN |           Titel |      | AutorId | Vorname |    Nachname |
|--------|-------|-----------------|      |---------|---------|-------------|
|      1 | 4FA33 |          Hamlet |      |       1 | William | Shakespeare |
|--------|-------|-----------------|      |---------|---------|-------------|
|      2 | E5B11 | Die Verwandlung |      |       2 |   Franz |       Kafka |
|--------|-------|-----------------|
|      3 | CD652 |       King Lear |    

| BuchId | AutorId |
|--------|---------|
|      1 |       1 |
|--------|---------|
|      2 |       2 |
|--------|---------|
|      2 |       1 |
|--------|---------|

```
---

## Wiederholung der Datenmodelle

---

# [fit] Hierarchisches Modell

^ Bäume legen das Schema fest
^ Gut geeignet, um hierarchische Daten darzustellen
^ nur 1:1 und 1:n-Beziehungen

---

# [fit] Netzwerkmodell

^ keine strenge Hierarchie und kann deswegen auch m:n-Beziehungen abbilden
^ kann auch m:n Beziehungen

---

# [fit] Objekt-Orientiertes Modell

^ Kaum Unterscheidung zwischen Datenbankschema und Programm,
^ DBMS implementieren direkt ein objektorientiertes Datenmodell

---

# [fit] Objekt-Relationales Modell

^ Add new data functionality to relational: User-Defined Types (UDTs): can be used in table cell or as row of a table
^ Funktionen, UDT

---

# [fit] XML-Basierendes Modell

^ An XML schema may or may not enforce element order.
^ Daten werden als XML gespeichert

---

# Los geht's `\o/`

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
^ JavaScript Object Notation

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

^ nicht ein 'bestes' Modell, sondern nur Modelle, die bestimmte Anforderungen besser oder schlechter erfüllen
^ werden mehrere Modelle in unterschiedlichen Entwicklungsphasen genutzt, wobei das relationale Modell, eventuell mit objekt-relationalen Erweiterungen zumeist als Implementierungsmodell dient

---

# *Relationales*
# [fit] *Datenbank-Design*

---

## Schreibweisen

---
```
Autor = (Autorvorname, Autornachname, Verlag, 
Buchtitel, ISBN, Preis, Sprache, Seitenanzahl)

Autor = (
  Autorvorname, 
  Autornachname, 
  Verlag, 
  Buchtitel, 
  ISBN, 
  Preis, 
  Sprache, 
  Seitenanzahl
)
```
---

# Eine Tabelle fuer alles

```
| Autorvorname | Autornachname |                     Verlag |       Buchtitel |              ISBN |    Preis | Sprache | Seitenanzahl |
|--------------|---------------|----------------------------|-----------------|-------------------|----------|---------|--------------|
|        Franz |         Kafka |         Ideenbrücke Verlag | Die Verwandlung | 978-3-945909-67-6 | 3,99 EUR | Deutsch |           64 |
|--------------|---------------|----------------------------|-----------------|-------------------|----------|---------|--------------|
|        Franz |         Kafka |        Philipp Reclam Jun. | Die Verwandlung | 978-3-15-009900-1 | 2,00 EUR | Deutsch |           80 |
|--------------|---------------|----------------------------|-----------------|-------------------|----------|---------|--------------|
|        Franz |         Kafka | Fischer Taschenbuch Verlag |      Das Urteil | 978-3-596-20019-1 | 6,95 EUR | Deutsch |          185 |
|--------------|---------------|----------------------------|-----------------|-------------------|----------|---------|--------------|

```
^ Probleme?
^ Redundanzen:
^ funktionale Abhängigkeit der Attribute - `Franz` und `Kafka`

---

## Funktionale Abhängigkeiten
### (Functional Dependency - FD)

^ der Attribute

---

# Definition:

`Sei V eine Attributmenge, X, Y ⊆ V und r ∈ Rel(V)`

`Dann ist Y funktional abhängig von X, notiert als X → Y, wenn und nur wenn jeder X-Wert von r genau einen eindeutigen Y-Wert in r bestimmt.  `

^ Mit anderen Worten: Sobald zwei Tupel der Relation von r in ihren X-Werten übereinstimmen, dann stimmen sie auch in ihren Y-Werten überein.  

---

![left fit](../images/FD_sample.png)

Menge F von FDs: 
`F = {AB → C, A → D, D → E}`

---

Test, ob eine Relation `r ∈ Rel(V)` eine FD der Form `X → Y` erfüllt:

 - Sortieren von r nach Werten des Attributes X,
 - Prüfen aller Tupel mit gleichen X-Werten auf gleiche Y-Werte.

---

![fit](../images/funktionaleAbhaengigkeit.png)

^ Aufgabe: welche sehen Sie?

---

![fit](../images/funktionaleAbhaengigkeit_shown.png)

---

#[fit] Triviale funktionale Abhängigkeit

## `X → X`

---

#[fit] Volle funktionale Abhängigkeit

```
X = {X1, X2, ..., Xn}
Y = {Y1, Y2, ..., Ym}
X → Y
```

`Y ist voll funktional abhängig von X, wenn Y funktional abhängig von X, aber nicht funktional abhängig von einer echten Teilmenge von X ist.`

^ ich brauche ALLE attribute
^ β heißt voll funktional abhängig von α, wenn aus α kein Attribut entfernt werden kann, so dass die Bedingung immer noch gilt.
^ es darf kein Attribut entfernt werden
^ ISBN vs (Buchtitel, Autor)
^ jede Teilmenge

---

# Eigenschaften
## [fit] der funktionalen Abhängigkeiten

---

> Schlüssel sind Spezialfälle von funktionalen Abhängigkeiten.

---

> Ein Schlüssel X liegt vor, wenn für ein Relationenschema r eine funktionale Abhängigkeit `X → Y` gilt und X minimal ist.

---

> Funktionale Abhängigkeiten sind Aussagen über das Schema, nicht über eine Ausprägung

---

> Wenn man einige FD gefunden hat, dann gibt es einen Algorithmus, um weitere FD daraus abzuleiten

^ Armstrong Axiome

---

> Aus einer Menge von gegebenen FD (als F bezeichnet) können meist weitere FD abgeleitet werden

---

# `F+` 

## *Transitive Hülle*

^ Transitivitaet erklaeren
^ `F+`  = Transitive Hülle (transitive closure) von F ist die Menge aller FDs, die durch F impliziert werden
^ Transitive Huelle (a-> b, b->c => a->c

---

##[fit] Armstrongsche Axiome

---

# *Reflexivität*

Wenn `Y ⊆ X`,  dann `X → Y` in F+ 

(X, Y, Z sind Mengen von Attributen):

^ Reflexivität: Eine Menge von Attributen bestimmt eindeutig die Werte einer Teilmenge dieser Attribute (triviale Abhängigkeit) 

---

# *Erweiterbarkeit*

Wenn  `X → Y` in `F+`,  dann `XZ → YZ`  in `F+` für beliebige `Z`

(X, Y, Z sind Mengen von Attributen):

^ Erweiterbarkeit/ Verstaerkung 

---

# *Transitivität*

Wenn  `X → Y`  und  `Y → Z` in `F+`,  dann   `X → Z` in `F+`

(X, Y, Z sind Mengen von Attributen):

---

# Anomalien

---

## Einfügeanomalie

---

## Löschanomalie

---

## Ānderungsanomalie

---

# Normalformen

^ Qualitaetsaussagen ueber Relationen

---  

![fit](../images/funktionaleAbhaengigkeit.png)

^ Probleme: Koennen keine Vorlesung loeschen ohne Daten zu verlieren
^ Autor ist String, aber sind mehrere

---

# [fit] Erste Normalform
# *1NF*

---

1. Alle Werte entstammen ausschließlich atomaren Wertebereichen

---

![fit](../images/normalform_nfnf.png)

^ nicht in erster Normalform, da die Werte von Autoren mehrwertig sind (eine Menge!)
^ Non First Normal Form (NFNF)
^ Abfragen werden erst ermoeglicht, wenn in 1NF
^ Sortierung nach Nachnamen schwierig

---

![fit](../images/normalform_nf1_fast.png)

^ noch nicht sortierbar

---

![fit](../images/normalform_nf1.png)

^ Schluessel bestimmen

---

# [fit] Zweite Normalform
# *2NF*

---

1. Relation ist in 1NF
2. Kein Nicht-Schlüsselattribut ist funktional abhängig von einer echten Teilmenge eines Schlüsselkandidaten

^ Relationen, die in der 1NF und keinen zusammengesetzen Schlüssel haben, sind sofort in 2NF
^ Zweite Normalform erzeugen heißt Tabelle aufspalten

---

![fit](../images/normalform_nf2_not.png)

^ Probleme; Hinzufuegen einer Spalte, Duplikate, moegliche Inkonsistenzen - Update-Anomalien
^ Abhaengigkeit: Vorname nur von Nachname
^ Nutzen: Reduzieren von Redundanzen

---

![fit](../images/normalform_2nf.png)

^ Inventarnummer ist Fremdschluessel

---

## Dekomposition 
Sei 
```
R = (Schlüsselteil1, Schlüsselteil2, NichtSchlüssel1, NichtSchlüssel2)
FD = {Schlüsselteil2 -> NichtSchlüssel2}
```
Dann gilt
```
R1 = (Schlüsselteil1, Schlüsselteil2, NichtSchlüssel1)
R2 = (Schlüsselteil2,  NichtSchlüssel2)
```

---

![fit](../images/normalform_2nf_follow-up.png)

^ ist in 1NF
^ name ist schluessel
^ FD: Name -> {Wohnort, PLZ}
^ voll abhaengig vom Schluessel, also auch 2NF
^ Aber etwas stmmt nicht

---

![right fit](../images/normalform_2nf_follow-up.png)

```
Name -> {Wohnort, PLZ}

PLZ -> Wohnort

Name -> PLZ -> Wohnort
```

^ transitiv

---

# [fit] Dritte Normalform
# *3NF*

---

1. Relation ist in 2NF
2. Jedes Attribut außerhalb des Primärschlüssels ist direkt abhängig vom Primärschlüssel (insbesondere keine transitiven Abhängigkeiten)

---

![fit](../images/normalform_3nf.png)

---

## Dekomposition
Sei
```
R = (Schlüsselteil1, NichtSchlüssel1, NichtSchlüssel2)
FD = {NichtSchlüssel1 -> NichtSchlüssel2}
```
Dann ergibt sich
```
R1 = (Schlüsselteil1, NichtSchlüssel1)
R2 = (NichtSchlüssel1, NichtSchlüssel2)
```

---

# [fit] Boyce-Codd-Normalform
# *BCNF*

^ Verschärfung der 3NF

---

# [fit] Vierte/ Fünfte Normalform
# *4NF/ 5NF*

^ vierte und fünfte Normalform zergliedern Relationen in weitere Teilrelationen
^ haben in der Praxis derzeit keine Bedeutung 

---

# Aufgabe 

---

![fit](../images/Aufgabe_NF.png)

^ Fügen Sie ggf. auch sinnvolle Primärschlüssel ein
^ in 3NF bringen
^ siehe Bilder

---

---

# [fit] Datenbankentwurf

---

## Kriterien

---

1. Redundanzfreie Informationen
2. Vollständige Darstellung aller Daten
3. Konsistenz des Entwurfs
4. Sprache ist ausdrucksstark und verständlich
5. Beschreibungskonstrukte sind klar definiert
6. Dokumente sind leicht lesbar

---

Modellierung einer Schule ?!

---

# [fit] Datendefinition

---

##[fit] Data Definition Language 
## *DDL*

^ Datenstrukturen und verwandte Elemente zu beschreiben, zu ändern oder zu entfernen.
^ Case insensitive - bezeichner kommt darauf an...

---

```
CREATE TABLE        CREATE VIEW
ALTER TABLE 
DROP TABLE          DROP VIEW
```

bzw [^oracle]

```
CREATE INDEX
ALTER INDEX
DROP INDEX

```

[^oracle]: https://docs.oracle.com/cd/B28359_01/server.111/b28286/statements_7002.htm

^ Relation wird im Data Dictionary eingetragen
^ NULL: keine Information

---
```
CREATE [TEMPORARY] TABLE [IF NOT EXISTS] tbl_name
    (create_definition,...)
    [table_options]
    [partition_options]

CREATE [TEMPORARY] TABLE [IF NOT EXISTS] tbl_name
    [(create_definition,...)]
    [table_options]
    [partition_options]
    select_statement

CREATE [TEMPORARY] TABLE [IF NOT EXISTS] tbl_name
    { LIKE old_tbl_name | (LIKE old_tbl_name) }

create_definition:
    col_name column_definition
  | [CONSTRAINT [symbol]] PRIMARY KEY [index_type] (index_col_name,...)
      [index_option] ...
  | {INDEX|KEY} [index_name] [index_type] (index_col_name,...)
      [index_option] ...
  | [CONSTRAINT [symbol]] UNIQUE [INDEX|KEY]
      [index_name] [index_type] (index_col_name,...)
      [index_option] ...
  | {FULLTEXT|SPATIAL} [INDEX|KEY] [index_name] (index_col_name,...)
      [index_option] ...
  | [CONSTRAINT [symbol]] FOREIGN KEY
      [index_name] (index_col_name,...) reference_definition
  | CHECK (expr)

column_definition:
    data_type [NOT NULL | NULL] [DEFAULT default_value]
      [AUTO_INCREMENT] [UNIQUE [KEY] | [PRIMARY] KEY]
      [COMMENT 'string']
      [COLUMN_FORMAT {FIXED|DYNAMIC|DEFAULT}]
      [STORAGE {DISK|MEMORY|DEFAULT}]
      [reference_definition]

data_type:
    BIT[(length)]
  | TINYINT[(length)] [UNSIGNED] [ZEROFILL]
  | SMALLINT[(length)] [UNSIGNED] [ZEROFILL]
  | MEDIUMINT[(length)] [UNSIGNED] [ZEROFILL]
  | INT[(length)] [UNSIGNED] [ZEROFILL]
  | INTEGER[(length)] [UNSIGNED] [ZEROFILL]
  | BIGINT[(length)] [UNSIGNED] [ZEROFILL]
  | REAL[(length,decimals)] [UNSIGNED] [ZEROFILL]
  | DOUBLE[(length,decimals)] [UNSIGNED] [ZEROFILL]
  | FLOAT[(length,decimals)] [UNSIGNED] [ZEROFILL]
  | DECIMAL[(length[,decimals])] [UNSIGNED] [ZEROFILL]
  | NUMERIC[(length[,decimals])] [UNSIGNED] [ZEROFILL]
  | DATE
  | TIME
  | TIMESTAMP
  | DATETIME
  | YEAR
  | CHAR[(length)] [BINARY]
      [CHARACTER SET charset_name] [COLLATE collation_name]
  | VARCHAR(length) [BINARY]
      [CHARACTER SET charset_name] [COLLATE collation_name]
  | BINARY[(length)]
  | VARBINARY(length)
  | TINYBLOB
  | BLOB
  | MEDIUMBLOB
  | LONGBLOB
  | TINYTEXT [BINARY]
      [CHARACTER SET charset_name] [COLLATE collation_name]
  | TEXT [BINARY]
      [CHARACTER SET charset_name] [COLLATE collation_name]
  | MEDIUMTEXT [BINARY]
      [CHARACTER SET charset_name] [COLLATE collation_name]
  | LONGTEXT [BINARY]
      [CHARACTER SET charset_name] [COLLATE collation_name]
  | ENUM(value1,value2,value3,...)
      [CHARACTER SET charset_name] [COLLATE collation_name]
  | SET(value1,value2,value3,...)
      [CHARACTER SET charset_name] [COLLATE collation_name]
  | spatial_type

index_col_name:
    col_name [(length)] [ASC | DESC]

index_type:
    USING {BTREE | HASH}

index_option:
    KEY_BLOCK_SIZE [=] value
  | index_type
  | WITH PARSER parser_name

reference_definition:
    REFERENCES tbl_name (index_col_name,...)
      [MATCH FULL | MATCH PARTIAL | MATCH SIMPLE]
      [ON DELETE reference_option]
      [ON UPDATE reference_option]

reference_option:
    RESTRICT | CASCADE | SET NULL | NO ACTION

table_options:
    table_option [[,] table_option] ...

table_option:
    ENGINE [=] engine_name
  | AUTO_INCREMENT [=] value
  | AVG_ROW_LENGTH [=] value
  | [DEFAULT] CHARACTER SET [=] charset_name
  | CHECKSUM [=] {0 | 1}
  | [DEFAULT] COLLATE [=] collation_name
  | COMMENT [=] 'string'
  | CONNECTION [=] 'connect_string'
  | DATA DIRECTORY [=] 'absolute path to directory'
  | DELAY_KEY_WRITE [=] {0 | 1}
  | INDEX DIRECTORY [=] 'absolute path to directory'
  | INSERT_METHOD [=] { NO | FIRST | LAST }
  | KEY_BLOCK_SIZE [=] value
  | MAX_ROWS [=] value
  | MIN_ROWS [=] value
  | PACK_KEYS [=] {0 | 1 | DEFAULT}
  | PASSWORD [=] 'string'
  | ROW_FORMAT [=] {DEFAULT|DYNAMIC|FIXED|COMPRESSED|REDUNDANT|COMPACT}
  | TABLESPACE tablespace_name [STORAGE {DISK|MEMORY|DEFAULT}]
  | UNION [=] (tbl_name[,tbl_name]...)

partition_options:
    PARTITION BY
        { [LINEAR] HASH(expr)
        | [LINEAR] KEY(column_list)
        | RANGE(expr)
        | LIST(expr) }
    [PARTITIONS num]
    [SUBPARTITION BY
        { [LINEAR] HASH(expr)
        | [LINEAR] KEY(column_list) }
      [SUBPARTITIONS num]
    ]
    [(partition_definition [, partition_definition] ...)]

partition_definition:
    PARTITION partition_name
        [VALUES 
            {LESS THAN {(expr) | MAXVALUE} 
            | 
            IN (value_list)}]
        [[STORAGE] ENGINE [=] engine_name]
        [COMMENT [=] 'comment_text' ]
        [DATA DIRECTORY [=] 'data_dir']
        [INDEX DIRECTORY [=] 'index_dir']
        [MAX_ROWS [=] max_number_of_rows]
        [MIN_ROWS [=] min_number_of_rows]
        [TABLESPACE [=] tablespace_name]
        [NODEGROUP [=] node_group_id]
        [(subpartition_definition [, subpartition_definition] ...)]

subpartition_definition:
    SUBPARTITION logical_name
        [[STORAGE] ENGINE [=] engine_name]
        [COMMENT [=] 'comment_text' ]
        [DATA DIRECTORY [=] 'data_dir']
        [INDEX DIRECTORY [=] 'index_dir']
        [MAX_ROWS [=] max_number_of_rows]
        [MIN_ROWS [=] min_number_of_rows]
        [TABLESPACE [=] tablespace_name]
        [NODEGROUP [=] node_group_id]

select_statement:
    [IGNORE | REPLACE] [AS] SELECT ...   (Some valid select statement)

```
---

```
CREATE TABLE employees_demo
    ( employee_id    NUMBER(6)
    , first_name     VARCHAR2(20)
    , last_name      VARCHAR2(25)  CONSTRAINT emp_last_name_nn_demo NOT NULL
    , email          VARCHAR2(25)  CONSTRAINT emp_email_nn_demo     NOT NULL
    , phone_number   VARCHAR2(20)
    , hire_date      DATE DEFAULT SYSDATE CONSTRAINT emp_hire_date_nn_demo NOT NULL
    , job_id         VARCHAR2(10)  CONSTRAINT emp_job_nn_demo          NOT NULL
    , salary         NUMBER(8,2)   CONSTRAINT emp_salary_nn_demo       NOT NULL
    , commission_pct NUMBER(2,2)
    , manager_id     NUMBER(6)
    , department_id  NUMBER(4)
    , dn             VARCHAR2(300)
    , CONSTRAINT     emp_salary_min_demo CHECK (salary > 0) 
    , CONSTRAINT     emp_email_uk_demo   UNIQUE (email)
    ) ;
```

^ NULL
^ Katalog.Schema.Tabellenname
^ leere Relation erzeugt,

---

# Wertebereiche

^ Beispiele mit oracle

---

## Zeichen und Zeichenketten

---

## `CHAR`

^ fixed-length character
^ between 1 and 2000 bytes

^ https://docs.oracle.com/cd/B28359_01/server.111/b28318/datatype.htm#i1960

---

## `VARCHAR2` bzw `VARCHAR`

^ https://docs.oracle.com/cd/B28359_01/server.111/b28318/datatype.htm#i1835

---

```
CHAR(10)       'abcdef   '     
VARCHAR2(10)   'abcdef'

```

---

## Datum
## `DATE`
### `DD-MON-YY`

^ https://docs.oracle.com/cd/B28359_01/server.111/b28318/datatype.htm#i1847

---

## Zeit
## `TIMESTAMP`

---

## Zeitzonen
###[fit] `TIMESTAMP WITH TIME ZONE`
###[fit] `TIMESTAMP WITH LOCAL TIME ZONE`

---

## Numerische Werte

---

## Integer
## `int`

---

## `smallint`

^ 256

---

## `float`

---

## oracle
## `NUMBER (precision, scale) `

^ oracle spezifisch
^ https://docs.oracle.com/cd/B28359_01/server.111/b28318/datatype.htm#i16209

---

# LOB
## Large objects 

---

## CLOB 
### Character Large Object 

^ dient zur Aufnahme langer Texte 

---

## BLOB 
### Binary Large Object

^ Dient zur Aufnahme von großen Binärdaten wie z.B. Multimediadaten (Bilder, Video)

---

# Constraints

^ Integritätsbedingungen, also z.B. Primary Key, Foreign Key, Not Null oder Unique werden vom DBMS benannt, damit sie eindeutig identifizierbar sind
^ können auch vom Benutzer benannt werden

---

##  Primärschlüssel
```
CREATE TABLE Bücher (
  ISBN char (13),
  PRIMARY KEY (ISBN)
)
CREATE TABLE Bücher (
  ISBN char (13) PRIMARY KEY
)
CREATE TABLE Bücher (
  ISBN char (13),
  CONSTRAINT PK_Bücher PRIMARY KEY (ISBN)
)
```

^ Relation nur ein Primärschlüssel deklarierbar, für den  selbstverständlich auch keine NULL erlaubt sind.
^ zusammengesetzte: PRIMARY KEY(Titel, Jahr)

---

## UNIQUE

```
CREATE TABLE Bücher (
  ID integer PRIMARY KEY,
  ISBN char (13) UNIQUE
)
```

^ identifizierende Attribute (Schlüssel) sind über die Auszeichnung als UNIQUE deklarierbar, 
^ UNIQUE -Attribute sind eindeutig, dürfen aber NULL enthalten

---

## Fremdschlüssel

```
CREATE TABLE Bücher (
  Verlagsname varchar (100),
  FOREIGN KEY (Verlagsname) REFERENCES Verlage (Verlagsname) 
)
CREATE TABLE Bücher (
  Verlagsname varchar (100) REFERENCES Verlage (Verlagsname) 
)
```
---

### Reaktionen auf Modifikationen
```
ON (<UPDATE>|<DELETE>)
   <NO ACTION>|<SET NULL>|<SET DEFAULT>|<CASCADE>
```
^ Änderung verbieten (NO ACTION). Dies ist auch die Default-Einstellung
Internen Wert auf NULL setzen (SET NULL)
Internen Wert auf Default-Wert setzen (SET DEFAULT)
Internen Wert entsprechend abändern (CASCADE)

---

```
CREATE TABLE supplier
( supplier_id numeric(10) >not null,
  supplier_name varchar2(50) not null,
  contact_name varchar2(50),
  CONSTRAINT supplier_pk PRIMARY KEY (supplier_id)
);

CREATE TABLE products
( product_id numeric(10) not null,
  supplier_id numeric(10) not null,
  CONSTRAINT fk_supplier
    FOREIGN KEY (supplier_id)
    REFERENCES supplier(supplier_id)
    ON DELETE CASCADE
);
```

^ Because of the cascade delete, when a record in the supplier table is deleted, all records in the products table will also be deleted that have the same supplier_id value.
^ betreffen die Tabelle nach Änderungen der referenzierten Tabelle (es wird automatisch auf Änderungen der Tabelle reagiert, die den Primärschlüssel enthält)

---

## Integritätsbedingungen

```
CREATE TABLE Bücher ( 
  Jahr integer CHECK (Jahr BETWEEN 1980 AND 2050)
)
```
---

## Default-Werte pro Spalte angegeben werden
```
CREATE TABLE Bücher (
  Lieferbar SMALLINT(1) DEFAULT 1
)
CREATE TABLE Bücher (
  Bestelldatum DATE NOT NULL
)
```

^ deafult wert ist NULL

---
```
CREATE TABLE Bücher (
  ISBN char (13),
  PRIMARY KEY (ISBN),
  Lieferbar smallint(1) default 1,
  Jahr integer CHECK (Jahr BETWEEN 1980 AND 2050),
  Verlagsname varchar (100),
  PRIMARY KEY (ISBN),
  FOREIGN KEY (Verlagsname) REFERENCES Verlage (Verlagsname) 
)
```

---

## `ALTER TABLE`

^ Modifizieren der Relation

---

## `DROP TABLE`

^ Loeschen
^ wichtig ist die Reihenfolge

---

## Sequence

```
CREATE SEQUENCE matrikel_seq;
CREATE TABLE Student (
  matrikelnummer INTEGER DEFAULT nextval('matrikel_seq'),
  name VARCHAR(30)
)
```

^ automatisch fortlaufende Nummerierung von Matrikelnummern in einer Sequenz erzeugt

---

## Index

^ interne Zugriffsstruktur zur Erhöhung der Zugriffsgeschwindigkeit bei Suchfunktionen

---

```
CREATE INDEX schnelle_namen_suche ON Bücher (ISBN asc);
```

^ aufsteigend (ASC) oder als absteigend (DESC)
^ mehrer Indeces pro tabelle
^ foerdert suchgeschwindigkeit

---

# Das war's für heute 
![fit](../images/Rainbow_Dash.png)
