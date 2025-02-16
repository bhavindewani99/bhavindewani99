SELECT seller_id
FROM Sales
GROUP BY seller_id
HAVING SUM(price) = (SELECT SUM(price) AS prices
                FROM Sales
                GROUP BY seller_id
                ORDER BY prices DESC
                LIMIT 1
);