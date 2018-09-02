package com.example.commonUnsafe;

import com.example.ConCurrent.annotations.ThreadSafe;
import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@ThreadSafe
public class ArrayListExample {

    private static Logger logger=LoggerFactory.getLogger(StringExamples.class);
    private static  int threadTootal=200;
    private static int clientTotal=5000;
    private static Map<Integer,Integer> map=new HashMap<>();
    private static List list=Collections.synchronizedList(Lists.newArrayList()) ;


    public static void main(String[] args) throws InterruptedException {
        Vector<Integer> vector=new Vector();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        for (int i=0 ;i<vector.size();i++){
            if(vector.get(i)==1){
                vector.remove(i);
            }
        }

//        ExecutorService exec= Executors.newCachedThreadPool();
//        final Semaphore semp=new Semaphore(threadTootal);
//        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
//        for (int index=0;index<clientTotal;index++){
//            int finalIndex = index;
//            exec.execute(()->{
//                try {
//                    semp.acquire();
//                    func(finalIndex);
//                    semp.release();
//
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//                countDownLatch.countDown();
//
//            });
//        }
//        countDownLatch.await();
//        exec.shutdown();
        logger.info("Size:{}",vector.size());
    }

    public static void func(int i){
        list.add(i);
    }
}
