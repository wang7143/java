package usefull_class.Date1;



import java.util.Date;

import org.junit.Test;

public class Datetest {


    @Test
    public void test1() {
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日之间的毫秒时间差
        System.out.println(time);
    }


    @Test
    public void test2() {
        Date date = new Date();
        System.out.println(date);

        System.out.println(date.getTime());

        //指定时间
        Date t1 = new Date(1352323230L);
        System.out.println(t1);

        //java.sql.Date对应数据库中的Date
        java.sql.Date sqldate = new java.sql.Date(161512313813L);
        System.out.println(sqldate);
    }

    
}
