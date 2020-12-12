package com.example.demo.repository;

/*
 ** @author: Sahib Singh created on 2020-12-12
 */

import com.example.demo.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRespository extends CrudRepository<Book,Long> {
}
