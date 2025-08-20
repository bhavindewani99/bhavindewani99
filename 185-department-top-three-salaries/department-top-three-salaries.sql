WITH CTE AS(
    SELECT d.name AS department, e.name AS employee, e.salary, 
    DENSE_RANK() OVER (PARTITION BY d.name ORDER BY e.salary DESC) AS rnk 
    FROM Employee e 
    JOIN Department d 
    ON e.departmentId = d.id 
    
)

SELECT  department, employee, salary
FROM CTE 
WHERE rnk <= 3;