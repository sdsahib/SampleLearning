package com.example.demo.service;


import com.example.demo.domain.Book;
import com.example.demo.repository.BookRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
 ** @author: Sahib Singh created on 2020-12-05
 */
@Service
@Slf4j
public class BookService {

    @Autowired
    private BookRespository bookRespository;

    public String postBook(Book book){
        try {
            Book b = bookRespository.save(book);
            return "Saved";
        }catch(DataAccessException ex){
            log.error(ex.toString());
            return "Not Saved";
        }
    }

    public List<Book> getAllBooks(){
        return (List<Book>) bookRespository.findAll();
    }

    public Book getBookById(Long id){
        Optional<Book> optionalBook = bookRespository.findById(id);
        if(optionalBook.isPresent()){
            return optionalBook.get();
        }
        return null;
    }
    public String deleteBook(Long id){
        try {
            bookRespository.deleteById(id);
            return "deleted Successfully";
        }catch(DataAccessException ex){
            return "Unable to delete";
        }
    }

    public String updateBook(Long id, Book book) {
        try{
            Optional<Book> toUpdate = bookRespository.findById(id);
            if(toUpdate.isPresent()){
                Book old = toUpdate.get();
                old.setName((book.getName()!=null)? book.getName(): old.getName());
                old.setAuthor((book.getAuthor()!=null)? book.getAuthor(): old.getAuthor());
                old.setPages((book.getPages() != 0 )? book.getPages(): old.getPages());
                old.setPrice((book.getPrice() !=0.0)? book.getPrice(): old.getPrice());
                old.setSubject((book.getSubject()!=null)? book.getSubject(): old.getSubject());

                bookRespository.save(old);
                return "Book Saved";
            }
            return "No Book found with id = " + id + " to Update";
        }catch(DataAccessException ex){
            return "Unable to Update";
        }
    }
}
