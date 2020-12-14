package lambda;

import java.util.*;

import javax.swing.*;

import javax.swing.Timer;

import org.junit.Test;



/**
 * This program demonstrates the use of lambda expressions
 * @version 2020年9月3日
 * @author Cay Horstmann
 */

/**
 * LambdaTest
 */
public class LambdaTest {
    public static void main(String[] args) {
        String[] planets = new String[] {"Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune"};

        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length: ");
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        //? sort方法接受实现了Comparator<String>的某个类对象。在这个对象上调用compare方法会执行这个lambda表达式体。这些对象和类的管理完全取决与具体实现，比传统的内联类高效，最好把lambda表示看作是一个函数，不是对象，要接受lambda表达式肯做是一个函数，而不是一个队象，另外要就接受lambda表达式可以传递到函数式接口。
        System.out.println(Arrays.toString(planets));

        Timer r = new Timer(1000, event -> System
        .out.println("The time is " + new Date()));
        r.start();

        //keep program running until user selects "OK"
        JOptionPane.showMessageDialog(null, "quit program?");
        System.exit(0);
    }
}


