# Write your MySQL query statement below
WITH CTE1 AS(
    SELECT v.member_id, COUNT(p.visit_id) AS total_purchases
    FROM Purchases p 
    JOIN Visits v
    ON p.visit_id = v.visit_id
    GROUP BY v.member_id
),
CTE2 AS(
    SELECT member_id, COUNT(visit_id) AS total_visits
    FROM Visits 
    GROUP BY member_id
)

SELECT m.member_id, m.name, 
  CASE
        WHEN vc.total_visits IS NULL THEN 'Bronze'
        WHEN 100 * IFNULL(pc.total_purchases, 0) / vc.total_visits >= 80 THEN 'Diamond'
        WHEN 100 * IFNULL(pc.total_purchases, 0) / vc.total_visits >= 50 THEN 'Gold'
        ELSE 'Silver'
    END AS category
FROM Members m 
LEFT JOIN CTE2 vc ON m.member_id = vc.member_id
LEFT JOIN CTE1 pc ON m.member_id = pc.member_id;