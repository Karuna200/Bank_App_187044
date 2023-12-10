import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    BufferedReader buff;
    InputStreamReader isr;
    public Main() {
        isr = new InputStreamReader(System.in);
        if(buff==null)
            buff = new BufferedReader(isr);
    }

    int selectedBank,selectedOperation;
    RBI temp = null;
    public static void main(String[] args) {
            Main obj = new Main();
            while(true) {
                System.out.println("Welcome to IBS\nPlease select your bank\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS\n5. IDFC");
                System.out.println("Please chose your bank: ");
                try {
                    obj.selectedBank = Integer.parseInt(obj.buff.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                    Customer cus = new Customer(obj.buff, obj.isr);
                    System.out.println("Please Enter your Details: ");
                    try {
                        System.out.println("Name: ");
                        cus.setCustomerName(obj.buff.readLine());
                        System.out.println("Email: ");
                        cus.setCustomerEmail(obj.buff.readLine());
                        System.out.println("Aadhar: ");
                        cus.setCustomerAadhar(obj.buff.readLine());

                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                switch (obj.selectedBank) {
                    case 1: {
                        obj.temp =  new ICICI(obj.buff, obj.isr);
                        break;
                    }

                }
                while (true)
                {
                    System.out.println("Select your choice\n1. Deposit\n2. Withdrawl\n3. OpenFD\n4. Apply Loan\n5. Apply Credit Card\n6.Add customer to the bank.\n7.Bank List");

                    try {
                        obj.selectedOperation = Integer.parseInt(obj.buff.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Customer Selected " + obj.selectedOperation);

                    switch (obj.selectedOperation) {
                        case 1:
                            //  System.out.println("deposit working start");
                            obj.temp.addCustomer(cus);
                            obj.temp.depositMoney(cus);
                            // System.out.println("deposit working end");
                            break;
                        case 2:
                            obj.temp.withdrawMoney(cus);
                            break;
                        case 3:
                            try {
                                System.out.println("Enter the amount for FD: \n");
                                float amount = Float.parseFloat(obj.buff.readLine());
                                System.out.println("Enter the ROI for FD: \n");
                                float ROI = Float.parseFloat(obj.buff.readLine());
                                System.out.println("Enter the years for FD: \n");
                                int years = Integer.parseInt(obj.buff.readLine());
                                obj.temp.openFD(cus, amount, ROI, years);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            break;
                        case 4:
                            try {
                                System.out.println("Enter the amount for your Loan: ");
                                float amount = Float.parseFloat(obj.buff.readLine());
                                System.out.println("Enter the ROI for your Loan: ");
                                int years = Integer.parseInt(obj.buff.readLine());
                                System.out.println("Enter the type of your Loan: ");
                                String loanType = obj.buff.readLine();
                                obj.temp.applyLoan(loanType, amount, years);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            break;
                        case 5: {
                            obj.temp.applyCreditCard(cus);
                            break;
                        }
                        case 6: {
                            obj.temp.addCustomer(cus);
                            System.out.println("Successfully added customer!!");
                            break;
                        }
                        case 7:{
                            System.out.println("Total customer to this bank particular bank is: " + obj.temp.getTotalCustomer());

                        }
                        default:
                            obj.temp.getBalance(cus);
                            break;
                    }
                    System.out.println("Do you want to continue?yes/no");
                    try {
                        int x = Integer.parseInt(obj.buff.readLine());
                        if(x==0){
                            break;
                        }
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }


                }
                }

    }

}
