-- 코드를 작성해주세요
select HE.DEPT_ID, DEPT_NAME_EN, round(avg(SAL),0) AVG_SAL
from HR_EMPLOYEES HE
join HR_DEPARTMENT HD
on HE.DEPT_ID = HD.DEPT_ID
group by HE.DEPT_ID
order by AVG_SAL desc
