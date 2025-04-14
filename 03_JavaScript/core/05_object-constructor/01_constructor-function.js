/**
 * 생성자 함수
 */

// 객체 리터럴에 의한 객체 생성
const students1 =
{
    name: '김영희',
    age: 16,
    getInfo: function()
    {
        return `${this.name}는 ${this.age}세 입니다.`;
    }
}
const students2 =
{
    name: '박철수',
    age: 20,
    getInfo: function()
    {
        return `${this.name}는 ${this.age}세 입니다.`;
    }
}

// 생성자 함수에 의한 객체 생성
// 객체를 생성하기 위한 템플릿처럼 생성자 함수를 사용하여 프로퍼티 구조가 동일한 객체 여러개를 간편하게 생성 가능

function Student(name, age)
{  
    // 생성자 함수 내부의 this는 생성자 함수가 생성할 인스턴스(객체)를 가리킨다.
    this.name = name;
    this.age = age;
    this.getInfo = function()
    {
        return `${this.name}은 ${this.age}세입니다.`;
    }
}

// 인스턴스(객체) 생성

const student3 = new Student('김영수', 16);
const student4 = new Student('장영철', 40);
const student5 = Student('옥순', 25); // new 키워드 없이는 잘못된 사용임. undefined를 반환하게 된다


console.log(student3.getInfo());
console.log(student4.getInfo());
console.log(student5);
