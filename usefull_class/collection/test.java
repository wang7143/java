package usefull_class.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.junit.Test;

/**
 * 
 * 1.集合是内存层面的储存
 * 
 * 2.数组的问题。（1）数组长度不可变（2）必须指明类型(3)删除和插入不方便（4）有序、可重复。对无序、不可重复的需求，不容易满足
 * 
 * 
 */

public class test {



    @Test
    public void test3() {
        Collection foo = new ArrayList();
        foo.add(123);
        foo.add(456);
        foo.add(new String("Tom"));
        foo.add(false);
        foo.add(456);
        foo.add(new Person("Jerry", 20));
        foo.remove(123);
        System.out.println(foo);

        foo.remove(new Person("Jerry", 20));
        System.out.println(foo);

        //removeAll 移除集合中所有元素

    }

    @Test
    public void test2() {
        Collection foo = new ArrayList();
        foo.add(123);
        foo.add(456);
        foo.add(new String("Tom"));
        foo.add(false);
        // Person person = new Person("Jerry",20);
        // foo.add(person);
        foo.add(new Person("Jerry", 20));
        boolean contains = foo.contains(123);
        System.out.println(contains);
        System.out.println(foo.contains(new String("Tom")));
        //System.out.println(foo.contains(person));

        System.out.println(foo.contains(new Person("Jerry", 20)));

        //!2.containsAll,判断另一个集合是否都在当前集合中

        Collection asList = Arrays.asList(123,456);
        System.out.println(foo.containsAll(asList));
        // System.out.println(foo.removeAll(asList));
        System.out.println(foo);

        //!retainAll 返回交集
        foo.retainAll(asList);
        System.out.println(foo);

        //!equals(Object obj)对比相等

        //!hasCode() 返回哈希值

        //!toArray()集合转数组，返回Object数组
        Object[] array = foo.toArray();

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        //数组转集合
        List<String> asList2 = Arrays.asList(new String[]{"aa","bb"});
        System.out.println(asList2);

        List asList3 = Arrays.asList(new Integer[]{123,456});
        System.out.println(asList3);

        //iterator()返回迭代器实例。遍历集合

    }
    
    @Test
    public void test1() {
        Collection foo = new ArrayList();
        foo.add("AA");
        foo.add("BB");
        foo.add(123);
        foo.add(new Date());

        System.out.println(foo.size());

        //addAll
        Collection foo1 = new ArrayList();
        foo1.add(456);
        foo1.add("CC");
        foo.addAll(foo1);

        System.out.println(foo);

        //clear()清空
        foo.clear();
        
        //isEmpty():判断当前集合是否为空
        System.out.println(foo.isEmpty());


    }
    
}

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [age=" + age + ", name=" + name + "]";
    }

    // @Override
    // public int hashCode() {
    //     final int prime = 31;
    //     int result = 1;
    //     result = prime * result + age;
    //     result = prime * result + ((name == null) ? 0 : name.hashCode());
    //     return result;
    // }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Person");
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}