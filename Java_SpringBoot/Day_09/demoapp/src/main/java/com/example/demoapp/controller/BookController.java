package com.example.demoapp.controller;


import com.example.demoapp.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
/*
Controller: Nơi tiếp nhận request từ client, xử lý và trả về response
   - @Controller: Các Controller trả về Template(Giao diện). Ngoài ra có thể trả về dữ liệu Json, XML,...
   - @RestController: Các Controller trả về dữ liệu dạng Json
*/
@RestController
public class BookController {

    private List<Book> books = new ArrayList<>(List.of(
            new Book(1, "askdbas", "askbdas", 2005),
            new Book(2, "baksjbdn", "baskjdb", 2008),
            new Book(3, "casdasd", "casdasda", 2009)
    ));
    // lấy danh sách tất cả sách
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return books;
    }

    // lấy sách theo id
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
