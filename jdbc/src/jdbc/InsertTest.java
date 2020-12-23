package jdbc;
/**
 * 
 * preparedStatement高效插入
 */

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

public class InsertTest {

    @Test
    public void test3() {
        //最终方法
        Connection con = null;
        PreparedStatement pr = null;
        try {
            con = jdbcutils.get();
            //设置不允许自动提交数据
            con.setAutoCommit(false);
            String sql = "insert into goods(name)values(?)";
            pr = con.prepareStatement(sql);
            for (int i = 0; i <= 20000; i++) {
                pr.setObject(1, "name_" + i);
                pr.addBatch();
                if(i % 500 == 0){
                    pr.executeBatch();
                    pr.clearBatch();
                }
                
            }

            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            jdbcutils.closeresource(con, pr);
        }
    }
    
    @Test
    public void test1() {
        Connection con = null;
        PreparedStatement pr = null;
        try {
            con = jdbcutils.get();
            String sql = "insert into goods(name)values(?)";
            pr = con.prepareStatement(sql);
            for (int i = 0; i < 20000; i++) {
                pr.setObject(1, "name_" + i);
                pr.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            jdbcutils.closeresource(con, pr);
        }
    }

    @Test
    public void test2() {
        //批量加入
        Connection con = null;
        PreparedStatement pr = null;
        try {
            con = jdbcutils.get();
            String sql = "insert into goods(name)values(?)";
            pr = con.prepareStatement(sql);
            for (int i = 0; i < 20000; i++) {
                pr.setObject(1, "name_" + i);
                pr.addBatch();
                if(i % 500 == 0){
                    pr.executeBatch();
                    pr.clearBatch();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            jdbcutils.closeresource(con, pr);
        }
    }

    
}
