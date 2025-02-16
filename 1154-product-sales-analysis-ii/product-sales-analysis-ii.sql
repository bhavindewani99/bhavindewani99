SELECT p.product_id, SUM(s.quantity) AS total_quantity
FROM Product p
JOIN Sales s
ON p.product_id = s.product_id
GROUP BY product_id;