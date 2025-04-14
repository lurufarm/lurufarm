-- 7. GROUPING
-- GROUP BY: 결과 집합을 특정 열의 값에 따라 그룹화 하는데 사용 => 그룹 함수 사용
-- HAVING: GROUP BY 절과 함께 사용해야하며 그룹에 대한 조건을 적용하는데 사용

select category_code, COUNT(*) from tbl_menu group by category_code;

-- SUM(컬럼): 컬럼 값의 합계를 알 수 있는 그룹 함수
select category_code, SUM(menu_price) from tbl_menu group by category_code;

-- AVG(컬럼): 컬럼 값들의 평균을 알 수 있는 그룹 함수
select category_code, AVG(menu_price) from tbl_menu group by category_code;

-- 2개 이상의 그룹 생성
select menu_price, category_code, count(*) from tbl_menu group by menu_price, category_code;

-- HAVING: Group by 결과에 조건을 작성함
select category_code, AVG(menu_price) from tbl_menu group by category_code having AVG(menu_price) >= 10000;

-- ROLLUP (집계함수)
-- 컬럼 1개를 활용한 rollup은 카테고리별 총 합계를 계산한다.
select category_code, SUM(menu_price) from tbl_menu group by category_code with rollup;
-- 컬럼 2개를 활용한 rollup
-- 첫 번째 group by에 서술된 컬럼에 대한 중간 집계와 마지막 총 집계가 구해짐.
select menu_price, category_code, SUM(menu_price) from tbl_menu group by menu_price, category_code with rollup;

