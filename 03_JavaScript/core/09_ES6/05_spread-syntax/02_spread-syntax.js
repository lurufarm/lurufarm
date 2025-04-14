/**
 * 스프레드 문법(전개 문법)
 * 배열을 통째로 매개변수에 넘겨주는 기능
 * 하나로 뭉쳐있는 여러 값들의 집합을 전개해서 개별적인 값들의 목록으로 만든다.
 * 사용 대상은 for ... of 문으로 순회할 수 있는 이터러블에 한정된다.
 */

console.log(`가장 큰 값: ${Math.max(10, 30, 20)}`);

let arr = [10, 30, 20];
console.log(`가장 큰 값: ${Math.max(arr)}`);
// 이렇게 하면 NaN이 뜸.

// Math.max는 숫자 목록을 인수로 받기 때문에 배열로는 제대로 동작하지 않는다.
// 이런 경우 스프레드 문법을 사용할 수 있다.

console.log(`가장 큰 값: ${Math.max(...arr)}`);
// 정상적인 결과가 출력된다. 함수를 호출할 때 ...arr를 사용하면 arr이 인수 목록으로 확장된다.

let arr1 = [10, 20, 30];
let arr2 = [100, 300, 200];

console.log(`가장 작은 값: ${Math.min(...arr1, ...arr2)}`);

// 일반 인수와 혼합해서도 사용 가능하다.
console.log(`가장 작은 값: ${Math.min(...arr1, 2, ...arr2)}`);

// 배열 병합에도 사용 가능 - concat보다 간결함
let merged = [0, ...arr, 2, ...arr2];
console.log(merged);

// 이터러블 배열 변환
// 스프레드 문법은 for ... of와 같은 방식으로 내부에서 이터레이터(반복자)를 사용해서 요소를 수집한다.
let str = 'JavaScript';
console.log([...str]); // 문자열을 배열로 전환
console.log(Array.from(str)); // 윗줄과 같은 결과가 나옴