SELECT CAR_ID, CAR_TYPE, FEE
FROM (
    SELECT 
        C.CAR_ID,
        C.CAR_TYPE,
        ROUND(
            C.DAILY_FEE * 30 *
            (100 - (
                SELECT D.DISCOUNT_RATE
                FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN D
                WHERE D.CAR_TYPE = C.CAR_TYPE
                  AND D.DURATION_TYPE = '30일 이상'
            )) / 100
        , 0) AS FEE
    FROM CAR_RENTAL_COMPANY_CAR C
    WHERE C.CAR_TYPE IN ('세단', 'SUV')
      AND C.CAR_ID NOT IN (
          SELECT H.CAR_ID
          FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
          WHERE H.START_DATE <= '2022-11-30'
            AND H.END_DATE >= '2022-11-01'
      )
) X
WHERE FEE >= 500000
  AND FEE < 2000000
ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC;