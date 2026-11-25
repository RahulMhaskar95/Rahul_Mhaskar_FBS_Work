class Account {
    double balance;
    Account(double balance) 
    {
        this.balance = balance;
    }
    void withdraw(double amount) 
    {
        if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be positive.");
        } 
        else if (amount > balance) 
        {
            System.out.println("Error: Insufficient balance.");
        } 
        else {
            balance = balance - amount;
            System.out.println("Withdrawal successful: Rs. " + amount + "\nRemaining balance: Rs. " + balance);
        }
        System.out.println("Transaction process completed. \n");
    }
}

public class atm_test {
    public static void main(String[] args) 
   {
        Account account = new Account(10000.0);
        account.withdraw(2000.0);
        account.withdraw(15000.0);
        account.withdraw(0.0);
    }
}