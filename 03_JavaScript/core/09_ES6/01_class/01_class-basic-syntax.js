/**
 * 클래스 기본 문법
 * 
 */

// 클래스 선언

class Student
{
    // 생성자를 통해 인스턴스 생성 및 초기화
    constructor(name)
    {
        this.group = 1;
        this.name = name;
    }
    
    // prototype method
    introduce()
    {
        console.log(`안녕하세요 저는 ${this.group}반 학생 ${this.name}입니다.`);
    }
}

let student = new Student("Panda");
student.introduce();

// 클래스 내부에 정의한 메서드는 클래스.prototype에 저장된다.
console.log(Student.prototype.introduce);

/**
 * 클래스 문법과 유사하게 기능하는 것 처럼 보이는 생성자 함수를 사용할 수도 있다.
 */

function Teacher(name)
{
    this.group = 1;
    this.name = name;
}

Teacher.prototype.introduce = function()
{
    console.log(`안녕하세요 저는 ${this.group}반 교사 ${this.name}입니다.`);
}

let teacher = new Teacher("test");
teacher.introduce();

/**
 * 생성자 함수와 클래스의 차이점
 * 클래스 생성자를 new와 함께 호출하지 않으면 에러가 발생함
 * 클래스는 호이스팅이 발생하지 않는 것처럼 동작함
 * 클래스는 항상 use strict 적용된다.
 * => 클래스 문법은 생성자 함수와는 다른 새로운 객체 생성 매커니즘이다.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
 */

Teacher();

// 클래스 표현식

// 익명 클래스 표현식
let Tutor = class
{
    teach()
    {
        console.log("이해하셨나요?");
    }
}

new Tutor().teach(); // 식별자 앞에 new를 붙인다.
// let tutor = new Tutor();
// tutor.teach();

// 기명 클래스 표현식
let Tutee = class MyTutee
{
    learn()
    {
        console.log(`우와 이해했어요!`);
        console.log(MyTutee);
    }
}

new Tutee().learn();

// 클래스 동적 생성

function makeTutee(message)
{
    return class{
        feedback()
        {
            console.log(message);
        };
    };
}

let SecondTutee = makeTutee("만점입니다");

new SecondTutee().feedback();
