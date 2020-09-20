package Sample_program.input_and_ouput;

import java.util.*;

public class Retirment2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("How much money will you contribute every year? ");
        double payment = in.nextDouble();
        
        System.out.print("Interest rate in %: ");
        double InterestRate = in.nextDouble();

        double balance = 0;

        String input;

        // update account balance while user isn't ready to retire
        do
        {
            //add this year's payment and interest
            balance += payment;
            double interest = balance * InterestRate / 100;
            balance += interest;


            //print current balance
            System.out.print("Ready to retire? (Y/N) ");
            input = in.next();
        }
        while (input.equals("N"));
        in.close();
    }
}