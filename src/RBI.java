import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RBI {
    float balance = 1000.0f;
    int count, years;
    float amount, ROI;

    BufferedReader buff;
    InputStreamReader isr;
    public RBI(BufferedReader buff, InputStreamReader isr){
        this.buff = buff;
        this.isr = isr;
    }
    public void depositMoney() {
        System.out.println("Enter the amount you want to deposit: \n");
        try{
            float amount = Float.parseFloat(buff.readLine());
            balance+=amount;
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Your Deposited amount is: \n" + balance);
    }
    public void withdrawMoney(){
        count++;
        if(count > 3){
            try{
                float amount = Float.parseFloat(buff.readLine());
                amount+= 0.01*amount;
                balance-=amount;
                System.out.println("Your amount is: \n" + balance);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        System.out.println("Enter the amount you want to withdraw: \n");
        if(balance > 1000.0f){
            try{
                float amount = Float.parseFloat(buff.readLine());
                balance-=amount;
                System.out.println("Your amount is: \n" + balance);
            }catch (IOException e){
                e.printStackTrace();
            }

        }else{
            System.out.println("Insufficient balance");
        }

    }
    public void openFD(float amount, float ROI, int years) {
        float profit = amount;
        for(int i=0;i<years;i++){
            profit+=(ROI/100)*profit;
        }
        System.out.println("Your Profit is: \n" + (profit-amount));

    }
    public void applyLoan(String loanType, float amount, float ROI, int years) {

        float profit = amount;
        for(int i=0;i<years;i++){
            profit+=(ROI/100)*profit;
        }
        System.out.println("Your profit after applying loan is: \n" +(profit-amount));

    }
    public void applyCreditCard() {

    }
    public void getBalance() {
        System.out.println("Your current balance is : \n" + balance);
    }
}
