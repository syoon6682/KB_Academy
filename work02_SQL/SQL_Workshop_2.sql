-- ##################  ���ڿ� �Լ� �ǽ� ######################
-- 1) ������ �̸��� ��ҹ��� ������� s�� �� ������ ��� ������ ����϶�.
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
WHERE LOWER(ename) LIKE '%s%';


-- 2) ���� ���� �� �����ȣ, �̸�, �޿��� ����Ѵ�.  ��, �̸��� �տ��� 3���ھ��� ����϶�.
SELECT empno, SUBSTR(ename, 1, 3) ename, sal
FROM emp;

-- 3) �̸��� ���ڼ��� 6�� �̻��� ����� �̸��� �տ��� 3�ڸ� ���Ͽ� �ҹ��ڷ� �̸����� ����϶�.
SELECT empno, LOWER(SUBSTR(ename, 1, 3)) ename, sal
FROM emp
WHERE LENGTH(ename) >= 6;



-- 4) ������ �̸��� �޿��� ����϶�, ��, �ݾ��� ��Ȯ���� ���� �޿��� 6�ڸ��� ����ϰ�, �� ������ ��� * �� ä�� ����϶�.
SELECT ename, LPAD(sal, 6, '*')
FROM emp;


-- 5) ���������� �Է��ϴ��� �Ʒ��� ���� �Է� �Ǿ���.(�̸��� ������ �Էµ�)
insert into emp values(8001,'   PARK   ', 'IT' ,  7521 , '21/11/10', 20000,1000,10);
select * from emp;

-- �̸��� 'PARK'�� ������ ������ ����Ͽ� ����.
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
WHERE ename = '   PARK   ';



-- �̸� �¿쿡 ������ �ִ��� ������ �����ϰ� �̸��� 'PARK'�� ������ ������ ����Ͽ� ����.
SELECT empno, TRIM(ename) ename, job, mgr, hiredate, sal, comm, deptno
FROM emp
WHERE TRIM(ename) = 'PARK';

-- ##################  ���� �Լ� �ǽ� ######################
-- 1) �޿��� $1,500���� $3,000 ������ ����� �޿��� 15%�� ȸ��� �����ϱ�� �Ͽ���. 
-- �̸� �̸�, �޿�, ȸ��(�Ҽ��� �� �ڸ� �Ʒ����� �ݿø�)�� ����϶�.
SELECT ename, sal, 
CASE WHEN sal BETWEEN 1500 and 3000 THEN sal*0.15
ELSE 0
END pay
FROM emp;

 

-- 2) �޿��� $2,000 �̻��� ��� ����� �޿��� 5%�� ������� ���� �� �Ͽ���. 
-- �̸�, �޿�, ������(�Ҽ��� ���� ����)�� ����϶�.
SELECT ename, sal, 
CASE WHEN sal > 2000 THEN TRUNC(sal*0.05)
ELSE 0
END pay
FROM emp;
  

 -- 3) ������ ����ϱ� ���� comm�� 150%�� ���ʽ��� �����Ϸ� �Ѵ�. comm�� �ִ� �������� ������� 
 -- ������ȣ, ������, �޿�, comm�� 150%�� �Ҽ������� �ø��Ͽ� ����϶�. (comm�� 0�̰ų�, null�̸� ����)
SELECT empno, ename, sal, CEIL(comm*1.5) bonus
FROM emp
WHERE (comm IS NOT NULL) OR (comm = 0);




-- ##################  ��¥ �Լ� �ǽ� ######################

-- 1)�Ի��Ϸκ��� 100���� ���� �ĸ� ���غ���. ����̸�, �Ի���, 100�� ���� ��, �޿��� ����϶�.
SELECT ename, hiredate, sal, hiredate+100 after100
FROM emp;


-- 2) �Ի��Ϸκ��� 6������ ���� ���� ��¥�� ���Ϸ��� �Ѵ�.  �Ի���, 6���� ���� ��¥, �޿��� ����϶�
SELECT ename, hiredate, sal, ADD_MONTHS(hiredate, 6) after6
FROM emp;

-- 3) �Ի��� ���� �ٹ��ϼ��� ����Ͽ� �μ���ȣ, �̸�, �ٹ��ϼ��� ����϶�.
SELECT deptno, ename, TRUNC(SYSDATE- hiredate) workday
FROM emp;

-- 4) ��� ����� �Ի��� �������� 100���� ���� ���� �������� ��¥�� ���ؼ� �̸�, �Ի���,��MONDAY���� ����϶�.
SELECT deptno, ename, NEXT_DAY(hiredate + 100, '������') monday
FROM emp;



-- ##################  ��ȯ �Լ� �ǽ� ######################

-- 1) ��� ������ �̸��� �Ի����� ��1996-05-14���� ���·� ��� �϶�.
SELECT ename, TO_CHAR(hiredate, 'YYYY"-"MM"-"DD') hiredate
FROM emp;


-- 2) ��� ������ �̸��� �Ի��� �Ի���� '1981.05' �������� ����϶�
SELECT ename, TO_CHAR(hiredate, 'YYYY"."MM') hiredate
FROM emp;

-- 3) ��� ������ ��ȣ, �̸�, �޿��� ����϶�. ��, �޿��տ� ȭ��ǥ��($), �׸��� õ����(,)ǥ��, �Ҽ������� 2�ڸ��� ǥ�õǵ��� �϶�.
SELECT empno, ename, TO_CHAR(sal, '$999,999.99') salary
FROM emp;

-- ##################  �Ϲ� �Լ� �ǽ� ######################

-- 1)  ��� ������ �̸�, �޿�, Ŀ�̼��� ����϶�. ��, comm�� null�̸� '����'���� ����϶�.
SELECT ename, sal, NVL(TO_CHAR(comm), '����') comm
FROM emp;

-- 2)  ��� ������ �̸�, �޿�, Ŀ�̼�, ������ ����϶�. 
-- comm�� null�̸� �������� ����
-- ���ʽ��� comm�� null�̸� 10
SELECT ename, sal, NVL(TO_CHAR(comm), '����') comm, sal*12 + NVL(comm, 10) annualsalary
FROM emp;


-- 3) ��� ������ �̸�, ����, �޿�, Ŀ�̼�, ���ʽ��� ����϶�. 
-- ���ʽ��� ������  MANAGER�̸� �޿��� 150%, �׿� ������ �޿��� 130% �̴�.
SELECT ename, sal, NVL(TO_CHAR(comm), '����') comm, 
CASE job WHEN 'MANAGER' THEN sal*1.5
    ELSE sal*1.3
    END bonus
FROM emp;


-- 4) 
-- mgr�� null�̸� ���������/ null�̸� mgr���� �������� �Ѵ�.
-- ��Ī�� mgr2�� ���� (2���� �̻� ��� ���)
SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno, 
CASE WHEN mgr is NULL THEN '���������'
    ELSE TO_CHAR(mgr)
    END mgr2
FROM emp;

SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno, 
DECODE(mgr, NULL, '���������', TO_CHAR(mgr)) mgr2
FROM emp;






