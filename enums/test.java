package enums;




public class test {
    public static void main(String[] args) {
        Season sprng = Season.SPRNG;
        System.out.println(sprng);

        // Season1 spring = Season1.SPRING;
        // System.out.println(spring);

        //values();
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }

        System.out.println(Season1.valueOf("SUMMER"));
    }
}

//5.0之前
class Season{
    private final String name;
    private final String Desc;
    //私有化构造器
    private Season(String name,String Desc){
        this.name = name;
        this.Desc = Desc;
    }

    //提供当前枚举类的多个对象
    public static final Season SPRNG = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "热");
    public static final Season AUTUM = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "冷");

    public String getName() {
        return name;
    }

    public String getDesc() {
        return Desc;
    }

    @Override
    public String toString() {
        return "Season [Desc=" + Desc + ", name=" + name + "]";
    }
}

//使用enum
enum Season1{
    SPRING("春天"),
    SUMMER("夏天"),
    AUTUMN("秋天"),
    WINTER("冬天");

    private final String name;

    private Season1(String s1) {
        this.name = s1;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.name;
    }
    
}