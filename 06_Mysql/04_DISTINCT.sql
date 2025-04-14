-- 4. DISTINCT
-- 중복 값을 제거하는데 사용한다. 컬럼에 있는 컬럼 값의 종류를 쉽게 파악할 수 있다.

select category_code from tbl_menu order by category_code;

-- 단일열 distinct 사용
select distinct category_code from tbl_menu order by category_code;

-- NULL 값을 포함한 열의 distinct 사용
select distinct ref_category_code from tbl_category;

-- 다중열 distinct (다중 컬럼을 묶은 값에서 중복 제거)
select distinct category_code, orderable_status from tbl_menu;