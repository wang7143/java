package usefull_class.Date1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;


import org.junit.Test;

/**
 * !@Descriptions  格式化日期和时间
 * 
 */

public class DateTimeFormatter_test {
    //预定义标准格式
    @Test
    public void name() {
        DateTimeFormatter isoLocalDateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        String format = isoLocalDateTime.format(LocalDateTime.now());
        System.out.println(format);
        //解析：字符串到日期

        TemporalAccessor parse = isoLocalDateTime.parse("2020-10-18T15:42:18");
        System.out.println(parse);

        //本地化相关格式
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter ofLocalizedDateTime = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withZone(ZoneId.systemDefault());
        String format2 = ofLocalizedDateTime.format(now);
        System.out.println(format2);

        DateTimeFormatter ofLocalizedDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String format3 = ofLocalizedDate.format(LocalDate.now());
        System.out.println(format3);

        //自定义方式
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String format4 = ofPattern.format(LocalDateTime.now());
        System.out.println(format4);

        //本地化相关格式
        TemporalAccessor parse2 = ofPattern.parse("2020-02-20 03:20:50");
        System.out.println(parse2);
    }


    
    


    

}
