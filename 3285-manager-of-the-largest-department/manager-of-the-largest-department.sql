# Write your MySQL query statement below
WITH CTE AS(
    SELECT position, emp_name AS manager_name, dep_id, 
    RANK () OVER(ORDER BY COUNT(*) DESC) AS rnk
    FROM Employees
    GROUP BY dep_id
)

SELECT manager_name, dep_id
FROM CTE
WHERE rnk = 1 AND position = 'Manager'
ORDER BY dep_id;