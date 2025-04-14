/**
 * 배열 구조 분해 할당
 * 구조 분해 할당을 사용하면 배열이나 객체를 변수로 '분해'하여 연결할 수 있다.
 */

let nameArr = ["Eunji", "Kwon"];

let [firstName, lastName] = nameArr;
// let firstName = nameArr[0];
// let lastName = nameArr[1];

console.log(firstName);
console.log(lastName);

// 반환 값이 배열인 split 메서드를 활용한 예제
let [firstName2, lastName2] = "은지 권".split(' ');

console.log(firstName2);
console.log(lastName2);

// 쉼표를 사용하여 필요하지 않은 배열 요소를 버릴 수 있다.
let [firstName3, , lastName3] = ['firstName', 'middleName', 'lastName'];

console.log(firstName3);
console.log(lastName3);

// 할당 연산자 우측엔 모든 이터러블이 올 수 있고 할당 연산자 좌측엔 뭐든지 올 수 있다.
let user = {};
[user.firstName, user.lastName] = "Gildong Hong".split(' ');

console.log(user.firstName);

// rest parameter ... 로 나머지 요소를 한번에 가져올 수 있다.
let [sign1, sign2, ...rest] = ["양자리", "물고기자리", "쌍둥이자리", "게자리", "사자자리"];

console.log(sign1);
console.log(sign2);
console.log(rest);


// 기본값을 설정하고 사용할 수도 있다.
// let [firstName4 = "아무개" , lastName4 = "홍"] = [];
let [firstName4 = "아무개", lastName4 = "홍"] = ["길동"];

console.log(firstName4);
console.log(lastName4);