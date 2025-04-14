WITH row_user AS (
    SELECT user_id, created_at,
           ROW_NUMBER() OVER(PARTITION BY user_id ORDER BY created_at) AS rn
    FROM Users
)
SELECT DISTINCT a.user_id
FROM row_user a
JOIN row_user b 
    ON a.user_id = b.user_id 
    AND a.rn < b.rn
WHERE ABS(DATEDIFF(b.created_at, a.created_at)) <= 7;
