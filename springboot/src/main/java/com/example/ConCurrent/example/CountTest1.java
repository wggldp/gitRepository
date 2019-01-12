package com.example.ConCurrent.example;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class CountTest1 {

    private static  int threadTootal=200;
    private static int clientTotal=5000;
   private static Map<Integer,Integer> map=new HashMap<>();
    private static  long count=0;
    public static void main(String[] args) throws InterruptedException {
      ExecutorService exec= Executors.newCachedThreadPool();
      final Semaphore semp=new Semaphore(threadTootal);
      final  CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int index=0;index<clientTotal;index++){
            exec.execute(()->{
                try {
                    semp.acquire();
                    func();
                    semp.release();
                    countDownLatch.countDown();
                }catch (Exception e){
                    e.printStackTrace();
                }
            });
        }
        countDownLatch.await();
        exec.shutdown();

    }
    public static void func(){
        count++;
    }
}
