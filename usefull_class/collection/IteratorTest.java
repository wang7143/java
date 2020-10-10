package usefull_class.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

public class IteratorTest {
    
    @Test
    public void test() {
        Collection foo = new ArrayList();
        foo.add(123);
        foo.add(456);
        foo.add(new String("Tom"));
        foo.add(false);

        Iterator iterator = foo.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
