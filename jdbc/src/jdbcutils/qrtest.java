package jdbcutils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.List;
import java.util.Map;


import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import BaseDao.Customer;
import c3p0.jdbcutils;
import deluyi.dluyi;

public class qrtest {

    @Test
    public void test1() throws Exception {
        QueryRunner qu = new QueryRunner();
        Connection con = dluyi.get();
        String sql = "insert into customers(name,email,birth)values(?,?,?)";

        int update = qu.update(con, sql, "aaa1", "@126.com", "1999-2-15");
        System.out.println(update);
        jdbcutils.closeresource(con, null);
    }

    @Test
    public void test2() {
        QueryRunner que = new QueryRunner();
        try {
            Connection con = dluyi.get();
            String sql = "select id,name,email,birth from customers where id = ?";
            BeanHandler<Customer> handler = new BeanHandler<>(Customer.class);
            Customer query = que.query(con, sql, 18, handler);
            System.out.println(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        QueryRunner que = new QueryRunner();
        try {
            Connection con = dluyi.get();
            String sql = "select id,name,email,birth from customers where id < ?";
            BeanListHandler<Customer> handler = new BeanListHandler<>(Customer.class);
            List<Customer> query = que.query(con, sql, 18, handler);
            query.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() {
        QueryRunner que = new QueryRunner();
        try {
            Connection con = dluyi.get();
            String sql = "select id,name,email,birth from customers where id = ?";
            MapHandler handler = new MapHandler();
            Map<String, Object> query = que.query(con, sql, 18, handler);
            System.out.println(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test5() {
        QueryRunner que = new QueryRunner();
        try {
            Connection con = dluyi.get();
            String sql = "select id,name,email,birth from customers where id < ?";
            MapListHandler handler = new MapListHandler();
            List<Map<String, Object>> query = que.query(con, sql, 18, handler);
            query.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6() {
        QueryRunner que = new QueryRunner();
        try {
            Connection con = dluyi.get();
            String sql = "select count(*) from customers";
            ScalarHandler scalarHandler = new ScalarHandler();
            Long query = (Long) que.query(con, sql, scalarHandler);
            System.out.println(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test7() {
        QueryRunner que = new QueryRunner();
        try {
            Connection con = dluyi.get();
            String sql = "select max(birth) from customers";
            ScalarHandler scalarHandler = new ScalarHandler();
            Date query = (Date) que.query(con, sql, scalarHandler);
            System.out.println(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //自动关闭
    public static void closer(Connection con, Statement stmt, ResultSet rs) {
        DbUtils.closeQuietly(con, stmt, rs);
    }
    
}
