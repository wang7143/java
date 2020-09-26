package Threadt;



public class windowsTest {
    public static void main(String[] args) {
        windows t1 = new windows();
        windows t2 = new windows();
        windows t3 = new windows();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }

    

}

class windows extends Thread{
    private static int ticket = 100;
    // private static Object foo = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (windows.class) {
                if( ticket > 0){
                    System.out.println(getName() + ":票号" + ticket);
                    ticket--;
                }else{
                    break;
                }
            }
            
        }
    }
}


