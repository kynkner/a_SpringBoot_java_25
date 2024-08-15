package com.example.demoapp.dao.impl;

import com.example.demoapp.dao.BookDao;
import com.example.demoapp.database.BookDB;
import com.example.demoapp.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {
    @Override
    public List<Book> findAll() {
        return BookDB.books;
    }
    //Loc du lieu theo id
    @Override
    public Book findById(int id) {
        return BookDB.books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }
    //Loc du lieu theo title co keyword bat ky
    @Override
    public List<Book> findByTitleContainsIgnoreCase(String keyword) {
        return BookDB.books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(keyword))
                .toList();
    }
}
