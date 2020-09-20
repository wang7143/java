package test.account;

public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt) {
        if(amt > 0){
            balance += amt;
            System.out.println("存入成功");
        }
    }

    public void withdraw(double amt) {
        if(balance >= amt){
            balance -= amt;
            System.out.println("取钱成功");
        }
    }


    

}
