# Write your MySQL query statement below
SELECT u.user_id AS buyer_id, u.join_date, IFNULL(COUNT(o.buyer_id),0) AS orders_in_2019
FROM Users u
LEFT JOIN Orders o
ON o.buyer_id = u.user_id
AND YEAR(o.order_date) = 2019
GROUP BY u.user_id;
