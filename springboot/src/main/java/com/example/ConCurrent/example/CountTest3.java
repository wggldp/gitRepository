package com.example.ConCurrent.example;

import java.util.concurrent.atomic.AtomicReference;

public class CountTest3 {

    private  static AtomicReference count=new AtomicReference(0);

    public static void main(String[] args) {
        count.compareAndSet(0,2);
        count.compareAndSet(2,4);
        count.compareAndSet(4,6);
        System.out.println(count);
    }
}
