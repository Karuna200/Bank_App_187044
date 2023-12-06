import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    BufferedReader buff;

    InputStreamReader isr;
    public Main() {
        if(isr == null){
            isr = new InputStreamReader(System.in);
        }
        if(buff == null){
            buff = new BufferedReader(isr);
        }
    }
    int selectedBank;

    public static void main(String[] args){
      Main obj = new Main();
     System.out.println("Welcome to IBS\nPlease select your bank\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS\n5. IDFC");
     InputStreamReader isr = new InputStreamReader(System.in);
     BufferedReader buff = new BufferedReader(isr);
     try{
         obj.selectedBank = Integer.parseInt(obj.buff.readLine());
         System.out.println("Customer Selected" + obj.selectedBank);
     }
     catch (IOException e){
         e.printStackTrace();
     }


    }
}