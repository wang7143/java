package jdbc;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;

public class transaction {
    
    @Test
    public void test() {
        String sql = "update user_table set balance = balance -100 where user = ?";
        update(sql, "AA");
        String sql1 = "update user_table set balance = balance + 100 where user = ?";
        update(sql1, "BB");
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
        Connection con = null;
        try {
            con = jdbcutils.get();
            //设置不能自动提交
            con.setAutoCommit(false);
            String sql = "update user_table set balance = balance -100 where user = ?";
            update1(con,sql, "AA");
            System.out.println(10/0);
            String sql1 = "update user_table set balance = balance + 100 where user = ?";
            update1(con,sql1, "BB");
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally{
            jdbcutils.closeresource(con, null);
        }
    }

    //考虑事务的转装操作
    public void update1(Connection con,String sql,Object ...args) {
        // Connection con = jdbcutils.get();
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
            jdbcutils.closeresource(null, pr);
        }
    }

    // @Test
    public static void test4() throws SQLException {
        Connection con = jdbcutils.get();
        con.setTransactionIsolation(2);
        System.out.println(con.getTransactionIsolation());
        con.setAutoCommit(false);
        String sql = "select user,password,balance from user_table where user = ?";
        User1 user = get(con, User1.class, sql, "CC");
        System.out.println(user);
    }

    @Test
    public void test5() throws InterruptedException, SQLException {
        Connection con = jdbcutils.get();
        con.setAutoCommit(false);
        String sql = "update user_table set balance = ? where user = ?";
        update1(con, sql, 5000, "CC");
        Thread.sleep(15000);
        System.out.println("修改结束");
    }

    // 事务使用
    public static <T> T get(Connection con, Class<T> cla, String sql, Object... args) {
        PreparedStatement pre = null;
        ResultSet ex = null;
        try {
            pre = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i + 1, args[i]);
            }
            ex = pre.executeQuery();

            ResultSetMetaData meta = ex.getMetaData();
            int col = meta.getColumnCount();
            if (ex.next()) {
                T t = cla.getDeclaredConstructor().newInstance();
                for (int i = 0; i < col; i++) {
                    Object ob = ex.getObject(i + 1);
                    // 通过下面方法获取的列名 getColumnName()
                    // 获取别名 getColumnLabel(),针对类字段名和表字段名不一样的情况
                    String name = meta.getColumnLabel(i + 1);
                    Field field = cla.getDeclaredField(name);
                    field.setAccessible(true);
                    field.set(t, ob);
                }
                return t;
            }

        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            jdbcutils.closeresource(null, pre, ex);
        }

        return null;
    }

    public static void main(String[] args) throws SQLException {
        test4();
    }
}


class User1 {
    private String user;
    private String password;
    private int balance;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return password;
    }

    public void setName(String name) {
        this.password = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public User1(String user, String password, int balance) {
        this.user = user;
        this.password = password;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User1 [balance=" + balance + ", password=" + password + ", user=" + user + "]";
    }

    public User1() {
    }
    
    
}