package com.example.demoapp.database;

import com.example.demoapp.utlis.IFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitDB implements CommandLineRunner {
    @Qualifier("excelFileReader")
//    @Qualifier("CSVFileReader")
//    @Qualifier("jsonFileReader")
    @Autowired
    private IFileReader fileReader;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("InitDB.run");

        BookDB.books = fileReader.readFile("books.xlsx");
//        BookDB.books = fileReader.readFile("books.csv");
//        BookDB.books = fileReader.readFile("books.json");
        System.out.println(BookDB.books.size());
    }
}
