--Sub Query

--?�� �ش��ϴ� �κ��� () �ȿ� ������ ���� �����ϰ�, �� ����� main �������� ����...
--CLERK�� �޿����� �� ���� �޿��� �޴� ����� �̸��� �޿�, ������ �˻�

-- ��ȣ �ȿ� �ִ� �� subquery, inner query
-- ���� �� query�� main query, outer query

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

--job �� ���� ���� ��� �޿��� �˻�, ����, ��ձ޿��� ���
--HAVING �� �ڿ� ���� ��������
--�׷��Լ� ��ø
SELECT job, round(AVG(sal))
FROM emp
GROUP BY job
HAVING AVG(sal) = (SELECT MIN(AVG(sal)) FROM emp GROUP BY job);

--FROM�� �ڿ� ���� ��������
--��� �߿��� �޿��� ���� ���� �޴� ��� ��ŷ 3�� �˻�
SELECT ename, sal, rownum
FROM (SELECT * FROM emp ORDER BY sal DESC)
WHERE rownum <= 3;


--SCOTT�� �޿����� �� ���� �޿��� �޴� ��� �˻�(���� �������� ��������)

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

--���� �� subquery
SELECT MIN(sal) FROM emp GROUP BY deptno;

--������
SELECT empno, ename, sal
FROM emp
WHERE sal IN (SELECT MIN(sal) FROM emp GROUP BY deptno);

--������ SALESMAN�� �ּ� �Ѹ��̻��� ������� �޿��� ���� �޴� ����� �̸�, �޿�, ������ ��ȸ�϶�
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

--�μ� ��ȣ�� 30���� ����� �޿� �߿��� ���� ���� �޿�(950)���� �� ���� �޿��� �޴� ����� �̸�, �޿�, �μ���ȣ 
SELECT sal, deptno FROM emp WHERE deptno = 30;

--1)�׷��Լ�
SELECT ename, sal, deptno
FROM emp
WHERE sal > (SELECT MIN(MIN(sal)) FROM emp GROUP BY deptno) AND deptno=30;

SELECT MIN(sal) FROM emp WHERE deptno = 30 GROUP BY deptno;
--2)���� �� ������
SELECT ename, sal, detpno
FROM emp
WHERE sal > ALL(SELECT MIN(sal) FROM emp WHERE deptno = 30);



--SUBQUERY������ NULL��
--IN�� Ȱ���� �񱳰� �ȵǹǷ� NVL�� ġȯ�� ������Ѵ�~~~
--EMP ���̺��� ���� ������ �Ŵ��� ��� �˻�
--�ٵ� null�� ó���� �Ƚ���ϴ�..
SELECT DISTINCT(m.ename)
FROM emp e, emp m
WHERE e.mgr = m.empno;

SELECT * FROM emp WHERE empno IN (SELECT mgr FROM emp);

--EMP ���̺��� ���������� �Ŵ����� �ʴ� ��� �˻�
SELECT ename
FROM emp
WHERE ename NOT IN (SELECT DISTINCT(m.ename)
FROM emp e, emp m
WHERE e.mgr = m.empno);
