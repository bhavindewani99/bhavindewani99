# Write your MySQL query statement below
SELECT LOWER(TRIM(product_name)) AS product_name, LEFT(sale_date,7) AS sale_date, COUNT(*) AS total
FROM Sales
GROUP BY 1,2
ORDER BY product_name, sale_date;