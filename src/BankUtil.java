import java.math.BigDecimal;

public class BankUtil {
    public static void addCustomer(Customer customer){
        Bank.customers[Bank.customerCount++]=customer;
    }
    public static void addAccountToCustomer(Long customerNo, Account account){
       Customer customer= searchCustomer(customerNo);
       Account [] accounts= customer.getAccounts();
       accounts [customer.getAccountCount()] =account;
       customer.setAccountCount(customer.getAccountCount()+1);

    }
    public static  Customer searchCustomer(Long customerNo){
        for (int i=0; i<Bank.customerCount; i++){
            if(Bank.customers[i].getCustomerNo().equals(customerNo)){
                return Bank.customers[i];
            }
        }
        throw new RuntimeException("Customer not found");
    }
    public static void transferMoneyFromTo(Long accountNoFrom, Long accountNoTo, BigDecimal money){
        Account accountFrom = searchAccount(accountNoFrom);
        Account accountTo= searchAccount(accountNoTo);
        accountFrom.setAmount(accountFrom.getAmount().subtract(money));
        accountTo.setAmount(accountTo.getAmount().add(money));
    }
    public static Account searchAccount(Long accountNo){
        for (int i=0; i<Bank.customerCount; i++){
            Customer customer= Bank.customers[i];
            for (int j=0; j<customer.getAccountCount(); j++){
                Account account= customer.getAccounts()[j];
                if (account.getAccountNo().equals(accountNo)){
                    return account;
                }
            }
        }
        throw new RuntimeException("Account not found");
    }

    public static void deposit(Long accountNo, BigDecimal deposit){
        Account account = searchAccount(accountNo);
        account.setAmount(account.getAmount().add(deposit));
    }
    public static void createCustomer(Customer customer){
        for (int i=0; i<Bank.customerCount; i++){
            Bank.customers[i]=customer;
        }
    }
}
