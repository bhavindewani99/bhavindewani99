select count(distinct account_id) as accounts_count from subscriptions 
where year(end_date) >= 2021
and account_id in (select distinct account_id from streams where year(stream_date) != 2021)
and year(start_date) <= 2021