# Write your MySQL query statement below
select
    age.age_bucket,
    round(sum(case when activity_type = 'send' then time_spent else 0 end) * 100 / sum(time_spent), 2) as send_perc,
    round(sum(case when activity_type = 'open' then time_spent else 0 end) * 100 / sum(time_spent), 2) as open_perc 
from activities act
left join age
on act.user_id = age.user_id
group by age_bucket