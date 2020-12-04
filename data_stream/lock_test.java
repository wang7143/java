package data_stream;

// public class lock_test implements Runnable{
//     int z = 50;
//     int y = 0;
//     public void run() {
//         while (true) {
//             synchronized(this){
//                 try{
//                     Thread.sleep(50);
//                 }catch(InterruptedException e){
//                     e.printStackTrace();
//                 }
//                 if(z <= 0){
//                     break;
//                 }
//                 z--;
//                 y++;
//                 System.out.println(Thread.currentThread().getName()+"ok");
//             }
//         }
//     }
// }
