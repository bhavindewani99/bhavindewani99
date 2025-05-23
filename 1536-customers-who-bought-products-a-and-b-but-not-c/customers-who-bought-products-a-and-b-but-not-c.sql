# Write your MySQL query statement below
SELECT c.customer_id, c.customer_name
FROM Customers c
JOIN Orders o
ON c.customer_id = o.customer_id
GROUP BY c.customer_id
HAVING SUM(o.product_name = 'A') > 0 AND SUM(o.product_name = 'B') > 0 AND SUM(o.product_name = 'C') = 0;