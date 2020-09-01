package arrays;

import java.lang.reflect.*;
import java.util.*;

/*
This program demonstrates(演示) the use of reflection for manipulating(利用) arrays。
*/

public class CopyofTest {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        a = (int[]) goodCopyOf(a, 10);
        System.out.println(Arrays.toString(a));
        
        String[] b = {"Tom", "Dick", "Harry"};
        b = (String[]) goodCopyOf(b,10);
        System.out.println(Arrays.toString(b));

        System.out.println("The following call will generate an exception.");
        b = (String[]) badCopyof(b, 10);
    }
    /**
     * This method attempts to grow array by allocating a new array and copying all elements.
     * @param a the array to grow
     * 
     * @param newLength the new length
     * @return a larger array that contains all elements of a. However, the returned array has type Object[], not the same type as a
     */

    public static Object[] badCopyof(Object[] a, int newLength) // not useful
    {
        Object[] newArray = new Object[newLength];
        System.arraycopy(a,0, newArray, 0, Math.min(a.length, newLength));
        return newArray;
    }

    /**
     * This method grows(扩展) an array by allocating(分配) a new array of the same type and coping all elements
     * @param a the array to grow. This can be an object array or a primitive(原始的) type array
     * @return a larger array that contains all elements of a.
     */
    public static Object goodCopyOf(Object a, int newLength) {
        Class<?> cl = a.getClass();
        if (!cl.isArray()) return null;
        Class<?> componentType = cl.getComponentType(); //getComponentType()方法确定数组对应的类型。
        int length = Array.getLength(a); //获得数组a的长度
        Object newArray = Array.newInstance(componentType, newLength);  //newInstance()是Array类中静态方法，能构造新数组，参数是元素类型，数组的长度
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }
}