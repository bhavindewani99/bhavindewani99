WITH CTE AS(
    SELECT c.customer_id, COUNT(DISTINCT c.product_key) AS no_of_keys
    FROM Customer c
    GROUP BY c.customer_id
)

SELECT DISTINCT c.customer_id
FROM CTE c 
JOIN Product p 
WHERE no_of_keys = (SELECT COUNT(*) FROM Product)
ORDER BY c.customer_id;