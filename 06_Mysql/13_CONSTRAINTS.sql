-- 13. CONSTRAINTS (제약 조건)
-- 테이블에 데이터가 입력되거나 수정될 때의 규칙을 정의하며 데이터 무결성 보장에 도움이 된다.

# NOT NULL: 컬럼 값에 NULL을 허용하지 않는 제약 조건
CREATE TABLE user_notnull (
	user_no INT NOT NULL,
    user_id VARCHAR(255) NOT NULL,
    user_pwd VARCHAR(255) NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    gender CHAR(3),
    phone VARCHAR(255) NOT NULL,
    email VARCHAR(255)
)ENGINE=INNODB;

INSERT INTO user_notnull (user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES 
	(1, 'user01', 'pass01', '박서준', '남', '010-1234-5678', 'parksj@naver.com'),
    (2, 'user02', 'pass02', '한소희', '여', '010-8765-4321', 'hansh@gmail.com');
    
SELECT * FROM user_notnull;

-- NOT NULL 제약 조건 확인
INSERT INTO user_notnull (user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES 
	(3, 'user03', 'pass03', null, '남', '010-1234-5678', 'parksj@naver.com');
    
# UNIQUE: 중복 값 허용하지 않는 제약 조건
-- 컬럼 레벨, 테이블 레벨 작성
CREATE TABLE user_unique (
	user_no INT NOT NULL UNIQUE, -- 컬럼 레벨에 작성
    user_id VARCHAR(255) NOT NULL,
    user_pwd VARCHAR(255) NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    gender CHAR(3),
    phone VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    CONSTRAINT UNIQUE(phone)	-- 테이블 레벨에 작성
)ENGINE=INNODB;

INSERT INTO user_unique (user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES 
	(1, 'user01', 'pass01', '박서준', '남', '010-1234-5678', 'parksj@naver.com'),
    (2, 'user02', 'pass02', '한소희', '여', '010-8765-4321', 'hansh@gmail.com');

SELECT * FROM user_unique;

-- UNIQUE 제약 조건으로 인해 user_no 중복으로 에러 발생
INSERT INTO user_unique (user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES 
	(1, 'user01', 'pass01', '박서준', '남', '010-1234-5678', 'parksj@naver.com');

-- user_no 중복으로 에러 발생
INSERT INTO user_unique (user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES 
    (2, 'user02', 'pass02', '한소희', '여', '010-8765-4321', 'hansh@gmail.com');

-- not null 제약조건 안걸린 컬럼 정상 삽입 확인
INSERT INTO user_unique (user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES 
    (3, 'user03', 'pass03', '한서희', '여', '010-8765-4325', null);
    
# PRIMARY KEY(PK): 테이블에서 한 행의 정보를 찾기 위해 사용하는 컬럼
-- 테이블의 식별자 역할. NOT NULL + UNIQUE의 의미이다.
-- 한 테이블당 한 개만 설정할 수 있다.
-- 한 개 컬럼을 대상으로 설정할 수도 있고, 여러 개의 컬럼을 묶어서 설정할 수도 있음(복합키)

CREATE TABLE user_pk (
	user_no INT PRIMARY KEY, -- 컬럼 레벨에 작성
    user_id VARCHAR(255) NOT NULL,
    user_pwd VARCHAR(255) NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    gender CHAR(3),
    phone VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    CONSTRAINT UNIQUE(phone)
)ENGINE=INNODB;

INSERT INTO user_pk (user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES 
	(1, 'user01', 'pass01', '박서준', '남', '010-1234-5678', 'parksj@naver.com'),
    (2, 'user02', 'pass02', '한소희', '여', '010-8765-4321', 'hansh@gmail.com');

SELECT * FROM user_pk;

-- PRIMARY KEY 제약 조건으로 인해 에러 발생 (PK는 NOT NULL)
INSERT INTO user_pk (user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES 
	(null, 'user01', 'pass01', '박서준', '남', '010-1234-5678', 'parksj@naver.com');

-- PRIMARY KEY 제약조건으로 인해 에러 발생 (PK는 UNIQUE)
INSERT INTO user_pk (user_no, user_id, user_pwd, user_name, gender, phone, email)
VALUES 
	(1, 'user01', 'pass01', '박서준', '남', '010-1234-5678', 'parksj@naver.com');
    
# FOREIGN KEY (FK): 참조된 다른 테이블에서 제공하는 값만 사용할 수 있도록 하는 제약 조건
-- FK 제약 조건에 의해 테이블 간의 관계가 형성

CREATE TABLE IF NOT EXISTS user_level(
	level_code INT NOT NULL UNIQUE,
    level_title VARCHAR(255) NOT NULL
)ENGINE=INNODB;

INSERT INTO user_level
VALUES
	(10, '초보'),
    (20, '중수'),
    (30, '고수');
    
SELECT * FROM user_level;

CREATE TABLE user_fk_1 (
	user_no INT PRIMARY KEY, -- 컬럼 레벨에 작성
    user_id VARCHAR(255) NOT NULL,
    user_pwd VARCHAR(255) NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    level_code INT,
    CONSTRAINT level_code_fk
    -- user_fk_1 테이블의 level_code 컬럼이 외래 키로 설정됨
	-- user_level 테이블의 level_code 컬럼을 참조함
    FOREIGN KEY (level_code) REFERENCES user_level (level_code)
)ENGINE=INNODB;

-- 테이블 스키마의 제약 조건 조회
SELECT * FROM information_schema.table_constraints
WHERE constraint_schema = 'menudb' AND table_name = 'user_fk_1';

INSERT INTO user_fk_1 (user_no, user_id, user_pwd, user_name, phone, email, level_code)
VALUES
	(1, 'user01', 'pass01', '판다', '010-3333-3333', 'panda@gmail.com', 10),
	(2, 'user02', 'pass02', '다람쥐', '010-8888-8888', 'squirrel@gmail.com', 20);

SELECT * FROM user_fk_1;

-- FOREIGN KEY 제약 조건으로 인한 에러 발생(참조 테이블 컬럼에 없는 값 적용)
INSERT INTO user_fk_1 (user_no, user_id, user_pwd, user_name, phone, email, level_code)
VALUES
	(3, 'user03', 'pass03', '양', '010-5555-5555', 'sheep@gmail.com', 50);
    
-- 제공되는 값 외에 null은 사용할 수 있음
INSERT INTO user_fk_1 (user_no, user_id, user_pwd, user_name, phone, email, level_code)
VALUES
	(3, 'user03', 'pass03', '양', '010-5555-5555', 'sheep@gmail.com', null);

-- 참조하는 자식 테이블의 행이 있을 경우 부모 테이블에서 값을 삭제하거나 수정할 수 없다. (기본 삭제 룰)
DELETE FROM user_level WHERE level_code = 10;
DROP TABLE IF EXISTS user_fk_1;


-- ON UPDATE SET NULL, ON DELETE SET NULL
CREATE TABLE user_fk_2 (
	user_no INT PRIMARY KEY,
    user_id VARCHAR(255) NOT NULL,
    user_pwd VARCHAR(255) NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    level_code INT,
    CONSTRAINT level_code_fk_2
    FOREIGN KEY (level_code) REFERENCES user_level (level_code)
		ON UPDATE SET NULL -- 부모 테이블의 값을 수정/삭제하면 그것을 참조하는 자식의 FK 컬럼을 null로 설정
        ON DELETE SET NULL
)ENGINE=INNODB;

INSERT INTO user_fk_2 (user_no, user_id, user_pwd, user_name, phone, email, level_code)
VALUES
	(1, 'user01', 'pass01', '판다', '010-3333-3333', 'panda@gmail.com', 10),
	(2, 'user02', 'pass02', '다람쥐', '010-8888-8888', 'squirrel@gmail.com', 20);
    
SELECT * FROM user_fk_2;
SELECT * FROM user_level;

-- 부모 테이블 컬럼 수정
UPDATE user_level
SET level_code = null
WHERE level_code = 10;

-- 부모 테이블의 컬럼 삭제
DELETE FROM user_level
WHERE level_code = 20;

# CHECK
-- 컬럼 레벨, 테이블 레벨 작성 가능
CREATE TABLE IF NOT EXISTS user_check(
	user_no INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL,
    gender VARCHAR(255) CHECK (gender IN ('남', '여')),
    age INT,
    CHECK (age > 19)
)ENGINE=INNODB;

INSERT INTO user_check (user_no, user_name, gender, age)
VALUES
	(null, '김길동', '남', 20),
    (null, '홍길동', '여', 22);
    
SELECT * FROM user_check;

-- CHECK 제약 조건 에러 발생(gender에 '남' 또는 '여' 외의 값을 입력 시 에러 발생)
INSERT INTO user_check (user_no, user_name, gender, age)
VALUES
	(null, '유길동', '남성', 20);
-- CHECK 제약 조건(age는 19세 이하 입력 시 에러 발생)
INSERT INTO user_check (user_no, user_name, gender, age)
VALUES
	(null, '유길동', '여', 9);

# DEFAULT: 컬럼에 기본 값을 적용할 수 있다.
CREATE TABLE tbl_default(
	country_code INT AUTO_INCREMENT PRIMARY KEY,
    country_name VARCHAR(255) DEFAULT '한국',
    population VARCHAR(255) DEFAULT '0명',
    add_day DATE DEFAULT (current_date),
    add_time DATETIME DEFAULT(current_time)
)ENGINE=INNODB;

SELECT * FROM tbl_default;

-- default 값을 넣기 위해 default 사용
INSERT INTO tbl_default VALUES(null, default, default, default, default);

-- default 값이 설정된 컬럼을 INSERT 대상 컬럼에 명시하지 않으면 default값으로 삽입됨
INSERT INTO tbl_default(country_code) VALUES (null);

-- null 입력 시 null로 삽입됨 (NOT NULL 계약 조건이 있는 경우 에러 발생)
INSERT INTO tbl_default VALUES (null, null, null, null, null);