package ClassLoaderT;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

public class test {

    @Test
    public void test1() {
        ClassLoader classLoader = test.class.getClassLoader();
        System.out.println(classLoader);

        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);

        System.out.println(parent.getParent());

        ClassLoader classLoader2 = String.class.getClassLoader();
        System.out.println(classLoader2);
    }

    @Test
    public void test2() throws IOException {
        
        Properties p = new Properties();



        ClassLoader classLoader = test.class.getClassLoader(); 

        InputStream re = classLoader.getResourceAsStream("ClassLoaderT.jdbc.properties");
        // FileInputStream file = new FileInputStream("/home/ubuntu/java/ClassLoaderT/jdbc.properties");

        p.load(re);

        String pr = p.getProperty("user");
        System.out.println(pr);
    }
}
