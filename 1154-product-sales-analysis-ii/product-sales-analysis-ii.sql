# Write your MySQL query statement below
SELECT s.product_id, SUM(s.quantity) AS total_quantity
FROM Sales s
GROUP BY product_id;