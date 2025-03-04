-- 코드를 작성해주세요

SELECT ED1.ID, ED1.GENOTYPE, ED2.GENOTYPE PARENT_GENOTYPE
FROM ECOLI_DATA ED1, ECOLI_DATA ED2
WHERE ED1.PARENT_ID = ED2.ID AND
      ED1.GENOTYPE & ED2.GENOTYPE = ED2.GENOTYPE
ORDER BY ED1.ID
