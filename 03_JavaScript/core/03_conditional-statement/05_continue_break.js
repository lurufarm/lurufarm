/**
 * continue와 break문
 * - continue: 현재 반복문의 나머지 코드를 건너뛰고, 다음 반복으로 넘어갑니다.
 * - break: 현재 반복문을 완전히 종료합니다.
 */

// 1. continue

for (let i = 1; i <= 10; i++)
{
    if (i % 2 === 0) // i가 짝수면 코드를 건너뜀
        continue;
    console.log(i);
}

// 2. break

for (let i = 1; i <= 10; i++)
{
    if(i > 5)
        break;
    console.log(`현재 값: ${i}`);
}

// continue를 사용한 중첩 반복문 예제
for (let i = 1; i <= 3; i++)
{
    for (let j = 1; j <=3; j++)
    {
        if (j === 2)
            continue;
        console.log(`i: ${i}, j: ${j}`);
    }
}

console.log("======")

// break를 사용한 중첩 반복문 예제
outerLoop: for (let i = 1; i <= 3; i++)
    {
        for (let j = 1; j <=3; j++)
        {
            if (j === 2)
                break outerLoop;
            console.log(`i: ${i}, j: ${j}`);
        }
    }

// for...of 반복문 (ES6에서 도입)
// 배열이나 이터러블(iterable) 객체의 각 요소를 순회하는데 사용

const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9];
// 인덱스가 필요하거나 요소의 순서와 관련된 작업을 할 때는 적합하지 않음.
// 단순히 배열의 요소를 순회할 때 사용
for (const number of numbers)
{
    console.log(number);
}

console.log("======")

for (const number of numbers) 
{
    if (number % 2 === 0)
        continue;
    console.log(number);
}
