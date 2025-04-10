# Write your MySQL query statement below
SELECT DISTINCT l.page_id AS recommended_page
FROM likes l
WHERE l.user_id IN (
    SELECT user1_id FROM friendship WHERE user2_id = 1
    UNION
    SELECT user2_id FROM friendship WHERE user1_id = 1
)
AND l.page_id NOT IN (
    SELECT page_id FROM likes WHERE user_id = 1
);
