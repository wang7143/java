package Threadt.threadnew;
/**
 * 创建线程的方式三：实现Callable接口
 * 
 * 1.call()可以返回值
 * 2.call()可以抛出异常，并且捕获
 * 3.Callable支持泛型
 */
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadNew1 {
    public static void main(String[] args) {
        NumThread num = new NumThread();
        //
        FutureTask task = new FutureTask<Integer>(num);

        new Thread(task).start();

        try { 
            //get()返回线程值
            Object sum = task.get();
            System.out.println(sum);
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}


class NumThread implements Callable<Integer>{
    //重写Callable中的run方法。
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            if(i % 2 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
    
}