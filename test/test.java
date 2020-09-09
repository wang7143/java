package test;

import java.util.*;


/**
 * test
 */



public class test {
    public static void main(String[] args) {
        int num = 187;
        int s;
        int i = 1;
        while (num > 0) {
            s = num % 10;
            System.out.println(EnumTtesest.getClassname(i));
            // System.out.println(EnumTtesest.getName(i) + "是" + s);
            num = num / 10;
            i++;
        }    
    }
}


