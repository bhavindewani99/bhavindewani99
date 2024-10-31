# Write your MySQL query statement below
SELECT e.user_id
FROM emails e
JOIN texts t
ON e.email_id = t.email_id
WHERE signup_action = 'Verified' AND DATEDIFF(action_date,signup_date) = 1
ORDER BY e.user_id;