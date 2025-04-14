package com.ohgiraffers.section01.autowired.constructor;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceConstructor")
public class BookService {

    private final BookDAO bookDAO;

    /** BookDAO 타입의 bean 객체를 생성자에 자동으로 주입해준다. 생성자가 하나만 존재하는 상황에서는 autowired 어노테이션 생략 가능 */
    @Autowired
    public BookService(BookDAO bookDAO)
    {
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> selectAllBooks()
    {
        return bookDAO.selectBookList();
    }

    public BookDTO searchBookBySequence(int sequence)
    {
        return bookDAO.selectOneBook(sequence);
    }
}

