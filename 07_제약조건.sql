--��������
--employee | department 2���� ����
--CTAS
DROP TABLE employee;
DROP TABLE department;

CREATE TABLE employee 
AS 
(SELECT * fROM emp);

CREATE TABLE department 
AS 
(SELECT * fROM dept);

--���̺� ���� Ȯ��
DESC employee;
DESC department;

--PK(�⺻Ű) ���������� ���̺� �߰�
--CTAS�δ� ���������� ������ �ȵ�
--employee, department ���̺� �⺻Ű ���������� �߰���
ALTER TABLE employee ADD CONSTRAINT employee_empno_pk PRIMARY KEY(empno);
ALTER TABLE department ADD CONSTRAINT department_deptno_pk PRIMARY KEY(deptno);

--FK(�ܷ�Ű) ���� ������ ���̺� �߰�
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno) REFERENCES department(deptno);


--FK(�ܷ�Ű) ���� ������ ���̺� �߰� + ON DELETE CASCADE
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno)
REFERENCES department(deptno) ON DELETE CASCADE;

SELECT * FROM employee;
SELECT * FROM department;

--20�� �μ��� �����ϴ��� 20�� �μ����� �ٹ��ϴ� ������ �״���̴�.
--�̰��� employee ���̺�� department ���̺��� ����(relational)�Ǿ��� ���� �ʱ� �����̴�.
--FK ���� ������ �߰��ؾ� �ϴ� �����̴�.
DELETE employee WHERE empno= 7369;
DELETE department WHERE deptno = 20;


--FK���������� �߰��ϸ� �ڽ��� ������ �ִ� �θ� ���̺� ������ �ȵȴ�.
--�ذ� ����� �ڽ� ���ڵ带 ���� ������ ��, �θ� ���ڵ� ������ ����
--���� ���� �۾��� �״�� ���ִ� �ɼ��� �ٷ� ON DELETE CASCADE
--FK ���� ������ ������ �� ON DELETE CASCADE �ɼ��� �Բ� �����ؾ� �Ѵ�

.