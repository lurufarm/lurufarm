package com.ohgiraffers.section01.conditional;

public class Application {
    public static void main(String[] args) {

        A_if a = new A_if();
//        a.simpleIfStatement();
//        a.nestedIfStatement();

        B_ifElseIf b = new B_ifElseIf();
//        b.simpleIfElseStatement();
//        b.nestedIfElseIfStatement();

        C_switch c = new C_switch();
//        c.simpleSwitchStatement();
        c.switchVendingMachine();
    }

}

