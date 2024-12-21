import java.math.BigDecimal;

public class Account {
    private Long accountNo;
    private BigDecimal amount= BigDecimal.valueOf(0);
    private BigDecimal deposit= BigDecimal.valueOf(0);
    private String currency;
    public Account(){
        this.accountNo = accountNo;
        this.amount = amount;
        this.deposit= deposit;
        this.currency= currency;
    }
   public void setAccountNo(Long accountNo){
        this.accountNo= accountNo;
   }
   public Long getAccountNo(){
        return accountNo;
   }
   public void setAmount(BigDecimal amount){
        this.amount= amount;
   }
   public BigDecimal getAmount(){
        return amount;
   }
   public void setDeposit(BigDecimal deposit){
        this.deposit= deposit;
   }
   public BigDecimal getDeposit(){
        return deposit;
   }
   public void setCurrency(String currency){
        this.currency=currency;
   }
   public String getCurrency(){
        return currency;
   }

}
