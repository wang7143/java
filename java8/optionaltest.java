package java8;

import java.util.Optional;

import org.junit.Test;

public class optionaltest {
    
    @Test
    public void test1() {

        Girl girl = new Girl();
        girl = null;
        Optional<Girl> of = Optional.ofNullable(girl);
        System.out.println(of);
    }

    @Test
    public void test2() {
        Girl girl = new Girl();
        // girl = null;
        Optional<Girl> of = Optional.of(girl);
        System.out.println(of);


    }

    // public String getGirlName(Boy boy) {
    //     return boy.getGirl().getName();
    // }

    @Test
    public void test3() {
        Boy boy = null;
        // boy = null;
        boy = new Boy();
        boy = new Boy(new Girl("456"));
        String girlName = getGirlName3(boy);
        System.out.println(girlName);
    }

    public String getGirlName1(Boy boy) {
        if(boy != null){
            Girl girl = boy.getGirl();
            if(girl != null){
                return girl.getName();
            }
        }

        return null;
    }

    //使用Optional类
    public String getGirlName3(Boy boy) {
        Optional<Boy> b = Optional.ofNullable(boy);

        Boy or = b.orElse(new Boy(new Girl("123")));

        Girl girl = or.getGirl();

        Optional<Girl> of = Optional.ofNullable(girl);

        Girl orElse = of.orElse(new Girl("古力娜扎"));
        return orElse.getName();

    }

    @Test
    public void test4() {
        Optional<Object> empty = Optional.empty();
        
        //空数据
        // System.out.println(empty.get());
        //是否有对象
        System.out.println(empty.isPresent());
    }

    @Test
    public void test5() {
        String str = "hello";
        //of(t)：必须非空 
        Optional<String> of = Optional.of(str);
        System.out.println(of.get());
    }

    @Test
    public void test6() {
        Optional<String> Nu = Optional.ofNullable(null);
        System.out.println(Nu.orElse("other"));
    }
}
