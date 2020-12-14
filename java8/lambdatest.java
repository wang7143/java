package java8;

import java.util.Comparator;

import org.junit.Test;

public class lambdatest {

    @Test
    public void test() {
        Runnable r1 = new Runnable(){

            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("我爱北京天安门");
            }  
        };
        r1.run();

        System.out.println("********************");

        Runnable r2 = () -> System.out.println("我爱北京故宫");
        r2.run();
    }

    @Test
    public void test1() {
        Comparator<Integer> com1 = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1, o2);
			}
            
        };
        int comp1 = com1.compare(1, 2);
        System.out.println(comp1);

        Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1, o2);
        int comp2 = com2.compare(11, 13);
        System.out.println(comp2);

        Comparator<Integer> com3 = Integer :: compare;
        int comp3 = com3.compare(12, 11);
        System.out.println(comp3);
    }
}
