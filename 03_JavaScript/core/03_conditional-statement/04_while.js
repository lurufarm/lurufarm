/**
 * 반복문: while
 * 조건문이 참인 동안 코드를 반복 실행합니다.
 * while (조건식)
 * { 조건식이 true일 동안 실행 }
*/

let count = 3;
while (count > 0) {
    console.log(`카운트다운: ${count}`);
    count--;
}

/**
 * 반복문: do-while
 * 최소 한 번 실행한 후 조건을 검사한다.
 * do
 * { 조건에 상관 없이 처음 실행 }
 * while (조건);
 */

let number = 1;

do
{
    console.log(`숫자: ${number}`);
    number++;
} while (number < 1);