-- �ּ��Դϴ�.
/*
���� ���� �ּ�
*/

SELECT * FROM emp;


-- ��ɾ�� �빮��
-- �� ���� ������ ���� Convention
SELECT 
empno, ename, job, deptno 
FROM emp;

-- emp ���̺��� ��� ����� �̸��� �Ի����� �˻�
SELECT 
ename, hiredate
FROM emp;

SELECT 
ename, hiredate
FROM emp
WHERE job = 'SALESMAN';

-- emp ���̺��� �μ���ȣ�� 10�� �μ��� ����� �̸�, ����, �޿�, �μ���ȣ�� �˻�
SELECT
ename, job, sal, deptno
FROM emp
WHERE deptno = 10;

-- �޿������� ����: ORDER BY ��
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
ename, job, sal AS �޿�, deptno
FROM emp
WHERE deptno = 10
ORDER BY �޿� DESC;


SELECT
ename, job, sal AS �޿�, deptno, hiredate
FROM emp
--WHERE deptno = 10
ORDER BY hiredate DESC;


SELECT
ename, job, sal, deptno
FROM emp
--WHERE deptno = 10
ORDER BY sal Desc;

--���� ��Ÿ���� Ű���� :: rownum
--���� ������ �� ���
--ORDER BY�� ����Ŭ������ ���� �������� ����(ROWNUM�� �� ���� ����ȴ�.)
SELECT
ename, job, sal AS �޿�, deptno, rownum
FROM emp
WHERE deptno = 10
ORDER BY �޿� DESC;

SELECT
ename, job, sal, deptno, rownum
FROM emp
WHERE deptno = 10
ORDER BY sal DESC;

--�޿����� �޴� ���� 3���� ��� ��� ��
-- ������ ���������� ���� ��Ų ����, ROWNUM�� ����
SELECT ename, sal, job, rownum AS RANKING
FROM (SELECT * FROM emp ORDER BY sal DESC)
WHERE rownum <= 3;

/*
SELECT ������ ���� �ȿ����� �������
1. ����Ŭ ���� ����
FROM -> WHERE -> SELECT(�÷� ����) -> ORDER BY(����)

2. MySQL ���� ����
FROM -> WHERE -> SELECT(�÷� ����) -> ORDER BY(����) --> limit
*/

--��� ����� �޿��� ���� �޿����� 100�� ���� ���� 2��� ����...��� ���(��� �̸�, �޿�, ������ �޿�, ����)
SELECT ename, sal, (sal+100)*2) job
FROM emp;

SELECT ename, sal, (sal+100)*2 �����޿�, job
FROM emp;

SELECT ename, sal, (sal+100)*2 "�����޿�", job
FROM emp
ORDER BY "�����޿�";

-- ��� �޿����� ������ �����ϰ� ������ �޿��� �˻�, ������ ������ 10*
--�̸�, ����, �޿�, ���� ������ �޿�

SELECT 
ename, job , sal, (sal*0.9) AS recieved_sal
FROM emp
ORDER BY 4;

SELECT 
ename, job , sal, (sal*0.9) AS recieved_sal, (sal*12) AS annul_salary
FROM emp
ORDER BY 4;

/*
1. null�� 0�� �ƴϰ� ���鵵 �ƴϴ�.
2. ������ �ǹ̸� ������ ���̴�.
    '�ڰݾ���' Ȥ�� '��Ȯ��(Unknown)'�� ���ϴ� ���� �� �ַ� ���ȴ�.
3. ��������(+, -, *, /)�� �ȵǰ� ��(=, !=, >, <, >=, <=)�� �Ұ����ϴ�. 
4. Null���� ������ ������ �ؾ��� ���� �ٸ� ������ ġȯ���Ѽ� �����Ѵ�. -> NVL()�Լ� ���
5. Oracle���� null���� ���� ū ������ ��޵ȴ�. �̶� MySQL������ ���ݴ�
*/

SELECT job, sal, sal*12 + NVL(comm, 0) AS AnnualSalary FROM emp ORDER BY AnnualSalary DESC;

-- EMP ��� �߿��� COMM�� NULL�� ����� �̸��� ����, �޿��� �˻�

--null�� �񱳰� ������ �����Ƿ� ������ �ȵ�
SELECT ename, sal, job 
FROM emp
WHERE comm = null;

SELECT ename, sal, job 
FROM emp
WHERE comm is not null;

 --emp ���̺��� ������ SALESMAN�� ����� �̸�, �޿�, ������ �˻�
 --�̶� ������ ���� ������ ���� ������ ���ĵǵ���
 
 SELECT 
 ename, sal, sal*12 + NVL(comm, 0) AS AnnualSalary
 FROM emp
 WHERE job = 'SALESMAN'
 ORDER BY 3 DESC; 
 
 --COMM�� ���� ���� �޴� ��������� �˻�(���, �̸�, ����, COMM)
 SELECT
 empno, ename, job, comm
 FROM emp
 WHERE comm is not null
 ORDER BY comm DESC;
 
 --emp���̺��� �μ�(��ȣ)�� �˻�
 --�ߺ��� ���ܳ��� Ű����
 
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
--����� �̸� �߿��� S�� �����ϴ� ����� �˻�
SELECT 
ename
FROM emp
WHERE ename LIKE 'S%';

--����� �̸� �߿��� S�� ���Ե� ����� �˻�
SELECT 
ename
FROM emp
WHERE ename LIKE '%S%';

--2��° ���ڿ� A�� �� �ִ� �̸��� ����� �˻�
SELECT 
ename
FROM emp
WHERE ename LIKE '_A%';

--81�⵵�� �Ի��� ����� �˻�
SELECT 
ename, hiredate
FROM emp
WHERE hiredate LIKE '81%';


 