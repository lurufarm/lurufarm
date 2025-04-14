-- 12. DDL(데이터 정의 언어)

# CREATE
-- IF NOT EXISTS 적용 시, '존재하지 않는다면 테이블을 만들어라' 라는 옵션으로 기존에 존재하는 테이블을 생성해도 에러 발생하지 않음
CREATE TABLE IF NOT EXISTS tbl_1 (
	pk INT PRIMARY KEY,
    fk INT,
    col1 VARCHAR(255),
    CHECK(col1 IN ('Y', 'N'))
)ENGINE=INNODB;

DESCRIBE tbl_1;
SELECT * FROM tbl_1;
INSERT INTO tbl_1 VALUES (1, 10, 'Y');

-- AUTO INCREMENT: INSERT 시 PRIMARY KEY에 해당하는 컬럼에 자동으로 번호를 발생, 중복되지 않는 값을 만들어준다.
CREATE TABLE IF NOT EXISTS tbl_2 (
	pk INT AUTO_INCREMENT PRIMARY KEY,
    fk INT,
    col1 VARCHAR(255),
    CHECK(col1 IN ('Y', 'N'))
)ENGINE=INNODB;

DESCRIBE tbl_2;

INSERT INTO tbl_2 VALUES (null, 10, 'Y');
INSERT INTO tbl_2 VALUES (null, 20, 'N');
SELECT * FROM tbl_2;

#ALTER: 테이블에 추가, 변경, 수정, 삭제하는 모든 명령어는 ALTER를 사용해 적용

-- 열(컬럼) 추가
ALTER TABLE tbl_2
ADD col2 INT NOT NULL;

-- 컬럼 여러 개 추가
ALTER TABLE tbl_2
ADD col3 DATE NOT NULL,
ADD col4 TINYINT NOT NULL;

-- DATE 타입이 0으로 추가되지 않는 설정을 수정한다.
SELECT @@GLOBAL.sql_mode;
SET GLOBAL sql_mode = ''; -- root 계정으로 접속해서 실행

SELECT * FROM tbl_2;

-- 열(컬럼) 삭제
ALTER TABLE tbl_2
DROP COLUMN col2;

-- 열 이름 및 데이터 형식 변경
ALTER TABLE tbl_2
CHANGE COLUMN fk change_fk DECIMAL NOT NULL;
DESCRIBE tbltbl_4_2;

-- 열 제약 조건 추가 및 삭제
-- 에러 발생: auto_increment 걸려있는 컬럼에서 pk 제약조건 제거 불가
-- auto_increment 조건을 MODIFY 명령어(컬럼의 정의 변경)로 먼저 제거한다.
ALTER TABLE tbl_2
DROP PRIMARY KEY;

-- MODIFY
ALTER TABLE tbl_2
MODIFY pk INT;

-- 다시 제약조건 추가
ALTER TABLE tbl_2
ADD PRIMARY KEY(pk);

# DROP: 테이블을 삭제하는 구문
CREATE TABLE IF NOT EXISTS tbl_3 (
	pk INT AUTO_INCREMENT PRIMARY KEY,
    fk INT,
    col1 VARCHAR(255),
    CHECK(col1 IN ('Y', 'N'))
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS tbl_4 (
	pk INT AUTO_INCREMENT PRIMARY KEY,
    fk INT,
    col1 VARCHAR(255),
    CHECK(col1 IN ('Y', 'N'))
)ENGINE=INNODB;

-- DROP TABLE [IF EXISTS] 테이블명1, 테이블명2, ...;
DROP TABLE IF EXISTS tbl_3;
DROP TABLE IF EXISTS tbl_2, tbl_4;

# TRUNCATE
-- 테이블에 존재하는 모든 데이터 제거
-- DELETE는 행을 하나씩 지우지만 TRUNCATE는 DROP 이후 테이블을 재생성 해주므로 효율적이다.
CREATE TABLE IF NOT EXISTS tbl_5 (
	pk INT AUTO_INCREMENT PRIMARY KEY,
    fk INT,
    col1 VARCHAR(255),
    CHECK(col1 IN ('Y', 'N'))
)ENGINE=INNODB;

INSERT INTO tbl_5 VALUES (null, 10, 'Y');
INSERT INTO tbl_5 VALUES (null, 20, 'Y');
INSERT INTO tbl_5 VALUES (null, 30, 'Y');
INSERT INTO tbl_5 VALUES (null, 40, 'Y');
INSERT INTO tbl_5 VALUES (null, 50, 'Y');

select * from tbl_5;

-- TRUNCATE는 테이블을 초기화 시킴
-- TABLE 키워드는 생략 가능
TRUNCATE tbl_5;
TRUNCATE TABLE tbl_5;





