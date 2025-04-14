package com.ohgiraffers.section01.list.run;

import javax.swing.*;
import java.util.Stack;

public class Application4 {
    public static void main(String[] args) {
        /** stack에 대해 이해하고 사용할 수 있다.
         * 후입선출(LIFO = Last Input First Out) 방식의 자료구조이다. */

        Stack<Integer> integerStack = new Stack<>();

        /** stack에 값을 넣을때는 push() 메소드를 사용한다. */

        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(4);
        integerStack.push(5);

        /** stack에서 요소를 찾을 때 search() 메소드를 사용할 수 있다.
         * 인덱스가 아닌 위에서부터의 순번을 의미하며, 가장 상단의 위치는 0이 아닌 1부터 시작한다. */
        System.out.println("intergerStack: " + integerStack.search(5)); // 5를 마지막에 넣어서 콘솔에 1로 출력됨

        /** stack에서 값을 꺼내는 메소드는 크게 2가지이다.
         * peek(): 해당 스택의 가장 마지막(상단)에 있는 요소 반환
         * pop(): 가장 마지막(상단)에 있는 요소 반환 후 제거 */
        System.out.println("peek(): " + integerStack.peek());
        System.out.println(integerStack);

        System.out.println("pop(): " + integerStack.pop());
        System.out.println("pop(): " + integerStack.pop());
        System.out.println("pop(): " + integerStack.pop());
        System.out.println("pop(): " + integerStack.pop());
        System.out.println("pop(): " + integerStack.pop());
//        System.out.println("pop(): " + integerStack.pop());
        /** 꺼내면서 요소를 제거하기 때문에 스택이 비어있는 상태에서 계속해서 pop을 하면 EmptyStackException이 발생한다. */
        System.out.println(integerStack);
    }
}
