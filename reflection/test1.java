package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;



public class test1 {

    @Test
    public void test() {
        Person p1 = new Person("Tom", 12);

        p1.age = 10;

        System.out.println(p1.toString());

        p1.show();
    }

    @Test
    public void test2() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
        Class cl = Person.class;
        Constructor co = cl.getConstructor(String.class,int.class);

        Object newInstance = co.newInstance("Tom",12);
        Person p = (Person) newInstance;
        System.out.println(p.toString());
        

        Field dec = cl.getDeclaredField("age");
        dec.set(p,10);
        System.out.println(p.toString());

        Method declaredMethod = cl.getDeclaredMethod("show");

        declaredMethod.invoke(p);

        Constructor decl = cl.getDeclaredConstructor(String.class);
        decl.setAccessible(true);
        Person p2 = (Person) decl.newInstance("Jerry");
        System.out.println(p2);

        Field name = cl.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p, "HanMeimei");
        System.out.println(p);

        Method m = cl.getDeclaredMethod("shownation", String.class);
        m.setAccessible(true);
        String invoke = (String) m.invoke(p, "zhongguo");
        System.out.println(invoke);
    }


    @Test
    public void get_Class() throws ClassNotFoundException {
        //方式1
        Class<Person> cl = Person.class;
        //方式2  运行时类的对象。
        Person pe = new Person();
        Class cl1 = pe.getClass();
        // System.out.println(cl1);
        //方式三
        Class<?> Name = Class.forName("reflection.Person");
        System.out.println(Name);

        // System.out.println(cl1 == Name);

        //方式4
        ClassLoader classLoader = test1.class.getClassLoader();
        Class<?> loadClass = classLoader.loadClass("reflection.Person");
        System.out.println(loadClass);
    }
}


