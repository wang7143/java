package methods;

import java.lang.reflect.*;

/**
 * This program shows how to invoke methods through reflection.
 * !该程序通过反射机制调用任意方法
 * @version 1.2 2020-8-30
 * @author  Cay Horstmann
 * !java.lang.reflect.Method
 * !调用这个对象所描述的方法，传递给定参数，并返回方法的返回值。对于静态方法，把null作为隐式参数传递。在使用包装器传递基本类型的值时，基本类型的返回值必须是未包装的。
 */

public class MethodTableTest {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException {
        //get method pointers to the square and sqrt throws Exception
        Method square = MethodTableTest.class.getMethod("square", double.class);
        //通过以上方法获得MethodTableTest中的square方法。
        Method sqrt = Math.class.getMethod("sqrt", double.class);
        //Math类中的一个方法，通过参数向它提供一个函数名sqrt和一个double类型的参数
        //print tables of x- and y-values

        printTable(1, 10, 10, square);
        printTable(1, 10, 10, sqrt);
        
    }

    /**
     * Returns the square of a number
     * @param x a number
     * @return x squared
     */

    public static double square(double x) {
        return x * x;
    }

    /**
     * Prints a table with x- and y- values for a method
     * @param from the lower bound for the x-values
     * @param to the upper bound for the x-values
     * @param n the upper bound for the x-values
     * @param f a method with a double parameter and double return value
     */

     public static void printTable(double from, double to, int n, Method f) {
         //print out the method as table header
         System.out.println(f);
         double dx = (to - from) / (n - 1);

         for (double x = from; x <= to; x += dx)
         {
             try{
                 double y = (Double) f.invoke(null, x); //Method类中的invoke方法，允许调用包装在当前Method对象中的方法。返回值必须是Object类型，
                 //!特别要重申：建议Java开发者不要使用Method对象的回调功能。使用接口进行回调会使得代码的执行速度更快，更易于维护
                 System.out.printf("%10.4f | %10.4f%n", x, y);
             }
             catch (Exception e)
             {
                 e.printStackTrace();
             }
         }
     }
}