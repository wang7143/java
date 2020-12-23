package jdbc;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;


import org.junit.Test;

public class in_Test {
    
    public static void main(String[] args) {
        delete();
    }

    @Test
    public void test1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("四级/六级");
        int type = sc.nextInt();
        System.out.print("身份证号");
        String IDcard = sc.next();
        System.out.print("准考证号");
        String examcard = sc.next();
        System.out.print("学生姓名");
        String name = sc.next();
        System.out.print("所在城市");
        String city = sc.next();
        System.out.print("考试成绩");
        int grade = sc.nextInt();

        String sql = "insert into examstudent(type,IDCard,examCard,studentName,location,grade)values(?,?,?,?,?,?)";

        int i = get(sql, type, IDcard, examcard, name, city, grade);
        if (i > 0) {
            System.out.println("添加成功");
        }
        sc.close();
    }

    // 添加数据
    public static <T> int get(String sql, Object... args) {
        Connection con = null;
        PreparedStatement pre = null;
        // ResultSet ex = null;
        try {
            con = jdbcutils.get();
            pre = con.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i + 1, args[i]);
            }

            return pre.executeUpdate();

        } catch (Exception e) {
            
            e.printStackTrace();
        } finally {
            jdbcutils.closeresource(con, pre);
        }

        return 0;
    }

    @Test
    public static void test2() {
        System.out.println("请选择您要输入的类型：");
        System.out.println("a.准考证号");
        System.out.println("b.身份正好");
        Scanner sc = new Scanner(System.in);
        String sl = sc.next();
        if("a".equalsIgnoreCase(sl)){
            System.out.println("请输入准考证号:");
            String examcard = sc.next();
            String sql = "select FlowID,Type type,IDCard,ExamCard examCard,StudentName name,location,Grade grade from examstudent where examCard = ?";

            Student student = get(Student.class, sql, examcard);
            if(student == null){
                System.out.println("输入准考正好有误");
            }else{
                System.out.println(student);
            }
        }else if("b".equalsIgnoreCase(sl)){
            System.out.println("请输入身份证号:");
            String examcard = sc.next();
            String sql = "select FlowID,Type type,IDCard,ExamCard examCard,StudentName name,location,Grade grade from examstudent where IDCard = ?";

            Student student = get(Student.class, sql, examcard);
            if(student == null){
                System.out.println("输入身份证号有误");
            }else{
                System.out.println(student);
            }
        }else{
            System.out.println("您的输入有误，请重新输入程序。");
        }
        sc.close();
        
    }

    public static <T> T get(Class<T> cla,String sql,Object...args) {
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
    public static void delete() {
        System.out.println("请输入学生考好：");
        Scanner scanner = new Scanner(System.in);
        String examCard = scanner.next();

        String sql = "select FlowID,Type type,IDCard,ExamCard examCard,StudentName name,location,Grade grade from examstudent where examCard = ?";

        Student student = get(Student.class, sql, examCard);
        if(student == null){
            System.out.println("查无此人，请重新输入");
        }else{
            String sql1 = "delete from examstudent where examCard = ?";
            int deleteCount = get(sql1,examCard);
            if(deleteCount > 0){
                System.out.println("删除成功");
            }
        }
        scanner.close();
    }

    
    
}
