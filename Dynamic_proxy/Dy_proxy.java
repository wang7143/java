package Dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human {
    String getBelief();

    void eat(String food);
}

// 被代理类
class SuperMan implements Human {

    @Override
    public String getBelief() {
        // TODO Auto-generated method stub
        return "I can fly";
    }

    @Override
    public void eat(String food) {
        // TODO Auto-generated method stub
        System.out.println("吃" + food);
    }

}

// 动态代理
class ProxyFactory {
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler han = new MyInvocationHandler();

        han.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), han);
    }
}


class HumanUtil{
    public void met1() {
        System.out.println("===========通用方法1===========");
    }
    public void met2() {
        System.out.println("===========通用方法2===========");
    }
}

class MyInvocationHandler implements InvocationHandler {

    private Object obj;

    public void bind(Object obj) {
        this.obj = obj;
    }

    //使用传进来的对象调用方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // TODO Auto-generated method stub

        HumanUtil util = new HumanUtil();
        util.met1();
        Object invoke = method.invoke(obj, args);
        util.met2();
        return invoke;
    }
    
}



public class Dy_proxy {

    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human proxyInstance =(Human) ProxyFactory.getProxyInstance(superMan);

        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("四川");

        NikeClothFactory nike = new NikeClothFactory();
        ClothFactory pro = (ClothFactory) ProxyFactory.getProxyInstance(nike);

        pro.produceCloth();
    }
}
