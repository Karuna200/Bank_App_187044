import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class HDFC implements RBI{

    HashMap<String, Float> mpp = new HashMap<String, Float>() ;

    float balance = 1000.0f;
    BufferedReader buff;
    InputStreamReader isr;
    public HDFC (BufferedReader buff, InputStreamReader isr){
        if(isr == null){
            this.isr = isr;
        }
        if(buff == null) {
            this.buff = buff;
        }

    }
    @Override
    public void depositMoney(){
        System.out.println("Enter the amount you want to deposit: ");
        try {
            float amount = Float.parseFloat(buff.readLine());
            balance += amount;
        }
        catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Your Deposited amount is: " + balance);
    }
    @Override
    public void withdrawMoney(){
        System.out.println("Enter the amount you want to withdraw: ");
        try {
            float amount = Float.parseFloat(buff.readLine());
            balance -= amount;
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Your amount is: " + balance);
    }

    @Override
    public void openFD(float amount, float ROI, int years) {
        float profit = amount;
        for (int i = 0; i < years; i++) {
            profit += (ROI / 100) * profit;
        }
        System.out.println("Your Profit is: " + (profit - amount));
    }

    @Override
    public void applyLoan(String loanType, float amount, int years) {
//        HashMap<String, Float> mpp = new HashMap<>();
        mpp.put("Home",5f);
        mpp.put("Education",3f);
        mpp.put("Personal",6f);
        mpp.put("Car",8f);
        float profit = amount;
        if(mpp.containsKey(loanType)) {
            float x = mpp.get(loanType);
            for(int i=0;i<years;i++) {
                profit+=(x/100)*profit;
            }

        }
        System.out.println("Your intrest after applying loan is: " + (profit - amount));

    }

    @Override
    public void applyCreditCard() {
        // Implement credit card application logic
    }

    @Override
    public void getBalance() {
        System.out.println("Your current balance is: " + balance);
    }

}