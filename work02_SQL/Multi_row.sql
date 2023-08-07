--�׷��Լ�
/*
COUNT, SUM, AVG, MAX, MIN
SUM, AVG -> ���ڵ����͸�
COUNT, MAX, MIN -> ����, ����, 

*/

SELECT COUNT(*) ��ü����� FROM emp;

// PK�� �־ �Ȱ��� ����� ����
SELECT COUNT(empno) ��ü����� FROM emp;

SELECT COUNT(-1) ��ü����� FROM emp;

SELECT ROUND(AVG(sal)), SUM(sal), MIN(sal), MAX(sal)
FROM emp;

-- �Ի����� ���� ������ ����� �Ի��� �� ���� �ֱٿ� �Ի��� ����� �Ի����� �˻�
SELECT MIN(hiredate), MAX(hiredate)
FROM emp;

-- �μ���ȣ�� 10���̰ų� 20�� �μ��� ������� �˻�
SELECT COUNT(empno)
FROM emp
WHERE deptno IN (10, 20);

--emp���̺��� �μ���ȣ ���� �˻�
SELECT COUNT(DISTINCT(deptno)) FROM emp;

--��� ����� ���ʽ��� ���
SELECT ROUND(AVG(NVL(comm,0))) AS "���ʽ� ���" FROM emp;

--����� �޿��� ��հ��� �˻�
--STEP1.
--�׷��Լ��� ���ԉ� ���� Į���� SELECT ���� ������ �� ����.
--GROUP BY���� ��õǾ����� �Ѵ�.
SELECT deptno, ROUND(AVG(sal))
FROM emp
GROUP BY deptno;

--STEP3. ALIAS 
SELECT deptno, ROUND(AVG(sal)) "AvgSalary"
FROM emp
GROUP BY deptno
ORDER BY 2;

--STEP4. ���� ������ ���� GROUP BY ������ Alias�� ���� �� ����
SELECT deptno, ROUND(AVG(sal)) "AvgSalary" --3
FROM emp --1
GROUP BY AvgSalary --2
ORDER BY 2;--4

--STEP5.
--�μ��� �޿��� ����� �˻�, 10�� �μ��� �����ϰ� �˻�, ������ �μ���ȣ��
--deptno DNumber
-- from -> where -> group by -> select -> order by  
SELECT deptno DNumber, ROUND(AVG(sal)) "AVGSAL"
FROM emp
WHERE deptno != 10
GROUP BY deptno
ORDER BY 1;

--�Ի�⵵�� ����� �˻�
SELECT EXTRACT(YEAR FROM hiredate) as YEAR FROM emp;
SELECT EXTRACT(MONTH FROM hiredate) as MONTH FROM emp;
SELECT EXTRACT(DAY FROM hiredate) as DAY FROM emp;

--step1
SELECT EXTRACT(YEAR FROM hiredate) as �Ի�⵵, COUNT(*) �ο���
FROM emp 
GROUP BY EXTRACT(YEAR FROM hiredate);

--step2
SELECT TO_CHAR(hiredate, 'YY') FROM emp;

SELECT TO_CHAR(hiredate, 'YY'), COUNT(empno)
FROM emp
GROUP BY TO_CHAR(hiredate, 'YY')
ORDER BY 1;

--step1.
--WHERE �Լ��� �׷��Լ��� ���� ����
SELECT deptno, ROUND(AVG(sal))
FROM emp
WHERE ROUND(AVG(sal)) >= 2000
GROUP BY deptno;

--step2
--GROUPING�� �� ������ �߷��� display�Ѵ� -> HAVING
--GROUP �Լ��� ���� ������ ��� HAVING
SELECT deptno, ROUND(AVG(sal))
FROM emp
GROUP BY deptno
HAVING ROUND(AVG(sal)) >= 2000;

--�ִ� �޿��� 2900�޷��� �Ѵ� �μ����� �ִ� �޿��� ���
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

���, ���� �ۼ��õ����� �������� Group By ������ �ۼ��ϰ� ����Ǵ� �κе��� ������ �ۼ��� ��
UNION ALL�� �����ϴ� ���(STEP 3, 4, 5 ���)
GROUPING SETS�� ����ϴ� ����� �ִµ� (STEMP 1 ���)

GROUPING SETS�� ����� ����� �ξ� �ӵ��� ������.

*/

