--IN 연산자
--여러 개의 값 중에서 어느 하나의 값과 일치하는지를 비교

--사원번호가 7369번이거나 7521번이거나 7762번인 사원을 검색
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

--문자함수 :: SUBSTRING
--SUBSTR(문자열, 시작위치, 개수)
SELECT SUBSTR('HelloWorld', 6) FROM dual;

--Wor을 추출
SELECT SUBSTR('HelloWorld', 6, 3) FROM dual;

SELECT SUBSTR('HelloWorld', -4, 2) FROM dual;

--emp테이블에서 사원의 이름이 N으로 끝나는 사원을 검색
SELECT * 
FROM emp
WHERE ename LIKE '%N';

SELECT *
FROM emp
WHERE SUBSTR(ename, -1) = 'N';

--emp테이블에서 사원들의 입사년도만 검색
SELECT ename, SUBSTR(hiredate,0, 2) AS "YEAR"
FROM emp;

--TRIM : 공백을 제거하는 함수
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

--숫자함수
--ROUND
/*
2번째 인자값 2의 의미는 소수점 이하 자리까지 숫자를 나타내라는 뜻
이렇게 되기 위해서는 소수점 이하 2자리에서 실질적으로 반올림이 진행된다.
*/
SELECT ROUND(45.923, 2) FROM dual;

SELECT ROUND(45.923, 0) FROM dual;
SELECT ROUND(45.923) FROM dual;

/*
두번째 인자값이 음수일때는
45.923
.을 중심으로 일, 십, 백 단위로 거슬러 올라감

양수 일때와 달리 해당자리에서 바로 반올림이 일어난다.
*/

SELECT ROUND(45.923, -1) FROM dual; --50

--FLOOR()::내림(소수점 아래를 버림)
SELECT FLOOR(45.923) FROM dual;

--TRUNC :: 자릿수를 지정, 지정된 자릿수 이하를 버림
SELECT TRUNC(45.923, 2) FROM dual; 

SELECT TRUNC(45.923, 1) FROM dual; 

--CEIL() :: 올림 -> FLOOR의 반대, 얘도 자릿수 지정 안됨
--정수를 반환하겠다는 의도
SELECT CEIL(45.923) FROM dual;

SELECT GREATEST(1,2,3) FROM dual;
SELECT LEAST(1,2,3) FROM dual;


--날짜 함수
SELECT SYSDATE FROM dual;

SELECT SYSTIMESTAMP FROM dual;

--그이를 만난지 100일째 되는 날 계산법ㅋㅋ
SELECT SYSDATE+100 FROM dual;

SELECT SYSDATE+1 내일 FROM dual;
SELECT SYSDATE-1 어제 FROM dual;

--여러분들이 그동안 살아오신 생애
SELECT ROUND(SYSDATE-TO_DATE('1996/02/23')) "살아온생애" FROM dual;

SELECT EXTRACT (day from sysdate) 일자, EXTRACT (month from sysdate) 월, EXTRACT (year from sysdate) 년도
FROM dual;

SELECT ename, hiredate, EXTRACT(YEAR FROM hiredate) "year", EXTRACT (DAY FROM hiredate) "day"
FROM emp
WHERE deptno=20;

--EMP 테이블에서 10번 부서원이 현재까지의 근무 월수를 계산하여 조회한다.
SELECT ename, hiredate, sysdate, months_between(sysdate, hiredate) m_between, trunc(months_between(sysdate, hiredate), 0) t_between
FROM emp
WHERE deptno=10
ORDER BY months_between(sysdate, hiredate) desc;

--EMP 테이블에서 10번 부서원의 입사 일자로부터 돌아오는 금요일, 토요일을 계산하여 조회
SELECT ename, hiredate, next_day(hiredate,'금요일') n_6, next_day(hiredate, '토요일') n_7
FROM emp
WHERE deptno = 10
ORDER BY hiredate desc;

--날짜와 날짜 사이의 개월수::Month_between(day1, day2)
--emp테이블에서 입사한 날로부터 2023/07/25 개월수
--음수가 나오는 문제
-- 1. 자리를 바꾼다 2. ABS를 쓴다.
SELECT ename, TRUNC(MONTHS_BETWEEN( '2023/07/25', hiredate)) 개월수

FROM emp;

--TO_NUMBER
SELECT '0001230' 결과1, TO_NUMBER('0001230') 결과2
FROM dual;

SELECT ename, hiredate, TO_CHAR(hiredate,'YYYY"년" MM"월" DD"일"') t_kor
FROM emp
WHERE deptno=20
ORDER bY hiredate desc;


--일반함수::DECODE
--EMP테이블에서 업무가 PRESIDENT / 사장,
--                   MANAGER / 관리자,
--                   ANALYST / 분석가,
--                   기타 / 직원,

SELECT ename, 
DECODE(job, 
'PRESIDET', '사장',
'MANAGER', '관리자',
'ANALYST', '분석가',
'직원') 직원분류
FROM emp;

--5000은 OWNER 급여, 3000 고액 급여, 이하는 일반급여, 급여 구분
SELECT ename, 
DECODE(sal, 
    5000, 'OWNER 급여',
    3000, '고액 급여',
    '일반 급여') 급여구분
FROM emp;

--CASE
--ELSE로 하지 않으면 NULL로 채워짐
SELECT ename, 
CASE WHEN job = 'PRESIDENT' THEN '사장' 
WHEN job = 'MANAGER' THEN '관리자' 
WHEN job = 'ANALYST' THEN '분석가' 
ELSE '직원' 
END 직원분류
FROM emp;

SELECT ename, 
CASE WHEN sal = 5000 THEN 'OWNER 급여' 
    WHEN sal = 3000 THEN '고액 급여' 
    ELSE '일반 급여' 
END 급여구분
FROM emp;

select ename, sal, job, decode(sal, 5000,'OWNER급여', between 1500 and 3000, '고액급여', '일반급여') from emp order by sal desc;