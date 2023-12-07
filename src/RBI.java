import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public interface RBI {


    void depositMoney();

    void withdrawMoney();

    void openFD(float amount, float ROI, int years);

    void applyLoan(String loanType, float amount, int years);

    void applyCreditCard();

    void getBalance();
}
