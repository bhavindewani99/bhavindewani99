# Write your MySQL query statement below
SELECT q.id, q.year, IFNULL(n.npv,0) AS npv
FROM NPV n
RIGHT JOIN Queries q
ON n.id = q.id AND n.year = q.year;