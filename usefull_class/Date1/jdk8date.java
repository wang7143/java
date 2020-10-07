package usefull_class.Date1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import org.junit.Test;



public class jdk8date {

    @Test
    public void name() {
        Date date1 = new Date(2020-1900,9-1,8);
        System.out.println(date1);
    }

    @Test
    public void name1() {
        LocalDate na = LocalDate.now();
        LocalTime loclaTime = LocalTime.now();
        LocalDateTime local = LocalDateTime.now();

        System.out.println(na);
        System.out.println(loclaTime);
        System.out.println(local);

        //设置指定年月日，没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020 , 10, 20, 21, 30, 20);
        System.out.println(localDateTime1);

        //get
        System.out.println(LocalDateTime.now().getDayOfMonth());
        System.out.println(localDateTime1.getMonth());

        LocalDate locald = LocalDate.now().withDayOfMonth(22);
        System.out.println(locald);

        LocalDateTime loc1 = LocalDateTime.now().plusMonths(3);
        System.out.println(loc1);

        
    }
}



