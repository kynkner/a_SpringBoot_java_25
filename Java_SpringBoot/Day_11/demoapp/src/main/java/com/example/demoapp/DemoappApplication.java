package com.example.demoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/*
*  Bean là gì?
*
* */
@SpringBootApplication
public class DemoappApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoappApplication.class, args);





//		Faker faker = new Faker();
//		System.out.println(faker.name().fullName());
//
//		Book book = new Book();
//		book.setId(1);
//		book.setTitle("asjhbdas");
//		book.setAuthor("ahksdas");
//		book.setYear(2000);
//
//		System.out.println(book);
//
//		Book book2 = Book.builder()
//				.year(1956)
//				.title("jahsbd")
//				.build();
	}

}
