package deluyi;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

public class test {

    
    public static Connection get() throws Exception {
        Properties properties = new Properties();
        InputStream file =  ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        properties.load(file);
        DataSource cre = DruidDataSourceFactory.createDataSource(properties);
        Connection con = cre.getConnection();
        return con;
    }
}
