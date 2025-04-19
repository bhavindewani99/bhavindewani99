WITH CTE AS (
    SELECT salary
    FROM Employees
    GROUP BY salary
    HAVING COUNT(*) >= 2
),
Ranked AS (
    SELECT e.employee_id, e.name, e.salary,
           DENSE_RANK() OVER (ORDER BY e.salary) AS team_id
    FROM Employees e
    WHERE e.salary IN (SELECT salary FROM CTE)
)

SELECT *
FROM Ranked
ORDER BY team_id, employee_id;
