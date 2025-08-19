# Write your MySQL query statement below
SELECT e.name AS Employee
FROM employee e 
JOIN employee m 
ON e.managerId = m.id 
WHERE m.salary < e.salary;