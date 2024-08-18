package com.example.demothymeleaf.controller;

import com.example.demothymeleaf.model.Book;
import com.example.demothymeleaf.model.PageRespnseImpl;
import com.example.demothymeleaf.model.PageResponse;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    private List<Book> books = new ArrayList<>(List.of(
            new Book (31, "Fair Stood the Wind for France", "Ms. Ismael Bins", 2012, 12),
            new Book (32, "Fair Stood the Wind for France", "Ms. Ismael Bins", 2012, 18),
            new Book (33, "Fair Stood the Wind for France", "Ms. Ismael Bins", 2012, 14),
            new Book (34, "Fair Stood the Wind for France", "Ms. Ismael Bins", 2012, 27),
            new Book (35, "Fair Stood the Wind for France", "Ms. Ismael Bins", 2012, 15),
            new Book (36, "Fair Stood the Wind for France", "Ms. Ismael Bins", 2012, 16),
            new Book (37, "Fair Stood the Wind for France", "Ms. Ismael Bins", 2012, 22)

    ));

    public BookController() {
        Faker faker = new Faker();
        for (int i = 0; i < 1000; i++) {
            Book book = Book.builder()
                    .id(i + 1)
                    .title(faker.book().title())
                    .author(faker.book().author())
                    .year(faker.number().numberBetween(1950, 2021))
                    .day(faker.number().numberBetween(1, 30))
                    .build();
            books.add(book);
        }
    }

    // http://localhost:8080/index -> Hiển thị templates "index.html"
    @GetMapping("/index")
    public String getHomePage(Model model, @RequestParam(required = false) String title) {
        Book book = books.get(0);
        List<Book> newBooks = new ArrayList<>();
        if(title != null) {
            newBooks = books.stream()
                    .filter(b -> b.getTitle().toLowerCase().contains(title.toLowerCase()))
                    .toList();
        }else {
            newBooks = books;
        }


        model.addAttribute("book", book);
        model.addAttribute("books", newBooks);

        return "index";
    }
    //http://localhost:8080/books
    //http://localhost:8080/books!page=1&size=10
    //currentPage: Trang hien tai
    //pageSize: So luong phan tu tren 1 trang
    //totalElements: Tong so phan tu
    //totalPages: Tong so trang
    //content: Du lieu hien thi o tren trang hien tai

    @GetMapping("/books")
    public String getBooksPage(Model model,
                               @RequestParam(required = false, defaultValue = "1") int page,
                               @RequestParam(required = false, defaultValue = "10") int size) {
        PageResponse<Book> pageResponse = PageRespnseImpl.<Book>builder()
                        .currentPage(page)
                        .pageSize(size)
                        .data(books)
                        .build();

        model.addAttribute("pageResponse", pageResponse);
        return "books";
    }

    @GetMapping("/books/{id}")
    public String getBooksDetail(@PathVariable int id, Model model) {
        Book book = books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
        // phan btvn
        List<Book> newBooks = books.stream()
                .filter(o -> o.getAuthor().equals(book.getAuthor()) && o.getId() != book.getId())
                .sorted((o1, o2) -> o2.getDay() - o1.getDay())
                .limit(4)
                .toList();

        model.addAttribute("book", book);
        model.addAttribute("books", newBooks );
        return "book-detail";
    }

    @GetMapping("/blog")
    public String getBlogPage() {
        return "admin/blog";
    }



}
