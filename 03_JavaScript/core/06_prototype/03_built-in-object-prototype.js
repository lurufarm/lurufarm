// 생성자 함수 프로토타입
// new 연산자를 이용해 만든 객체는 생성자 함수의 프로토타입 정보를 사용해 [[Prototype]]을 설정한다.

const user =
{
    activate: true,
    login: function()
    {
        console.log('로그인 되었습니다.');
    }
}

// 생성자 함수
function Student(name)
{
    this.name = name;
}

// 여기서의 prototype은 앞에서 봤던 프로토타입과 이름만 같을 뿐, 실제로는 일반 프로퍼티이다.
Student.prototype = user;

// 생성자 함수를 생성자 함수로서 사용할 때는 새롭게 만들어진 객체에 프로토타입을 할당하게 된다.
// new Student를 호출할 때 만들어지는 새로운 객체의 [[Prototype]]을 할당한다.
// 내부적으로 student.__proto__ = user; 와 같다는 뜻
let student = new Student("홍길동");

console.log(student.activate);

// Function, String, Number를 비롯한 내장 객체들 역시 프로토타입에 메서드를 저장한다.
// 모든 내장 프로토타입의 상속 트리 꼭대기엔 Object.prototype이 있어야 한다고 규정한다.

const num = new Number(100);

// num은 Number.prototype을 상속받았는가?
console.log(num.__proto__ === Number.prototype);

// num은 Object.prototype을 상속받았는가?
console.log(num.__proto__.__proto__ === Object.prototype);

// 프로토타입 체인 최상단에는 null이 있다.
console.log(num.__proto__.__proto__.__proto__);

console.log(num);
console.log(num.toString());
