# Write your MySQL query statement below
WITH CTE AS(
    SELECT day, MAX(amount) AS amount
    FROM Transactions 
    GROUP BY day
)
SELECT t.transaction_id
FROM Transactions t
JOIN CTE m
  ON t.day = m.day AND t.amount = m.amount
ORDER BY transaction_id;