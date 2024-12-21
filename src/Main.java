import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println();
            MenuUtil.printMenu();
            System.out.print("Please select : ");
            int option= sc.nextInt();
            switch (option){
                case 1 -> MenuUtil.addNewAccount();
                case 2 -> MenuUtil.addDeposit();
                case 3 -> MenuUtil.transferMoney();
                case 4 -> MenuUtil.totalDeposit();
                case 5 -> MenuUtil.customer();
            }
        }
    }
}