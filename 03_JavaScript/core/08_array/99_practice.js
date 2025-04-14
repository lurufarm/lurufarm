/*
2-1. min, max function

1. 전달된 매개변수 중 최소값을 반환하는 함수 min(a, b)와
   전달된 매개변수 중 최대값을 반환하는 함수 max(a, b)를 정의하세요.

2. 변수 초기화를 통해 숫자를 설정하고,
   최소값과 최대값을 함수 호출을 통해 리턴 받아 콘솔에 출력하는
   테스트 코드를 작성하세요.

예시 출력:
최소값 : 10
최대값 : 20
*/
function min(a, b)
{
    if (a > b)
        return b;
    else 
        return a;
}

function max(a, b)
{
    if (a > b)
        return a;
    else
        return b;
}

console.log(`최소값: ${min(10, 20)}`);
console.log(`최대값: ${max(10, 20)}`);

/*
2-1. 화살표 함수로 변경하기

1. 2-1에서 작성한 함수 선언문으로 작성된 min, max 함수를
   화살표 함수로 변경하여 작성하세요.

2. 삼항 연산자를 이용하여 함수 본문을 하나의 구문으로 변경하세요.

3. 변수 초기화를 통해 숫자를 설정하고,
   최소값과 최대값을 함수 호출을 통해 리턴 받아 콘솔에 출력하는
   테스트 코드를 작성하세요.

예시 출력:
최소값 : 10
최대값 : 20
*/
console.log("==========");

min = (a, b) => a > b ? b : a;
max = (a, b) => a > b ? a : b;

console.log(`최소값: ${min(1, 2)}`);
console.log(`최대값: ${max(1, 2)}`);

/*
3-1. 객체 리터럴로 계산기 객체 만들기

1. calculator 라는 객체를 생성하고 다음과 같은 메소드를 정의하세요.
   - sum 메소드: 객체의 a, b 두 값의 합을 반환
   - multi 메소드: 객체의 a, b 두 값의 곱을 반환

2. 객체의 a와 b 값을 초기화하고, 각 메소드를 실행하여 결과를 출력하는 코드를 작성하세요.

예시 출력:
합 : 30
곱 : 200
*/
console.log("==========");

let calculator =
{
    sum: function (a, b)
    {
        return a + b;
    },
    multi: function(a, b)
    {
        return a * b;
    }
}

console.log(calculator.sum(10, 20));
console.log(calculator.multi(10, 20));


/*
3-2. 객체 생성자로 계산기 객체 만들기

1. Calculator라는 생성자 함수를 생성하고 다음과 같은 메소드를 정의하세요.
   - sum 메소드: 저장된 두 값의 합을 반환
   - multi 메소드: 저장된 두 값의 곱을 반환

2. Calculator 생성자를 통해 객체를 생성하고, 
   저장할 두 값을 초기화한 후 각 메소드를 실행하여 결과를 출력하는 코드를 작성하세요.

예시 출력:
합 : 30
곱 : 200
*/
console.log("==========");

function Calculater(a, b)
{
    this.a = a;
    this.b = b;
    this.sum = function()
    {
        return this.a + this.b;
    }
    this.multi = function()
    {
        return this.a * this.b;
    }
}

let obj1 = new Calculater(10, 20);
console.log(obj1.sum());
console.log(obj1.multi());

/*
4-1. 특정 범위 외 요소 삭제 함수 작성

1. 배열(arr)의 요소 중 a와 b 사이에 속하지 않는 요소를 삭제하는 함수 filterRange(arr, a, b)를 작성하세요.
   - arr: 대상 배열
   - a: 범위의 최소값
   - b: 범위의 최대값

2. filterRange 함수는 a와 b 사이에 속하는 요소는 유지하고,
   그 외의 요소는 삭제하여 결과를 반환해야 합니다.

3. 힌트: splice 메소드를 사용하여 배열 요소를 삭제할 수 있습니다.

예시 출력:
[5, 3, 1, 4]
*/

let arr = [5, 3, 8, 1, 10, 4];

function filterRange(arr, a, b)
{
    arr.forEach(function(element, index)
    { 
        if (element < a || element > b)
            arr.splice(index, 1);
    });

    console.log(`filterRange: ${arr}`);
}

filterRange(arr, 1, 5);

/*
5-1. 학생 객체 정렬 및 이름 합성 함수 작성

1. Student 생성자 함수를 통해 생성된 3명의 학생 객체를 studentList 배열에 담습니다.

2. 다음 함수를 작성하세요:
   - sortFromScore(arr): 전달된 배열(arr)을 score 속성을 기준으로 내림차순으로 정렬하여 반환하는 함수.
   - makeFullName(arr): 전달된 배열(arr)을 순회하며 lastName과 firstName을 합성한 name 속성을 추가하고,
     객체를 새로운 형식으로 반환하는 함수.

3. sort와 map 메소드를 활용하여 작성하세요.

예시 출력:
[
  Student { firstName: '관순', lastName: '유', score: 80 },
  Student { firstName: '보고', lastName: '장', score: 70 },
  Student { firstName: '길동', lastName: '홍', score: 60 }
]
[
  { name: '유관순', score: 80 },
  { name: '장보고', score: 70 },
  { name: '홍길동', score: 60 }
]
*/

function Student(firstName, lastName, score)
{
    this.firstName = firstName;
    this.lastName = lastName;
    this.score = score;
}

let students = [];
students.push(new Student('보고', '장', 70));
students.push(new Student('길동', '홍', 60));
students.push(new Student('관순', '유', 80));

console.log(students);

// ----

function sortFromScore(arr)
{
    arr.sort((a, b) => b.score - a.score);
}

sortFromScore(students);
console.log(students);

// ----

function makeFullName(arr)
{
    arr.map(function(obj){
        obj.name = obj.lastName + obj.firstName;
    })
}
makeFullName(students);
console.log(students);

const newStudents = students.map(function(student){
    let newStudent =
    {
        name: student.name,
        score: student.score
    };
    return newStudent;
});
console.log(newStudents);
