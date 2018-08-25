package com.example.design;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestMain {
    static class LinkList{
        LinkList(int a){

        }
    }
    public static void main(String[] args) {

        List<Integer> list=new ArrayList();
        Date date1=new Date();
        for (int i=0;i<10000000;i++){
            list.add(i);
        }
        Date date2=new Date();
        System.out.println((date2.getTime()-date1.getTime()));

        int a=0;
        date1=new Date();
        for (int i=0;i<10000000;i++) {
            if (list.get(i)==100){
                a=100000;
                break;
            }
        }
        date2=new Date();
        System.out.println((date2.getTime()-date1.getTime()));
    }

}
