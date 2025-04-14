/**
 * 함수 표현식
 * 함수 표현식은 함수를 변수에 저장해 재사용성을 높인다.
 */

// function greet() {}
// 함수 표현식은 변수에 할당되므로 함수명을 생략할 수 있다.
const greet = function(name) 
{
    console.log(`안녕하세요 ${name}님!`);
}
greet("고릴라");

const add = function(a, b)
{
    return a + b;
}

console.log(add(5,10));

const calc = function add(a, b)
{
    return a + b;
}

console.log(calc(10,20));

// 함수 호출흔 식별자로 이루어짐. 함수명으로 호출은 불가능함. 이 경우에 const add를 주석처리하고 console.log(add(a,b)); 하게 되면 오류남
