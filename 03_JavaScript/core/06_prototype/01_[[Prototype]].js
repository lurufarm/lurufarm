/**
 * [[Prototype]]
 * 자바스크립트 객체는 [[Prototype]]이라는 숨김 프로퍼티를 갖는다.
 * 이 프로퍼티 값은 null이거나 다른 객체에 대한 참조가 되는데, 다른 객체를 참조하는 경우 참조하는 경우,
 * 참조 대상을 프로토타입(prototype)이라고 한다.
 * object에서 프로퍼티를 읽으려 할 때 해당 프로퍼티가 없으면 자바스크립트는 자동으로 프로토타입에서 프로퍼티를 갖는다.
 * 이것을 프로토타입 상속이라고 한다.
 */

const user =
{
    activate: true,
    login: function()
    {
        console.log('로그인 되었습니다.');
    }
}

const student = 
{
    passion: true
};

student.__proto__ = user;
// student의 프로포타입은 user이다. 또는 student는 user를 상속받는다 라고 표현하기도 한다.
// 프로토타입에서 상속받은 프로퍼티를 '상속 프로퍼티'라고 한다.

console.log(student.activate);
student.login();

// 프로토타입 체인
const greedyStudent =
{
    class: 11,
    __proto__: student
};

console.log(greedyStudent.passion); // student에서 상속
console.log(greedyStudent.activate); // user에서 상속. user-student-greedyStudent 순으로 상속받은것