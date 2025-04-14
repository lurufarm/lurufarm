package com.ohgiraffers.section02.looping;

public class Application {
    public static void main(String[] args) {

        A_for a = new A_for();
//        a.simpleForStatement();
//        a.testForExample1();
//        a.testForExample2();
//        a.testForExample3();
//        a.testForExample4();

        B_nestedFor b = new B_nestedFor();
//        b.printGugudan();
//        b.printStarInputRow();

        C_while c = new C_while();
//        c.simpleWhileStatement();
//        c.testWhileSample1();
//        c.testWhileSample2();
        D_doWhile d = new D_doWhile();
//        d.simpleDoWhileStatement();

        // 문제
        b.printStarTraining();
        c.testWhileSample3();
        d.testDoWhileSample();
    }
}
