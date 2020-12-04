package data_stream;

public class Test {
    public static void main(String[] args) {
        lock_test foo = new lock_test();
        Thread t = new Thread(foo, "1");
        Thread b = new Thread(foo, "2");
        Thread c = new Thread(foo, "3");

        t.start();
        b.start();
        c.start();
    }
}

class lock_test implements Runnable {
    // int z;
    // int y;
    private static int count;
    public lock_test() {
        // z = 50;
        // y = 1;
        count = 0;
    }
    public void run() { 
        
        synchronized (this) {
            for (int i = 0;i < 20; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public int getCount() {
        return count;
    }
}

