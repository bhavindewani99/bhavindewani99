# Write your MySQL query statement below
SELECT r1.driver_id, IFNULL(COUNT(DISTINCT r2.ride_id),0) AS cnt
FROM Rides r1
LEFT JOIN Rides r2
ON r1.driver_id = r2.passenger_id
GROUP BY r1.driver_id;