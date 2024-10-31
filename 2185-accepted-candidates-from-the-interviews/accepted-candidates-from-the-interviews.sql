# Write your MySQL query statement below
SELECT c.candidate_id 
FROM Candidates c
JOIN Rounds r
ON c.interview_id = r.interview_id
WHERE c.years_of_Exp >= 2 
GROUP BY c.candidate_id
HAVING SUM(r.score) > 15;