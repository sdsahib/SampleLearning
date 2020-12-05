package com.example.demo.controller;

/*
 ** @author: Sahib Singh created on 2020-12-05
 */

import com.example.demo.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@Slf4j
public class Book {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getBook() {
        return "GetBook call";
    }

    @GetMapping("/book/{bookName}")
    public String getBookName(@PathVariable String bookName){
        System.out.println("Book Name: " + bookName);
        return "BookName received "+ bookName;
    }

    @PostMapping(value = "/book")
    public String postBook(@RequestBody com.example.demo.domain.Book book){
        return bookService.postBook(book);
    }


}
