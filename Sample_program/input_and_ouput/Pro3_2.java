package Sample_program.input_and_ouput;

import java.util.*;


public class Pro3_2 {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        //get first input
        System.out.print("What is your name?");
        String name = in.nextLine();

        //GET SECOND input
        System.out.print("How old are you? ");
        int age = in.nextInt();

        //display output on console
        System.out.println("Hello, "+ name + ".Next year, you'll be " + (age + 1));
        in.close();
    }
}

// Mon Feb 09 18:05:19 PST 2015