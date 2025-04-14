select * from employee;
select * from department;
select * from job;
select * from location;
select * from nation;
select * from sal_grade;

select a.DEPT_ID, a.DEPT_TITLE, b.LOCAL_NAME, c.NATIONAL_NAME
from department a
join location b on a.LOCATION_ID = b.LOCAL_CODE
join nation c on b.NATIONAL_CODE = c.NATIONAL_CODE;

select EMP_ID, EMP_NAME, SALARY, tmp.DEPT_TITLE, tmp.NATIONAL_NAME
from employee e
join (select a.DEPT_ID, a.DEPT_TITLE, b.LOCAL_NAME, c.NATIONAL_NAME
from department a
join location b on a.LOCATION_ID = b.LOCAL_CODE
join nation c on b.NATIONAL_CODE = c.NATIONAL_CODE) as tmp
on e.DEPT_CODE = tmp.DEPT_ID
order by tmp.NATIONAL_NAME DESC;

select EMP_ID, EMP_NAME, SALARY, tmp.DEPT_TITLE, tmp.NATIONAL_NAME, SALARY+s.MIN_SAL as '위로금'
from employee e
join (select a.DEPT_ID, a.DEPT_TITLE, b.LOCAL_NAME, c.NATIONAL_NAME
	from department a
	join location b on a.LOCATION_ID = b.LOCAL_CODE
	join nation c on b.NATIONAL_CODE = c.NATIONAL_CODE) as tmp
on DEPT_CODE = tmp.DEPT_ID
join sal_grade s on s.SAL_LEVEL = e.SAL_LEVEL
where tmp.NATIONAL_NAME = '러시아'
order by SALARY+s.MIN_SAL DESC;


CREATE TABLE IF NOT EXISTS TEAM_INFO (
	TEAM_CODE INT PRIMARY KEY AUTO_INCREMENT,
    TEAM_NAME VARCHAR(100) NOT NULL,
    TEAM_DETAIL VARCHAR(500),
    USE_YN CHAR(2) CHECK (USE_YN IN ('Y', 'N')) NOT NULL
)ENGINE=INNODB;

use employee;
describe tbl_category;



CREATE TABLE IF NOT EXISTS MEMBER_INFO (
	MEMBER_CODE INT PRIMARY KEY AUTO_INCREMENT,
    MEMBER_NAME VARCHAR(70) NOT NULL,
    BIRTH_DATE DATE,
    DIVISION_CODE CHAR(2),
    DETAIL_INFO VARCHAR(500),
    CONTACT VARCHAR(50) NOT NULL,
    TEAM_CODE INT NOT NULL,
    ACTIVE_STATUS CHAR(2) DEFAULT 'Y' CHECK (ACTIVE_STATUS IN ('Y', 'N', 'H')),
    CONSTRAINT TEAM_CODE
    FOREIGN KEY (TEAM_CODE) REFERENCES TEAM_INFO (TEAM_CODE)
)ENGINE=INNODB;

DROP TABLE MEMBER_INFO;
    
INSERT INTO TEAM_INFO 
VALUES 
(null, '음악감상부', '클래식 및 재즈 음악을 감상하는 사람들의 모임', 'Y'),
(null, '맛집탐방부', '맛집을 찾아다니는 사람들의 모임', 'N'),
(null, '행복찾기부', null, 'Y');
    
SELECT * FROM TEAM_INFO;

INSERT INTO MEMBER_INFO
VALUES
(null, '송가인', '1990-01-30', 1, '안녕하세요 송가인입니다~', '010-9494-9494', 1, 'H'),
(null, '임영웅', '1992-05-03', null, '국민아들 임영웅입니다~', 'hero@trot.com', 1, 'Y'),
(null, '태진아', null, null, null, '(1급 기밀)', 3, 'Y');

SELECT * FROM MEMBER_INFO;

select count(*)
from (select * 
    from employee e 
    join department d on e.DEPT_CODE = d.DEPT_ID
	join job j on e.JOB_CODE = j.JOB_CODE) as tmp
where tmp.DEPT_TITLE = '기술지원부' and tmp.JOB_NAME = '대리'
union all
select count(*)
from (select * 
    from employee e 
    join department d on e.DEPT_CODE = d.DEPT_ID
	join job j on e.JOB_CODE = j.JOB_CODE) as tmp
where tmp.DEPT_TITLE = '인사관리부' and tmp.JOB_NAME = '사원'
union all
select count(*)
from (select * 
    from employee e 
    join department d on e.DEPT_CODE = d.DEPT_ID
	join job j on e.JOB_CODE = j.JOB_CODE) as tmp
where tmp.DEPT_TITLE like '%영업%' and tmp.JOB_NAME = '부장';


with tmp as (select * 
    from employee e 
    join department d on e.DEPT_CODE = d.DEPT_ID
	join job j on e.JOB_CODE = j.JOB_CODE)
select count(*)
from tmp
where tmp.DEPT_TITLE = '기술지원부' and JOB_NAME = '대리'
union all
select count(*)
from tmp
where tmp.DEPT_TITLE = '인사관리부' and JOB_NAME = '사원'
union all
select count(*)
from tmp
where tmp.DEPT_TITLE like '%영업%' and JOB_NAME = '부장';
