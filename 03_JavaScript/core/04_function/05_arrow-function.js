/**
 * ES6에서 도입된 화살표 함수는 function 키워드 대신 화살표를 사용해 좀 더 간략한 방법으로 함수를 선언할 수 있도록 한다.
 * 화살표 함수는 항상 익명 함수로 정의한다. 본문이 한 줄인 함수를 작성할 때 유용하다. 
 */

let message;

// 기존 function 정의
message = function() 
{
    return "Hello World!";
};

console.log(message());

// function 키워드 생략 가능
message = () => 
{
    return "Arrow Function!";
};

console.log(message());

// 명령문이 하나만 있는 경우 중괄호 생략 가능
// 함수 몸체 내부의 문이 값으로 평가될 수 있는 표현식인 문이라면 암묵적으로 반환된다.
// return 키워드도 생략 가능

message = () => "Arrow Functions are Simple!";

console.log(message());

message = (val1, val2) => "Arrow" + val1 + val2;

console.log(message(' Function', '!'));

// 매개변수가 하나면 소괄호 생략 가능

message = val1 => "Arrow" + val1;

console.log(message(' Functions are Good!!'));