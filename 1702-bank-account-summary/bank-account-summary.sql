# Write your MySQL query statement below
WITH cte AS (
    SELECT u.user_id, u.user_name, u.credit AS old_credit, 
           SUM(
               CASE 
                  WHEN u.user_id = t.paid_by THEN -t.amount
                  WHEN u.user_id = t.paid_to THEN t.amount
                  ELSE 0
               END
           )   balance
    FROM users u, transactions t
    GROUP BY 1,2,3)

SELECT user_id, user_name, (old_credit + balance) AS credit, 
       (CASE WHEN old_credit + balance >= 0 THEN "No"
            WHEN old_credit + balance < 0 THEN "Yes"
        END) credit_limit_breached
FROM cte
ORDER BY 1