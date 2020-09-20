package test.WrapperTest;

import org.junit.Test;

public class WrapperTest {
    
    @Test
    public void test1() {
        int num1 = 10;
        Integer in1 = num1;
        System.out.println(in1);

    }

    @Test
    public void test2() {
        Integer in1 = Integer.valueOf(12);

        int i1 = in1.intValue();

        System.out.println(i1);
    }
}
