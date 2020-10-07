package Threadt.acount;

public class AccountTest {
    public static void main(String[] args) {
        Account acct = new Account(0);
        Customer c1 = new Customer(acct);
        Customer c2 = new Customer(acct);

        c1.setName("甲");
        c2.setName("乙");

        c1.start();
        c2.start();



    }
}

class Account {
    private double money;

    public Account(double money) {
        this.money = money;
    }

    public synchronized void deposit(double amt) {
        if (amt > 0) {
            money += amt;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "存钱成功。余额为：" + money);
        }
    }
}


class Customer extends Thread{
    private Account acct;

    public Customer(Account acct) {
        this.acct = acct;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for(int i = 0;i < 3; i++){
            acct.deposit(1000);
        }
    }
}