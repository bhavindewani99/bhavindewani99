# Write your MySQL query statement below

SELECT season_id, team_id, team_name, ((3*wins)+(1*draws)) AS points, (goals_for - goals_against) AS goal_difference,
    RANK () OVER (PARTITION BY season_id ORDER BY ((3*wins)+(1*draws)) DESC, (goals_for - goals_against) DESC, team_name) AS position
FROM SeasonStats
ORDER BY season_id ASC, position ASC, team_name ASC;
