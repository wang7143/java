package generi;

import org.graalvm.compiler.lir.LIRInstruction.Temp;
import org.junit.Test;

public class orderTest {
    
    @Test
    public void test1() {
        order o = new order<>();
        o.setOrderT(123);
        o.setOrderT("ABC");

        order<String> o1 = new order<String>("orderAA",1001,"jack");

        o1.setOrderT("AA:hello");
        

    }
}
