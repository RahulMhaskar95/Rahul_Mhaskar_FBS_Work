class BankAccount 
{
    static String bankName = "ABC Bank";
    String accountHolder;
    int accountNumber;
    double balance;
    BankAccount(String accountHolder, int accountNumber, double balance) 
    {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    void deposit(double amount) 
    {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
            return;
        }
        balance = balance + amount;
        System.out.println("Deposit Successful: " + amount);
        System.out.println("Balance: " + balance);
    }

    
    void deposit(double amount, String description) 
    {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
            return;
        }
        balance = balance + amount;
        System.out.println("Deposit Successful: " + amount);
        System.out.println("Transaction: " + description);
        System.out.println("Balance: " + balance);
    }

  
    void displayDetails() 
    {
        System.out.println("Bank: " + bankName);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

public class  bank_test {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Rahul", 1001, 5000);
        BankAccount acc2 = new BankAccount("Amit", 1002, 3000);
        acc1.displayDetails();
        acc1.deposit(2000, "Salary Credit");
        System.out.println();
        acc2.displayDetails();
    }
}