# Write your MySQL query statement below
WITH CTE AS(
    SELECT d.name as department, e.name AS employee, e.salary, DENSE_RANK() OVER (PARTITION BY d.name ORDER BY e.salary DESC) AS rnk 
    FROM Employee e 
    JOIN department d 
    ON d.id = e.departmentId
)

SELECT department, employee, salary
FROM CTE 
WHERE rnk = 1;