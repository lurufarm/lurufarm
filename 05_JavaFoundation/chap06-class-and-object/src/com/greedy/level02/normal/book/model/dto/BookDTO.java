package com.greedy.level02.normal.book.model.dto;

import java.awt.print.Book;

public class BookDTO {
    private String title;
    private String publisher;
    private String author;
    private int price;
    private double discountRate;

    public BookDTO() {}

    public BookDTO(String title, String publisher, String author)
    {
        this.title = title;
        this.publisher = publisher;
        this.author = author;
    }

    public BookDTO(String title, String publisher, String author, int price, double discountRate)
    {
        this(title, publisher, author);
        this.price = price;
        this.discountRate = discountRate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public String getAuthor() {
        return this.author;
    }

    public void printInformation()
    {
        System.out.println(this.title + ", " + this.publisher + ", " + this.author + ", " + this.price + ", " + this.discountRate);
    }

}
