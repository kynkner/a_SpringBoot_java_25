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
    //Sắp xếp books theo năm giảm dần
    @Override
    public List<Book> findBooksSortByYear() {
        return bookDao.findAll().stream()
                .sorted((o1, o2) -> o2.getYear() - o1.getYear())
                .toList();
    }
    //Tìm kiếm danh sách theo tên(trang tên chứa từ khóa bất kỳ)
    @Override
    public List<Book> findBooksByTitle(String keyword) {
        return bookDao.findByTitleContainsIgnoreCase(keyword);
    }
    //Tìm kiếm sách được xuất bản trong khoảng thời gian(fromYear, toYear)
    @Override
    public List<Book> findBooksBeeetweenYears(int startYear, int endYear) {
        return bookDao.findAll().stream()
                .filter(book -> book.getYear() >= startYear && book.getYear() <= endYear)
                .toList();
    }
}
