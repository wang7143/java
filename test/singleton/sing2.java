package test.singleton;

public class sing2 {
    public static void main(String[] args) {
        System.out.println(args);
    }
}


/**
 * 懒汉式
 */
class Order {

    private Order(){

    }

    /**
     * 
     */
    private static Order instance = null;


    public static Order getinstance() {
        if(instance == null){
            instance = new Order();
        }
        return instance;
    }
}