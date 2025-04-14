const user =
{
    id:'user',
    login: function()
    {
        console.log(`${this.id}님 로그인 되었습니다.`);
    }
};

const student =
{
    __proto__: user
};

console.log(student.id);

student.id = 'user01';
student.login();

// login 메소드 내의 this는 프로토타입에 영향받지 않으며,
// 메서드를 객체에서 호출했든 프로토타입에서 호출했든 상관없이
// this는 언제나 .앞에 있는 객체이다.
// 메서드는 공유되지만 객체의 상태는 공유되지 않는다.
console.log(user);
console.log(student);
console.log("====");

for (let prop in student) // for...in은 객체의 프로퍼티 키 값을 조회할 수 있는 반복문
{
    // for...in 반복문은 상속 프로퍼티도 순회 대상에 포함시킨다.
    console.log(prop);
    let isOwn = student.hasOwnProperty(prop); // hasOwnProperty는 내 프로퍼티일 경우 true, 상속 프로퍼티일 경우 false를 반환하는 메서드
    if(isOwn)
    {
        console.log(`객체 자신의 프로퍼티 ${prop}`);
    }
    else
    {
        console.log(`상속 프로퍼티 ${prop}`);
    }
}