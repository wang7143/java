package reflection;


@MyAnnotaion
public class Per extends Fa<String> implements Comparable<String>,Myinterface{

	@Override
	public int compareTo(String o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void info() {
		// TODO Auto-generated method stub
		System.out.println("人");
    }
    
    private String name;
    int age;
    public int id;

    public Per(){}

    @MyAnnotaion(value="abc")
    private Per(String name){
        this.name = name;
    }
    
    Per(String name,int age){
        this.name = name;
        this.age = age;
    }

    @MyAnnotaion
    private String show(String nation) {
        System.out.println(nation);
		return nation;
    }

    public String display (String ins) throws NullPointerException{
        return ins;
    }

    private static void name() {
        System.out.println("静态方法");
    }

    @Override
    public String toString() {
        return "Per [age=" + age + ", id=" + id + ", name=" + name + "]";
    }

    
}
