package test.account;

public class Bank {
    private Customer[] customers = new Customer[10];
    private int numberOCustomers;

    public void addCustomer(String f,String l) {

        Customer cust = new Customer(f,l);
        // customers[numberOCustomers] = cust;
        customers[numberOCustomers++] = cust;
    }

    public int  getNumofCustomers() {
        return numberOCustomers;
    }

    public Customer getCustomer(int index) {
        if (index >= 0 && index < numberOCustomers){
            return customers[index];
        }
        return null;
    }
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addCustomer("Jane", "Smith");
        bank.getCustomer(0).setAccount(new Account(2000));
        bank.getCustomer(0).getAccount().withdraw(500);
        double balance = bank.getCustomer(0).getAccount().getBalance();
        System.out.println("客户" + bank.getCustomer(0).getFirstName() + "的余额" + balance);
        
        System.out.println("***************");
        bank.addCustomer("wanli", "yang");

        System.out.println("bank customers " + bank.getNumofCustomers());
    
    }
}
