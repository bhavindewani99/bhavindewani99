WITH winery_totals AS (
    SELECT 
        country,
        winery,
        SUM(points) AS total_points
    FROM Wineries
    GROUP BY country, winery
),
ranked AS (
    SELECT 
        country,
        winery,
        total_points,
        ROW_NUMBER() OVER (
            PARTITION BY country 
            ORDER BY total_points DESC, winery ASC
        ) AS rnk
    FROM winery_totals
)
SELECT 
    country,
    COALESCE(MAX(CASE WHEN rnk = 1 
                      THEN CONCAT(winery, ' (', total_points, ')') END),
             'No first winery') AS top_winery,
    COALESCE(MAX(CASE WHEN rnk = 2 
                      THEN CONCAT(winery, ' (', total_points, ')') END),
             'No second winery') AS second_winery,
    COALESCE(MAX(CASE WHEN rnk = 3 
                      THEN CONCAT(winery, ' (', total_points, ')') END),
             'No third winery') AS third_winery
FROM ranked
GROUP BY country
ORDER BY country;
