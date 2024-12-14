-- 코드를 입력하세요
SELECT B.AUTHOR_ID, A.AUTHOR_NAME, CATEGORY, SUM(SALES * PRICE) TOTAL_SALES
FROM BOOK B
JOIN BOOK_SALES BS ON B.BOOK_ID = BS.BOOK_ID
JOIN AUTHOR A ON B.AUTHOR_ID = A.AUTHOR_ID
WHERE SALES_DATE LIKE "2022-01-%"
GROUP BY A.AUTHOR_ID, CATEGORY
ORDER BY A.AUTHOR_ID, CATEGORY DESC