-- OUTER JOIN
SELECT DISTINCT(deptno) FROM emp;
SELECT deptno FROM dept;

SELECT e.empno, e.ename, e.job, e.deptno e_deptno, d.deptno d_deptno, d.dname
FROM dept d, emp e
WHERE d.deptno = e.deptno(+);

SELECT e.ename, e.sal, e.deptno, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno 
AND e.sal(+)>2000; --Non join 조건에도 +를 해줘야 40번이 나옴