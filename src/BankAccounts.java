public class BankAccounts {
    String AccountNo;
    float balance;

    public BankAccounts(String AccountNo,float balance){
        this.AccountNo = AccountNo;
        this.balance = balance;
    }

    public String getAccountNo() {
        return AccountNo;
    }

    public void setAccountNo(String accountNo) {
        AccountNo = accountNo;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
