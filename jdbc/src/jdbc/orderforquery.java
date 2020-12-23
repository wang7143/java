package jdbc;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;

public class orderforquery {

    @Test
    public void test6() {
        String sql = "select order_id orderID,order_name orderName,order_date date from `order` where order_id = ?";
        order or = orderquery(sql, 1);
        System.out.println(or);

    }

    public order orderquery(String sql,Object...args) {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet ex = null;
        try {
            con = jdbcutils.get();
            pre = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i+1, args[i]);
            }
            ex = pre.executeQuery();

            ResultSetMetaData meta = ex.getMetaData();
            int col = meta.getColumnCount();
            if(ex.next()){
                order or = new order();
                for (int i = 0; i < col; i++) {
                    Object ob = ex.getObject(i +1);
                    //通过下面方法获取的列名 getColumnName()
                    //获取别名 getColumnLabel(),针对类字段名和表字段名不一样的情况
                    String name = meta.getColumnLabel(i+1);
                    Field field = order.class.getDeclaredField(name);
                    field.setAccessible(true);
                    field.set(or,ob);
                }
                return or;
            }
            
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }finally{
            jdbcutils.closeresource(con, pre, ex);
        }

        return null;
    }

    @Test
    public void query1() throws SQLException {
        Connection con = jdbcutils.get();
        String sql = "select order_id,order_name,order_date from `order` where order_id = ?";
        PreparedStatement pre = con.prepareStatement(sql);
        pre.setObject(1, 1);

        ResultSet ex = pre.executeQuery();
        if(ex.next()){
            int id = (int)ex.getObject(1);
            String name = (String) ex.getObject(2);
            Date date = (Date) ex.getObject(3);

            order or = new order(id,name,date);
            System.out.println(or);
        }

        jdbcutils.closeresource(con, pre, ex);
    }
}
