/**
 * 배열 고차 함수 
 * 고차 함수: 함수를 인수로 전달받거나 함수를 반환하는 함수
 */

// Array.prototype.sort: 배열을 기준으로 정렬
let numbers = [];

// Math.random(): 0 이상 1 미만의 난수를 랜덤으로 생성하는 함수
// Math.floor(): 실수를 내림하여 정수로 변환

for (let i = 0; i < 10; i++)
{
    numbers[i] = Math.floor(Math.random() * 100) + 1;
}

console.log(`정렬 전 numbers: ${numbers}`);

numbers.sort();

console.log(`정렬 후 numbers: ${numbers}`);

function compare(a, b)
{
    if(a > b)
        return 1;
    if(a == b)
        return 0;
    if(a < b)
        return -1;
}

numbers.sort(compare);
console.log(numbers);

// 숫자 내림차순 정렬

numbers.sort(function(a, b)
{
    return b - a;
})

numbers.sort((a, b) => b - a);
console.log(numbers);

// Array.prototype.forEach: for를 대체할 수 있는 고차함수
/**
 * 배열.forEach(function(item, index, array))
 * {
 *      // 배열 요소 각각에 실행할 기능 작성
 * });
 */

numbers = [1, 2, 3, 4, 5];

numbers.forEach(function(item, index, array)
{
    console.log(`item: ${item}`);
    console.log(`index: ${index}`);
    console.log(`array: ${array}`);
});

// 각 요소 별로 * 10 한 값을 콘솔에 출력
numbers.forEach(item => console.log(item * 10));

// Array.prototype.map
// 배열 요소 전체를 대상으로 콜백 함수 호출 후 반환 값들로 구성된 새로운 배열 반환
/**
 * 배열.map(function(item, index, array)
 * {
 *      // 배열 요소 각각에 반환할 새로운 값
 * });
 */

const types = [true, 1, 'text'].map(item => typeof item);
console.log(`types: ${types}`);

// Array.prototype.filter
// 배열 요소 전체를 대상으로 콜백 함수 호출 후 반환 값이 true인 요소로만 구성된 새로운 배열 반환

numbers.filter(item => item % 2);
console.log(numbers);

const odds = numbers.filter(item => item % 2);
console.log(odds);

// Array.prototype.reduce
// 배열을 순회하며 각 요소에 대하여 이전의 콜백함수 실행 반환값을 전달하여 콜백함수를 실행하고 그 결과 반환

/**
 * previousValue: 이전 콜백의 반환값
 * currentValue: 배열 요소의 값
 * currentIndex: 인덱스
 * array: 메소드를 호출한 배열
 */
numbers.reduce(function(previousValue, currentValue, currentIndex, array)
{
    console.log(`previousValue: ${previousValue}`);
    console.log(`currentValue: ${currentValue}`);
    console.log(`currentIndex: ${currentIndex}`);
    console.log(`array: ${array}`);
});

// 합산
const sum = numbers.reduce(function(previousValue, currentValue)
{
    return previousValue + currentValue;
})

console.log(sum);

const sum1 = numbers.reduce((previousValue, currentValue) => previousValue + currentValue);

// 최대값 취득
const max = numbers.reduce(function(pre, cur)
{
    return pre > cur ? pre : cur;
});

const max1 = numbers.reduce((pre, cur) => pre > cur? pre : cur);

console.log(max);
console.log(max1);

// Array.prototype.some
// 배열 내 일부 요소가 콜백 함수의 테스트를 통과하는지 확인하여 그 결과를 boolean으로 반환

// 배열 내 요소 중 10보다 큰 값이 1개 이상 존재하는지 확인
let result = [1,5,3,2,4].some(item => item > 10);

// Array.protoytype.every
// 배열 내 모든 요소가 콜백함수의 테스트를 통과하는지 확인하여 그 결과를 boolean으로 반환
result = [1,5,3,2,4].every(item=> item <= 0);
console.log(result);


// Array.prototype.find
// 배열을 순회하며 각 요소에 대하여 콜백함수를 실행하여 그 결과가 참인 첫 번째 요소를 반환
const students = 
[
    {name: '유관순', score: 90},
    {name: '홍길동', score: 80},
    {name: '장보고', score: 70}
];

result = students.find(item => item.name === '유관순');
console.log(result);
result = students.find(item => item.name === '신사임당');
console.log(result);

// 80점 이상의 학생들을 알고싶다면?
// filter는 콜백함수의 실행 결과가 true인 배열 요소의 값만을 추출한 새로운 배열을 반환
// result = students.filter(item => item.score >= 80);
result = students.filter(item => item.score >= 80);
console.log(result);