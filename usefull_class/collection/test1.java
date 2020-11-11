package usefull_class.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

import org.junit.Test;

public class test1 {
    
    @Test
    public void test1() {
        Collection foo = new ArrayList();

        foo.add(123);
        foo.add(456);
        foo.add(789);
        foo.add(852);

        foo.forEach(System.out::println);
    }


    @Test
    public void test2() {
        TreeSet foo = new TreeSet();
        
    }
}
