-- 코드를 입력하세요
select RR.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, round(avg(REVIEW_SCORE),2) SCORE
from REST_INFO RI
join REST_REVIEW RR
on RI.REST_ID = RR.REST_ID
where substr(ADDRESS,1,2) = "서울"
group by RR.REST_ID
order by SCORE desc, FAVORITES desc