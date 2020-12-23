package jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

public class connection {

    @Test
    public void test1() throws SQLException {
        Driver dr = new com.mysql.cj.jdbc.Driver();
        String url = "jdbc:mysql://localhost:3307/test";
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root");
        Connection connect = dr.connect(url, info);
        System.out.println(connect.getMetaData().getURL());

    }

    @Test
    public void test2() throws SQLException {
        try {
            Class<?> f = Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                Driver dr = (Driver) f.getDeclaredConstructor().newInstance();
                String url = "jdbc:mysql://localhost:3307/test";
                Properties info = new Properties();
                info.setProperty("user", "root");
                info.setProperty("password", "root");
                Connection connect = dr.connect(url, info);
                System.out.println(connect.getMetaData().getURL());
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            
            e.printStackTrace();
        }

    }

    @Test
    public void test3() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Class<?> f = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver dr = (Driver) f.getDeclaredConstructor().newInstance();
        DriverManager.registerDriver(dr);
        String url = "jdbc:mysql://localhost:3307/test";
        String user = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);

    }

    @Test
    public void test4() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3307/test";
        String user = "root";
        String password = "root";
        // Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }

    @Test
    public void test5() throws IOException, ClassNotFoundException, SQLException {
        
        //读取配置文件中的4个基本信息
        InputStream resour = connection.class.getClassLoader().getResourceAsStream("./jdbc/jdbc.properties");

        Properties pro = new Properties();
        pro.load(resour);

        String user = pro.getProperty("user");
        String password = pro.getProperty("password");
        String url = pro.getProperty("url");
        String driverClass = pro.getProperty("driverClass");

        Class.forName(driverClass);
        
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println(con);

    }
}
