package java8;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;




public class lambdatest1 {
    
    @Test
    public void test() {
        Consumer<String> con = new Consumer<String>(){

            @Override
            public void accept(String t) {
                // TODO Auto-generated method stub
                System.out.println(t);
            }
        };
        con.accept("aaaaa");

        System.out.println("*************");

        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };

        con1.accept("bbbbbbbb");
    }


    @Test
    public void test2() {
        Consumer<String> con = (s) -> {
            System.out.println(s);
        };
        con.accept("llllll");

        Consumer<String> con1 = s -> {
            System.out.println(s);
        };
        con1.accept("xxxxxxxx");
    }


    @Test
    public void test3() {
        Comparator<Integer> comparator = new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return 0;
			};
            
        };

        Comparator<Integer> com2 = (o1,o2) -> o1.compareTo(o2);
        System.out.println(com2.compare(12, 12));
    }

    @Test
    public void test8() {
        happy(500, new Consumer<Double>() {

			@Override
			public void accept(Double t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}
            
        });
        happy(400, money -> System.out.println(money));
        
    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

    public List<String> Stringf(List<String> list, Predicate<String> pre) {
        ArrayList<String> filterList = new ArrayList<>();

        for (String s : list) {
            if(pre.test(s)){
                filterList.add(s);
            }
        }

        return filterList;
    }

    @Test
    public void test5() {
        List<String> list = Arrays.asList("北京","南京","东京","天津");
        List<String> stringf = Stringf(list, new Predicate<String>(){

            @Override
            public boolean test(String t) {
                // TODO Auto-generated method stub
                return t.contains("京");
            }
        });
        System.out.println(stringf);

        List<String> stringf2 = Stringf(list, s -> s.contains("京"));
        System.out.println(stringf2);
    }

    @Test
    public void test6() {
        PrintStream out = System.out;

        Consumer<String> con2 = out::println;
        con2.accept("beijing");
    }


    @Test
    public void test9() {
        java8.Employee emp = new java8.Employee(1001,"Tom",23,5600);
        Supplier<String> sup1 = () -> emp.getName();
        System.out.println(sup1.get());

        System.out.println("*******************");

        Supplier<String> sup2 = emp::getName;
        System.out.println(sup2.get());
    }


    @Test
    public void test7() {
        Comparator<Integer> com1 = (t1,t2) -> Integer.compare(t1, t2);
        System.out.println(com1.compare(12, 21));

        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(21, 12));
    }

    @Test
    public void test4() {
        Function<Double,Long> fun1 = new Function<Double,Long>(){

			@Override
			public Long apply(Double t) {
				// TODO Auto-generated method stub
				return Math.round(t);
			}
            
        };

        Function<Double,Long> func1 = d -> Math.round(d);
        System.out.println(func1.apply(12.3));

        Function<Double,Long> func2 = Math::round;
        System.out.println(func2.apply(12.6));

    }

    @Test
    public void testa() {
        Comparator<Integer> com1 = (t1,t2) -> Integer.compare(t1, t2);
        System.out.println(com1.compare(12, 23));
        System.out.println("**************");

        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(31, 21));
    }


    @Test
    public void testb() {
        Function<Double,Long> fun = d -> Math.round(d);
        fun.apply(12.3);

        Function<Double,Long> fun1 = Math::round;
        System.out.println(fun1.apply(12.6));
    }

    //类：：非静态方法
    @Test
    public void testc() {
        Comparator<String> com = (s1,s2) -> s1.compareTo(s2);
        System.out.println(com.compare("abc", "adb"));

        System.out.println("***********");

        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("abc", "abm"));

        BiPredicate<String,String> pre = (s1,s2) -> s1.equals(s2);
        System.out.println(pre.test("abc", "abc"));

        BiPredicate<String,String> pre1 = String::equals;
        System.out.println(pre1.test("abc", "abd"));
    }

    @Test
    public void testd() {
        java8.Employee employee = new java8.Employee(1001,"Jerry",23,6000);
        Function<java8.Employee,String> func = e -> e.getName();
        System.out.println(func.apply(employee));

        System.out.println("***************");

        Function<java8.Employee,String> fun1 = java8.Employee::getName;
        System.out.println(fun1.apply(employee));
    } 

    //构造器引用
    @Test
    public void testn() {
        //返回Employee的对象
        Supplier<java8.Employee> sup1 = () -> new java8.Employee();
        System.out.println(sup1.get());
        //同上
        Supplier<java8.Employee> sup2 = java8.Employee::new;
    }

    @Test
    public void testv() {
        Function<Integer,java8.Employee> fun = id -> new java8.Employee(id);
        java8.Employee em = fun.apply(1001);

        System.out.println("***************");

        Function<Integer,java8.Employee> fun1 = java8.Employee::new; 
    }

    @Test
    public void testl() {
        BiFunction<Integer,String,java8.Employee> fun = (id,name) -> new java8.Employee(id,name);
        System.out.println(fun.apply(1001, "Tom"));

        BiFunction<Integer,String,java8.Employee> fun1 = java8.Employee::new;
        System.out.println(fun1.apply(1002, "lj"));
    }

    //数组引用
    @Test
    public void testo() {
        Function<Integer,String[]> fun = Length -> new String[Length];
        String[] apply = fun.apply(5);
        System.out.println(Arrays.toString(apply));

        System.out.println("*************");
        Function<Integer,String[]> fun1 = String[]::new;
        System.out.println(Arrays.toString(fun1.apply(5)));
    }
}







