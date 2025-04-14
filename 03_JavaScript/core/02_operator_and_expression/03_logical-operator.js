/**
 * 논리 연산자 (Logical Operators)
 * 여러 조건을 결합하여 하나의 논리적 결과를 도출한다.
 * 논리 연산자는 AND, OR, NOT 연산자가 있다.
 */

let a = true;
let b = false;

// 1. AND 연산자 (&&)
console.log(a && b); // a와 b가 모두 true일 때 참이므로 false

// 2. OR 연산자 (||)
console.log(a || b); // a와 b 중 하나라도 true이면 참이므로 true

// 3. NOT 연산자 (!)
console.log(!a); // true이면 false, false면 true를 반환
console.log(!b); // true이면 false, false면 true를 반환

/**
 * 단축 평가 (Short-circuit Evaluation)
 * 표현식을 평가하는 도중 평가 결과가 확정 된 경우 나머지 평가 과정을 생략하는것
 */

// AND 연산자에서 단축평가
let first = "Hello";
let second = "";
let result1 = first && second;

console.log(result1); // 했을 시 second의 빈칸 값이 들어가게 되어 false로 출력되지 않고 빈 문자열만 출력됨

// OR 연산자에서 단축평가
let result2 = first || second;

console.log(result2); // first가 truthy한 값이므로, 평가 결과가 확정됨. 따라서 first의 값인 "Hello"가 result2에 담기게 된다.

// 단축 평가 : 기본값 설정
let userName = null;
let displaName = userName || "Guest"; // userName이 현재 falsy한 값이므로 Guest로 설정될 것임.

console.log("환영합니다, " + displaName);

/**
 * 옵셔널 체이닝 연산자(optional-chaining-operator)
 * ES11에서 도입된 연산자로
 * 좌항의 피연산자가 null 또는 undefined인 경우 undefined를 반환하고, 그렇지 않으면 우항의 프로퍼티 참조를 이어간다. 
 */

let obj = null;
// let val = obj?.value; 
// console.log(val); // 여기서는 obj가 null값이므로, undefined를 반환할 것이다.
// let val = obj.value; // 여기서 옵셔널 체이닝 연산자인 ?를 뺐을 때, 타입에러가 떠버림. "cannot read properties of null"

// console.log(val);

/**
 * null 병합 연산자 (값 ?? 값)
 * null 또는 undefined 일 때만 오른쪽 값을 반환하고,
 * 그 외의 값은 왼쪽 값을 그대로 반환한다.
 */

let value1 = 0;
let value2 = null;

let result3 = value1 ?? "Default Value"; // 0이 들어가있으므로 0이 반환됨
let result4 = value2 ?? "Default Value"; // null이 들어가있으므로 Default Value가 반환됨.

console.log(result3);
console.log(result4); 