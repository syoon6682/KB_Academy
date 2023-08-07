SELECT e.ename, e.sal
FROM emp e, dept d;


-- SELF ���� : �ϳ��� ���̺��� ��ü������ ������
-- Ư�� ����� ����� �̸��� �˻�

SELECT empno, ename, mgr 
FROM emp;

/*
EMP E
1. Ư�� ����� ename�� ��ȸ�ؼ� emp ���̺��� ã�´�. SMITH
2. SMITH�� ����ȣ mgr�� ��ȸ, ������ ��ȣ�� ã�� (7902)
---------------------------------------------------------
EMP M
3. �ٽ� 7902��ȣ�� empno�� ã�´�.
4. empno�� 7902���� ����� �̸� ename�� ã�´�. (ford)
*/

-- STEP 1
SELECT empno, ename, mgr FROM emp; --e ����� ����ȣ�� ã��
SELECT empno, ename FROM emp; --m ����� �̸��� ã��

SELECT e.empno, e.ename, e.mgr 
FROM emp e, emp m;

SELECT * 
FROM (SELECT empno, ename, mgr FROM emp) e, (SELECT empno, ename FROM emp) d
WHERE e.mgr = d.empno;

SELECT * 
FROM (SELECT empno, ename, mgr FROM emp) e, (SELECT empno, ename FROM emp) d;

-- STEP 2 ���� ������ �߰�
SELECT * 
FROM (SELECT empno, ename, mgr FROM emp) e, (SELECT empno, ename FROM emp) d
WHERE e.mgr = d.empno;

-- STEP 3. ALIAS ���� -> �����ȣ, ����̸�, ����̸�
SELECT e.empno "�����ȣ", e.ename "����̸�", d.ename "����̸�"
FROM (SELECT empno, ename, mgr FROM emp) e, (SELECT empno, ename FROM emp) d
WHERE e.mgr = d.empno;

SELECT e.empno "�����ȣ", e.ename "����̸�", d.ename "����̸�"
FROM emp e, emp d
WHERE e.mgr = d.empno
ORDER BY 1;

-- STEP 4. Ư�� ���(BLAKE)�� ��� �̸��� �˻�

SELECT e.empno "�����ȣ", e.ename "����̸�", d.ename "����̸�"
FROM emp e, emp d
WHERE e.mgr = d.empno AND e.ename = 'BLAKE'
ORDER BY 1;