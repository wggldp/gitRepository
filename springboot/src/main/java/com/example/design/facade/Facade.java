package com.example.design.facade;

import com.example.design.facade.impl.ModelAImpl;
import com.example.design.facade.impl.ModelBImpl;

public class Facade {
    public  void test(){

        ModeA ma=new ModelAImpl();
       ma.say();
        ModelB mb=new ModelBImpl();
        mb.say();
    }
}
