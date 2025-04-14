-- 11. TRANSACTION: 데이터베이스에서 한 번에 수행되는 작업의 단위
-- 작업 중 문제가 있을 경우 ROLLBACK, 잘 수행되었을 경우 COMMIT 처리
-- MySQL의 기본 설정은 autocommit이므로 해당 설정을 변경 후 테스트

-- autocommit 활성화
SET autocommit = 1;
SET autocommit = ON;

-- autocommit 비활성화
SET autocommit = 0;
SET autocommit = OFF;

-- 트랜잭션 시작
START TRANSACTION;

-- 트랜잭션 진행
SELECT * FROM tbl_menu;
INSERT INTO tbl_menu VALUES(null, '오삼불고기', 10000, 4, 'Y');
UPDATE tbl_menu SET menu_name = '삼오불고기' WHERE menu_code = 20;
DELETE FROM tbl_menu WHERE menu_code = 200;

-- 트랜잭션 종료
-- DML 수행 후 COMMIT 또는 ROLLBACK을 수행하며
-- COMMIT 이후에는 ROLLBACK을 해도 적용되지 않는다.
COMMIT; -- 트랜잭션을 최종 반영해서 저장한다.
ROLLBACK; -- 트랜잭션을 되돌린다.

