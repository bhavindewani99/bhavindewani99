SELECT MIN(ABS(x1.x - x2.x)) AS shortest
FROM Point x1
JOIN Point x2
ON x1.x <> x2.x;