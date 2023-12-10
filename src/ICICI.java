import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class ICICI implements RBI{

    HashMap<String, Float> mpp = new HashMap<String, Float>() ;
    private static ArrayList<Customer> list = new ArrayList<>();


    private float min_balance = 1000.0f;
    BufferedReader buff;
    InputStreamReader isr;


    public ICICI(BufferedReader buff, InputStreamReader isr) {
        if (isr != null) {
            this.isr = isr;
        } else {
            this.isr = new InputStreamReader(System.in); // Initialize isr if null
        }

        if (buff != null) {
            this.buff = buff;
        } else {
            this.buff = new BufferedReader(this.isr); // Initialize buff if null
        }
    }

    @Override
    public void depositMoney(Customer cus){
        System.out.println("Enter the amount you want to deposit: ");
        try {
            float amount = Float.parseFloat(buff.readLine());
            cus.balance+= amount;
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Your amount is: " + cus.getBalance());
    }
    @Override
    public void withdrawMoney(Customer cus){
        System.out.println("Enter the amount you want to withdraw: ");
        try {
            float amount = Float.parseFloat(buff.readLine());
            cus.balance -= amount;
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Your amount is: " + cus.getBalance());
    }

    @Override
    public void openFD(Customer cus,float amount, float ROI, int years) {
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
    public void applyCreditCard(Customer cus) {
        if(cus.getBalance() > 2*min_balance){
            System.out.println("Eligible for CreditCard");
        }else{
            System.out.println("Not Eligible for CreditCard");
        }
        // Implement credit card application logic
    }

    @Override
    public void getBalance(Customer cus) {
        System.out.println("Your current balance is: " + cus.getBalance());
    }


    @Override
    public void addCustomer(Customer cus){
        boolean bl = false;
        for (int i = 0; i < list.size(); i++) {
            Customer c = list.get(i);
            if (c.getCustomerAadhar().equalsIgnoreCase(cus.getCustomerAadhar())) {
                bl = true;
            }
        }
        if (!bl) {
            list.add(cus);
        }

    }

    @Override
    public int getTotalCustomer(){

        return list.size();
    }

}
