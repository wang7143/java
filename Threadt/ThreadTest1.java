package Threadt;

public class ThreadTest1 {
    public static void main(String[] args) {
        Mthread the = new Mthread();
        Thread t1 = new Thread(the);
        
        t1.start();

        Thread t2 = new Thread(the);

        t2.start();
    }
}


class Mthread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() +":"+ i);
            }
        }

    }
    
}