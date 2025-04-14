/**
 * 데이터 타입 변환(Data Type Conversion)
 * 자바스크립트에서 데이터 타입은 필요에 따라 자동으로 변환되거나 명시적으로 변환할 수 있다.
 */

// 자동 타입 변환 (암시적 변환)
console.log("5" + 2); // 문자열 + 숫자 => 문자열로 변환됨
console.log(`10 + 20 : ${10 + 20}`); // 템플릿 리터럴 표현식 삽입은 표현식의 결과를 문자열 타입으로 암묵적으로 변환

// '+'연산자를 제외한 산술 연산자의 피연산자는 모두 숫자여야하므로, 숫자가 아닌 피연산자를 숫자 타입으로 암묵적으로 타입 변환한다.
console.log(10 / '5'); // '5'가 숫자 타입으로 변환되어 2가 출력된다.
console.log(10 + '5'); // '+'이므로 105로 출력된다.
console.log(10 % 'Javascript'); // NaN - 피연산자 숫자 변환 불가로 연산 수행 불가능

/**
 * 명시적 타입 변환
 * 개발자의 의도에 따라 값의 타입을 변환하는 것이다.
 * 자바스크립트에서 기본 제공하는 표준 빌트인 생성자 함수(String, Number, Boolean)를 new 연산자 없이 호출하는 방법,
 * 빌트인 메서드를 사용하는 방법, 암묵적 타입 변환을 이용하는 방법이 있다.
 */

console.log('======= 문자열 타입으로 변환 =======');

// 1. String 생성자 함수를 new 연산자 없이 호출
let string = String(10);
console.log(typeof string);

// 2. Object.prototype.toString 메서드 사용
let string2 = (10).toString();
console.log(typeof string2);

console.log('======= 숫자 타입으로 변환 =======');

// 1. Number 생성자 함수를 new 연산자 없이 호출
let num = Number("10");
console.log(typeof num);

console.log(Number(true));
console.log(Number(false));

// 2. parseInt, parseFloat 함수 이용 (문자열->숫자만 가능)
console.log(parseInt('10.01'));
console.log(parseFloat('10.01'));

console.log('======= 논리 타입으로 변환 =======');

// 1. Boolean 생성자 함수를 new 연산자 없이 호출
console.log(Boolean('JavsScript'));
console.log(Boolean(''));
console.log(Boolean(1));
console.log(Boolean(0));

/**
 * Truthy와 Falsy 값
 * 자바스크립트에서 Falsy한 값은 false로 평가되는 값이고, 그 외의 모든 값은 Truthy한 값으로 평가된다.
 * 
 * - Falsy한 값 (false로 평가되는 값)
 * false
 * 0 (숫자 0)
 * '' (빈 문자열)
 * null
 * undefined
 * NaN (Not a Number)
 * 
 * 이 값들은 조건문이나 논리 연산자에서 **false**로 평가된다.
 */