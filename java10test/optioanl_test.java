package java10test;

import java.util.Optional;

import org.junit.Test;

public class optioanl_test {
    

    @Test
    public void test1() {
        Optional<Object> e = Optional.empty();
        System.out.println(e.isPresent());
        System.out.println(e.isEmpty());

        e = Optional.of("abc");
        //返回值，如果为空抛异常
        var obj = e.orElseThrow();
        System.out.println(obj);

        Optional<String> of = Optional.of("hello");
        Optional<Object> or = e.or(() -> of);
        System.out.println(or);
    }
}
