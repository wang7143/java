package test.singleton;

public class singleton {
    public static void main(String[] args) {
        Bank bank1 = Bank.getinstance();
        System.out.println(args);
        System.out.println(bank1);

    }
}


//饿汉式
class Bank{
    private Bank(){
    }
    //对象也必须是静态的
    private static Bank instance = new Bank();
    //提供公共的静态方法
    public static Bank getinstance() {
        return instance;
    }
}