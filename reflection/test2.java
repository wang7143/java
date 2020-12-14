package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

public class test2 {

    @Test
    public void test1() {
        Class cl = Per.class;

        Field[] fields = cl.getFields();

        // 获取当前运行类及其父类的搜友public属性
        for (Field field : fields) {
            System.out.println(field);
        }

        // 获得当前运行时类所有属性，不包括父类属性
        Field[] declaredFields = cl.getDeclaredFields();

        for (Field field : declaredFields) {
            System.out.println(field);
        }
    }

    @Test
    public void test2() {
        Class cl = Per.class;

        Field[] declaredFields = cl.getDeclaredFields();

        for (Field field : declaredFields) {
            // 返回权限修饰符
            int modifiers = field.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            // 数据类型
            Class type = field.getType();
            System.out.print(type.getName() + "\t");

            System.out.print(field.getName());

            System.out.println("\t");
        }
    }

    
    // 获取方法
    @Test
    public void test4() {
        Class cl = Per.class;
        // Method[] methods = cl.getMethods();
        // for (Method method : methods) {
        // System.out.println(method);
        // }

        Method[] declaredMethods = cl.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }
    }

    // 获取注解
    @Test
    public void test5() {

        Class cl = Per.class;

        // 注解

        // 权限修饰符
        Method[] declaredMethods = cl.getDeclaredMethods();
        for (Method method : declaredMethods) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation an : annotations) {
                System.out.println(an);
            }

            // 返回修饰符
            System.out.print(Modifier.toString(method.getModifiers()) + "\t");

            // 返回值类型
            System.out.print(method.getReturnType().getName() + "\t");

            // 方法名
            System.out.print(method.getName());

            // 形参列表
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)) {
                for (Class m : parameterTypes) {
                    System.out.println('(' + m.getName() + ')');
                }
            }

            Class<?>[] exceptionTypes = method.getExceptionTypes();
            if (!(exceptionTypes == null && exceptionTypes.length == 0)) {
                // System.out.println("throws");
                for (Class m : exceptionTypes) {
                    System.out.println(m.getName() + ',' + ' ');
                }
            }
            System.out.println();

        }
    }

    // 获取构造器
    @Test
    public void test7() {
        Class<?> cl = Per.class;
        Constructor<?>[] constructors = cl.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println();

        // 获取当前运行时类中声明的所有构造器
        Constructor<?>[] declaredConstructors = cl.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println(constructor);
        }

    }

    @Test
    public void test9() {
        Class<?> cl = Per.class;
        // 父类
        Class<?> superclass = cl.getSuperclass();
        // 带泛型的父类
        Type genericSuperclass = cl.getGenericSuperclass();
        System.out.println(superclass);
        System.out.println(genericSuperclass);

        ParameterizedType p = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = p.getActualTypeArguments();
        for (Type type : actualTypeArguments) {
            System.out.println(type.getTypeName());
        }
    }

    @Test
    public void test8() {
        Class<?> cl = Per.class;
        Class<?>[] interfaces = cl.getInterfaces();
        for (Class<?> class1 : interfaces) {
            System.out.println(class1);
        }
        System.out.println();

        Class<?>[] interfaces2 = cl.getSuperclass().getInterfaces();
        for (Class<?> class1 : interfaces2) {
            System.out.println(class1);
        }
    }

    // 获取运行时类的包
    @Test
    public void testa() {
        Class<?> cl = Per.class;
        Package package1 = cl.getPackage();

        System.out.print(package1);
    }

    // 获取运行时类注解
    @Test
    public void testb() {
        Class<?> cl = Per.class;
        Annotation[] annotations = cl.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }

    // 调用运行时指定的结构，属性，方法，构造器
    @Test
    public void testc() throws NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException, NoSuchMethodException {
        Class<?> cl = Per.class;
        Per p =(Per) cl.getDeclaredConstructor().newInstance();
        //指定属性
        Field field = cl.getField("id");

        field.set(p, 1001);
        
        int pid =(int) field.get(p);
        
        System.out.println(pid);

        Field dec = cl.getDeclaredField("name");

        //获取私有属性必须设置以下
        dec.setAccessible(true);
        dec.set(p, "tom");

        System.out.println(dec.get(p));
    }

    @Test
    public void teste() throws InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException {
        
        Class<?> cl = Per.class;
        Per p =(Per) cl.getDeclaredConstructor().newInstance();

        Method declaredMethod = cl.getDeclaredMethod("show", String.class);

        declaredMethod.setAccessible(true);
        declaredMethod.invoke(p, "aaaaaa");

        //获取静态方法
        Method de = cl.getDeclaredMethod("name");
        de.setAccessible(true);
        Object invoke = de.invoke(null);
        System.out.println(invoke);        
    }


    @Test
    public void testo() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException,
            IllegalArgumentException, InvocationTargetException {
        Class cl = Per.class;

        Constructor de = cl.getDeclaredConstructor(String.class);

        de.setAccessible(true);

        Per newInstance =(Per) de.newInstance("aaa");

        System.out.println(newInstance.toString());

    }
}
