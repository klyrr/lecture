1. Erstellen Sie einen View für alle Mitarbeiter, die in einer Abteilung arbeiten, die mit 'P' anfängt

CREATE VIEW PERSONAL_ABTEILUNG_P AS
    SELECT PERSONAL.* 
    FROM PERSONAL, ABTEILUNG 
    WHERE PERSONAL.ABT_NR = ABTEILUNG.ABT_NR AND ABTEILUNG.NAME LIKE 'P%';

2. Erstellen Sie einen View für Mitarbeiter und die Summe ihrer Prämien.

CREATE VIEW PERSONAL_PRAEMIE (PNR, SUM_BETRAG) AS
    SELECT PERSONAL.PNR, SUM(PRAEMIE.P_BETRAG)
    FROM PERSONAL, PRAEMIE
    WHERE PERSONAL.PNR = PRAEMIE.PNR 
    GROUP BY PERSONAL.PNR;

3. Erstellen Sie einen View für Mitarbeiter, die Kinder haben. Und dann eine View für Mitarbeiter, die mindestens zwei Kinder haben.

CREATE VIEW MITARBEITER_KINDER (PNR, ANZAHL_KINDER) AS
    SELECT PERSONAL.PNR, count(*)
    FROM PERSONAL, KIND 
    WHERE PERSONAL.PNR = KIND.PNR
    GROUP BY PERSONAL.PNR;

CREATE VIEW MITARBEITER_KINDER_ANDERS AS 
    SELECT DISTINCT PERSONAL.*
    FROM PERSONAL, KIND 
    WHERE PERSONAL.PNR = KIND.PNR;

CREATE VIEW MITARBEITER_MIN_ZWEI_KINDER AS
    SELECT PERSONAL.*
    FROM PERSONAL 
    WHERE PERSONAL.PNR IN (
    	SELECT PERSONAL.PNR
	    FROM PERSONAL, KIND 
	    WHERE PERSONAL.PNR = KIND.PNR
	    GROUP BY PERSONAL.PNR
	    HAVING COUNT(*) > 1
    );

I. Fügen Sie jedem Mitarbeiter eine Prämie von 500,- hinzu, der ein Kind hat.

INSERT INTO PRAEMIE 
  SELECT PNR, 500, '12-apr-14'
  FROM MITARBEITER_KINDER_ANDERS ;

Ia. Fügen Sie jedem Mitarbeiter eine Prämie von 500,- pro Kind hinzu.

INSERT INTO PRAEMIE 
  SELECT PERSONAL.PNR, 100, '12-apr-14'
  FROM PERSONAL, KIND
  WHERE PERSONAL.PNR = KIND.PNR;

INSERT INTO PRAEMIE 
  SELECT PERSONAL.PNR, COUNT(*) * 100, '12-nov-14'
  FROM PERSONAL, KIND
  WHERE PERSONAL.PNR = KIND.PNR
  GROUP BY PERSONAL.PNR ;
















