# Write your MySQL query statement below
select prices.product_id, ifnull(round(sum(prices.price*unitssold.units)/sum(unitssold.units), 2), 0) as average_price
from prices left join unitssold
on prices.product_id=unitssold.product_id
and unitssold.purchase_date between prices.start_date and prices.end_date
group by prices.product_id;