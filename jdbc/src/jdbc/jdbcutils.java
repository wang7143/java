package jdbc;


import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class jdbcutils {
    public static Connection get() {
        Properties pro = null;
        Connection con = null;
        try {
            InputStream resour = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

            pro = new Properties();
            pro.load(resour);

            String user = pro.getProperty("user");
            String password = pro.getProperty("password");
            String url = pro.getProperty("url");
            String driverClass = pro.getProperty("driverClass");

            Class.forName(driverClass);
            
            con = DriverManager.getConnection(url, user, password);
            
        } catch (Exception e) {
            
        }
        return con;
    }

    public static void closeresource(Connection con, Statement ps) {
        try {
            if(con != null){
                con.close();
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        try {
            if(ps != null){
                ps.close();
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }

    public static void closeresource(Connection con, Statement ps,ResultSet rs){
        try {
            if(con != null){
                con.close();
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        try {
            if(ps != null){
                ps.close();
            }
        } catch (SQLException e) {
           
            e.printStackTrace();
        }
        try {
            if (rs != null){
                rs.close();
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }
}
