package com.example.demoapp.controller;


import com.example.demoapp.model.Book;
import com.example.demoapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/*
Controller: Nơi tiếp nhận request từ client, xử lý và trả về response
   - @Controller: Các Controller trả về Template(Giao diện). Ngoài ra có thể trả về dữ liệu Json, XML,...
   - @RestController: Các Controller trả về dữ liệu dạng Json
   - @RestController = @Controller + @ResponseBody
   - @ResponseBody: Chỉ trả về dữ liệu, không trả về Template, Dữ liệu trả về có thể là Json, XML,...
   - @ResponseEntity<?>: Class đại diện cho 1 đối tượng response, có thể set status code, header,...
*/
@Controller
@RequestMapping
public class BookController {
    @Autowired
    private BookService bookService;

//    // lấy danh sách tất cả sách
    @GetMapping("/books")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED) //201
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.CREATED);
    }

    // lấy sách theo id
    @GetMapping("/books/{id}")
    @ResponseBody
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Book book = bookService.findBookById(id);
            if (book == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    //1. Viết API sắp xếp books theo năm giảm dần
    @GetMapping("/sortByYear")
    public ResponseEntity<List<Book>> sortByYear() {
//        books.sort(new Comparator<Book>() {
//            @Override
//            public int compare(Book o1, Book o2) {
//                return o2.getYear() - o1.getYear();
//            }
//        });
        return new ResponseEntity<>(bookService.findBooksSortByYear(), HttpStatus.OK);
    }

    //2. Tìm kiếm danh sách theo tên(trang tên chứa từ khóa bất kỳ)
    @GetMapping("/searchByTitle/{keyword}")
    public ResponseEntity<List<Book>> searchByTitle(@PathVariable String keyword) {
        return ResponseEntity.ok(bookService.findBooksByTitle(keyword));
    }

    //3. Tìm kiếm sách được xuất bản trong khoảng thời gian(fromYear, toYear)
    @GetMapping("/searchByYear/fromYear/{fromYear}/toYear/{toYear}")
    public ResponseEntity<List<Book>> searchByYear(@PathVariable int fromYear, @PathVariable int toYear) {
       return ResponseEntity.ok(bookService.findBooksBeeetweenYears(fromYear, toYear));
    }
}
