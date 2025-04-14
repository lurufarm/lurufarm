package com.ohgiraffers.section01.list.run;

import com.ohgiraffers.section01.list.comparator.AscendingPrice;
import com.ohgiraffers.section01.list.dto.BookDTO;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Application2 {
    public static void main(String[] args) {
        /** ArrayList 사용자 정의 자료형으로 이용하기 */

        List<BookDTO> bookList = new ArrayList<>();

        bookList.add(new BookDTO(1, "홍길동전", "허균", 50000));
        bookList.add(new BookDTO(2, "목민심서", "정약용", 30000));
        bookList.add(new BookDTO(3, "동의보감", "허준", 40000));
        bookList.add(new BookDTO(4, "삼국사기", "김부식", 46000));
        bookList.add(new BookDTO(5, "삼국유사", "일연", 58000));

//        for (BookDTO book : bookList)
//        {
//            System.out.println(book);
//        }

        /** 제네릭 타입 제한에 의해 Comparable 타입을 가지고 있는 경우에만 sort가 가능하다.
         * EX) String 클래스는 implements Comparable (정렬 기준을 구현) 되었기 때문에 사용 가능했다. */
//        Collections.sort(bookList);

        /** 가격 오름차순 정렬
         * AscendingPrice 클래스 생성 (Comparator 인터페이스를 구현하여 정렬 기준을 작성한다.)
         */

        Collections.sort(bookList, new AscendingPrice());

//        for (BookDTO book : bookList)
//        {
//            System.out.println(book);
//        }

        /** 가격 내림차순 정렬
         * 익명클래스
         * 정렬 기준을 계속해서 사용하는 경우, AscendingPrice 클래스를 만든 것처럼 클래스를 생성해도 되지만
         * 한 번만 사용하기 위해서는 조금 더 간편하게 익명클래스를 사용할 수 있다.
         */

        Collections.sort(bookList, new Comparator<BookDTO>() {
            @Override
            public int compare(BookDTO o1, BookDTO o2) {
                /** 가격 내림차순 정렬 조건
                 * o2의 가격이 더 큰 경우에 양수를 반환하여 swap하라는 flag를 전달한다. */
                return o1.getPrice() >= o2.getPrice() ? -1 : 1;
            }
        });

//        for (BookDTO book : bookList)
//        {
//            System.out.println(book);
//        }

        /** 제목 오름차순 정렬 */
        bookList.sort(new Comparator<BookDTO>() {
            @Override
            public int compare(BookDTO o1, BookDTO o2) {
                /** 문자열 대소비교는 String 클래스에 정의 된 compareTo() 메소드를 활용한다.
                 * 앞의 값이 더 작은 경우 음수를 반환하고, 같으면 0, 앞의 값이 큰 경우 양수를 반환한다. */
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });

//        for (BookDTO book : bookList)
//        {
//            System.out.println(book);
//        }

        /** 제목 내림차순 정렬 */
        bookList.sort(new Comparator<BookDTO>() {
            @Override
            public int compare(BookDTO o1, BookDTO o2) {
                return o2.getTitle().compareTo(o1.getTitle());
            }
        });

        for (BookDTO book : bookList)
        {
            System.out.println(book);
        }

    }
}