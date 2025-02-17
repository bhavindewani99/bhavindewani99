SELECT DISTINCT c.title
FROM Content c
JOIN TVProgram tv
ON tv.content_id = c.content_id
WHERE program_date BETWEEN '2020-06-01' AND '2020-06-30' AND c.Kids_content = 'Y' AND content_type = 'Movies';