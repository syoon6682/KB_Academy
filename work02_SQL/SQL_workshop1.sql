-- 1) emp ���̺� ������ Ȯ���ϼ���.
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno 
FROM emp;

-- 2) �μ���ȣ�� 20���� �μ��� ��� �� �����ȣ, �̸�, ������ ����϶�
SELECT empno, ename, sal 
FROM emp
WHERE deptno = 20;

-- 3) �̸��� JONES�� ����� ��� ������ ����϶�.
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno 
FROM emp
WHERE ename = 'JONES';


-- 4)������ MANAGER�� �ƴ� ����� ��� ������ ����϶�.
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno 
FROM emp
WHERE job != 'MANAGER';


-- 5) �޿��� $1,600���� ũ�� $3,000���� ���� ����� �̸�, ����, �޿��� ����϶�.
SELECT ename, job, sal 
FROM emp
WHERE 1600 < Sal and sal < 3000;


-- 6) �Ի����� 80�⵵�� ����� ��� ������ ����϶�
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno 
FROM emp
WHERE hiredate LIKE '80%';



-- 7) �Ի����� 81/12/09 ���� ���� �Ի��� ������� ��� ������ ����϶�.
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno 
FROM emp
WHERE hiredate < '81/12/09';


-- 8) �̸� �� S�ڰ� �� �ִ� ����� ��� ������ ����϶�.
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno 
FROM emp
WHERE ename LIKE '%S%';


-- 9) comm�� null�� �ƴ� ������� �̸�, �޿�, comm, �μ���ȣ�� ��ȸ
-- comm�� ��Ī�� ���ʽ��� �ϰ� ���ʽ��� ���� ���������(desc) ����
SELECT ename, sal, comm, deptno 
FROM emp
WHERE comm is not null;


-- 10) ����߿��� �������� SALESMAN�̰ų� ����(PRESIDENT)�̸鼭 ���ÿ� �޿��� 1500 �̻��� �Ǵ� ����� �˻�
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno 
FROM emp
WHERE (job = 'SALESMAN' OR job = 'PRESIDENT') and sal >= 1500;


-- 11) �μ���ȣ�� �⺻ ��������, �μ���ȣ�� ������� �޿��� ���� ������ �����Ͽ� ���, �̸�, ����, �μ���ȣ,�޿��� ��ȸ
SELECT empno, ename, job, deptno, sal 
FROM emp
ORDER BY deptno, sal DESC ;

-- 12) �μ����� ����ϴ� ������ �ѹ��� ��ȸ�Ͻÿ�
-- ��, ���� �������� �����մϴ�.
SELECT deptno, job
FROM emp
GROUP BY deptno, job
ORDER BY deptno;


-- 13) �Ի����� ���� ������ ��� 5�� ��ȸ�Ͻÿ�
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno 
FROM (SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno FROM emp ORDER BY hiredate)
WHERE rownum <= 5;


-- 14) emp Table���� �̸�, �޿�, Ŀ�̼� �ݾ�, �Ѿ�(sal + comm)��  ���Ͽ� �Ѿ��� ���� ������ ����϶�. 
-- ��, Ŀ�̼��� NULL�� ����� �����Ѵ�.(Ŀ�̼Ǳݾ�: sal*comm/100)
SELECT ename, sal, comm * sal/100 AS commision, sal+comm AS total 
FROM emp
WHERE comm is not null;


-- 15)  10�� �μ��� ��� ����鿡�� �޿��� 13%�� ���ʽ��� �����ϱ�� �Ͽ���. �̸�, �޿�, ���ʽ� �ݾ�, �μ���ȣ�� ����϶�.
SELECT  ename, sal, sal * 0.13 AS bonus, deptno 
FROM emp
WHERE deptno = 10;


