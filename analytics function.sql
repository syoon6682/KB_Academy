--분석함수
--OVER()함수는 ORDER BY 절 뒤에 작동한다.
SELECT empno, ename, deptno, sal,
    RANK() OVER (ORDER BY sal DESC) "RANK"
FROM emp;

SELECT empno, ename, deptno, sal,
    DENSE_RANK() OVER (ORDER BY sal DESC) "RANK"
FROM emp;

SELECT empno, ename, deptno, sal,
    RANK() OVER (PARTITION BY deptno ORDER BY sal DESC) "RANK"
FROM emp;

-- 분석함수가 OVERHEAD를 줄여준다. 성능이 좋다. JOIN/SUBQUERY가 줄어든다.
--STEP1
SELECT ename, sal, rownum FROM emp ORDER BY sal DESC;

--STEP2
SELECT ename, sal, rownum FROM (SELECT * FROM emp ORDER BY sal DESC)
WHERE rownum<=3;

--STEP 3. ROW_NUMBER(), OVER() 함꼐 사용해서 STEP2와 동일한 결과 출력
--안됨, 안되요 
SELECT ename, sal, 
    RANK() OVER (ORDER BY sal DESC 
    ROWS RANGE BETWEEN 1 PRECEDING AND 3 FOLLOWING) "급여랭킹"
FROM emp;


--ROW_NUMBER()
--GROUP BY절, ORDER BY 절에서 지정된 행의 순서를 할당하는 분석함수
--이러헥 2중으로 기준을 제시해서 명확한 ranking 반환
SELECT ename, sal, hiredate,
    ROW_NUMBER() OVER(ORDER BY sal DESC, hiredate ASC) "순번"
FROM emp;



