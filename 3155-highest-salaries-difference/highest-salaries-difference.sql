# Write your MySQL query statement below
SELECT ABS((SELECT MAX(salary) AS marketing_salary FROM Salaries
       WHERE department = 'Marketing')-
       (SELECT MAX(salary) AS engineering_salary FROM Salaries
       WHERE department = 'Engineering')) AS salary_difference;