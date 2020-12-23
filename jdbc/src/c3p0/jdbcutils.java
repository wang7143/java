package c3p0;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class jdbcutils {

    private static ComboPooledDataSource comb = new ComboPooledDataSource("hellc3p0");
    public static Connection get() throws SQLException {
        Connection con = comb.getConnection();
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
