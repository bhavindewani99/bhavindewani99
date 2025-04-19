SELECT 
    p.player_id, 
    p.player_name, 
    COUNT(*) AS grand_slams_count
FROM Players p
JOIN (
    SELECT Wimbledon AS player_id FROM Championships
    UNION ALL
    SELECT Fr_open FROM Championships
    UNION ALL
    SELECT US_open FROM Championships
    UNION ALL
    SELECT Au_open FROM Championships
) AS wins 
ON p.player_id = wins.player_id
GROUP BY p.player_id, p.player_name
ORDER BY grand_slams_count;
