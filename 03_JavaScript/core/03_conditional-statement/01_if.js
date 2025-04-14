/**
 * 조건문
 * if (조건식) 
 * { 조건이 true일 때 실행 }
 * else
 * { 조건이 false일 때 실행 }
 */

let temperature = 5;
if (temperature < 10)
{
    console.log("오늘은 추운 날씨입니다. 옷을 따뜻하게 입으세요!");
}
else
{
    console.log("오늘은 날씨가 괜찮습니다.");
}

/**
 * if-elseif-else
 * if (조건식 1)
 * { 조건식 1이 true일 때 실행 }
 * else if (조건식 2)
 * { 조건식 2가 true일 때 실행 }
 * else if (조건식 3)
 * { 조건식 3이 true일 때 실행 }
 * else
 * { 모든 조건이 해당되지 않으면 실행 }
 */

let score = 85;

if (score >= 90)
{
    console.log("성적이 우수합니다.");
}
else if (score >= 80)
{
    console.log("성적이 양호합니다.");
}
else if (score >= 70)
{
    console.log("성적이 보통입니다.");
}
else
{
    console.log("성적이 부족합니다. 공부가 필요합니다.");
}