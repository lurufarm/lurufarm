// 객체 구조 분해 할당

let pants = {
    productName: "슬랙스",
    color: "검정색",
    price: 20000
};

// let { productName, color, price } = pants;

// console.log(productName);
// console.log(color);
// console.log(price);

// 각 변수의 서술 순서는 무관하며 { 객체 프로퍼티 : 목표 변수 } 형식으로도 작성할 수 있다.
let { color: co, price: pr, productName: pn } = pants;

console.log(co);
console.log(pr);
console.log(pn);