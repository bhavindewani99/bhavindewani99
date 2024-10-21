# Write your MySQL query statement below
SELECT seller_id
FROM Sales s
GROUP BY seller_id
HAVING SUM(price) = (SELECT SUM(price)
					 FROM Sales
                     GROUP BY seller_id
                     ORDER BY 1 DESC
                     LIMIT 1 )