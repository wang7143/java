package java9test.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

public class about_stream {
    @Test
    public void test1() {
        List<Integer> as = Arrays.asList(23,5,48,35,65,1,15,11,5,152);
        //返回从开头开始直到不满足规则停止
        // as.stream().takeWhile(x -> x < 60).forEach(System.out::println);

        //返回剩余的元素从第一个满足条件的开始
        as.stream().dropWhile(x -> x < 60).forEach(System.out::println);
    }


    @Test
    public void test3() {
        Stream<Integer> of = Stream.of(1,2,3);
        of.forEach(System.out::println);

        //不能为单个null值
        // Stream<Integer> of1 = Stream.of(null);
        // of1.forEach(System.out::println);

        //允许值为空
        Stream<Object> o2 = Stream.ofNullable(null);
        o2.forEach(System.out::println);

    }

    @Test
    public void test6() {
        // Stream.iterate(0, x -> x +1).limit(10).forEach(System.out::println);
        //Java9中重载方法
        Stream.iterate(0, x -> x < 100, x -> x + 1).forEach(System.out::println);
    }

    @Test
    public void test7() {
        List<String> arr = new ArrayList<>();
        arr.add("Tom");
        arr.add("Jerry");
        arr.add("Tim");

        Optional<List<String>> of = Optional.ofNullable(arr);
        Stream<List<String>> stream = of.stream();
        stream.flatMap(x -> x.stream()).forEach(System.out::println);
        
    }

}
