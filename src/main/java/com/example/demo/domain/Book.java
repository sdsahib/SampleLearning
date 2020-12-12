package com.example.demo.domain;


import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.*;

/*
 ** @author: Sahib Singh created on 2020-12-05
 */
//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
//POJO -> plain old java object

@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String author;
    private String subject;
    private int pages;
    private double price;
}
