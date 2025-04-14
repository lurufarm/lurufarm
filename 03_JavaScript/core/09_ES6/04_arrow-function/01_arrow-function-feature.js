/**
 * 화살표 함수
 * 화살표 함수는 기존의 함수보다 표현이 간략하며, 내부 동작도 간략하다.
*/

// 1. 화살표 함수는 this를 가지지 않는다.

let theater = 
{
    store: "건대점",
    titles: ["모아나", "하얼빈", "소방관", "라이온킹", "알라딘"],
    
    showMovieList()
    {   
        this.titles.forEach(
            // 화살표 함수 본문에서 this에 접근하면 외부에서 값을 가져오므로, this.store는 theater를 가리킨다.
            title => console.log(`${this.store} : ${title}`));
        // this.titles.forEach(function(title)
        // {
        //     // 화살표 함수가 아닌 일반 함수 안에서의 this는 Global이라고 하는 전역 객체를 가리킨다.
        //     console.log(this);
        //     console.log(`${this.store} : ${title}`);
        // })
    }
}


theater.showMovieList();

// 2. 화살표 함수는 new와 함께 호출할 수 없다.
// this가 없기 때문에 생성자 함수로 사용할 수 없다.
// 화살표 함수로는 인스턴스를 생성할 수 없다.

const arrowFunc = () => {};
// new arrowFunc();

// 3. 화살표 함수는 arguments를 지원하지 않는다.

(function()
{
    const arrowFunc = () => console.log(arguments); 
    arrowFunc(3, 4);

}(1,2));

// 결과는 [Arguments] { '0': 1, '1': 2 } 이렇게 나오는데
// 화살표 함수는 본인의 arguments가 아닌 상위 스코프인 즉시 실행 함수의 arguments 1, 2를 가리키게 된다.

// 즉시 실행 함수
// (function() { 실행할 구문 }(매개변수 전달));

/**
 * 화살표 함수는 다른 함수의 인수로 전달되어 콜백함수로 사용되는 경우가 많다.
 * 위의 특징들은 콜백함수 내부의 this가 외부함수의 this와 다르기 때문에 발생하는 문제를 해결하기 위해
 * 의도적으로 설계된 것이라 할 수 있다.
 */