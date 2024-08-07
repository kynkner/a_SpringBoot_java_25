package com.example.demoapp;

import com.example.demoapp.model.Book;
import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoappApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoappApplication.class, args);

		Faker faker = new Faker();
		System.out.println(faker.name().fullName());

		Book book = new Book();
		book.setId(1);
		book.setTitle("asjhbdas");
		book.setAuthor("ahksdas");
		book.setYear(2000);

		System.out.println(book);

		Book book2 = new Book();


	}

}
