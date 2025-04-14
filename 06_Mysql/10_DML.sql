-- 10. DML
-- 데이터 조작 언어
-- 테이블에 값을 삽입(INSERT)하거나 수정(UPDATE)하거나 삭제(DELETE)하는 SQL언어
-- INSERT INTO 테이블명 VALUES (수정할 데이터...);
SELECT * FROM menudb.tbl_menu;
insert into tbl_menu values (null, '꿔바로우', 18000, 5, 'Y');

-- INSERT INTO 테이블명 (컬럼명1, 컬럼명2, 컬럼명3, ...)
-- VALUES (컬럼명1에 대한 데이터, 컬럼명 2에 대한 데이터, 컬럼명 3에 대한 데이터, ...);
insert into tbl_menu(menu_code, menu_name, menu_price, category_code, orderable_status)
values (null, '돈가스김밥', 8000, 4, 'Y');

-- NULL허용 가능한 (NULLABLE) 컬럼이나 AUTO_INCREMENT가 있는 컬럼을 제외하고 INSERT 가능
-- 삽입할 컬럼명을 명시하면 INSERT 시 데이터의 순서를 바꾸는 것도 가능
insert into tbl_menu(menu_name, category_code, menu_price, orderable_status)
values ('쉬림프로제파스타', 12, 21000, 'Y');

-- MULTI INSERT (여러 행을 한번에 삽입)
insert into tbl_menu
values 
	(null, '감자튀김', 3000, 12, 'Y'),
    (null, '햄버거', 10000, 12, 'Y'),
    (null, '초콜릿케이크', 9000, 12, 'Y');
    
# UPDATE
-- UPDATE 테이블명
-- SET 컬럼명1 = 수정할 데이터
--   , 컬럼명2 = 수정할 데이터
--   , ...
-- WHERE 수정 대상 데이터 조건;    
UPDATE tbl_menu
SET menu_name = '오늘점심맛있다'
	, menu_price = 1000
WHERE menu_code = 22;

-- MySQL은 UPDATE나 DELETE 시 자기 자신 테이블의 데이터를 사용하면 1093 에러 발생
UPDATE tbl_menu
SET menu_name = '오늘저녁밥'
WHERE menu_code = (SELECT menu_code
					FROM tbl_menu
                    WHERE menu_name = '오늘점심맛있다');
                    
-- 이 때, 서브쿼리를 하나 더 사용하여 임시테이블처럼 사용하면 해결 가능
UPDATE tbl_menu
SET menu_name = '오늘저녁밥'
WHERE menu_code = (SELECT tmp.menu_code
					FROM (SELECT menu_code
							FROM tbl_menu
							WHERE menu_name = '오늘점심맛있다') as tmp
				  );
                  
# DELETE
-- DELETE FROM 테이블명
-- WHERE 삭제 조건;
DELETE FROM tbl_menu
WHERE menu_code = 22;

-- LIMIT를 활용한 행 삭제 (offset 지정은 안됨)
DELETE FROM tbl_menu
ORDER BY menu_price
LIMIT 3;

# REPLACE: 중복된 데이터를 덮어쓸 수 있는 기능
-- PRIMARY KEY 또는 UNIQUE KEY에 대해 중복값을 INSERT하면 충돌(에러) 발생
-- INSERT INTO tbl_menu VALUES(2, '떡볶이', 2000, 4, 'Y');
REPLACE INTO tbl_menu VALUES (2, '로제떡볶이', 12000, 4, 'Y');

-- REPLACE는 중복값에 대해서는 데이터를 덮어쓰고, 중복값이 없다면 INSERT함
-- INTO 키워드 생략 가능
REPLACE tbl_menu VALUES (200, '삼계탕', 15000, 4, 'Y');

-- UPDATE시 WHERE구문 없이 UPDATE 가능
REPLACE tbl_menu
SET menu_code = 2,
	menu_name = '우럭매운탕',
    menu_price = 12000,
    category_code = 9,
    orderable_status = 'N';


