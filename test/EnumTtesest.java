package test;

public enum EnumTtesest { 
    UNIT("个位",1),TEN("十位",2),HUNDREDS("百位",3);

    private String name1;  
    private int index;  
    // 构造方法  
    private EnumTtesest(String name1, int index) {  
        this.name1 = name1;  
        this.index = index;  
    }

    public static String getName(int index) {  
        for (EnumTtesest c : EnumTtesest.values()) {  
            if (c.getIndex() == index) {  
                return c.name1;  
            }  
        }  
        return null;  
    }

    // get set 方法  
    public String getName() {  
        return name1;  
    }

    public int getIndex() {  
        return index;  
    }

    public static String getClassname(int index) {
        for (EnumTtesest c : EnumTtesest.values()) {  
            if (c.getIndex() == index) {  
                return c.name(inst);  
            }  
        }
        return null;
    }
} 


