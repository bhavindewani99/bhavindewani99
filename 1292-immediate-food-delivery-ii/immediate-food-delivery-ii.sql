# Write your MySQL query statement below
WITH CTE AS(
    SELECT customer_id, MIN(order_date) AS first_order
    FROM Delivery
    GROUP BY customer_id
)
SELECT  ROUND(COUNT(CASE WHEN c.first_order = d.customer_pref_delivery_date THEN 1 END)*100.0/COUNT(*),2) AS immediate_percentage
FROM CTE c 
JOIN delivery d 
ON d.customer_id = c.customer_id AND  d.order_date = c.first_order;
