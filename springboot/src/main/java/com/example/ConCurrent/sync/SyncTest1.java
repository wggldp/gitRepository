package com.example.ConCurrent.sync;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SyncTest1 {

    public void test1(){
        synchronized (this){
            for (int i=0;i<10;i++){
                System.out.println("test1"+i);
            }
        }
    }

    public synchronized  void test2(){
        for (int i=0;i<10;i++){
            System.out.println("test2"+i);
        }
    }
    private static final Map aa= new HashMap();
    static {
        aa.put("11","22");
    }
    public static void main(String[] args) {
        aa.put("11","33");
        System.out.println(aa.get("11"));
        SyncTest1 syncTest1=new SyncTest1();
        SyncTest1 syncTest2=new SyncTest1();
        ExecutorService exec= Executors.newCachedThreadPool();
        exec.execute(()->{
            syncTest1.test1();
        });
        exec.execute(()->{
            syncTest2.test1();
        });
    }
}
