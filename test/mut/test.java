package test.mut;

public class test {
    public static void main(String[] args) {
        father P2 = new son2();

        son2 M1 = (son2)P2;

        M1.name();
        M1.a = 10;
        System.out.println(M1.getA());

        // son2 M2 = (son2)P2;

        // M2.name();
        char a = 'A';
        int b = 65;
        System.out.println(a == b);

    }
}
