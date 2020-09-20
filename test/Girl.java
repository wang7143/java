package test;



/**
  *!@description:
  *@author: dong
  *@date: 2020-09-17 07:50:13
  *@version: V1.0.5
*/

public class Girl {

    private String name;
    private int age;

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Girl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void marry(boy boy) {
        System.out.println("嫁" + boy.getName());
        boy.marry(this);
    }

    /**
     * 
     * @param girl
     * 
     */
    
    public int compare(Girl girl) {
        return this.age - girl.age;
    }

    public Girl() {
    }
	

}
