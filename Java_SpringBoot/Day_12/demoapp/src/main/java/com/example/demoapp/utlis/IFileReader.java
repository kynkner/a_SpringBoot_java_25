package com.example.demoapp.utlis;

import com.example.demoapp.model.Book;

import java.util.List;

public interface IFileReader {
    List<Book> readFile(String path);
}
