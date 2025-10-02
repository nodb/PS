WITH RECURSIVE gen AS (
  -- 루트(부모가 NULL) = 1세대
  SELECT ID, PARENT_ID, 1 AS generation
  FROM ECOLI_DATA
  WHERE PARENT_ID IS NULL

  UNION ALL

  -- 자식 = 부모 세대 + 1
  SELECT e.ID, e.PARENT_ID, g.generation + 1
  FROM ECOLI_DATA e
  JOIN gen g ON e.PARENT_ID = g.ID
)
SELECT
  COUNT(*) AS COUNT,
  generation AS GENERATION
FROM gen g
WHERE NOT EXISTS (               -- 자식이 없는(leaf) 개체만
  SELECT 1
  FROM ECOLI_DATA c
  WHERE c.PARENT_ID = g.ID
)
GROUP BY generation
ORDER BY generation;
