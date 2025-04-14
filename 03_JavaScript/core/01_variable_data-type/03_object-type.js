/**
 * 자바스크립트는 객체 기반 프로그래밍 언어로 원시 값을 제외한 나머지 값(함수, 배열, 정규 표현식 등)은 모두 객체이다.
 * 객체는 0개 이상의 프로터피로 구성된 집합이며 프로퍼티는 키(key)와 값(value)으로 구성된다.
 * 자바스크립트에서 사용할 수 있는 모든 값은 프로퍼티 값이 될 수 있다.
 * 프로퍼티 값이 함수일 경우 method라고 부른다.
 */

// 객체 생성(객체 리터럴 방식)
let person = {
    // 키-값 쌍으로 구성된 프로퍼티.
    // 프로퍼티 : 객체의 상태를 나타내는 값(data)
    name: "Panda",
    age: 20,
    greet: function() {
        console.log("Hello," + this.name);
    }
}

// 프로퍼티 값 단축 구문
const id = 'p-0001';
const price = 30000;

const product =
{
    id : id,
    price : price
};


// ES6에서는 프로퍼티 값으로 변수를 사용하는 경우, 변수 이름과 프로퍼티 키가 동일한 이름일 때
// 프로퍼티 키를 생략할 수 있다. 프로퍼티 키는 변수 이름으로 자동 생성된다.
const product2 = { id, price };

console.log(product);
console.log(product2);

// ES6에서는 메서드를 정의할 때 function 키워드를 생략한 축약 표현을 사용할 수 있다.
const dog =
{
    name: '두부',
    eat(food)
    {
        console.log(`${this.name}(은)는 ${food}를 맛있게 먹어요.`);
    }
}   

dog.eat("감자");

// 객체 속성 접근(마침표 표기법)
console.log(person.name);
console.log(person.age);

// 객체 속성 접근(대괄호 표기법) - 프로퍼티 키는 반드시 따옴표로 감싼 문자열을 사용한다.
console.log(person['name']);

// 객체의 메서드 호출
person.greet();3
person['greet']();

// 객체의 새로운 속성 추가
person.city = "Seoul";
console.log(person.city);

// 객체 속석 상제
delete person.age;
console.log(person.age);