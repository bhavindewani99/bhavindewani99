SELECT q.id, q.year, IFNULL(npv.npv,0) AS npv
FROM Queries q
LEFT JOIN NPV npv
ON npv.id = q.id AND npv.year = q.year;