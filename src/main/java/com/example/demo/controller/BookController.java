package com.example.demo.controller;

/*
 ** @author: Sahib Singh created on 2020-12-05
 */

import com.example.demo.domain.Book;
import com.example.demo.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@Slf4j
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getAllBooks() {
       return bookService.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id){
        log.info("getBookByID called with bookid={}",id,id);
        Book value = bookService.getBookById(id);
        if(value ==null)
            return ResponseEntity.status(200).body("Book Not Found");
        return ResponseEntity.status(200).body(value);
    }

    @PostMapping(value = "/book")
    public String postBook(@RequestBody Book book){
        return bookService.postBook(book);
    }

    @DeleteMapping(value = "/book/{id}")
    public String deleteBookById(@PathVariable Long id){
        return bookService.deleteBook(id);
    }

    @PutMapping(value = "/book/{id}")
    public String updateBook(@PathVariable Long id, @RequestBody Book book){
        return bookService.updateBook(id, book);
    }
}
