--IN ������
--���� ���� �� �߿��� ��� �ϳ��� ���� ��ġ�ϴ����� ��

--�����ȣ�� 7369���̰ų� 7521���̰ų� 7762���� ����� �˻�
--1STEP

SELECT * FROM emp WHERE empno=7369;
SELECT * FROM emp WHERE empno=7521;
SELECT * FROM emp WHERE empno=7762;

--2STEP
SELECT * FROM emp WHERE empno=7369 OR empno=7521 OR empno=7762;

--3STEP
SELECT * FROM emp WHERE empno IN (7369, 7521, 7762);

SELECT * FROM emp WHERE empno NOT IN (7369, 7521, 7762);

SELECT * FROM emp WHERE NOT empno=7369 AND NOT empno=7521 AND NOT empno=7762;

--�����Լ� :: SUBSTRING
--SUBSTR(���ڿ�, ������ġ, ����)
SELECT SUBSTR('HelloWorld', 6) FROM dual;

--Wor�� ����
SELECT SUBSTR('HelloWorld', 6, 3) FROM dual;

SELECT SUBSTR('HelloWorld', -4, 2) FROM dual;

--emp���̺��� ����� �̸��� N���� ������ ����� �˻�
SELECT * 
FROM emp
WHERE ename LIKE '%N';

SELECT *
FROM emp
WHERE SUBSTR(ename, -1) = 'N';

--emp���̺��� ������� �Ի�⵵�� �˻�
SELECT ename, SUBSTR(hiredate,0, 2) AS "YEAR"
FROM emp;

--TRIM : ������ �����ϴ� �Լ�
SELECT RTRIM('James Gosling          ') name
FROM dual;

SELECT LTRIM('          James Gosling') name
FROM dual;

SELECT TRIM('        James Gosling          ') name
FROM dual;

--REPLACE() :
SELECT REPLACE('SALESMAN', 'MAN', 'PERSON') name
FROM dual;

SELECT REPLACE('        James      Gosling   is   good       ', ' ', '') name
FROM dual;

--�����Լ�
--ROUND
/*
2��° ���ڰ� 2�� �ǹ̴� �Ҽ��� ���� �ڸ����� ���ڸ� ��Ÿ����� ��
�̷��� �Ǳ� ���ؼ��� �Ҽ��� ���� 2�ڸ����� ���������� �ݿø��� ����ȴ�.
*/
SELECT ROUND(45.923, 2) FROM dual;

SELECT ROUND(45.923, 0) FROM dual;
SELECT ROUND(45.923) FROM dual;

/*
�ι�° ���ڰ��� �����϶���
45.923
.�� �߽����� ��, ��, �� ������ �Ž��� �ö�

��� �϶��� �޸� �ش��ڸ����� �ٷ� �ݿø��� �Ͼ��.
*/

SELECT ROUND(45.923, -1) FROM dual; --50

--FLOOR()::����(�Ҽ��� �Ʒ��� ����)
SELECT FLOOR(45.923) FROM dual;

--TRUNC :: �ڸ����� ����, ������ �ڸ��� ���ϸ� ����
SELECT TRUNC(45.923, 2) FROM dual; 

SELECT TRUNC(45.923, 1) FROM dual; 

--CEIL() :: �ø� -> FLOOR�� �ݴ�, �굵 �ڸ��� ���� �ȵ�
--������ ��ȯ�ϰڴٴ� �ǵ�
SELECT CEIL(45.923) FROM dual;

SELECT GREATEST(1,2,3) FROM dual;
SELECT LEAST(1,2,3) FROM dual;


--��¥ �Լ�
SELECT SYSDATE FROM dual;

SELECT SYSTIMESTAMP FROM dual;

--���̸� ������ 100��° �Ǵ� �� ��������
SELECT SYSDATE+100 FROM dual;

SELECT SYSDATE+1 ���� FROM dual;
SELECT SYSDATE-1 ���� FROM dual;

--�����е��� �׵��� ��ƿ��� ����
SELECT ROUND(SYSDATE-TO_DATE('1996/02/23')) "��ƿ»���" FROM dual;

SELECT EXTRACT (day from sysdate) ����, EXTRACT (month from sysdate) ��, EXTRACT (year from sysdate) �⵵
FROM dual;

SELECT ename, hiredate, EXTRACT(YEAR FROM hiredate) "year", EXTRACT (DAY FROM hiredate) "day"
FROM emp
WHERE deptno=20;

--EMP ���̺��� 10�� �μ����� ��������� �ٹ� ������ ����Ͽ� ��ȸ�Ѵ�.
SELECT ename, hiredate, sysdate, months_between(sysdate, hiredate) m_between, trunc(months_between(sysdate, hiredate), 0) t_between
FROM emp
WHERE deptno=10
ORDER BY months_between(sysdate, hiredate) desc;

--EMP ���̺��� 10�� �μ����� �Ի� ���ڷκ��� ���ƿ��� �ݿ���, ������� ����Ͽ� ��ȸ
SELECT ename, hiredate, next_day(hiredate,'�ݿ���') n_6, next_day(hiredate, '�����') n_7
FROM emp
WHERE deptno = 10
ORDER BY hiredate desc;

--��¥�� ��¥ ������ ������::Month_between(day1, day2)
--emp���̺��� �Ի��� ���κ��� 2023/07/25 ������
--������ ������ ����
-- 1. �ڸ��� �ٲ۴� 2. ABS�� ����.
SELECT ename, TRUNC(MONTHS_BETWEEN( '2023/07/25', hiredate)) ������

FROM emp;

--TO_NUMBER
SELECT '0001230' ���1, TO_NUMBER('0001230') ���2
FROM dual;

SELECT ename, hiredate, TO_CHAR(hiredate,'YYYY"��" MM"��" DD"��"') t_kor
FROM emp
WHERE deptno=20
ORDER bY hiredate desc;


--�Ϲ��Լ�::DECODE
--EMP���̺��� ������ PRESIDENT / ����,
--                   MANAGER / ������,
--                   ANALYST / �м���,
--                   ��Ÿ / ����,

SELECT ename, 
DECODE(job, 
'PRESIDET', '����',
'MANAGER', '������',
'ANALYST', '�м���',
'����') �����з�
FROM emp;

--5000�� OWNER �޿�, 3000 ��� �޿�, ���ϴ� �Ϲݱ޿�, �޿� ����
SELECT ename, 
DECODE(sal, 
    5000, 'OWNER �޿�',
    3000, '��� �޿�',
    '�Ϲ� �޿�') �޿�����
FROM emp;

--CASE
--ELSE�� ���� ������ NULL�� ä����
SELECT ename, 
CASE WHEN job = 'PRESIDENT' THEN '����' 
WHEN job = 'MANAGER' THEN '������' 
WHEN job = 'ANALYST' THEN '�м���' 
ELSE '����' 
END �����з�
FROM emp;

SELECT ename, 
CASE WHEN sal = 5000 THEN 'OWNER �޿�' 
    WHEN sal = 3000 THEN '��� �޿�' 
    ELSE '�Ϲ� �޿�' 
END �޿�����
FROM emp;

select ename, sal, job, decode(sal, 5000,'OWNER�޿�', between 1500 and 3000, '��ױ޿�', '�Ϲݱ޿�') from emp order by sal desc;