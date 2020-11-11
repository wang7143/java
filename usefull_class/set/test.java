package usefull_class.set;

import java.util.HashSet;

import org.junit.Test;

/**
 * !set接口,储存无序/不可重复的数据
 * Hashset: 线程不安全,可以存储null
 * LinkedHashSet: 作为Hashset子类;遍历数据时可以按照添加的顺序遍历
 * TreeSet: 可以按照添加对象的指定属性,进行排序
 */
public class test {
    @Test
    public void test1() {
        HashSet foo = new HashSet();
        foo.add(123);
        foo.add("AA");
        foo.add(456);
        foo.add(String.valueOf(456));

        System.out.println(foo);

    }
}
