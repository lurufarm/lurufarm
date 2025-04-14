-- 5. LIMIT
-- SELECT문의 결과 집합에서 반환할 행의 수를 제한하는데 사용

-- 전체 행 조회
select menu_code, menu_name, menu_price from tbl_menu order by menu_price desc;
-- select menu_code, menu_name, menu_price from tbl_menu order by menu_price desc limit [offset], [row_count];
select menu_code, menu_name, menu_price from tbl_menu order by menu_price desc limit 1, 4; -- 즉 이 구문은 2번행부터 5번행까지 조회하겠다는 의미
-- offset: 시작할 행의 번호(인덱스 체계)
-- row_count: 이후 행부터 반환받을 행의 개수

select menu_code, menu_name, menu_price from tbl_menu order by menu_price desc limit 5; -- 상위 다섯 행만 조회