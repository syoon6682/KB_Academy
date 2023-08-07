-- 주석입니다.
/*
여러 라인 주석
*/

SELECT * FROM emp;


-- 명령어는 대문자
-- 절 별로 나누는 것이 Convention
SELECT 
empno, ename, job, deptno 
FROM emp;

-- emp 테이블에서 모든 사원의 이름과 입사일을 검색
SELECT 
ename, hiredate
FROM emp;

SELECT 
ename, hiredate
FROM emp
WHERE job = 'SALESMAN';

-- emp 테이블에서 부서번호가 10번 부서인 사원의 이름, 업무, 급여, 부서번호를 검색
SELECT
ename, job, sal, deptno
FROM emp
WHERE deptno = 10;

-- 급여순으로 정렬: ORDER BY 절
SELECT
ename, job, sal, deptno
FROM emp
WHERE deptno = 10
ORDER BY sal DESC;

SELECT
ename, job, sal, deptno
FROM emp
WHERE deptno = 10
ORDER BY 3 DESC;

SELECT
ename, job, sal AS 급여, deptno
FROM emp
WHERE deptno = 10
ORDER BY 급여 DESC;


SELECT
ename, job, sal AS 급여, deptno, hiredate
FROM emp
--WHERE deptno = 10
ORDER BY hiredate DESC;


SELECT
ename, job, sal, deptno
FROM emp
--WHERE deptno = 10
ORDER BY sal Desc;

--행을 나타내는 키워드 :: rownum
--행을 제한할 때 사용
--ORDER BY가 오라클에서는 가장 마지막에 실행(ROWNUM이 그 전에 실행된다.)
SELECT
ename, job, sal AS 급여, deptno, rownum
FROM emp
WHERE deptno = 10
ORDER BY 급여 DESC;

SELECT
ename, job, sal, deptno, rownum
FROM emp
WHERE deptno = 10
ORDER BY sal DESC;

--급여많이 받는 상위 3인의 결과 얻는 법
-- 정렬을 강제적으로 먼저 시킨 다음, ROWNUM을 적용
SELECT ename, sal, job, rownum AS RANKING
FROM (SELECT * FROM emp ORDER BY sal DESC)
WHERE rownum <= 3;

/*
SELECT 구문의 서버 안에서의 실행순서
1. 오라클 실행 순서
FROM -> WHERE -> SELECT(컬럼 제한) -> ORDER BY(정렬)

2. MySQL 실행 순서
FROM -> WHERE -> SELECT(컬럼 제한) -> ORDER BY(정렬) --> limit
*/

--모든 사원의 급여를 기존 급여에서 100을 더한 값의 2배로 증가...결과 출력(사원 이름, 급여, 증가된 급여, 업무)
SELECT ename, sal, (sal+100)*2) job
FROM emp;

SELECT ename, sal, (sal+100)*2 증가급여, job
FROM emp;

SELECT ename, sal, (sal+100)*2 "증가급여", job
FROM emp
ORDER BY "증가급여";

-- 사원 급여에서 세금을 제외하고 수령한 급여를 검색, 세금은 연봉의 10*
--이름, 업무, 급여, 실제 수령한 급여

SELECT 
ename, job , sal, (sal*0.9) AS recieved_sal
FROM emp
ORDER BY 4;

SELECT 
ename, job , sal, (sal*0.9) AS recieved_sal, (sal*12) AS annul_salary
FROM emp
ORDER BY 4;

/*
1. null은 0도 아니고 공백도 아니다.
2. 나름의 의미를 가지는 값이다.
    '자격없음' 혹은 '미확정(Unknown)'을 뜻하는 값일 때 주로 사용된다.
3. 연산적용(+, -, *, /)이 안되고 비교(=, !=, >, <, >=, <=)가 불가능하다. 
4. Null값을 가지고 연산을 해야할 때는 다른 값으로 치환시켜서 연산한다. -> NVL()함수 사용
5. Oracle에서 null값은 가장 큰 값으로 취급된다. 이때 MySQL에서는 정반대
*/

SELECT job, sal, sal*12 + NVL(comm, 0) AS AnnualSalary FROM emp ORDER BY AnnualSalary DESC;

-- EMP 사원 중에서 COMM이 NULL인 사원의 이름과 업무, 급여를 검색

--null은 비교가 통하지 않으므로 쿼리가 안됨
SELECT ename, sal, job 
FROM emp
WHERE comm = null;

SELECT ename, sal, job 
FROM emp
WHERE comm is not null;

 --emp 테이블에서 업무가 SALESMAN인 사원의 이름, 급여, 연봉을 검색
 --이때 연봉이 높은 순에서 낮은 순으로 정렬되도록
 
 SELECT 
 ename, sal, sal*12 + NVL(comm, 0) AS AnnualSalary
 FROM emp
 WHERE job = 'SALESMAN'
 ORDER BY 3 DESC; 
 
 --COMM을 가장 많이 받는 사원순으로 검색(사번, 이름, 업무, COMM)
 SELECT
 empno, ename, job, comm
 FROM emp
 WHERE comm is not null
 ORDER BY comm DESC;
 
 --emp테이블에서 부서(번호)를 검색
 --중복을 벗겨내는 키워드
 
 SELECT DISTINCT
 deptno
 FROM
 emp
 ORDER BY deptno;

SELECT DISTINCT(deptno)
FROM
emp
ORDER BY 1;
 
SELECT deptno 
FROM dept d
WHERE EXISTS(
SELECT * FROM emp e
WHERE d.deptno = e.deptno
);

/*

*/
--사원의 이름 중에서 S로 시작하는 사원을 검색
SELECT 
ename
FROM emp
WHERE ename LIKE 'S%';

--사원의 이름 중에서 S가 포함된 사원을 검색
SELECT 
ename
FROM emp
WHERE ename LIKE '%S%';

--2번째 문자에 A가 들어가 있는 이름의 사원을 검색
SELECT 
ename
FROM emp
WHERE ename LIKE '_A%';

--81년도에 입사한 사원을 검색
SELECT 
ename, hiredate
FROM emp
WHERE hiredate LIKE '81%';


 