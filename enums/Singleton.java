package enums;
/*
这种写法能够在多线程中很好的工作避免同步问题，同时也具备lazy loading机制，遗憾的是，由于synchronized的存在，效率很低，在单线程的情景下，完全可以去掉synchronized，为了兼顾效率与性能问题，改进后代码如下：
*/

public class Singleton {
    private static volatile Singleton singleton = null;

    private Singleton(){}

    public static Singleton getSingleton() {
       synchronized (Singleton.class){
           if (singleton == null){
               singleton = new Singleton();
           }
       } 
       return singleton;
    }
}

