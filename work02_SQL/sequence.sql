--sequence 생성하기

CREATE SEQUENCE ora_seq
START WITH 1
INCREMENT BY 1; -- 1씩 증가할거임

SELECT ora_seq.nextVal FROM dual;

SELECT ora_seq.currVal FROM dual;

SELECT ora_seq.nextVal FROM dual;

--Table에 적용하기
CREATE SEQUENCE seq_mymember
START WITH 1
INCREMENT BY 1;

CREATE TABLE mymember(
no number primary key,
name varchar2(30));

--이때 no에 sequence를 연결
INSERT INTO mymember (no, name) VALUES(seq_mymember.nextval, '홍길동');

INSERT INTO mymember (no, name) VALUES(seq_mymember.nextval, '강감찬');

SELECT * FROM mymember;
