package jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;

import java.util.Scanner;



public class insert {

    public static void main(String[] args) {
        up();
    }

    public static void up() {
        Scanner sca = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = sca.next();
        System.out.println("请输入邮箱：");
        String email = sca.next();
        System.out.println("请输入生日：");
        String birth = sca.next();

        String sql = "insert into customers(name,email,birth)values(?,?,?)";
        
        int i = get(Customer_date.class, sql, name, email, birth);
        if(i > 0){
            System.out.println("添加成功");
        }else{
            System.out.println("失败");
        }
        sca.close();
    }

    public static <T> int get(Class<T> cla, String sql, Object... args) {
        Connection con = null;
        PreparedStatement pre = null;
        // ResultSet ex = null;
        try {
            con = jdbcutils.get();
            pre = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i+1, args[i]);
            }

            return pre.executeUpdate();
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }finally{
            jdbcutils.closeresource(con, pre);
        }

        return 0;
    }
}
