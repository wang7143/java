package java9test.src;

import java.io.InputStreamReader;

import org.junit.Test;



public class about_try {
    
    @Test
    public void test1() {
        // InputStreamReader in = new InputStreamReader(System.in);
        // char[] buf = new char[20];
        // int len;
        // if((len = in.read(buf)) != -1){
        //     String str = new String(buf,0,len);
        // }


        //java8自动关闭
        try(InputStreamReader in = new InputStreamReader(System.in)) {
            char[] buf = new char[20];
            int len;
            if((len = in.read(buf)) != -1){
                String str = new String(buf,0,len);
            }
        } catch (Exception e) {
            //TODO: handle exception
        }


        

    }

    @Test
    public void test2() {
        //Java9变化
        InputStreamReader in = new InputStreamReader(System.in);
        try (in) {
            char[] buf = new char[20];
            int len;
            if((len = in.read(buf)) != -1){
                String str = new String(buf,0,len);
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
