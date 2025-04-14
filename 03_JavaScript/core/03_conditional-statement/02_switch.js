/**
 * switch문
 * 하나의 변수에 대해 여러 경우를 처리한다.
 */

let fruit = "포도";

switch (fruit)
{
    case "사과" :
        console.log("선택한 과일은 사과입니다.🍎");
        break;
    case "바나나" :
        console.log("선택한 과일은 바나나입니다.🍌");
        break;
    case "오렌지" :
        console.log("선택한 과일은 오렌지입니다.🍊")
        break;
    default:
        console.log("알 수 없는 과일입니다.🤷‍♂️");
}