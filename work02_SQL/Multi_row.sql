--그룹함수
/*
COUNT, SUM, AVG, MAX, MIN
SUM, AVG -> 숫자데이터만
COUNT, MAX, MIN -> 숫자, 문자, 

*/

SELECT COUNT(*) 전체사원수 FROM emp;

// PK를 넣어도 똑같은 결과가 나옴
SELECT COUNT(empno) 전체사원수 FROM emp;

SELECT COUNT(-1) 전체사원수 FROM emp;

SELECT ROUND(AVG(sal)), SUM(sal), MIN(sal), MAX(sal)
FROM emp;

-- 입사한지 가장 오래된 사원의 입사일 과 가장 최근에 입사한 사원의 입사일을 검색
SELECT MIN(hiredate), MAX(hiredate)
FROM emp;

-- 부서번호가 10번이거나 20번 부서의 사원수를 검색
SELECT COUNT(empno)
FROM emp
WHERE deptno IN (10, 20);

--emp테이블에서 부서번호 수를 검색
SELECT COUNT(DISTINCT(deptno)) FROM emp;

--모든 사원의 보너스의 평균
SELECT ROUND(AVG(NVL(comm,0))) AS "보너스 평균" FROM emp;

--사원의 급여의 평균값을 검색
--STEP1.
--그룹함수의 포함됮 않은 칼럼이 SELECT 절에 나열될 수 없다.
--GROUP BY절에 명시되어져야 한다.
SELECT deptno, ROUND(AVG(sal))
FROM emp
GROUP BY deptno;

--STEP3. ALIAS 
SELECT deptno, ROUND(AVG(sal)) "AvgSalary"
FROM emp
GROUP BY deptno
ORDER BY 2;

--STEP4. 실행 순서에 의해 GROUP BY 절에는 Alias는 들어올 수 없음
SELECT deptno, ROUND(AVG(sal)) "AvgSalary" --3
FROM emp --1
GROUP BY AvgSalary --2
ORDER BY 2;--4

--STEP5.
--부서별 급여의 평균을 검색, 10번 부서는 제외하고 검색, 정렬은 부서번호로
--deptno DNumber
-- from -> where -> group by -> select -> order by  
SELECT deptno DNumber, ROUND(AVG(sal)) "AVGSAL"
FROM emp
WHERE deptno != 10
GROUP BY deptno
ORDER BY 1;

--입사년도별 사원수 검색
SELECT EXTRACT(YEAR FROM hiredate) as YEAR FROM emp;
SELECT EXTRACT(MONTH FROM hiredate) as MONTH FROM emp;
SELECT EXTRACT(DAY FROM hiredate) as DAY FROM emp;

--step1
SELECT EXTRACT(YEAR FROM hiredate) as 입사년도, COUNT(*) 인원수
FROM emp 
GROUP BY EXTRACT(YEAR FROM hiredate);

--step2
SELECT TO_CHAR(hiredate, 'YY') FROM emp;

SELECT TO_CHAR(hiredate, 'YY'), COUNT(empno)
FROM emp
GROUP BY TO_CHAR(hiredate, 'YY')
ORDER BY 1;

--step1.
--WHERE 함수는 그룹함수와 같이 못씀
SELECT deptno, ROUND(AVG(sal))
FROM emp
WHERE ROUND(AVG(sal)) >= 2000
GROUP BY deptno;

--step2
--GROUPING을 한 다음에 추려서 display한다 -> HAVING
--GROUP 함수에 들어가는 조건은 모두 HAVING
SELECT deptno, ROUND(AVG(sal))
FROM emp
GROUP BY deptno
HAVING ROUND(AVG(sal)) >= 2000;

--최대 급여가 2900달러가 넘는 부서들의 최대 급여를 출력
SELECT deptno, MAX(sal)
FROM emp
GROUP BY deptno
HAVING MAX(sal) > 2900;

--ROLLUP

SELECT deptno, count(*), sum(sal)
FROM emp
GROUP BY ROLLUP(deptno);

SELECT deptno, count(*), sum(sal)
FROM emp
GROUP BY deptno;

SELECT deptno, job, SUM(sal)
FROM emp
GROUP BY ROLLUP (deptno, job)
ORDER BY deptno;


SELECT deptno, job, SUM(sal)
FROM emp
GROUP BY ROLLUP (job, deptno);
--ORDER BY deptno;


--GROUPING SETS
SELECT deptno, job, SUM(sal)
FROM emp
GROUP BY GROUPING SETS(deptno, job);

SELECT deptno, job, SUM(sal)
FROM emp
GROUP BY ROLLUP(deptno, job);

--GROUPING SETS PRAC
--step 1.
SELECT deptno, job, SUM(sal)
FROM emp
GROUP BY GROUPING SETS(job, deptno)
ORDER BY JOB,DEPTNO ;

--step2
SELECT deptno, job, SUM(sal)
FROM emp
GROUP BY deptno
UNION ALL
SELECT job, SUM(sal)
FROM emp
GROUP BY job;

--step3
SELECT TO_CHAR(deptno) deptno, SUM(sal)
FROM emp
GROUP BY deptno
UNION ALL
SELECT job, SUM(sal)
FROM emp
GROUP BY job;


--step4
SELECT deptno, NULL job, SUM(sal)
FROM emp
GROUP BY deptno
UNION ALL
SELECT NULL deptno, job, SUM(sal)
FROM emp
GROUP BY job;

/*

통계, 쿼리 작성시동일한 쿼리문을 Group By 절에서 작성하고 변경되는 부분들을 일일이 작성한 후
UNION ALL로 결합하는 방식(STEP 3, 4, 5 방식)
GROUPING SETS를 사용하는 방식이 있는데 (STEMP 1 방식)

GROUPING SETS를 사용한 방식이 훨씬 속도가 빠르다.

*/

