package Threadt.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class tpool {
    public static void main(String[] args) {
        ExecutorService ser = Executors.newFixedThreadPool(10);
        Num t1 = new Num();
        Num1 t2 = new Num1();
        ser.execute(t1); //适用于Runnable
        ser.execute(t2);

        //ser.submit(arg0) 可以使用callable方法
        ser.shutdown();
        
    }
}


class Num implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}


class Num1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + i);
            }
        }
    }
}
