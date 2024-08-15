package com.example.demo_stream_api;

public class VietNam implements Greeting {

    @Override
    public void sayHello(String name) {
        System.out.println("Xin chao "+ name);
    }
}
