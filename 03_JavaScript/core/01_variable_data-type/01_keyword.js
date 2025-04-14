/*


*/
// let: 값을 변경할 수 있는 변수 선언

// let greeting;
// greeting ="Hello, Node.js!";

let greeting = "Hello, Node.js!";
console.log(greeting);

// const 키워드로 선언한 변수는 재할당이 금지된다.
// const 키워드로 선언한 변수는 반드시 선언과 동시에 초기화 해야한다.

const x = 1;
// x = 2;

/*
 * 변수 선언 규칙과 스타일
 * - 변수 이름은 알파벳, 숫자, _, $만 사용할 수 있다. 
 * - 변수 이름은 숫자로 시작할 수 없다.
 * - 카멜케이스(camelCase)를 사용하는 것이 일반적이다.
 * - 예약어 사용 금지: 변수 이름으로는 자바스크립트의 예약어를 사용하지 않는다.
 * - 대소문자 구분: 변수 이름에서 대소문자를 구분한다. A, a 둘은 다른 변수이다.
 * - 의미 있는 이름 사용: 변수 이름은 그 변수의 역할이나 내용을 명확하게 나타내는 것이 좋다.
 * - 상수 변수: 상수를 선언할 때는 일반적으로 대문자와 언더스코어를 사용하는 것이 일반적이다.
*/

// let 1name = "test";

// 올바른 변수 선언
let userName = "SG"; // 카멜케이스 스타일
const userAge = 20;

console.log('사용자 이름:' + userName + ", 나이:" + userAge);
console.log(`사용자 이름:${userName}, 나이:${userAge}`);