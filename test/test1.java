package test;


public class test1 {
    public static void main(String[] args) {
        boolean x = true;
        boolean y = false;

        short z = 42;

        if ((z++==42) && (y = true)){
            z++;
        }
        System.out.println(y);
        if((++z == 45)){
            z++;
        }

        System.out.println(x);
        System.out.println("z=" + z);
    }
}
 