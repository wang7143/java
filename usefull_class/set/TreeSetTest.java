package usefull_class.set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

public class TreeSetTest {

    @Test
    public void test() {
        TreeSet foo = new TreeSet();


        //!必须添加同类型对象
        // foo.add(789);
        // foo.add(123);
        // foo.add(456);


        //需要排序 
        foo.add(new User("Tom", 12));
        foo.add(new User("Jack", 12));
        foo.add(new User("java", 14));
        foo.add(new User("java", 22));

        
        Iterator iterator = foo.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        Comparator com = new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User)o1;
                    User u2 = (User)o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                }else{
                    throw new RuntimeException();
                }
            }
        };
        TreeSet foo = new TreeSet(com);
        foo.add(new User("Tom", 12));
        foo.add(new User("Jack", 12));
        foo.add(new User("java", 14));
        foo.add(new User("java", 22));

        Iterator iterator = foo.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
