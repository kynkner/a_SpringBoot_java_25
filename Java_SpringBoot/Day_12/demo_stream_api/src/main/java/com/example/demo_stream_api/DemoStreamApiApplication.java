package com.example.demo_stream_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
* Function interface: là interface chỉ chưa 1 phương thức abstract
* Lambda expression: Được sử dụng để triển khai function interface
* */
@SpringBootApplication
public class DemoStreamApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoStreamApiApplication.class, args);

//        //C1: Su dung class implement Greeting
//        VietNam vietNam = new VietNam();
//        vietNam.sayHello("Dung");
//
//        //C2: Su dung Anonymous class
//        Greeting english = new Greeting() {
//            @Override
//            public void sayHello(String name) {
//                System.out.println("Hello " + name);
//            }
//        };
//        english.sayHello("Nam");
//
//        //C3: Su dung Lambda expression
//        Greeting french = (name) ->{
//            System.out.println("Hello " + name);
//        };
//        french.sayHello("French");
//
//        //Calculator sum of 2 numbers
//        Calulator sum = (a, b) -> {
//            return a + b;
//        };
//        System.out.println("Sum = " + sum.calulate(5, 8));
//
//        // Calculate subtraction of 2 numbers
//        Calulator subtraction = (a, b) -> {
//            return a - b;
//        };
//        System.out.println("Subtraction = " + subtraction.calulate(50, 18));
//
//        //Thao tac voi List
//        List<Integer> numbers = new ArrayList<>(List.of(3 ,5 ,4 ,8 ,9 ,10 ,25 ,36 ,47));
//        numbers.forEach((number) -> System.out.print(number +" "));
//        System.out.println();
//        System.out.print("Xoa so le: ");
//        numbers.removeIf((number) -> number % 2 == 1);
//        numbers.forEach((number) -> System.out.print(number + " "));
//        System.out.println();
//        System.out.print("sap xep giam dan: ");
//        numbers.sort((a, b) -> b - a);
//        numbers.forEach((number) -> System.out.print(number + " "));

        // Stream API
        List<Integer> numbers = new ArrayList<>(List.of(3 ,5 ,4 ,4 ,8 ,8 ,9 ,10 ,25 ,36 ,47));
        int total = numbers.stream()
                .map(number -> number * number)
                .reduce(0, (a, b) -> a + b);
        System.out.println("Tong = " + total);

        int max = numbers.stream()
                .filter(number -> number % 2 == 0)
                .max((a, b) -> a - b)
                .orElse(0);
        System.out.println("Max = " + max);

        int max1 = numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(number -> number)
                .max()
                .orElse(0);
        System.out.println("Max1 = " + max1);


//        7. Lấy danh sách các phần tử không trùng nhau (distinct)
        List<Integer> distinct = numbers.stream()
                .distinct()
                .toList();
        System.out.println("Distinct = " + distinct);
//        8. Lấy 5 phần tử đầu tiên trong mảng (limit)
        List<Integer> limit = numbers.stream()
                .limit(5)
                .toList();
        System.out.println("Limit = " + limit);
//        9. Lấy phần tử từ thứ 3 -> thứ 5 (limit + skip)
        List<Integer> limitSkip = numbers.stream()
                .skip(2)
                .limit(5)
                .toList();
        System.out.println("limitSkip = " + limitSkip);
//        10. Lấy phần tử đầu tiên > 5 (findFirst)
        Optional<Integer> findFirst = numbers.stream()
                .filter(n -> n > 5)
                .findFirst();
        findFirst.ifPresent(first -> System.out.println("First: " + first));
//        11. Kiểm tra xem list có phải là list chẵn hay không (allMatch)
        boolean allMatch = numbers.stream()
                .allMatch(n -> n % 2 == 0);
        System.out.println("allMatch: " + allMatch);
//        12. Kiểm tra xem list có phần tử > 10 hay không (anyMatch)
        boolean anyMatch = numbers.stream()
                .anyMatch(n -> n > 10);
        System.out.println("anyMatch: " + anyMatch);
//        13. Có bao nhiêu phần tử > 5 (count)
        long count = numbers.stream()
                .filter(n -> n > 5)
                .count();
        System.out.println("Count: " + count);
//        14. Nhân đôi các phần tủ trong list và trả về list mới (map)
        List<Integer> map = numbers.stream()
                .map(n -> n * 2)
                .toList();
        System.out.println("Map: " + map);
//        15. Kiểm tra xem list không chứa giá trị nào = 8 hay không (noneMatch)
        boolean noneMatch = numbers.stream()
                .noneMatch(n -> n == 8);
        System.out.println("noneMatch: " + noneMatch);


    }

}
