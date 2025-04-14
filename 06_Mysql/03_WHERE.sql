-- 3. WHERE
-- 특정 조건에 맞는 레코드만을 선택하는데 사용되며, 다양한 방법으로 조건을 설정할 수 있다.

-- (1) 비교 연산자 활용

-- 같음(=) 연산자
SELECT 
	menu_name,
    menu_price,
    orderable_status
FROM
	tbl_menu
WHERE
	-- orderable_status = 'Y';
	menu_price = 13000;

-- 같지 않음(!=, <>) 연산자
SELECT
	menu_name,
    menu_price,
    orderable_status
FROM
	tbl_menu
WHERE
	orderable_status <> 'Y';
    
-- 대소 비교 연산자(>, <, >=, <=)
SELECT
	menu_code,
    menu_name,
    menu_price
FROM
	tbl_menu
WHERE
	menu_price >= 20000;
    
-- (2) AND 연산자
SELECT 1 AND 1;
SELECT 1 AND 0, 0 AND 1, 0 AND 0, 0 AND NULL;
SELECT 1 AND NULL, NULL AND NULL;

-- 구매 가능하면서 카테고리 코드가 10인 메뉴 조회
SELECT 
	*
FROM
	tbl_menu
WHERE
	orderable_status = 'Y' AND category_code = 10;
    
-- (3) OR 연산자 사용
SELECT 1 OR 1, 1 OR 0, 0 OR 1;
SELECT 0 OR 0;
SELECT 1 OR NULL, 0 OR NULL, NULL OR NULL;

-- 가격이 5000원 초과이거나 카테고리 코드가 10인 메뉴 조회
SELECT
	*
FROM
	tbl_menu
WHERE
	menu_price > 5000 OR category_code = 10;
    
-- AND와 OR의 우선순위
-- AND가 OR보다 우선순위가 높다. 만약 OR의 우선수위를 높이고 싶다면 소괄호를 사용해야한다.


-- (4) BETWEEN 연산자
SELECT
	*
FROM
	tbl_menu
WHERE
	menu_price BETWEEN 10000 AND 25000
ORDER BY
	menu_price;
    
    
-- (5) LIKE 연산자
-- '검색어%': 검색어로 시작하는 단어
-- '%검색어': 검색어로 끝나는 단어
-- '%검색어%': 검색어를 포함한 단어
SELECT
	*
FROM
	tbl_menu
WHERE
	menu_name NOT LIKE '%마늘%'
ORDER BY
	menu_name;
    
-- (6) IN 연산자
SELECT
	*
FROM
	tbl_menu
WHERE
	-- category_code = 4 OR category_code = 5 OR category_code = 6
    category_code NOT IN (4, 5, 6)
ORDER BY
	category_code;
    
-- (7) IS NULL 연산자
SELECT
	*
FROM 
	tbl_category
WHERE
	ref_category_code IS NOT NULL;