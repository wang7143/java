package jdbc;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import org.junit.Test;

public class BlobTest {
    @Test
    public void test1() throws Exception {
        Connection connection = jdbcutils.get();
        String sql = "insert into customers(name,email,birth,photo)values(?,?,?,?)";

        PreparedStatement pr = connection.prepareStatement(sql);

        pr.setObject(1, "yuan");
        pr.setObject(2, "456");
        java.sql.Date date = java.sql.Date.valueOf("1789-2-11");
        pr.setDate(3, date);
        FileInputStream file = new FileInputStream(new File("/home/ubuntu/java/jdbc/src/jdbc/1.apk"));
        pr.setBlob(4, file);
        pr.execute();

        jdbcutils.closeresource(connection, pr);
    }

    @Test
    public void test2() {
        Connection con = null;
        PreparedStatement pre = null;
        ResultSet re = null;
        FileOutputStream file = null;
        InputStream bin = null;
        try {
            con = jdbcutils.get();
            String sql = "select id,name,email,birth,photo from customers where id = ?";
            pre = con.prepareStatement(sql);
            pre.setInt(1, 16);
    
            re = pre.executeQuery();
    
            if (re.next()) {
                int id = re.getInt(1);
                String name = re.getString(2);
                String email = re.getString(3);
                Date birth = re.getDate(4);
    
                Customer_date cus = new Customer_date(id, name, email, birth);
                System.out.println(cus);
    
                Blob photo = re.getBlob("photo");
                bin = photo.getBinaryStream();
                file = new FileOutputStream("/home/ubuntu/java/jdbc/src/jdbc/te.jpg");
                byte[] buf = new byte[1024];
                int len;
                while ((len = bin.read(buf)) != -1) {
                    file.write(buf, 0, len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            jdbcutils.closeresource(con, pre, re);
            try {
                if(file != null){
                    file.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(bin != null) {
                    bin.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        

        
    }
}
