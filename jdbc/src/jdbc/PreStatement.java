package jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.text.SimpleDateFormat;
import java.util.Properties;

import org.junit.Test;

public class PreStatement {

    // 添加数据
    @Test
    public void test1() {

        
        Connection con = null;
        PreparedStatement pre = null;
        try {
            InputStream resour = connection.class.getClassLoader().getResourceAsStream("./jdbc/jdbc.properties");

            Properties pro = new Properties();
            pro.load(resour);

            String user = pro.getProperty("user");
            String password = pro.getProperty("password");
            String url = pro.getProperty("url");
            String driverClass = pro.getProperty("driverClass");

            Class.forName(driverClass);
        
            con = DriverManager.getConnection(url, user, password);

            String sql = "insert into customers(name,email,birth)values(?,?,?)";
            pre = con.prepareStatement(sql);

            pre.setString(1, "管理员");
            pre.setString(2, "admin@gmail.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-DD");
            java.util.Date parse = sdf.parse("2004-01-01");
;           pre.setDate(3, new Date(parse.getTime()));
        //执行
            pre.execute();            
        } catch (Exception e) {
            
        }finally{
            try {
                if(con != null){
                    con.close();
                }
            } catch (SQLException e) {
                
                e.printStackTrace();
            }
            try {
                if(pre != null){
                    pre.close();
                }
            } catch (SQLException e) {
                
                e.printStackTrace();
            }
        }
    }

    //修改
    @Test
    public void change() throws ClassNotFoundException, IOException, SQLException {
        Connection con = jdbcutils.get();

        String sql = "update customers set name = ? where id = ?";

        PreparedStatement pr = con.prepareStatement(sql);

        pr.setObject(1, "莫扎特");
        pr.setObject(2, 18);
        pr.execute();

        jdbcutils.closeresource(con, pr);
    }

    public void update(String sql,Object ...args) {
        Connection con = jdbcutils.get();
        PreparedStatement pr = null;
        try {
            pr = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pr.setObject(i+1, args[i]);
            }
            pr.execute();
        } catch (SQLException e) {
            
            e.printStackTrace();
        } finally{
            jdbcutils.closeresource(con, pr);
        }
    }

    @Test
    public void test2() {
        // String sql = "delete from customers where id = ?";
        String sql = "update `order` set order_name = ? where order_id = ?";
        update(sql, "DD",2);
        
    }
}
