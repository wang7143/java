package usefull_class.Date1;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.junit.Test;

import sun.awt.image.OffScreenImage;

public class instesttest {


    @Test
    public void name() {
        Instant inst = Instant.now();
        //!格林威治时间
        System.out.println(inst);

        //改变时间
        OffsetDateTime foo = inst.atOffset(ZoneOffset.ofHours(8));
        System.out.println(foo);

        //获取毫秒数
        long epochMilli = inst.toEpochMilli();
        System.out.println(epochMilli);

        //通过给定的毫秒数，指定时间
        Instant ofEpochMilli = Instant.ofEpochMilli(155046453135L);
        System.out.println(ofEpochMilli);
    }
}



