/*
1. 클래스와 메서드 정의
- Animal 클래스를 정의하고 name과 sound를 속성으로 갖습니다.
- Animal 클래스는 sound를 출력하는 speak 메서드를 가집니다.
- Animal 클래스를 상속받은 Dog 클래스를 정의하고, Dog 클래스는 `name`과 `sound`를 초기화하도록 생성자를 작성하세요.
- Dog 클래스를 통해 객체를 생성하고 speak 메서드를 호출하세요.

예시 출력:
'강아지'가 '왕!' 하고 짖습니다.
*/

class Animal
{
    constructor(name, sound)
    {
        this.name = name;
        this.sound = sound;
    }

    speak()
    {
        console.log(`'${this.name}'이/가 '${this.sound}' 하고 짖습니다.`);
    }
}

let dog = new Animal("강아지", "왕!");
dog.speak();


/*
2. Getter와 Setter 활용
- Rectangle 클래스를 정의하고 width와 height 속성을 갖습니다.
- 면적을 계산하는 getter인 `area`를 추가하세요.
- width 또는 height를 변경할 수 있도록 setter를 추가하세요.
- Rectangle 클래스를 통해 객체를 생성하고 면적을 출력한 뒤 width를 변경하고 다시 면적을 출력하세요.

예시 출력:
면적: 50
변경 후 면적: 75
*/
console.log(`======`);

class Rectangle
{
    constructor(width, height)
    {
        this.width = width;
        this.height = height;
    }
    
    get area()
    {
        console.log(`면적: ${this._width * this._height}`);
        return this._width * this._height;
    }
    
    get width()
    {
        return this._width;
    }

    get height()
    {
        return this._height;
    }

    set width(value)
    {
        this._width = value;
    }

    set height(value)
    {
        this._height = value;
    }
}

let rec = new Rectangle(5, 10);
rec.area;
rec.height = 15;
console.log(`변경 후 면적: ${rec.width * rec.height}`);

/*
3. Rest 파라미터와 Spread 문법 활용
- 두 개의 함수 sumAll과 mergeArrays를 작성하세요.
  1. sumAll 함수는 가변 인수를 받아 모든 숫자의 합을 반환합니다.
  2. mergeArrays 함수는 두 개의 배열을 인수로 받아 두 배열을 합친 새 배열을 반환합니다.
- 두 함수를 각각 호출하여 결과를 출력하세요.

예시 출력:
합계: 15
병합된 배열: [1, 2, 3, 4, 5, 6]
*/
console.log(`======`);

function sumAll(...args)
{
    let sum = 0;
    for (let arg of args)
    {
        sum += arg;
    }
    return sum;
}

function mergeArrays(...args)
{
    let arrays = [...args];
    return arrays;
}

let arr1 = [1, 2, 3, 4, 5];
let six = [6];
let sum = sumAll(1, 2, 3, 4, 5);
let merged = mergeArrays(arr1, six);
console.log(`합계: ${sum}`);
console.log(`병합된 배열 ${merged}`);

/*
4. 구조분해 할당 활용
- user 객체를 생성하고 name, age, location 속성을 초기화합니다.
- 구조분해 할당을 사용하여 name과 age를 추출하고 이를 이용해 "name은 age살입니다." 형태의 문장을 출력하세요.
- 구조분해 할당을 사용하여 배열에서 첫 번째 요소와 나머지 요소를 분리하여 출력하세요.

예시 출력:
홍길동은 30살입니다.
첫 번째 요소: 1
나머지 요소: [2, 3, 4, 5]
*/
console.log(`======`);
let user =
{
    name: "홍길동",
    age: 30,
    location: 1
};

let { name, age, location } = user;
console.log(`${name}은 ${age}살입니다.`);

console.log(`======`);
const arr = [1, 2, 3, 4, 5];
let [one, ...rest] = arr;
console.log(`첫 번째 요소: ${one}`);
console.log(`나머지 요소: ${rest}`);


/*
5. 클래스와 구조분해 할당을 활용한 학생 관리 시스템
- Student 클래스를 정의하고 name, age, score 속성을 추가하세요.
- 3명의 학생 데이터를 가진 배열 students를 생성하세요.
- 구조분해 할당을 사용하여 학생들의 이름과 점수만 배열로 추출하여 출력하세요.

예시 출력:
학생 이름: [유관순, 홍길동, 장보고]
학생 점수: [90, 80, 70]
*/

class Student
{
    constructor(name, age, score)
    {
        this.name = name;
        this.age = age;
        this.score = score;
    }
}

const students =
[
    new Student("유관순", 20, 90),
    new Student("홍길동", 19, 80),
    new Student("장보고", 25, 70)
];

let names = students.map(({ name }) => name);
console.log(names);
let scores = students.map(({score}) => score);
console.log(scores);