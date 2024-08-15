package com.example.demothymeleaf.controller;

import com.example.demothymeleaf.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    private List<Book> books = new ArrayList<>(List.of(
            new Book(1, "askdbas", "askbdas", 2005),
            new Book(2, "baksjbdn", "baskjdb", 2008),
            new Book(3, "casdasd", "casdasda", 2009)
    ));
    // http://localhost:8080/index -> Hiển thị templates "index.html"
    @GetMapping("/index")
    public String getHomePage(Model model) {
        Book book = books.get(0);
        model.addAttribute("book", book);
        return "index";
    }
    @GetMapping("/blog")
    public String getBlogPage() {
        return "admin/blog";
    }



}
