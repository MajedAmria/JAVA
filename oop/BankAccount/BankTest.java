public class BankTest {

    public static void main(String[] args) {

        BankAccount bank1 =new BankAccount(100,250);

        bank1.depositMoney(50,"saving");
        bank1.withdrawMoney(100);
        bank1.accountBalance();
        
    }
    
}
