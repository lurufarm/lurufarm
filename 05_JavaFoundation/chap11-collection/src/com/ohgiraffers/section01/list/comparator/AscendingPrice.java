package com.ohgiraffers.section01.list.comparator;

import com.ohgiraffers.section01.list.dto.BookDTO;

import java.util.Comparator;

public class AscendingPrice implements Comparator<BookDTO> {

    /** sort() 메소드에서 내부적으로 compare 메소드를 호출하여 swap여부를 결정한다.
     * Comparator 인터페이스를 상속받으면 compare 메소드 오버라이딩이 강제화된다. */
    @Override
    public int compare(BookDTO o1, BookDTO o2) {

        /** 가격이 오름차순 정렬이 되기 위해서는 앞의 가격이 더 작은 가격이어야 한다.
         * 만약 뒤의 가격이 더 작은 경우, 두 인스턴스의 순서를 바꾸어야 한다.
         * 그 때 두 값을 바꾸라는 신호로 양수를 반환하면 정렬 시 순서를 바꾸는 조건으로 사용된다. */

        int result = 0;

        if(o1.getPrice() > o2.getPrice())
            result = 1;
        else if (o1.getPrice() < o2.getPrice())
            result = -1;
        else
            result = 0;

        return result;
    }
}
