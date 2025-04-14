// 함수의 매개변수가 많거나 매개변수 기본값이 필요한 경우 등에 활용됨

// function displayProduct(producer = "아무개", width = 0, height = 0, items = [])
// {}
// ex) displayProduct("홍길동", undefined, undefined, ["coffee", "donut"]);

// 구조 분해 할당을 이용하면 문제점이 해결된다
function displayProduct({ producer = "아무개", width = 0, height = 0, items = [] })
{
    console.log(`${producer} ${width} ${height}`);
    console.log(items);
}

// 함수에 전달할 객체
let exampleProduct =
{
    items: ["Coffee", "Donut"],
    producer: "신사임당",
};

displayProduct(exampleProduct);