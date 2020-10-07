package Threadt.threadcommunication;


/**
 * todo wait() notify() notifyall()必须出现在同一代码块中。并且调用者必须相同，监视器必须相同，否者会出现java.lang.IllegalMonitorStateException
 * *上面三个方法定义在object类中。
 * sleep() 不会释放同步监视器， wait()会释放
 */
public class test1 {
    public static void main(String[] args) {
        number number = new number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}

class number implements Runnable {

    private int number = 1;
    Object foo = new Object();
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            synchronized (this) {
                notify();  //唤醒被wait() 的线程，多个wait()唤醒最先被wait()
                if (number <= 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        wait();//当前线程进入阻塞状态，释放同步监视器
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                else{
                    break;
                }
            }
        }
    }
    
}