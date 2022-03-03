package com.myTutorial.bookstore.service;


import com.myTutorial.bookstore.model.Book;
import com.myTutorial.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public Optional<Book>findBookById(Integer bookId){
        return bookRepository.findById(bookId);
    }
}
