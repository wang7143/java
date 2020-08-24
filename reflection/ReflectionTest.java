package reflection;

import java.util.*;

import java.lang.reflect.*;


/**
 * ReflectionTest
 */
public class ReflectionTest {

    public static void main(String[] args) {
        //read class name from command line args or user input
        String name;
        if (args.length > 0) name = args[0];
        else
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Date): ");
            name = in.next();
            in.close();
        }

        try{
            //print class name and superclass name (if != Object)
            Class<?> cl = Class.forName(name);
            Class<?> superl = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());  
            //Modifier静态方法返回分析getModifiers的方法，它将返回一个整形数值
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print("class " + name);
            if (superl != null && superl != Object.class) System.out.print("extends " + superl.getName());
            System.out.print("\n{\n");
            printConstructors(cl);
            System.out.println();
            printMethods(cl);
            System.out.println();
            printFields(cl);
            System.out.println("}");
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static void printConstructors(Class<?> cl) {
        Constructor<?>[] constructors = cl.getDeclaredConstructors();
        //class中的getDeclaredConstructors返回全部构造器
        for (Constructor<?> c : constructors)
        {
            String name = c.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(name + "(");

            Class<?>[] paramTypes = c.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++)
            {
                if (j > 0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    public static void printMethods(Class<?> cl) {
        Method[] methods = cl.getDeclaredMethods();
        //Class类中方法getDeclaredMethods，返回全部方法
        for (Method m : methods)
        {
            Class<?> retType = m.getReturnType();
            String name = m.getName();

            System.out.print("   ");
            //print  modifiers,return type and method name
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(retType.getName() + " " + name + "(");

            Class<?>[] paramTypes = m.getParameterTypes();
            for (int j = 0; j < paramTypes.length; j++)
            {
                if (j > 0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }
    }

    public static void printFields(Class<?> cl) {
        Field[] fields = cl.getDeclaredFields();
        //Class类中的getDeclaredFields，返回类中声明的全部域。
        for (Field f : fields)
        {
            Class<?> type = f.getType();
            String name = f.getName();
            System.out.print("   ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name + ";");
        }
    }
}