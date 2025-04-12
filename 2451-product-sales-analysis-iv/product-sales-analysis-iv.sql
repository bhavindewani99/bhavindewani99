WITH CTE AS (
    SELECT 
        s.user_id, 
        s.product_id, 
        SUM(s.quantity * p.price) AS total_spent
    FROM Sales s
    JOIN Product p 
        ON s.product_id = p.product_id
    GROUP BY s.user_id, s.product_id
),
ranked AS (
    SELECT *,
           RANK() OVER (PARTITION BY user_id ORDER BY total_spent DESC) AS rnk
    FROM CTE
)
SELECT user_id, product_id
FROM ranked
WHERE rnk = 1;
