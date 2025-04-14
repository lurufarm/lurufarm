/**
 * 나머지 매개변수(...)
 */

function merge(msg1, msg2)
{
    return msg1 + msg2;
}

console.log(merge('안녕하세요.'));
console.log(merge('안녕하세요.', ' 반갑습니다.'));
console.log(merge('안녕하세요.', ' 반갑습니다.', ' 판다입니다'));

// merge가 현재 매개변수가 2개뿐이므로 판다입니다는 잘림

// 나머지 매개변수 ...를 사용하면 매개변수를 한데 모아 배열에 담을 수 있다.

function mergeAll(...args) // 여러 개를 전달하고 싶을 때
{
    let message = '';
    
    for(let arg of args) message += arg;
    
    return message;
}

console.log(mergeAll('안녕하세요'));
console.log(mergeAll('안녕하세요', ' 반갑습니다.'));
console.log(mergeAll('안녕하세요', ' 반갑습니다.', ' 판다입니다.'));

// ...args를 사용하면 자연스럽게 여러 개의 매개변수를 함수에 적용할 수 있다.
// 단, ...args는 맨 마지막에 써야한다.

function func(arg1, arg2, ...args)
{ }
