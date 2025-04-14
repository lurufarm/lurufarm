/**
 * 스프레드 문법을 이용한 배열, 객체 복사
 */

let arr = [10, 20, 30];
let arrCopy = [...arr];
console.log(arr);
console.log(arrCopy);

console.log(arr === arrCopy); // 주소값이 다르기 때문에 false로 나옴
arrCopy.push(50); // 복사본 배열에 값 추가
console.log(arr);
console.log(arrCopy);

let obj = { name: "홍길동", age: 20 };
let objCopy = { ...obj };
console.log(obj);
console.log(objCopy);

objCopy.age = 30;
console.log(obj);
console.log(objCopy);

/**
 * 스프레드 문법: 배열을 목록으로 확장
 * 나머지 매개변수: 인수 목록의 나머지를 배열로 모아줌
 */