package data_stream;

public class lock {
	static String object1 = "Abc"; //创建静态对象object1
	static String object2 = "abd"; //创建静态对象object2
	public static void main(String[] args){
		Thread thread1 = new Thread(()->{
			try {
                int i = 0;
				while(i < 2) {
					synchronized (object1) {
						System.out.println(Thread.currentThread().getName()+"上锁了object1");
						Thread.sleep(1000);
						synchronized (object2) {
							System.out.println(Thread.currentThread().getName()+"上锁了object2");		
						}
                    }
                    i++;
				}
				}catch (Exception e) {
					e.printStackTrace();
				}
	});
		Thread thread2 = new Thread(()-> {
			try {
				while(true) {
					synchronized (object2) {
						System.out.println(Thread.currentThread().getName()+"锁住了object2");
						Thread.sleep(1000);
						synchronized (object1) {
							System.out.println(Thread.currentThread().getName()+"锁住了object1");		
						}
					}
				}
				}catch (Exception e) {
					e.printStackTrace();
				}			
	});		
		thread1.start();
		thread2.start();	
   }
}
