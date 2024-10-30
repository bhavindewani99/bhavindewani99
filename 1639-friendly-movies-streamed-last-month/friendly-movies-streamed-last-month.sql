# Write your MySQL query statement below
SELECT DISTINCT c.title
FROM TVProgram tv
JOIN Content c
ON tv.content_id = c.content_id
WHERE c.Kids_content = 'Y' AND c.content_type = 'Movies' AND YEAR(tv.program_date) = 2020 AND MONTH(tv.program_date)=6;
