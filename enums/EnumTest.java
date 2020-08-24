package enums;

import java.util.*;


public class EnumTest
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE) ");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        in.close();
        System.out.println("size=" + size);
        System.out.println("abbreviation=" + size.getAbbreviation());
        if (size == Size.EXTRA_LARGE)
            System.out.println("Good job--you paid attention to the _.");
    }
}


enum Size   //声明Size 是 enum的一个对象
{
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");  //对象里面包含
    private Size(String abbreviation) {this.abbreviation = abbreviation;}
    public String getAbbreviation() {return abbreviation; }
    private String abbreviation;
}


//static Enum valueOf(Class enumClass, String name)
//返回指定名字、给定类的枚举常量。

