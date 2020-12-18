package java9test.src;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class about_list {
    

    @Test
    public void test1() {


        //java8 的写法
        List<String> arr = new ArrayList<>();
        arr.add("123");
        arr.add("456");
        arr.add("789");

        //设置只能读取，不能添加写入
        arr = Collections.unmodifiableList(arr);

        arr.add("987");
        System.out.println(arr);

    }


    @Test
    public void test2() {
        //java9只读集合
        List<String> list = Collections.unmodifiableList(Arrays.asList("a","b","c"));
    }



    @Test
    public void test3() {

        //只读集合
        List<Integer> asList = Arrays.asList(1,2,3,4,5);

        asList.add(6);
    }

    @Test
    public void test4() {
        //java9 只读集合
        System.out.println(List.of(1,2,3,4,5));
        Set<Integer> of = Set.of(1,2,3,4,5,6);
        System.out.println(of);
        Map<String, Integer> of2 = Map.of("aaa",123,"ccc",5);
        System.out.println(of2);

        Map<String, Integer> ofE = Map.ofEntries(Map.entry("asd", 21),Map.entry("era", 23));
        System.out.println(ofE);
    }


    @Test
    public void test5() {
        //java9 InputStream新方法：tranferTo()
        ClassLoader cl = this.getClass().getClassLoader();
        InputStream is = cl.getResourceAsStream("java9test/src/aa.txt");
        try (InputStream is1 = cl.getResourceAsStream("/home/ubuntu/java/java9test/src/aa.txt");OutputStream os = new FileOutputStream("/home/ubuntu/java/java9test/src/aax.txt")){
            is.transferTo(os);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

}
