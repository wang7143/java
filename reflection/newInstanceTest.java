package reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.Random;


import org.junit.Test;

public class newInstanceTest {

    @Test
    public void test1() throws InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException {
        Class<Person> cl = Person.class;

        Person newInstance = cl.getDeclaredConstructor().newInstance();
        System.out.println(newInstance);

    }

    @Test
    public void test2() {
        int num = new Random().nextInt(3);
        String classPath = "";
        switch (num) {
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "reflection.Person";
                break;

        }

        try {
            Object obj = getInstance(classPath);
            System.out.println(obj);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    public Object getInstance(String classPath) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException {

        Class<?> cl = Class.forName(classPath);
        return cl.getDeclaredConstructor().newInstance();
        
    }
}
