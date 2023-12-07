import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    float balance;
    float amount;
    float ROI;
    String loanType;

    int years;

    BufferedReader buff;
    InputStreamReader isr;
    public Main() {
        isr = new InputStreamReader(System.in);
        if(buff==null)
            buff = new BufferedReader(isr);
    }

    int selectedBank,selectedOperation;
    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println("Welcome to IBS\nPlease select your bank\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS\n5. IDFC");

        RBI temp = null;

        try {
            obj.selectedBank = Integer.parseInt(obj.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        switch (obj.selectedBank){
            case 1: temp = new ICICI(obj.buff, obj.isr); break;
            case 2: temp = new HDFC(obj.buff, obj.isr); break;
            case 3:
            case 4:
            case 5:

        }
        System.out.println("Select your choice\n1. Deposit\n2. Withdrawl\n3. OpenFD\n4. Apply Loan\n5. Apply CC");

        try {
            obj.selectedOperation = Integer.parseInt(obj.buff.readLine());
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Customer Selected " + obj.selectedOperation);

        switch (obj.selectedOperation){
            case 1: temp.depositMoney(); break;
            case 2: temp.withdrawMoney(); break;
            case 3: try{
                System.out.println("Enter the amount for FD: \n");
                obj.amount = Float.parseFloat(obj.buff.readLine());
                System.out.println("Enter the ROI for FD: \n");
                obj.ROI = Float.parseFloat(obj.buff.readLine());
                System.out.println("Enter the years for FD: \n");
                obj.years = Integer.parseInt(obj.buff.readLine());
            }catch (IOException e){
                e.printStackTrace();
            }
                temp.openFD(obj.amount, obj.ROI,obj.years); break;
            case 4: try{
                System.out.println("Enter the amount for your Loan: ");
                obj.amount = Float.parseFloat(obj.buff.readLine());
                System.out.println("Enter the ROI for your Loan: ");
                obj.years = Integer.parseInt(obj.buff.readLine());
                System.out.println("Enter the type of your Loan: ");
                obj.loanType = obj.buff.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
                temp.applyLoan(obj.loanType,obj.amount,obj.years); break;
            default: temp.getBalance(); break;

        }
    }
}