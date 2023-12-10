import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public interface RBI {

    void depositMoney(Customer cus);

    void withdrawMoney(Customer cus);

    void openFD(Customer cus,float amount, float ROI, int years);

    void applyLoan(String loanType, float amount, int years);

    void applyCreditCard(Customer cus);

    void getBalance(Customer cus);

    void addCustomer(Customer cus);

    int getTotalCustomer();

}
