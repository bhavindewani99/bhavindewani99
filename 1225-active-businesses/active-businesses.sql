# Write your MySQL query statement below
WITH avg_activity AS(
    SELECT business_id, event_type, occurrences,
    AVG(occurrences) OVER (PARTITION BY event_type) AS average
    FROM Events
)

SELECT business_id 
FROM avg_activity
GROUP BY business_id
HAVING SUM(occurrences>average)>1