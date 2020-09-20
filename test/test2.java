package test;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        System.out.println("第一个数");
        int num1 = scan.nextInt();
        System.out.println("第二个数");
        int num2 = scan.nextInt();
        System.out.println("第三个数");
        int num3 = scan.nextInt();

        scan.close();

        int num4 = (num1 > num2) ? ((num1 > num3) ? num1 : num3):((num2 > num3) ? num2 : num3);
        if (num4 != num1){
            System.out.println(num4 + ',' + num1);
        }
        
    }
}
