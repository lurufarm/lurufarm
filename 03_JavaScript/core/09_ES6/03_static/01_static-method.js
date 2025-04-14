/**
 * 정적 메서드
 * 정적 메서드는 특정 클래스 인스턴스가 아닌 클래스 '전체'에 필요한 기능을 만들 때 사용
 */

class Student
{
    constructor(name, height)
    {
        this.name = name;
        this.height = height;
    }

    static compare(studentA, studentB)
    {
        return studentA.height - studentB.height; // 인스턴스끼리 비교해주는 메서드
    }
}

let students =
[
    new Student('유관순', 165.5),
    new Student('홍길동', 180.5),
    new Student('신사임당', 163.2)
];

students.sort(Student.compare);
console.log(students);

// 정적 메서드 사용 용도 예시
// 조건에 맞는 Student를 만들어야 할 때, 생성자도 사용 가능하지만
// 클래스에 정적 메서드를 만들어 팩토리 메서드를 구현할 수 있다.

class User
{
    constructor(id, registDate)
    {
        this.id = id;
        this.registDate = registDate;
    }

    static registUser(id)
    {
        return new this(id, new Date());
    }
}

let user01 = User.registUser('user01'); 
console.log(user01);