package dbcp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

public class dbcpTest {

    @Test
    public void test() throws SQLException {
        // 创建了DBCP的数据库连接池
        BasicDataSource su = new BasicDataSource();

        // 设置基本信息

        su.setDriverClassName("com.mysql.cj.jdbc.Driver");
        su.setUrl("jdbc:mysql://localhost:3307/test?rewriteBatchedStatements=true");
        su.setUsername("root");
        su.setPassword("root");

        su.setInitialSize(10);
        su.setMaxActive(10);

        Connection con = su.getConnection();

    }

    // 配置文件

    private static DataSource source;
    static{
        Properties properties = new Properties();
        try {
            InputStream file =  ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(file);
            source  = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public static Connection test2() throws SQLException {
        
        Connection con = source.getConnection();
        return con;
        
    }
}
