package com.ohgiraffers.section01.object.book;

import java.util.Objects;

public class Book {

    private int number;
    private String title;
    private String author;
    private int price;

    public Book() {
    }

    public Book(int number, String title, String author, int price) {
        this.number = number;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        /** 주소 값이 같을 경우 동일 객체이므로, 필드 값 확인할 필요 없이 true 반환 */
        if (this == o) return true;
        /** 전달 된 객체가 null이거나 다른 클래스 타입이면 비교할 필요 없이 false 반환 */
        if (o == null || getClass() != o.getClass()) return false;
        /** Book 타입이면서 동일 객체가 아니므로 동등 객체인지 비교 시작 */
        Book book = (Book) o;
        return number == book.number && price == book.price && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }
}
