package c3p0;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.junit.Test;

public class c3p0Test {
    @Test
    public void test1() throws PropertyVetoException, SQLException {
        ComboPooledDataSource con = new ComboPooledDataSource();
        con.setDriverClass("com.mysql.cj.jdbc.Driver");
        con.setJdbcUrl("jdbc:mysql://localhost:3307/test?rewriteBatchedStatements=true");
        con.setUser("root");
        con.setPassword("root");
        //数据连接池数
        con.setInitialPoolSize(10);

        Connection conn = con.getConnection();

        System.out.println(conn);
    }

    //使用配置文件
    @Test
    public void test2() throws SQLException {
        ComboPooledDataSource com = new ComboPooledDataSource("hellc3p0");
        Connection con = com.getConnection();
        System.out.println(con);

        
    }
}
