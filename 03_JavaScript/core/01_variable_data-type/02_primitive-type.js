/**
 * 원시 데이터 타입
 * 자바 스크립트에는 원시 타입(Primitive types)이라는 기본적인 데이터 타입들이 있다.
 * 원시 타입은 변경 불가능한 값들이며, 자주 사용되는 원시 타입들로는
 * 숫자(number), 문자열(string), 불린(boolean), null, undefined 등이 있다.
*/

/**
 * 숫자(number)
 * 자바의 경우 정수와 실수를 구분해 int, long, float, double 등과 같은 다양한 숫자 타입을 제공한다.
 * 하지만 자바스크립트의 경우 하나의 숫자 타입만 존재하고 모든 수를 실수로 처리한다.
*/

// 자바 스크립트의 경우 let과 const만 잇는 늒김... let age = 30; 하면 알아서 숫자값이 들어감

let age = 30;
console.log(age);

/**
 * 문자열
 * 문자열 타입은 텍스트 데이터를 나타내는데 사용한다.
 * 문자열은 작은 따옴표(''), 큰 따옴표(""), 또는 백틱(``)으로 텍스트를 감싼다.
 */

let string = "문자열";
console.log(string);

// 불린(boolean): 불린 타입의 값은 논리적 참, 거짓을 나타내는 true와 false 뿐이다.
let isStudent = true;
console.log(isStudent);

// null: 명시적으로 값이 없음을 나타내는 데이터 타입
let address = null;
console.log(address);

// undefined: 변수에 값이 할당되지 않았을 때 자동으로 할당되는 값
let salary;
console.log(salary);

// typeof: 데이터 타입을 확인할 때 사용
console.log(typeof age);
console.log(typeof string);
console.log(typeof isStudent);
console.log(typeof address); // 원래 null이라고 나와야하는데 버그로 인해 object로 나옴. 근데 기존 코드를 망가뜨릴 수 있어서 걍 수정안하는 버그라고함
console.log(typeof salary);

/**
 * 템플릿 리터럴
 * ES6부터 도입된 멀티라인 문자열, 표현식 삽입 등의 편리한 문자열 처리 기능을 제공하는 문자열 표기법
 * 작은 따옴표, 큰 따옴표 대신 백틱(``)을 사용해 표현한다.
 */
// 일반 문자열 내에서는 줄바꿈이 허용되지 않는다.
// let str = '안녕하세요.
// 반갑습니다.';

// 이스케이프 시퀀스를 사용해야 한다.
let str = '안녕하세요.\n반갑습니다.';
console.log(str);

// 백틱을 사용하면 줄바꿈이 허용되며 모든 공백이 있는 그대로 적용된다.
let multiLine = `ㄴㅁㅇㄻ
ㅁㄴㅇㄹㄴㅇㄹ
ㅁㄴㅇㄹㄴㅇㄹ`;
console.log(multiLine);

// 문자열은 문자열 연산자 +를 사용해 연결할 수 있다.
let lastName = '홍';
let firstName = '길동';
console.log('제 이름은 ' + lastName + firstName + ' 입니다');
console.log(`제 이름은 ${lastName}${firstName} 입니다.`);

// 일반 문자열에서의 표현식 삽입은 문자열로 취급된다.
console.log('제 이름은 ${lastName}${firstName} 입니다.');
