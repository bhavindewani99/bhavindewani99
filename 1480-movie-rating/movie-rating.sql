WITH CTE AS(
    SELECT u.name, DENSE_RANK () OVER (ORDER BY COUNT(mr.rating) DESC, u.name) AS rnk 
    FROM users u 
    JOIN MovieRating mr 
    ON u.user_id = mr.user_id
    GROUP BY u.name
   
  
   
),
CTE2 AS(
    SELECT m.title, DENSE_RANK() OVER (ORDER BY AVG(mr.rating) DESC, m.title ASC) AS rnk 
    FROM movies m 
    JOIN MovieRating mr 
    ON m.movie_id = mr.movie_id
    WHERE mr.created_at >= '2020-02-01' AND mr.created_at < '2020-03-01'
    GROUP BY m.title

)

SELECT name AS results
FROM CTE 
WHERE rnk = 1

UNION ALL
SELECT title AS results
FROM CTE2
WHERE rnk = 1;