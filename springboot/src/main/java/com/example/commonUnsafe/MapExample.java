package com.example.commonUnsafe;

import com.example.ConCurrent.annotations.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;



@ThreadSafe
public class MapExample {

    private static Logger logger=LoggerFactory.getLogger(StringExamples.class);
    private static  int threadTootal=200;
    private static int clientTotal=5000;
    private static Map<Integer,Integer> map=new HashMap<>();
    private static Map list=new HashMap();


    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec= Executors.newCachedThreadPool();
        final Semaphore semp=new Semaphore(threadTootal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int index=0;index<clientTotal;index++){
            int finalIndex = index;
            exec.execute(()->{
                try {
                    semp.acquire();
                    func(finalIndex);
                    semp.release();

                }catch (Exception e){
                    e.printStackTrace();
                }
                countDownLatch.countDown();

            });
        }
        countDownLatch.await();
        exec.shutdown();
        logger.info("Size:{}",list.size());
    }

    public static void func(int i){
        list.put(i,i);
    }
}
