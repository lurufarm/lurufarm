/**
 * 배열(Array)
 * 배열은 여러 개의 데이터를 순서대로 저장할 수 있는 자료형이다.
 * 배열의 요소들은 인덱스(index)를 통해 접근할 수 있으며 인덱스는 0부터 시작된다.
 */

// 배열 리터럴 생성
const fruits = ["사과", "바나나", "오렌지"];

// 배열 생성자 함수
const arr = new Array(1, 2, 3);
console.log(arr);

// Array.of 메소드
console.log(Array.of('hello', 'js'));

// 배열 요소 접근
console.log(fruits[0]);
console.log(fruits[1]);
console.log(fruits[2]);

// 배열 요소 수정
fruits[1] = "블루베리";
console.log(fruits);

// const로 선언했지만, 배열이기때문에 수정 가능

// 배열의 길이 확인
console.log(fruits.length);

console.log(typeof arr);

/**
 * 배열 메서드
 * push(): 배열 끝에 요소 추가
 * pop(): 배열 끝에 요소 제거
 * shift(): 배열 첫 번째 요소 제거
 * unshift(): 배열 첫 번째에 요소 추가
 * forEach(): 각 요소에 대해 함수를 실행
 * concat(): 두 개 이상의 배열을 결합
 * slice(): 배열의 요소 선택 잘라내기
 * splice(): 배열의 index 위치의 요소 제거 및 추가
 * join(): 배열을 구분자로 결합하여 문자열로 변환
 */

fruits.push("포도");
console.log(fruits);

fruits.pop();
console.log(fruits);

fruits.shift();
console.log(fruits);

fruits.unshift("딸기");
console.log(fruits);

fruits.forEach((fruit) => {
    console.log("과일: ", fruit);
})

// 배열명.concat(배열명1, 배열명2, ...) 로 합칠 수 있음
const arr2 = fruits.concat(arr);
console.log(arr2);

// 배열명.slice(시작 인덱스, 종료 인덱스)
console.log(arr2.slice(1, 3)); // 원본 배열에 영향을 주지 않는다.
console.log(arr2);

// 배열명.splice(index, 제거 수, 추가 값1, 추가 값 2, ...)
console.log(arr2.splice(0, 1, "hi")); // 원본 배열에 영향을 준다.
console.log(arr2);

// 배열명.join() 배열 형태를 문자열로 변환해서 반환해준다.
console.log(arr2.join('/'));

/**
 * [객체 배열]
 * 배열 안에 객체를 포함시킬 수 있다.
 * 각 객체는 고유한 속성을 가질 수 있다.
 */

// 객체 배열 생성
const people = [
    { name: '홍길동', age: 25, job: "개발자" },
    { name: '김영희', age: 30, job: "디자이너" },
    { name: '이철수', age: 28, job: "마케터" }
];

// 객체 배열 접근
console.log(people[0].name);
console.log(people[1].age);
console.log(people[2].job);

/**
 * [배열의 객체에 대해 메서드 적용]
 * 배열의 객체 요소를 순회하며 특정 작업을 수행할 수 있다.
 */

// 각 사람의 정보를 출력하는 함수
people.forEach((person)=>{
    console.log(`${person.name}은(는) ${person.age}살이며, 직업은 ${person.job}입니다.`);
});