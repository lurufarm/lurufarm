package com.ohgiraffers.section02.variable;

public class Application3 {
    public static void main(String[] args) {
        /*
         * 변수의 명명 규칙
         * 1. 컴파일 에러를 발생시키는 규칙
         *   1-1. 동일한 범위 내에서 동일한 변수명을 가질 수 없다.
         *   1-2. 예약어는 사용이 불가능하다. (자바에서 미리 사용하겠다고 compiler와 약속한 키워드)
         *   1-3. 변수명은 대/소문자를 구분한다.
         *   1-4. 변수명은 숫자로 시작할 수 없다.
         *   1-5. 특수 기호는 '_'와 '$'만 사용 가능하다. (공백을 사용할 수 없다.)
         * 2. 컴파일 에러를 발생시키지는 않지만, 개발자들끼리의 암묵적인 규칙
         *   2-1. 변수명의 길이 제한은 없지만, 적당한 길이를 쓰는게 좋다.
         *   2-2. 변수명이 합성어로 이루어진 경우, 첫 단어는 소문자, 두 번째 시작 단어는 대문자로 작성(CamelCase)
         *   2-3. 한글로 변수명을 짓는 것이 가능하나, 권장하지 않는다. (에러를 유발할 수 있음)
         *   2-4. 변수 안에 저장된 값이 어떤 의미를 가지는지 명확하게 표현하도록 한다.
         *   2-5. boolean 형은 의문문으로 가급적 긍정형태로 네이밍한다.
         */


        // 동일한 범위 내에서 동일한 변수명을 가질 수 없다.
        int age = 20;
//        int age = 30;

        // 예약어는 사용 불가
//        int true = 1;
//        int for = 20;
    
        // 변수명은 대소문자를 구분한다.
        int Age = 20;   // 위에서 만든 age와 다른 변수로 취급
        int True = 10;
        
        // 변수명은 숫자로 시작할 수 없다.
//        int 1age = 20;    // 숫자로 시작해서 에러 발생 
        int age1 = 20;      // 숫자가 첫 글자가 아니면 섞어서 사용 가능

        // 특수기호는 '_'과 '$'만 사용 가능

//        int sh@rp = 20;
        int _age = 20;
        int $harp = 20;
//        int a ge = 20; // 공백 사용 불가

        int asdjfksjdfkljsdkfjsdkfljsdkljfskdljfskdljfksldjfklaskdjaklwjiejaslfdkjdf;

        // 카멜케이스
        // 자바에서는 클래스명만 유일하게 대문자로 시작한다.
        int maxAge = 20;
        String user_name; // 에러가 발생하지는 않지만, 이런 변수명을 사용하는 것을 지양한다.

        int 나이; // 한글 변수명은 사용하지 않는다.

        String s;
        String name; // 문자열 형태의 이름을 저장하는 변수임을 파악할 수 있다.

        // 전형적인 변수 이름이 있다면, 가급적 사용한다.
        int sum = 0;
        int max = 10;
        int min = 0;
        int count = 1;

        // boolean 형은 의문문으로 가급적 긍정형태로 네이밍
        boolean isAlive = true;
        boolean isDead = false; // 부정형보다는 긍정형을 선호함

    }
}
