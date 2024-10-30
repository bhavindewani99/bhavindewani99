# Write your MySQL query statement below
SELECT DISTINCT c1.user_id
FROM Confirmations c1
JOIN Confirmations c2
ON c1.user_id = c2.user_id and c1.time_stamp>c2.time_stamp and 
timestampdiff(second, c2.time_stamp,c1.time_stamp)<=86400