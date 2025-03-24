Select distinct b.book_id, b.name 
from books b 
left join orders o
ON b.book_id = o.book_id
and dispatch_date >= ("2019-06-23" - INTERVAL 1 YEAR)
where available_from < ("2019-06-23" - INTERVAL 30 DAY)
group by b.book_id, b.name 
having SUM(coalesce(o.quantity,0)) < 10