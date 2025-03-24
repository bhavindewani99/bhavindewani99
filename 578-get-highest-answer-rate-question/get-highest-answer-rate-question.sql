WITH CTE AS(SELECT action, question_id, (COUNT(CASE WHEN action = 'answer' THEN 1 END) * 1.0 / 
    COUNT(CASE WHEN action = 'show' THEN 1 END)) AS ans_rate 
FROM SurveyLog
GROUP BY question_id
)

SELECT question_id AS survey_log
FROM CTE
WHERE ans_rate = (SELECT MAX(ans_rate) FROM CTE)
ORDER BY question_id ASC
LIMIT 1;