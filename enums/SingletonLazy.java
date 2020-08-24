package enums;

/*
    显然这种写法比较简单，但问题是无法做到延迟创建对象，事实上如果该单例类涉及资源较多，创建比较耗时间时，我们更希望它可以尽可能地延迟加载，从而减小初始化的负载，于是便有了如下的懒汉式单例：
*/

public class SingletonLazy {

    private static volatile SingletonLazy instance;

    private SingletonLazy(){

    }

    public static synchronized SingletonLazy getInstance() {
        if (instance == null){
            instance = new SingletonLazy();
        }
        return instance;
    }
    
}