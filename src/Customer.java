import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Customer {
    String CustomerName, CustomerEmail, CustomerAadhar, CustomerAddress, CustomerPhone;
    BufferedReader buff;
    InputStreamReader isr;
    float balance;

    public Customer(String customerName, String customerEmail, String customerAadhar, String customerAddress, String customerPhone, float balance) {
        this.CustomerName = customerName;
        this.CustomerEmail = customerEmail;
        this.CustomerAadhar = customerAadhar;
        this.CustomerAddress = customerAddress;
        this.CustomerPhone = customerPhone;
        this.balance = balance;
    }

    public Customer(BufferedReader buff, InputStreamReader isr){
        this.buff = buff;
        this.isr = isr;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public String getCustomerEmail() {
        return CustomerEmail;
    }

    public String getCustomerAadhar() {
        return CustomerAadhar;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public String getCustomerPhone() {
        return CustomerPhone;
    }

    public float getBalance() {
        return balance;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public void setCustomerEmail(String customerEmail) {
        CustomerEmail = customerEmail;
    }

    public void setCustomerAadhar(String customerAadhar) {
        CustomerAadhar = customerAadhar;
    }

    public void setCustomerAddress(String customerAddress) {
        CustomerAddress = customerAddress;
    }

    public void setCustomerPhone(String customerPhone) {
        CustomerPhone = customerPhone;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
