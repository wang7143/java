package map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;

import org.junit.Test;

public class CollectionsTest {
    
    @Test
    public void name() {
        List foo = new ArrayList();
        foo.add(123);
        foo.add(95);
        foo.add(789);

        System.out.println(foo);
        // Collections.sort(foo);
        // Collections.swap(foo, 1, 2);
        System.out.println(foo);
        
    }

    @Test
    public void test1() {
        Set a = new HashSet<>();
        a.add("aaa");
        a.add("bbb");
        a.add("ccc");
        a.add("ddd");
        
        System.out.println(a);
        Iterator it = a.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        

    }
}
