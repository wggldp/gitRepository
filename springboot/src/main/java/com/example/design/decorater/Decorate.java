package com.example.design.decorater;

public class Decorate implements Componet{
    private  Componet componet;

    public Decorate(Componet componet){
        this.componet=componet;
    }

    @Override
    public void show() {
        this.componet.show();
    }
}
