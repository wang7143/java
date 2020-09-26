package Threadt;

public class single {
    
}


class Bank{
    private Bank(){}

    private static Bank instance = null;

    public static synchronized Bank getInstance(){
        if(instance == null){
            instance = new Bank(); 
        }
        return instance;
    }
}
