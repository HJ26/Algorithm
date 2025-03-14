-- 코드를 입력하세요
SELECT PRODUCT_CODE, SUM( PRICE * SALES_AMOUNT ) SALES
FROM PRODUCT P
JOIN OFFLINE_SALE OS
ON P.PRODUCT_ID = OS.PRODUCT_ID
GROUP BY P.PRODUCT_ID, PRODUCT_CODE
ORDER BY SALES DESC, PRODUCT_CODE