WITH CTE AS(
    SELECT u.name, 
    DENSE_RANK() OVER (ORDER BY COUNT(mr.user_id) DESC, u.name ASC) AS rnk 
    FROM Users u 
    JOIN MovieRating mr
    ON u.user_id = mr.user_id
    GROUP BY u.name
),
CTE2 AS( 
    SELECT m.title,
    DENSE_RANK() OVER (ORDER BY AVG(mr.rating) DESC, m.title ASC) AS rnk2 
    FROM Movies m 
    JOIN MovieRating mr
    ON m.movie_id = mr.movie_id
    WHERE mr.created_at BETWEEN '2020-02-01' AND '2020-02-29'
    GROUP BY m.title)

 SELECT name AS results
 FROM CTE
 WHERE rnk = 1
 UNION ALL
 SELECT title AS results
 FROM CTE2
 WHERE rnk2 = 1;