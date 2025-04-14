# Write your MySQL query statement below
WITH CTE AS(
    SELECT team_name, (3*wins+draws) AS points, 
    RANK() OVER (ORDER BY (3*wins+draws) DESC ) AS position,
    COUNT(*) OVER() AS total_team
    FROM TeamStats
)

SELECT team_name, points, position, 
CASE WHEN position <= ceil(total_team/3.0) THEN 'Tier 1'
WHEN  position <= ceil(2*total_team/3.0) THEN 'Tier 2'
ELSE 'Tier 3' END AS tier
FROM CTE
ORDER BY points DESC, team_name;