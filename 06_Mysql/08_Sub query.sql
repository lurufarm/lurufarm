-- 8. SUBQUERIES
-- 다른 쿼리 내에서 실행되는 쿼리
-- 서브 쿼리의 결과를 활용해서 복잡한 main query를 작성해 한 번에 여러 작업을 수행할 수 있음

-- 민트 미역국과 동일 카테고리인 메뉴 목록 조회
select menu_code, menu_price, category_code, orderable_status 
from tbl_menu 
where category_code = (select category_code from tbl_menu where menu_name = '민트미역국');

-- FROM절에 쓰인 서브쿼리(derived table, 파생 테이블)
-- 파생 테이블은 별칭을 가져야만 한다.
-- 서브 쿼리
select count(*) from tbl_menu group by category_code;

select max(count)
from 
	(select count(*) as 'count'
	from tbl_menu
	group by category_code) as countmenu;
    
-- 상관 서브쿼리
-- 메인 쿼리가 서브 쿼리의 결과에 영향을 주는 경우를 말한다.
-- 카테고리별 평균 가격보다 높은 가격의 메뉴를 조회
select menu_code, menu_name, menu_price, category_code, orderable_status
from tbl_menu a
where menu_price > (select avg(menu_price)
					from tbl_menu
                    where category_code = a.category_code);
                    
-- EXISTS: 조회 결과가 있으면 true, 없으면 false를 반환하는 연산자
-- 메뉴가 있는 카테고리 조회
select category_name
from tbl_category a
where EXISTS (
				select 1
				from tbl_menu b
                where b.category_code = a.category_code)
order by 1; -- 컬럼 순번으로 작성 가능 (SELECT 절에 나열된 컬럼의 순서)

-- CTE (Common Table Expressions)
-- 파생 테이블과 비슷한 개념으로 코드의 가독성 및 재사용성을 위해 파생 테이블 대신 사용한다.
-- FROM절 (JOIN 절)에서만 사용된다.

WITH menucate AS (
				select menu_name, category_name
                from tbl_menu a
                join tbl_category b on a.category_code = b.category_code)
select *
from menucate
order by menu_name;