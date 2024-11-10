# Write your MySQL query statement below
SELECT ROUND(SQRT(MIN((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y))),2) AS shortest
FROM Point2D p1
JOIN Point2D p2
WHERE p1.x <> p2.x OR p1.y <> p2.y;