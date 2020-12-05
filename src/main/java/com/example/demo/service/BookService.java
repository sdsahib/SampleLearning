package com.example.demo.service;


import com.example.demo.domain.Book;
import org.springframework.stereotype.Service;

/*
 ** @author: Sahib Singh created on 2020-12-05
 */
@Service
public class BookService {

    public String postBook(Book book){
        System.out.println(book.getAuthor());
        System.out.println(book.getName());
        return book.toString();
    }

}
