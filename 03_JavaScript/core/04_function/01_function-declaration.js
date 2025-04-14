/**
 * 함수 (function)
 * 함수는 특정 작업을 수행하는 코드 블럭이다.
 * 
 * - 함수 선언문
 * function 함수 이름 (매개변수1, 매개변수2, ...)
 * { 
 *      함수가 수행할 코드
 *      return 반환값; 
 * }
 * - 함수 호출 방법:
 * 함수 이름(인수);
 * 
 * - 매개변수: 함수 선언 시 정의하는 변수
 * - 인수: 함수를 호출할 때 전달하는 실제 값
 */

/**
 * 자바스크립트 엔진은 함수를 호출하기 위해 함수 이름과 동일한 식별자를 암묵적으로 생성하고,
 * 거기에 함수 객체를 할당한다. 즉 함수는 함수 이름으로 호출하는것이 아니라 함수 객체를 가리키는 식별자로 호출한다.
 */

function greet(name)
{
    // console.log(`안녕하세요, ${name}님!`);
    return (`안녕하세요, ${name}님!`);
}

console.log(greet("ㅁㄴㅇ")); // 함수 호출

function add (a, b)
{
    return a + b;
}
const result = add(5, 10);
console.log(result);

// 매개변수는 함수 몸체 내부에서만 참조할 수 있음


// 학생 이름과 점수를 입력받아 성적을 계산하고 결과를 반환하는 프로그램

function checkPass(name, score)
{
    if (score >= 60)
        return (`${name}님은 합격입니다.`);
    else
        return (`${name}님은 불합격입니다.`);
}

console.log(checkPass("ㅁㄴㅇ", 80));
console.log(checkPass("ㅂㅈㄷ", 30));

// 여러 학생의 점수를 입력받아 평균 점수를 계산하는 함수 작성

function calculateAverage(scores)
{
    let total = 0;
    for (let i = 0; i < scores.length; i++)
    {
        total += scores[i];
    }

    return total / scores.length;
}

let scoress = [ 80, 90, 75, 65, 95 ];

let average = calculateAverage(scoress);

console.log(average);

// 여러 학생의 이름과 점수를 배열로 입력받아 합격 여부를 반환하는 함수 작성

function checkAllStudent(students)
{
    for (let i = 0; i < students.length; i++)
    {
        let result = checkPass(students[i].name, students[i].score);
        console.log(result);
    }
}

let studentList = 
[
    {name:"김ㅁㅁ", score:75},
    {name:"이ㅁㅁ", score:50},
    {name:"박ㅁㅁ", score:85},
];

checkAllStudent(studentList);

/**
 * 함수는 코드를 모듈화하고 재사용성을 높인다.
 * 매개변수와 반환값을 활용해 다양한 입력과 결과를 처리 가능
 * 기본값, 배열 등 다른 문법과 결합하여 복잡한 로직을 간단히 구현 가능
 */