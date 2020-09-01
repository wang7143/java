package objectAnalyzer;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class ObjectAnalyzer {
    private ArrayList<Object> visited = new ArrayList<>();

    /*
    Converts an object to string representation that lists all fields.
    讲对象转换成字符串形式
    @param obj an object
    参数是一个对象
    @retrun a string with the object's class name and all field names and values
    返回带有对象的类名称以及所有字段名称和值的字符串
    */
    public String toString(Object obj) {
        if (obj == null) return "null";
        if (visited.contains(obj)) return "...";
        visited.add(obj);
        Class<?> cl = obj.getClass();
        if (cl == String.class) return (String) obj;
        if (cl.isArray())
        {
            String r = cl.getComponentType() + "[]{"; //getcomponenttype() 返回数组中的class对象，如果不是class对象就返回null
            for (int i = 0; i < Array.getLength(obj); i++)  //getlength返回数组长度
            {
                if (i > 0) r += ",";
                Object val = Array.get(obj, i); //返回数组中的第i个对象
                if (cl.getComponentType().isPrimitive()) r += val; //方法isPrimitive查看是否为原始类型，如果是返回true
                else r += toString(val);
            }
            return r + "}";
        }

        String r = cl.getName();
        // inspect the fields of this class and all superclass
        //检查当前类和超类的所有字段
        do
        {
            r += "[";
            Field[] fields = cl.getDeclaredFields();
            AccessibleObject.setAccessible(fields, true);   //为反射对象设置可访问标志，flag为true表明屏蔽java的访问检查，让对象的私有属性可以被查询和设置 setAccessible是Field、method、constructor类的公共超类，这个特性是为调试、持久存储和相似机制提供的。
            //get the names and values of all fields  获取域中所有名字和值
            for (Field f : fields)
            {
                if (!Modifier.isStatic(f.getModifiers())) //返回F是否带有static修饰符
                {
                    if (!r.endsWith("[")) r += ",";
                    r += f.getName() + "=";
                    try{
                        Class<?> t = f.getType();
                        Object val = f.get(obj);
                        if (t.isPrimitive()) r += val;
                        else r += toString();
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
            r += "]";
            cl = cl.getSuperclass();
        }
        while (cl != null);
        return r;
    }
}