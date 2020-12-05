package com.example.demo.domain;


import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.springframework.lang.NonNull;

/*
 ** @author: Sahib Singh created on 2020-12-05
 */
//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor

@Data
public class Book {
    private String name;
    private String author;
    private String subject;
    private int pages;
    private double price;
}
