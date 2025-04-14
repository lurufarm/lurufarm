/**
 * 콜백 함수는 다른 함수에 전달되어 실행되는 함수이다.
 * 고차 함수는 콜백 함수를 인수로 받거나 다른 함수를 반환하는 함수이다.
 */

/**
 * 기본 콜백 함수 활용
 * 마을에서 이벤트가 발생하면 알림을 출력한다.
 */

function triggerEvent(eventName, callback)
{
    console.log(`이벤트: ${eventName} 시작됨`);
    callback(eventName); // 이벤트 발생 후 콜백 실행
    console.log(`이벤트: ${eventName} 종료됨`);
}

function displayNotification(eventName)
{
    console.log(`알림: ${eventName} 이벤트가 발생하였습니다.`);
}

triggerEvent("시장 개장", displayNotification);

/**
 * 결과 설명
 * - triggerEvent 고차함수는 이벤트를 시작하고 종료하며, 콜백 함수로 알림을 전달한다.
 * - 이벤트 이름은 콜백 함수에 전달되어 알림 메시지에 포함된다.
 */

/**
 * 데이터 처리와 콜백
 * 주문 데이터를 처리한 후 결과를 출력한다.
 */

function processOrders(orders, callback)
{
    console.log("주문 처리 중...");

    // map: 배열의 각 요소에 대해 주어진 함수를 호출하고, 그 결과로 새로운 배열을 생성
    // 원본 배열은 변하지 않으며, map 함수는 항상 새로운 배열을 반환한다.
    const orderCompletion = orders.map(order => 
        ({
            ...order, status: "완료"
        }));
    callback(orderCompletion);
}

function notifyCompletion(proccessedOrders)
{
    console.log("처리된 주문 목록", proccessedOrders);
}

const orderlist = 
[
    {orderId:1, item:"빵"},
    {orderId:2, item:"우유"}
];

processOrders(orderlist, notifyCompletion);