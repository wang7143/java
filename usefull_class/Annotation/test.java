package usefull_class.Annotation;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

import org.junit.Test;

/**
 * !注解测试
 * 
 */
public class test {
    public static void main(String[] args) {
        
    }

    @Test
    public void getAn() {
        Class cl = Person.class;
        Annotation[] foo = cl.getAnnotations();
        for (int i = 0; i < foo.length; i++) {
            System.out.println(foo[i]);
        }
    }
}


@test1(value = "hi")
@test1(value = "abc")
class Person{

    @SuppressWarnings("unused")
    @test1(value = "autbut")
    private String name;
    @SuppressWarnings("unused")
    private int age;


    @test1(value = "123")
    public void walk() {
        System.out.println("人走路");
    }


    @test1(value = "456")
    public void eat() {
        System.out.println("吃饭");
    }


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}


interface Info{
    void show();
}


class Student extends Person implements Info{
    public Student(String name, int age) {
        super(name, age);
    }


    @Override
    public void walk() {
        System.out.println("学生走路");
    }


    @Override
    public void show() {
        System.out.println("展示");
    }

    
}


class Generic<@test1 T>{
    public void show() throws @test1 RuntimeException{
        ArrayList<@test1 String> list = new ArrayList<>();
        int num = (@test1 int) 10L;
    }
}