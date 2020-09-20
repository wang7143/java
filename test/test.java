package test;




/**
 * test
 */



public class test {
    public static void main(String[] args) {
        int num = 187;
        int i = 1;
        while (num > 0) {
            System.out.println(EnumTtesest.getClassname(i));
            // System.out.println(EnumTtesest.getName(i) + "是" + s);
            num = num / 10;
            i++;
        }    
    }
}


