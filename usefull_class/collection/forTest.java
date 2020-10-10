package usefull_class.collection;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

public class forTest {
    @Test
    public void Test() {
        Collection foo = new ArrayList();
        foo.add(123);
        foo.add(456);
        foo.add(new String("Tom"));
        foo.add(false);

        for(Object obj : foo){
            System.out.println(obj);
        }
    }

    @Test
    public void test2() {
        int[] arr = new int[]{1,2,3};
        for (int i : arr) {
            System.out.println(i);
        }
    }

    @Test
    public void test3() {
        String[] foo = new String[]{"MM","MM","MM"};

        for (int i = 0; i < foo.length; i++) {
            foo[i] = "GG";
        }

        for (String string : foo) { //新建数组
            string = "MM";
        }

        for (String string : foo) {
            System.out.println(string);
        }
    }
}
