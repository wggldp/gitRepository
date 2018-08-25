package com.example.design.decorater;

public class Finery extends Person {
    protected Person person;
    public void Decorate(Person p){
        this.person=p;
    }
    @Override
    public void show(){
        person.show();
    }
}
