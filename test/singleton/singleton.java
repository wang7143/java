package test.singleton;

public class singleton {
    public static void main(String[] args) {
        test t = new test();
        System.out.println(t.name);
        // Bank bank1 = Bank.getinstance();
        // System.out.println(args);
        // System.out.println(bank1);
        
    }
}

// 饿汉式
class Bank {

    static String name = "A";

    private Bank() {
    }

    // 对象也必须是静态的
    private static Bank instance = new Bank();

    // 提供公共的静态方法
    public static Bank getinstance() {
        return instance;
    }

    static {
        System.out.println("static block 1");
    }
    // todo用来初始化类,对象
    // todo静态代码块,随着类的加载而执行
    static {
        System.out.println("static block");
    }
    // todo非静态代码块，随着对象的加载而执行
    {
        System.out.println("block");
    }
}

class test {
    String name = "test";
    static{
        System.out.println("static block");
    }

    {
        System.out.println("block");
    }
}