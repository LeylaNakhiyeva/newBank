import java.math.BigDecimal;
import java.util.Scanner;

public class MenuUtil {
    public static void printMenu(){
        String menu="1. Add new account \n" +
                "2. Add deposit \n" +
                "3. Transfer money to other account \n" +
                "4. Calculate the total deposit amount of the bank \n" +
                "5. Create customer";
        System.out.println(menu);
    }
    public static void customer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name: ");
        String name= sc.next();
        System.out.println("Surname: ");
        String surname = sc.next();
        System.out.println("Birth date: ");
        String birthDate = sc.next();
        System.out.println("CustomerNo: ");
        Long customerNo = sc.nextLong();
        Customer customer= new Customer();
        customer.setName(name);
        customer.setSurname(surname);
        customer.setBirthDate(birthDate);
        customer.setCustomerNo(customerNo);
        BankUtil.createCustomer(customer);
        System.out.println(customer.getName());
    }


    public static void addNewAccount () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter customerNo: ");
        Long customerNo = sc.nextLong();
        System.out.print("AccountNo: ");
        Long accountNo = sc.nextLong();
        System.out.println("Currency: ");
        String currency = sc.next();
        Account account = new Account();
        account.setAccountNo(accountNo);
        account.setAmount(account.getAmount());
        account.setCurrency(currency);
        BankUtil.addAccountToCustomer(customerNo, account);
    }

    public static void addDeposit(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter accountNo: ");
        Long accountNo = sc.nextLong();
        System.out.println("Enter deposit amount: ");
        BigDecimal depositAmount = sc.nextBigDecimal();
        BankUtil.deposit(accountNo, depositAmount);
    }

    public static void transferMoney(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter accountNoFrom: ");
        Long accountNoFrom = sc.nextLong();
        System.out.println("Enter accountNoTo: ");
        Long accountNoTo = sc.nextLong();
        System.out.println("Enter transferMoney: ");
        BigDecimal money = sc.nextBigDecimal();
        BankUtil.transferMoneyFromTo(accountNoFrom, accountNoTo, money);
    }

    public static void totalDeposit(){
        BigDecimal totalDeposit= BigDecimal.valueOf(0);
        for (int i=0; i<Bank.customerCount; i++){
            Customer customer= Bank.customers[i];
            for (int j=0; j< customer.getAccountCount(); j++){
                Account account= customer.getAccounts()[j];
                totalDeposit.add(account.getAmount());
            }
        }
        System.out.println("Total deposit: "+ totalDeposit);
    }

}
