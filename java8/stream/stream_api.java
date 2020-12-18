package java8.stream;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

import java8.Employee;
import java8.EmployeeData;

public class stream_api {

    public static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();

        //返回顺序流
        Stream<Employee> stream = employees.stream();

        //返回一个并行流
        Stream<Employee> parallelStream = employees.parallelStream();
    }

    @Test
    public void test2() {
        //Arrays的静态方法
        int[] arr = new int[]{1,2,3,4,5,6};
        IntStream stream = Arrays.stream(arr);

        Employee e = new Employee(1001,"Tom");
        Employee e1 = new Employee(1002,"Tom1");
        Employee[] arr1 = new Employee[]{e1,e};

        Stream<Employee> stream2 = Arrays.stream(arr1);

    }


    //
    @Test
    public void test3() {
        Stream<Integer> of = Stream.of(1,2,3,4,5,6);


    }

    //无限流
    @Test
    public void test4() {

        //迭代
        Stream.iterate(0, t -> t+2).limit(10).forEach(System.out::println);

        //生成
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    //中间操作，切片
    @Test 
    public void test5() {
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> stream = employees.stream();
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);

        //截断流
        employees.stream().limit(3).forEach(System.out::println);


        //筛选
        employees.add(new Employee(1003,"刘强东",40,6000));

        employees.stream().distinct().forEach(System.out::println);
        
        

    }

    @Test
    public void test6() {
        //转大写
        List<String> aslist = Arrays.asList("a","bb","c","d");
        // aslist.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        List<Employee> employees = EmployeeData.getEmployees();
        // employees.stream().map(Employee :: getName).filter(name -> name.length() > 3).forEach(System.out::println);;

        aslist.stream().map(stream_api::fromStringToStream).forEach(s -> s.forEach(System.out::println));
        
        // ss.forEach(s ->{
        //     s.forEach(System.out::println);
        // });

        // Stream<Character> flat = aslist.stream().flatMap(stream_api::fromStringToStream);
        // flat.forEach(System.out::println);
    }

    @Test
    public void test7() {
        ArrayList arr = new ArrayList();
        arr.add(1);
        arr.add(2);
        arr.add(3);

        ArrayList arr2 = new ArrayList();
        arr2.add(4);
        arr2.add(5);
        arr2.add(6);

        arr.addAll(arr2);
        System.out.println(arr);
    }


    //排序
    @Test
    public void test8() {
        List<Integer> a = Arrays.asList(12,65,54,21,10,64);
        a.stream().sorted().forEach(System.out::println);

        List<Employee> employees = EmployeeData.getEmployees();
        // employees.stream().sorted().forEach(System.out::println);

        employees.stream().sorted((e1,e2) -> {
            int age = Integer.compare(e1.getAge(), e2.getAge());
            if(age != 0){
                return age;
            }else{
                return Double.compare(e1.getSalary(),e2.getSalary());
            }
        }).forEach(System.out::println);
    }

    //终止操作
    @Test
    public void test9() {
        List<Employee> employees = EmployeeData.getEmployees();
        boolean all = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(all);

        boolean all1 = employees.stream().allMatch(e -> e.getSalary() > 10000);
        System.out.println(all1);

        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(noneMatch);

        Optional<Employee> findFirst = employees.stream().findFirst();
        System.out.println(findFirst);

        Optional<Employee> findAny = employees.parallelStream().findAny();
        System.out.println(findAny);
    }

    @Test
    public void testa() {
        List<Employee> employees = EmployeeData.getEmployees();
        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);

        Stream<Double> m = employees.stream().map(e -> e.getSalary());
        System.out.println(m.max(Double::compare));

        Optional<Employee> min = employees.stream().min((e1,e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);

    }

    //规约
    @Test
    public void testb() {
        List<Integer> as = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer reduce = as.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> map = employees.stream().map(e -> e.getSalary());
        // Optional<Double> reduce2 = map.reduce(Double::sum);
        Optional<Double> reduce2 = map.reduce((d1,d2) -> d1 + d2);
        System.out.println(reduce2);

        
    }

    @Test
    public void testc() {
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> collect = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());

        collect.forEach(System.out::println);

        Set<Employee> collect2 = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());

        collect2.forEach(System.out::println);
    }
}
