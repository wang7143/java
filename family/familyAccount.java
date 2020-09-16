package family;

import java.util.Scanner;
/**
 * *@author dong
 * !@version 2.0
 */


public class familyAccount {
    public static void main(String[] args) {
        
        Scanner num = new Scanner(System.in);
        int select;
        String details = "";
        int principal = 10000;
        // int[][] arr = new int[5][];
        while (true) { 
            print_menu();
            select = num.nextInt();
            if (select < 1 && select > 4){
                System.out.println("输入错误，请输入1-4");
                continue;
            }
            else{
                switch (select) {
                    case 1:
                        System.out.println("收支明细");
                        in_out();
                        System.out.print(details);
                        break;
                    case 2:
                        System.out.println("登记收入");
                        details = income(num,details,principal);
                        break;
                    case 3:
                        System.out.println("登记支出");
                        details = out(num, details, principal);
                        break;
                    case 4:
                        System.out.println("确认是否退出Y/N");
                        char s = num.next().charAt(0);
                        
                        if (s == 'N' || s == 'n'){
                            break;
                        }
                        else if (s == 'Y' || s == 'y'){
                            num.close();
                            System.exit(0);
                        }
                        else{
                            System.out.println("输入错误");
                            break;
                        }     
                }
            }
        }
    }

    public static void print_menu() {
        System.out.println("-----------家庭收支记账软件-----------");
        System.out.println("            1 收支明细                ");
        System.out.println("            2 登记收入                ");
        System.out.println("            3 登记指出                ");
        System.out.println("            4 退   出\n");
        System.out.println("            请选择（1-4）：");
    }

    public static void in_out() {
        System.out.println("-----------当前收支明细记录-----------");
        System.out.println("收支\t账户金额\t收支金额\t说明\t");
    }

    public static String income(Scanner num,String details,int principal) {
        System.out.print("本次收入金额：");
        int in = num.nextInt();
        System.out.print("本次收入说明：");
        String info = num.next();
        principal += in;
        details += ("收入\t" + principal +"\t\t" + in + "\t\t" + info + "\n");
        System.out.println("-----------登记完成-----------\n");
        return details;
    }

    public static String out(Scanner num,String details,int principal) {
        System.out.print("本次支出金额：");
        int out = num.nextInt();
        System.out.print("本次支出说明：");
        String info = num.next();

        if (principal >= out){
            principal -= out;
            details += ("收入\t" + principal +"\t\t" + out + "\t\t" + info + "\n");
        }
        else{
            System.out.println("支付失败，超出额度");
        }
        return details;
    }
}
