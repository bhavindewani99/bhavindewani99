# Write your MySQL query statement below
SELECT DISTINCT
  SUBSTRING(email, LOCATE('@', email) + 1) AS email_domain, COUNT(email) AS count
FROM 
  Emails
WHERE SUBSTRING(email, LOCATE('@', email) + 1) LIKE '%.com%'
GROUP BY email_domain
ORDER BY email_domain ASC;
