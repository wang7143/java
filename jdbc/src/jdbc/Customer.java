package jdbc;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;



public class Customer {

    @Test
    public void testQ() throws SQLException {
        Connection con = jdbcutils.get();
        String sql = "select * from customers where id = ?";
        PreparedStatement pr = con.prepareStatement(sql);
        // 执行并返回结果
        pr.setObject(1, 1);
        ResultSet ex = pr.executeQuery();
        // 处理结果集
        if (ex.next()) { // 如果有数据
            int id = ex.getInt(1);
            String name = ex.getString(2);
            String email = ex.getString(3);
            Date date = ex.getDate(4);

            Customer_date customer_date = new Customer_date(id, name, email, date);
            System.out.println(customer_date);
            // System.out.println(id + name + email + date);

            // Object[] data = new Object[]{id,name,email,date};

        }
        jdbcutils.closeresource(con, pr, ex);

    }

    @Test
    public void test2() {
        String sql = "select name,email from customers where id = ?";
        try {
            Customer_date que = queryForCustomers(sql, 13);
            System.out.println(que);
        } catch (Exception e) {
            
            e.printStackTrace();
        }

    }

    public Customer_date queryForCustomers(String sql,Object...args) throws Exception {
        Connection con = jdbcutils.get();

        PreparedStatement pre = con.prepareStatement(sql);

        for (int i = 0; i < args.length; i++) {
            pre.setObject(i + 1, args[i]);
        }

        ResultSet ex = pre.executeQuery();
        //元数据
        ResultSetMetaData meta = ex.getMetaData();
        int count = meta.getColumnCount();
        if(ex.next()){
            Customer_date cust = new Customer_date();
            for (int i = 0; i < count; i++) {
                Object ob = ex.getObject(i + 1);
                //获取列名
                String co = meta.getColumnName(i + 1);

                //给CUST赋值
                Field de = Customer_date.class.getDeclaredField(co);
                de.setAccessible(true);
                de.set(cust, ob);
            }
            return cust;
        }
        jdbcutils.closeresource(con, pre, ex);
        return null;
    }
}


class Customer_date{
    private int id;
    private String name;
    private String email;
    private java.util.Date birth;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public java.util.Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Customer_date [birth=" + birth + ", email=" + email + ", id=" + id + ", name=" + name + "]";
    }

    public Customer_date() {
    }

    public Customer_date(int id, String name, String email, java.util.Date birth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
    }
    
    
    
}