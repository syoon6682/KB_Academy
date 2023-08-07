-- ##################  �׷� �Լ� �ǽ� ######################

-- 1)  30�� �μ� ������ ���(�Ҽ�2�ڸ� �Ʒ� �ø�), �ְ�, ����, �ο����� ���Ͽ� ����϶�.
SELECT ROUND(AVG(sal), 2) AVG, MAX(sal) MAX, MIN(sal) MIN, COUNT(-1) CNT
FROM emp
WHERE deptno = 30;

-- 2) �� �μ��� �޿��� ���(�Ҽ����� �ݿø�), �ְ�, ����, �ο����� ���Ͽ� ����϶�.
SELECT deptno, ROUND(AVG(sal), 2) AVG, MAX(sal) MAX, MIN(sal) MIN, COUNT(-1) CNT
FROM emp
GROUP BY deptno
ORDER BY deptno;

-- 3) �� �μ��� ���� ������ �ϴ� ����� �ο����� ���Ͽ� �μ���ȣ,������, �ο����� ����϶�.
SELECT deptno, job, COUNT(-1) CNT
FROM emp
GROUP BY deptno, job
ORDER BY deptno;


-- 4) ���� ������ �ϴ� ����� ���� 2�� �̻��� ������ �ο�����  ����϶�.
SELECT job, COUNT(job) CNT
FROM emp
GROUP BY job
HAVING COUNT(-1) >= 2;



-- 5) �� �μ��� ��� ����(�Ҽ����� ����), ��ü ����, �ְ� ����, ���� ������ ���Ͽ� ��� ������ ���� ������ ����϶�. 
SELECT deptno, TRUNC(AVG(sal)) AVG, SUM(sal) SUM, MAX(sal) MAX, MIN(sal) MIN
FROM emp
GROUP BY deptno
ORDER BY 2 DESC;


-- 6) �� �μ��� ���� ������ �ϴ� ����� �޿��� �հ踦 ���Ͽ� �μ���ȣ,������ �޿��� �Ұ�� ������ ����϶�.
-- �μ��� �����Ѵ�.
SELECT deptno, job, COUNT(-1) CNT
FROM emp
GROUP BY ROLLUP(deptno, job);





-- 7) �� �μ��� �ο����� ��ȸ�ϵ� �ο����� 5�� �̻��� �μ��� ��µǵ��� �Ͻÿ�.
SELECT deptno, COUNT(deptno) COUNT
FROM emp
GROUP BY deptno
HAVING COUNT(deptno) >= 5;

-- 8)  �� �μ��� �ִ�޿��� �ּұ޿��� ��ȸ�Ͻÿ�.
--   ��, �ִ�޿��� �ּұ޿��� ���� �μ��� ������ �Ѹ��� ���ɼ��� ���⶧����    ��ȸ������� ���ܽ�Ų��.
SELECT deptno, MAX(sal) MAX, MIN(sal) MIN
FROM emp
GROUP BY deptno
HAVING MAX(sal) != MIN(sal)
ORDER BY 2 DESC;


/* 9) �μ��� 10, 20, 30 ���� ������ �߿��� �޿��� 2500 �̻� 5000 ���ϸ� �޴�
   �������� ������� �μ��� ��� �޿��� ��ȸ�Ͻÿ�.
   ��, ��ձ޿��� 2000 �̻��� �μ��� ��µǾ�� �ϸ�, ��°���� ��ձ޿��� ����
   �μ����� ��µǵ��� �ؾ� �Ѵ�. */
SELECT deptno, TRUNC(AVG(sal)) AVG
FROM emp
WHERE (deptno IN (10, 20, 30)) AND (sal BETWEEN 2500 and 5000)
GROUP BY deptno
HAVING AVG(sal) >= 2000
ORDER BY TRUNC(AVG(sal)) DESC;




 -- 10)