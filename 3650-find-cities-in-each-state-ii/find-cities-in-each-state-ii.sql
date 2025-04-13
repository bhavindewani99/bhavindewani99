SELECT 
    state, 
    GROUP_CONCAT(city ORDER BY city ASC separator ', ') AS cities,
    SUM(CASE WHEN LEFT(city, 1) = LEFT(state, 1) THEN 1 ELSE 0 END) AS matching_letter_count
FROM cities
GROUP BY state
HAVING COUNT(city) >= 3  AND SUM(CASE WHEN LEFT(city, 1) = LEFT(state, 1) THEN 1 ELSE 0 END) > 0 
ORDER BY matching_letter_count DESC, state ASC;