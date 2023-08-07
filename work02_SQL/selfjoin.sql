SELECT e.ename, e.sal
FROM emp e, dept d;


-- SELF 조인 : 하나의 테이블을 자체적으로 조인함
-- 특정 사원의 상사의 이름을 검색

SELECT empno, ename, mgr 
FROM emp;

/*
EMP E
1. 특정 사원의 ename을 조회해서 emp 테이블에서 찾는다. SMITH
2. SMITH의 상사번호 mgr을 조회, 관리자 번호를 찾음 (7902)
---------------------------------------------------------
EMP M
3. 다시 7902번호의 empno를 찾는다.
4. empno가 7902번인 사원의 이름 ename을 찾는다. (ford)
*/

-- STEP 1
SELECT empno, ename, mgr FROM emp; --e 사원의 상사번호를 찾고
SELECT empno, ename FROM emp; --m 사원의 이름을 찾고

SELECT e.empno, e.ename, e.mgr 
FROM emp e, emp m;

SELECT * 
FROM (SELECT empno, ename, mgr FROM emp) e, (SELECT empno, ename FROM emp) d
WHERE e.mgr = d.empno;

SELECT * 
FROM (SELECT empno, ename, mgr FROM emp) e, (SELECT empno, ename FROM emp) d;

-- STEP 2 조인 조건을 추가
SELECT * 
FROM (SELECT empno, ename, mgr FROM emp) e, (SELECT empno, ename FROM emp) d
WHERE e.mgr = d.empno;

-- STEP 3. ALIAS 지정 -> 사원번호, 사원이름, 상사이름
SELECT e.empno "사원번호", e.ename "사원이름", d.ename "상사이름"
FROM (SELECT empno, ename, mgr FROM emp) e, (SELECT empno, ename FROM emp) d
WHERE e.mgr = d.empno;

SELECT e.empno "사원번호", e.ename "사원이름", d.ename "상사이름"
FROM emp e, emp d
WHERE e.mgr = d.empno
ORDER BY 1;

-- STEP 4. 특정 사원(BLAKE)의 상사 이름을 검색

SELECT e.empno "사원번호", e.ename "사원이름", d.ename "상사이름"
FROM emp e, emp d
WHERE e.mgr = d.empno AND e.ename = 'BLAKE'
ORDER BY 1;