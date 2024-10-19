# Write your MySQL query statement below
SELECT state, GROUP_CONCAT(city ORDER BY city ASC separator ', ') AS cities
FROM cities
GROUP BY state
ORDER BY state ASC;