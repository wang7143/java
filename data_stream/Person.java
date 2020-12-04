package data_stream;

import java.io.Serializable;

public class Person implements Serializable{

    public static final long serialVersionUID = 1321351313515214L;
    private String name;
    private int age;

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

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    

}
