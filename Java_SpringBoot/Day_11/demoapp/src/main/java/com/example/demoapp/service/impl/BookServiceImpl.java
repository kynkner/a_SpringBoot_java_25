package com.example.demoapp.service.impl;

import com.example.demoapp.dao.BookDao;
import com.example.demoapp.model.Book;
import com.example.demoapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }

    @Override
    public Book findBookById(int id) {
        return bookDao.findById(id);
    }

    @Override
    public List<Book> findBooksSortByYear() {
        List<Book> books = bookDao.findAll();
        books.sort((o1, o2) -> o2.getYear() - o1.getYear());
        return books;
    }

    @Override
    public List<Book> findBooksByTitle(String keyword) {
        return bookDao.findByTitleContainsIgnoreCase(keyword);
    }

    @Override
    public List<Book> findBooksBeeetweenYears(int startYear, int endYear) {
        List<Book> books = bookDao.findAll();
        List<Book> result = new ArrayList<>();
        for (Book book : books){
            if (book.getYear() >= startYear && book.getYear() <= endYear){
                result.add(book);
            }
        }
        return result;
    }
}
