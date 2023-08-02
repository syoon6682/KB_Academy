--�м��Լ�
--OVER()�Լ��� ORDER BY �� �ڿ� �۵��Ѵ�.
SELECT empno, ename, deptno, sal,
    RANK() OVER (ORDER BY sal DESC) "RANK"
FROM emp;

SELECT empno, ename, deptno, sal,
    DENSE_RANK() OVER (ORDER BY sal DESC) "RANK"
FROM emp;

SELECT empno, ename, deptno, sal,
    RANK() OVER (PARTITION BY deptno ORDER BY sal DESC) "RANK"
FROM emp;

-- �м��Լ��� OVERHEAD�� �ٿ��ش�. ������ ����. JOIN/SUBQUERY�� �پ���.
--STEP1
SELECT ename, sal, rownum FROM emp ORDER BY sal DESC;

--STEP2
SELECT ename, sal, rownum FROM (SELECT * FROM emp ORDER BY sal DESC)
WHERE rownum<=3;

--STEP 3. ROW_NUMBER(), OVER() �Բ� ����ؼ� STEP2�� ������ ��� ���
--�ȵ�, �ȵǿ� 
SELECT ename, sal, 
    RANK() OVER (ORDER BY sal DESC 
    ROWS RANGE BETWEEN 1 PRECEDING AND 3 FOLLOWING) "�޿���ŷ"
FROM emp;


--ROW_NUMBER()
--GROUP BY��, ORDER BY ������ ������ ���� ������ �Ҵ��ϴ� �м��Լ�
--�̷��� 2������ ������ �����ؼ� ��Ȯ�� ranking ��ȯ
SELECT ename, sal, hiredate,
    ROW_NUMBER() OVER(ORDER BY sal DESC, hiredate ASC) "����"
FROM emp;



