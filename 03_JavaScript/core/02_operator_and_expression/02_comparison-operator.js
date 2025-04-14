/**
 * 비교 연산자
 * 도 값을 비교하여 참 또는 거짓을 반환한다.
 */

let x = 10;
let y = 20;

//  1. 동등 연산자 (Equality Operators)
console.log(x == y);
console.log(x != y);

// 2. 일치 연산자 (Strict Equality Operators) : 타입까지 비교
console.log(x === 10); // x가 숫자 타입이면서 값도 같아서 true
console.log(x === "10"); // 값은 같지만 타입이 달라서 false
console.log(x == "10"); // 타입은 다르지만 값이 같아서 true (값만 비교)
console.log(x !== "10"); // 값 또는 타입이 달라서 true

// 3. 크기 비교 연산자 (Relational Operators)
console.log(x > y); // x가 작으므로 false
console.log(x < y); // true
console.log(x >= y); // false
console.log(x <= y); // true
