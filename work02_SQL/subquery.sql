--Sub Query

--?에 해당하는 부분을 () 안에 쿼리를 먼저 수행하고, 그 결과가 main 쿼리에서 실행...
--CLERK의 급여보다 더 많은 급여를 받는 사원의 이름과 급여, 업무를 검색

-- 괄호 안에 있는 걸 subquery, inner query
-- 가장 주 query를 main query, outer query

SELECT ename, sal, job
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename='CLARK');

SELECT ename, sal
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE empno = 7566);

SELECT empno, ename, job, hiredate, sal
FROM emp 
WHERE job = (SELECT job FROM emp WHERE empno = 7521) AND sal > (SELECT sal FROM emp WHERE empno = 7934);

SELECT ename, empno, sal, hiredate
FROM emp
WHERE sal = (SELECT MAX(sal) FROM emp);

--job 별 가장 작은 평균 급여를 검색, 업무, 평균급여를 출력
--HAVING 절 뒤에 오는 서브쿼리
--그룹함수 중첩
SELECT job, round(AVG(sal))
FROM emp
GROUP BY job
HAVING AVG(sal) = (SELECT MIN(AVG(sal)) FROM emp GROUP BY job);

--FROM절 뒤에 오는 서브쿼리
--사원 중에서 급여를 가장 많이 받는 사원 랭킹 3을 검색
SELECT ename, sal, rownum
FROM (SELECT * FROM emp ORDER BY sal DESC)
WHERE rownum <= 3;


--SCOTT의 급여보다 더 많은 급여를 받는 사원 검색(가장 전형적인 서브쿼리)

--STEP 1
SELECT ename, sal
FROM emp
WHERE sal > (SELECT sal FROM emp WHERE ename='SCOTT');

--STEP 2
SELECT * 
FROM emp a, (SELECT sal FROM emp WHERE ename='SCOTT') b
WHERE a.sal > b.sal;

--STEP 3
SELECT empno, ename
FROM emp
WHERE sal = (SELECT MIN(sal) FROM emp GROUP BY deptno);

--다중 행 subquery
SELECT MIN(sal) FROM emp GROUP BY deptno;

--다중행
SELECT empno, ename, sal
FROM emp
WHERE sal IN (SELECT MIN(sal) FROM emp GROUP BY deptno);

--업무가 SALESMAN인 최소 한명이상의 사원보다 급여를 많이 받는 사원의 이름, 급여, 업무를 조회하라
SELECT ename, sal, job
FROM emp
WHERE job != 'SALESMAN' AND sal > ANY(SELECT sal FROM emp WHERE job='SALESMAN');

SELECT ename, sal, job
FROM emp
WHERE job != 'SALESMAN' AND sal > (SELECT MIN(sal) FROM emp WHERE job='SALESMAN')
ORDER BY sal DESC;

SELECT ename, sal, hiredate, deptno
FROM emp
WHERE sal > ALL(SELECT sal FROM emp WHERE job='SALESMAN')
ORDER BY sal DESC;

--부서 번호가 30번인 사원의 급여 중에서 가장 낮은 급여(950)보다 더 높은 급여를 받는 사원의 이름, 급여, 부서번호 
SELECT sal, deptno FROM emp WHERE deptno = 30;

--1)그룹함수
SELECT ename, sal, deptno
FROM emp
WHERE sal > (SELECT MIN(MIN(sal)) FROM emp GROUP BY deptno) AND deptno=30;

SELECT MIN(sal) FROM emp WHERE deptno = 30 GROUP BY deptno;
--2)다중 행 연산자
SELECT ename, sal, detpno
FROM emp
WHERE sal > ALL(SELECT MIN(sal) FROM emp WHERE deptno = 30);



--SUBQUERY에서의 NULL값
--IN을 활용한 비교가 안되므로 NVL로 치환을 해줘야한다~~~
--EMP 테이블에서 부하 직원을 거느린 사원 검색
--근데 null값 처리를 안썼습니다..
SELECT DISTINCT(m.ename)
FROM emp e, emp m
WHERE e.mgr = m.empno;

SELECT * FROM emp WHERE empno IN (SELECT mgr FROM emp);

--EMP 테이블에서 부하직원을 거느리지 않는 사원 검색
SELECT ename
FROM emp
WHERE ename NOT IN (SELECT DISTINCT(m.ename)
FROM emp e, emp m
WHERE e.mgr = m.empno);
