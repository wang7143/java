package reflection;

import java.io.Serializable;

public class Fa<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat() {
        System.out.println("生物进食");
    }
}
