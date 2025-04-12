# Write your MySQL query statement below
SELECT order_id, customer_id, order_type
FROM Orders
WHERE 
	order_type = 0 or 
	(order_type = 1 and customer_id not in (
		SELECT customer_id
		FROM Orders
		WHERE order_type = 0)
	)
;