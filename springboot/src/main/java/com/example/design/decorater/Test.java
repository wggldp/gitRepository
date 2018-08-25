package com.example.design.decorater;

import java.util.HashMap;
import java.util.Random;

public class Test {

    public static  void searchNumCount(Integer number){
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int j=0;j<100000000;j++){
            Random rd = new Random();
            int key = rd.nextInt(10000);
            Integer val = map.get(key);
            if(val != null){
                val = val + 1;
                map.put(key,val);
            }else{
                map.put(key,1);
            }
        }
        System.out.println("次数:"+map.get(number));

    }
    public static void main(String[] args) {
            searchNumCount(1000);
    }
}
