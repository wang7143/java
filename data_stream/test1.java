package data_stream;

public class test1 {
    public static void main(String[] args) {
        Runnable rt = new RunThread();
        for (int i = 1; i <=3; i++) {
            new Thread(rt,(i)+"号选手").start();
        }
    }
}


class RunThread implements Runnable{
    public int maters = 100;
    public void run() {
        while (true) {
            if(!go()){
                break;
            }

        }
    }
    //同步方法：跑步（每人跑100米）
    public synchronized boolean go() {
        if (maters <= 0) {
            return false;
        }
        System.out.println(Thread.currentThread().getName() + "拿到接力棒！");
        for (int i = 0; i < 100; i += 10) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "跑了" + (i + 10) + "米！");
        }
        maters-=100;
        System.out.println("还剩"+maters);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}