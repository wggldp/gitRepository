package com.example.commonUnsafe;

import com.example.ConCurrent.annotations.ThreadSafe;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@ThreadSafe
public class DateFormat {

    private static DateTimeFormatter dateTimeFormatter= DateTimeFormat.forPattern("yyyy-MM-dd");
    private static Logger logger=LoggerFactory.getLogger(StringExamples.class);
    private static  int threadTootal=200;
    private static int clientTotal=5000;
    private static Map<Integer,Integer> map=new HashMap<>();
    private static  long count=0;



    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec= Executors.newCachedThreadPool();
        final Semaphore semp=new Semaphore(threadTootal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int index=0;index<clientTotal;index++){
            exec.execute(()->{
                try {
                    semp.acquire();
                    func();
                    semp.release();

                }catch (Exception e){
                    e.printStackTrace();
                }
                countDownLatch.countDown();

            });
        }
        countDownLatch.await();
        exec.shutdown();
    }

    public static void func(){
        try {
            logger.info(DateTime.parse("2019-10-10",dateTimeFormatter).toDate().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
