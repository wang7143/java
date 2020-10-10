package Threadt;

public class windwst {
    public static void main(String[] args) {
        windws1 the = new windws1();
        Thread t1 = new Thread(the);
        Thread t2 = new Thread(the);
        Thread t3 = new Thread(the);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
    }
}


class windws1 implements Runnable{

    private int ticket = 100;
    @Override
    public void run() {
        while (true) {
            if(ticket > 0){
                System.out.println(Thread.currentThread().getName()+ "卖票，票号" + ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
    
}








