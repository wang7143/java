package map;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties foo = new Properties();
        FileInputStream fil = new FileInputStream("jdbc.properties");
        foo.load(fil);
        String name = foo.getProperty("name");
        String password = foo.getProperty("password");

        System.out.println("name = " + name + ", password = " + password);
        fil.close();
    }
    


}
