package jdbcutils;

import java.sql.Connection;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import deluyi.dluyi;

public class qrtest {
    

    @Test
    public void test1() throws Exception {
        QueryRunner qu = new QueryRunner();
        Connection con = dluyi.get();
        String sql = "insert into customers(name,email,birth)values(?,?,?)";

        qu.update(con, sql, "aaa1","@126.com","1999-2-15");
    }

    public static void main(String[] args) {
        test1();
    }
}
