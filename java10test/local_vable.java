package java10test;

import java.util.ArrayList;

import org.junit.Test;

public class local_vable {
    
    @Test
    public void test1() {
        //局部变量推断
        var num = 10;

        var li = new ArrayList<>();

        li.add(123);

        for (var i : li) {
            System.out.println(i);
            System.out.println(i.getClass());
        }

        for (var i = 0; i < 100; i++) {
            
        }
    }

    @Test
    public void test2() {
        //var推断必须赋值
        var num = "hello";
        //lambda表达式不能使用var和函数式接口
        

    }
}
