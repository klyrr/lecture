-- 1. Welcher Mitarbeiter hat wie viele Kinder?
SELECT COUNT(*) AS "Anzahl der Kinder", PERSONAL.PNR, PERSONAL.VORNAME, PERSONAL.NACHNAME
FROM PERSONAL, KIND
WHERE PERSONAL.PNR=KIND.PNR
GROUP BY PERSONAL.PNR, PERSONAL.VORNAME, PERSONAL.NACHNAME;

-- 2. Wieviele Mitarbeiter haben schon mal eine Prämie bekommen?
SELECT COUNT(DISTINCT(PNR))
FROM PRAEMIE;

-- 3. Was ist der höchste Neuwert der Maschinen?
SELECT MAX(NEUWERT) 
FROM MASCHINE;

-- 4. Was war die niedrigste Prämie?
SELECT MIN(P_BETRAG)
FROM PRAEMIE;

-- 5. Wie viel sind alle Maschinen zusammen zum aktuellen Zeitpunkt wert?
SELECT SUM(ZEITWERT)
FROM MASCHINE;

-- 6. Wer arbeitet an Maschinen, die zusammen einen Neuwert von mehr als 60.000 EUR haben?
SELECT PNR
FROM MASCHINE
GROUP BY PNR
HAVING SUM(NEUWERT) > 60000;

SELECT MASCHINE.PNR, VORNAME, NACHNAME
FROM MASCHINE, PERSONAL
WHERE MASCHINE.PNR = PERSONAL.PNR
GROUP BY MASCHINE.PNR, VORNAME, NACHNAME
HAVING SUM(NEUWERT) > 60000;

-- 8. Wer arbeitet an Maschinen, deren durchschnittlicher Zeitwert weniger als 20.000 EUR wert ist?
SELECT MASCHINE.PNR, VORNAME, NACHNAME
FROM PERSONAL, MASCHINE
WHERE MASCHINE.PNR=PERSONAL.PNR
GROUP BY MASCHINE.PNR, VORNAME, NACHNAME
HAVING AVG(ZEITWERT) < 20000;

-- 9. Was ist der durchschnittliche Anschaffungswert einer Maschine?
SELECT AVG(NEUWERT)
FROM MASCHINE;






















