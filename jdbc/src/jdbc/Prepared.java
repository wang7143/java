package jdbc;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;






public class Prepared {

    

    @Test
    public void test1() {
        String sql = "select id,name,email from customers where id = ?";
        
        Customer_date customer = get(Customer_date.class, sql, 12);
        System.out.println(customer);

        String sql1 = "select order_id orderID,order_name orderName from `order` where order_id = ?";
        order order = get(order.class,sql1, 1);
        System.out.println(order);

    }

    public <T> T get(Class<T> cla,String sql,Object...args) {
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
                T t = cla.getDeclaredConstructor().newInstance();
                for (int i = 0; i < col; i++) {
                    Object ob = ex.getObject(i +1);
                    //通过下面方法获取的列名 getColumnName()
                    //获取别名 getColumnLabel(),针对类字段名和表字段名不一样的情况
                    String name = meta.getColumnLabel(i+1);
                    Field field = cla.getDeclaredField(name);
                    field.setAccessible(true);
                    field.set(t,ob);
                }
                return t;
            }
            
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }finally{
            jdbcutils.closeresource(con, pre, ex);
        }

        return null;
    }

    @Test
    public void test2() {
        String sql = "select id,name,email from customers where id < ?";
        List<Customer_date> getmut = getmut(Customer_date.class, sql, 12);
        getmut.forEach(System.out::println);

        
    }

    public <T> List<T> getmut(Class<T> cla,String sql,Object...args) {
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
            //创建集和储存对象
            ArrayList<T> list = new ArrayList<T>();
            while(ex.next()){
                T t = cla.getDeclaredConstructor().newInstance();
                for (int i = 0; i < col; i++) {
                    Object ob = ex.getObject(i +1);
                    //通过下面方法获取的列名 getColumnName()
                    //获取别名 getColumnLabel(),针对类字段名和表字段名不一样的情况
                    String name = meta.getColumnLabel(i+1);
                    Field field = cla.getDeclaredField(name);
                    field.setAccessible(true);
                    field.set(t,ob);
                }
                list.add(t);
            }
            return list;
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }finally{
            jdbcutils.closeresource(con, pre, ex);
        }

        return null;
    }
}
