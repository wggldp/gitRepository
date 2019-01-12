package com.example.design.decorater;

public class Person implements Componet {
    private String name;
    public Person(){

    }
    public Person(String name ){
        this.name=name;
    }

    @Override
    public void show() {
        System.out.println("装饰:"+name);
    }
}
