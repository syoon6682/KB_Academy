--JOIN
--���� ���̺�κ��� �����͸� ������ �� ���Ǵ� ���

--������ ���� ������ ������
SELECT * FROM emp;

--����, �μ��� ���� ������ ������
SELECT * FROM emp, dept;

/*
��ó�� ���� ����� Cartessian Product
emp�� dept ���̺��� �������� ���� ���
14*4=56��

Cartessian Product�� ����Ǵ� ���
1) ���� ������ ���ٶ�
2) ���� ������ �߸��ٶ�
���: ���� ���� ����~~
*/

--STEP1.
--1. ���� ������ ���� ���̺� �������� �÷��� ���� ������ �Ǵ� �÷��̴�.
--2. ���� ������ where���� ���� =�� ����ؼ� ���

-- * ǥ���� �����ؾ� �Ѵ�. Projection �䱸��
SELECT * FROM emp, dept
WHERE emp deptno = dept deptno;

--STEP2.
--deptno ��� ���̺� ���� �����;� �ϴ��� ���� ����
--��� ���̺��� �� ������ ������
SELECT empno, ename, sal, emp.deptno, dname
FROM emp, dept
WHERE emp.deptno = dept.deptno;

--STEP3.
SELECT emp.empno, emp.ename, emp.sal, emp.deptno, dept.dname
FROM emp, dept
WHERE emp.deptno = dept.deptno;

--STEP4
SELECT e.empno, e.ename, e.sal, e.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno;

--����̸�, �޿�, �μ���ȣ, �μ��̸�, �μ���ġ�� �˻�
--��, �޿��� 2000 �̻��̰� 30�� �μ��� ���ؼ��� �˻�
--where ������ ���� ���ǰ� �Բ� ������������ ���� ���´�.
SELECT e.ename, e.sal, e.deptno, d.dname, d.loc
FROM emp e, dept d
WHERE (e.deptno = d.deptno) and (e.sal>2000) and (e.deptno = 30);

--���忡�� �ٹ��ϴ� ����� �̸��� �޿��� �˻�
SELECT e.ename, e.sal, d.loc
FROM emp e, dept d
WHERE (e.deptno = d.deptno) and (d.loc = 'NEW YORK');




