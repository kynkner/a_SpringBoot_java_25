package com.example.demoapp.controller;


import com.example.demoapp.model.Book;
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

    private List<Book> books = new ArrayList<>(List.of(
            new Book(1, "askdbas", "askbdas", 2005),
            new Book(2, "baksjbdn", "baskjdb", 2008),
            new Book(3, "casdasd", "casdasda", 2009)
    ));

    // lấy danh sách tất cả sách
    @GetMapping("/books")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED) //201
    public List<Book> getAllBooks() {
        return books;
    }

    // lấy sách theo id
    @GetMapping("/books/{id}")
    @ResponseBody
    public Book getBookById(@PathVariable int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
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
        books.sort((o1, o2) -> o2.getYear() - o1.getYear());
        return ResponseEntity.ok(books);
    }
    //2. Tìm kiếm danh sách theo tên(trang tên chứa từ khóa bất kỳ)
    @GetMapping("/searchByTitle/{keyword}")
    public ResponseEntity<List<Book>> searchByTitle(@PathVariable String keyword) {
        List<Book> reslut = new ArrayList<>();
        for (Book book : books){
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())){
                reslut.add(book);
            }
        }
        return ResponseEntity.ok(reslut);
    }
    //3. Tìm kiếm sách được xuất bản trong khoảng thời gian(fromYear, toYear)
    @GetMapping("/searchByYear/fromYear/{fromYear}/toYear/{toYear}")
    public ResponseEntity<List<Book>> searchByYear(@PathVariable int fromYear, @PathVariable int toYear) {
        List<Book> reslut = new ArrayList<>();
        for (Book book : books){
            if (book.getYear() >= fromYear && book.getYear() <= toYear){
                reslut.add(book);
            }
        }
        return ResponseEntity.ok(reslut);
    }
}
