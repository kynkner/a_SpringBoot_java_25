package com.example.demoapp.service;

import com.example.demoapp.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book findBookById(int id);

    List<Book> findBooksSortByYear();

    List<Book> findBooksByTitle(String keyword);

    List<Book> findBooksBeeetweenYears(int startYear, int endYear);


}
