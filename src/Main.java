import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    BufferedReader buff;
    InputStreamReader isr;
    public Main() {
        if(isr == null)
            isr = new InputStreamReader(System.in);
        if(buff==null)
            buff = new BufferedReader(isr);
    }

    int selectedBank, selectedOperation;
    public static void main(String[] args) {
        Main obj = new Main();
        RBI rb = new RBI(obj.buff,obj.isr);
        System.out.println("Welcome to IBS\nPlease select your bank\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS\n5. IDFC");

        try {
            obj.selectedBank = Integer.parseInt(obj.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Customer Selected " + obj.selectedBank);
        System.out.println("Select your choice\n1. Deposit\n2. Withdrawl\n3. OpenFD\n4. Apply Loan\n5. Apply CC");

        try {
            obj.selectedOperation = Integer.parseInt(obj.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Customer Selected " + obj.selectedOperation);

        switch (obj.selectedOperation){
            case 1: rb.depositMoney(); break;
            case 2: rb.withdrawMoney(); break;
            case 3: try{
                        System.out.println("Enter the amount for FD: \n");
                        rb.amount = Float.parseFloat(obj.buff.readLine());
                        System.out.println("Enter the ROI for FD: \n");
                        rb.ROI = Float.parseFloat(obj.buff.readLine());
                        System.out.println("Enter the years for FD: \n");
                        rb.years = Integer.parseInt(obj.buff.readLine());
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    rb.openFD(rb.amount, rb.ROI,rb.years);
            case 4: try{
                System.out.println("Enter the amount for your Loan: \n");
                rb.amount = Float.parseFloat(obj.buff.readLine());
                System.out.println("Enter the ROI for your Loan: \n");
                rb.ROI = Float.parseFloat(obj.buff.readLine());
                System.out.println("Enter the years for your Loan: \n");
                rb.years = Integer.parseInt(obj.buff.readLine());
            }catch (IOException e){
                e.printStackTrace();
            }
                rb.applyLoan("HELLO",rb.amount, rb.ROI,rb.years);
            default: rb.getBalance();

        }

    }
}