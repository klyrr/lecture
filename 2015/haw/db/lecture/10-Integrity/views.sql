# Aufgaben

1. Erstellen Sie eine View, die nur Maschinen enthält, deren Zeitwert weniger als 60% des Neuwerts ist

CREATE VIEW 60_PERCENT_NEUWERT
AS
SELECT MNR, ZEITWERT
FROM MASCHINE
WHERE ZEITWERT <= NEUWERT * 0.6;

2. Erstellen Sie eine View mit Mitarbeitern, die mehr als 3000,- verdienen

CREATE VIEW MITARBEITER_KLEINER_3000
AS
SELECT PERSONAL.*
FROM GEHALT, PERSONAL
WHERE PERSONAL.GEH_STUFE = GEHALT.GEH_STUFE AND GEHALT.BETRAG < 3000;
