--sequence �����ϱ�

CREATE SEQUENCE ora_seq
START WITH 1
INCREMENT BY 1; -- 1�� �����Ұ���

SELECT ora_seq.nextVal FROM dual;

SELECT ora_seq.currVal FROM dual;

SELECT ora_seq.nextVal FROM dual;

--Table�� �����ϱ�
CREATE SEQUENCE seq_mymember
START WITH 1
INCREMENT BY 1;

CREATE TABLE mymember(
no number primary key,
name varchar2(30));

--�̶� no�� sequence�� ����
INSERT INTO mymember (no, name) VALUES(seq_mymember.nextval, 'ȫ�浿');

INSERT INTO mymember (no, name) VALUES(seq_mymember.nextval, '������');

SELECT * FROM mymember;
