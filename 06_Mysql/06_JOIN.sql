-- 6. JOIN
-- 두 개 이상의 테이블을 관련있는 컬럼을 통해 결합하는데 사용
-- 반드시 연관있는 컬럼이 존재해야하며 이를 통해 join된 테이블들의 컬럼을 모두 활용할 수 있다.

-- ALIAS
-- 컬럼 또는 테이블에 별칭을 부여할 수 있다.

-- 컬럼 별칭
-- as '별칭'의 형태로 작성하나 별칭에 특수문자가 없다면 생략 가능
select menu_code as 'code', menu_name as name, menu_price price from tbl_menu order by price;

-- 테이블 별칭
-- 어떤 테이블 소속인지 쉽게 알 수 있게 하며 as를 써도 되고 생략도 가능
select a.category_code, a.menu_name from tbl_menu as a order by a.category_code, a.menu_name;

-- JOIN의 종류
-- (1) Inner Join: 두 테이블의 교집합을 반환하는 SQL JOIN 유형
-- ON을 이용한 문법 (연결에 사용될 컬럼명이 동일하지 않거나, 동일하거나 모두 사용 가능)
select a.menu_name, b.category_name from tbl_menu a 
-- inner join tbl_category b on a.category_code = b.category_code;
join tbl_category b on a.category_code = b.category_code;

-- USING을 이용한 문법 (연결에 사용될 컬럼명이 동일한 경우에만 사용)
select a.menu_name, b.category_name from tbl_menu a join tbl_category b using (category_code);

-- (2) Left Join: 첫 번째(왼쪽) 테이블의 모든 레코드와 두 번째(오른쪽) 테이블에서 일치하는 레코드를 반환
select a.category_code, b.menu_name from tbl_category a left join tbl_menu b using (category_code);

-- (3) Right Join: 두 번째(오른쪽) 테이블의 모든 레코드와 첫 번째(왼쪽) 테이블에서 일치하는 레코드를 반환
select a.menu_name, b.category_code from tbl_menu a right join tbl_category b on a.category_code = b.category_code;

-- (4) Cross Join: 두 테이블의 모든 가능한 조합을 반환하는 SQL JOIN 유형
select a.menu_name, b.category_name from tbl_menu a cross join tbl_category b;

-- (5) Self Join: 같은 테이블 내에서 행과 행 사이의 관계를 찾기 위해 사용되는 SQL JOIN 유형
select a.category_name, b.category_name from tbl_category a join tbl_category b on a.ref_category_code = b.category_code;