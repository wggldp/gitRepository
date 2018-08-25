package com.example.design.singlefactory;

public class Test {


    public static void main(String[] args) {
        Api api = TestFactory.createApi();
        api.say();
    }
}
