package BaseDao;

import java.sql.Connection;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import jdbc.jdbcutils;

public class coustomerTest {
    
    private Custimpl dao = new Custimpl();

    @Test
    public void test1() {
        Connection con = null;
        try {
            con = jdbcutils.get();
            Customer cust = new Customer(1,"小黑","126.com",new Date(56446465121313L));
            dao.insert(con, cust);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcutils.closeresource(con,null);
        }
    }

    @Test
    public void test2() {
        Connection con = null;
        try {
            con = jdbcutils.get();
            
            dao.deleteById(con, 24);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcutils.closeresource(con,null);
        }
    }


    @Test
    public void test3() {
        Connection con = null;
        try {
            con = jdbcutils.get();
            Customer cust = new Customer(18,"贝多芬","163.com",new Date(3154315135L));
            dao.update(con, cust);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcutils.closeresource(con,null);
        }
    }

    @Test
    public void test4() {
        Connection con = null;
        try {
            con = jdbcutils.get();
            
            Customer c = dao.getCustomerBiId(con, 19);
            System.out.println(c);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcutils.closeresource(con,null);
        }
    }

    @Test
    public void test5() {
        Connection con = null;
        try {
            con = jdbcutils.get();
            
            List<Customer> all = dao.getAll(con);
            all.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcutils.closeresource(con,null);
        }
    }

    @Test
    public void test6() {
        Connection con = null;
        try {
            con = jdbcutils.get();
            
            Long count = dao.getCount(con);
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcutils.closeresource(con,null);
        }
    }

    @Test
    public void test7() {
        Connection con = null;
        try {
            con = jdbcutils.get();
            
            java.sql.Date maxBirth = dao.getMaxBirth(con);
            System.out.println(maxBirth);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jdbcutils.closeresource(con,null);
        }
    }
}
