# Write your MySQL query statement below
SELECT c.customer_id, c.name
FROM Customers c
JOIN ORDERS o
ON c.customer_id = o.customer_id
JOIN Product p
ON o.product_id = p.product_id
GROUP BY o.customer_id
HAVING SUM(CASE WHEN YEAR(o.order_date)=2020 AND MONTH(o.order_date) = 06 THEN o.quantity*p.price END) >= 100
   AND SUM(CASE WHEN YEAR(o.order_date)=2020 AND MONTH(o.order_date) = 07 THEN o.quantity*p.price END) >= 100
