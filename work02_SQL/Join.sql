--JOIN
--여러 테이블로부터 데이터를 가져올 때 사용되는 기법

--직원에 대한 정보를 가져옴
SELECT * FROM emp;

--직원, 부서에 대한 정보를 가져옴
SELECT * FROM emp, dept;

/*
위처럼 나온 결과를 Cartessian Product
emp와 dept 테이블의 수평적인 결합 결과
14*4=56행

Cartessian Product가 도출되는 경우
1) 조인 조건을 안줄때
2) 조인 조건을 잘못줄때
결론: 조인 조건 주자~~
*/

--STEP1.
--1. 조인 조건은 양쪽 테이블에 공통적인 컬럼이 조인 조건이 되는 컬럼이다.
--2. 조인 조건은 where절에 지정 =를 사용해서 명시

-- * 표현은 자제해야 한다. Projection 요구됨
SELECT * FROM emp, dept
WHERE emp deptno = dept deptno;

--STEP2.
--deptno 어느 테이블 것을 가져와야 하는지 에러 도출
--모든 테이블을 다 뒤지기 때문에
SELECT empno, ename, sal, emp.deptno, dname
FROM emp, dept
WHERE emp.deptno = dept.deptno;

--STEP3.
SELECT emp.empno, emp.ename, emp.sal, emp.deptno, dept.dname
FROM emp, dept
WHERE emp.deptno = dept.deptno;

--STEP4
SELECT e.empno, e.ename, e.sal, e.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno;

--사원이름, 급여, 부서번호, 부서이름, 부서위치를 검색
--단, 급여가 2000 이상이고 30번 부서에 한해서만 검색
--where 절에서 조인 조건과 함께 비조인조건이 같이 나온다.
SELECT e.ename, e.sal, e.deptno, d.dname, d.loc
FROM emp e, dept d
WHERE (e.deptno = d.deptno) and (e.sal>2000) and (e.deptno = 30);

--뉴욕에서 근무하는 사원의 이름과 급여를 검색
SELECT e.ename, e.sal, d.loc
FROM emp e, dept d
WHERE (e.deptno = d.deptno) and (d.loc = 'NEW YORK');




