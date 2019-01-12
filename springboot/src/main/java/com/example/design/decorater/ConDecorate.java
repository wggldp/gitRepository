package com.example.design.decorater;

public class ConDecorate extends Decorate {
    public ConDecorate(Componet componet) {
        super(componet);
    }

    public void show(){
        System.out.println("11111111111111");
        super.show();

    }
}
