package usefull_class.comparable_dfgfdg;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;

import org.junit.Test;



public class comparable_Test {
    

    @Test
    public void test1() {
        String[] foo = new String[]{"ac","ad","aa","af"};
        Arrays.sort(foo);
        System.out.println(Arrays.toString(foo));
    }

    @Test
    public void test2() {
        goods[] foo = new goods[5];
        foo[0] = new goods(34,"xiaomi");
        foo[1] = new goods(32,"huawei");
        foo[2] = new goods(37,"weiruan");
        foo[3] = new goods(31,"yijia");
        foo[4] = new goods(32,"dell");
        Arrays.sort(foo);
        System.out.println(Arrays.toString(foo));
    }

    @Test
    public void test3() {
        String[] foo = new String[]{"ac","ad","aa","af"};
        Arrays.sort(foo,new Comparator(){
            @Override
            public int compare(Object arg0, Object arg1) {
                // TODO Auto-generated method stub
                if(arg0 instanceof String && arg1 instanceof String){
                    String s1 = (String)arg0;
                    String s2 = (String)arg1;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(foo));
    }


    @Test
    public void test4() {
        goods[] foo = new goods[5];

        foo[0] = new goods(34,"xiaomi");
        foo[1] = new goods(32,"huawei");
        foo[2] = new goods(37,"weiruan");
        foo[3] = new goods(31,"yijia");
        foo[4] = new goods(32,"dell");

        Arrays.sort(foo, new Comparator(){
            @Override
            public int compare(Object arg0, Object arg1) {
                if(arg0 instanceof goods && arg1 instanceof goods){
                    goods g1 = (goods)arg0;
                    goods g2 = (goods)arg1;
                    if(g1.getName().equals(g2.getName())){
                        return Double.compare(g1.getPrice(), g2.getPrice());
                    }else{
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(foo));
    }
}




