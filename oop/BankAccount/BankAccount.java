public class BankAccount {
	private double checkingBalance;
	private double savingBalance;
	
	public static int numberOfAccounts;
	public static int totalAmountStored;

	

	
	public BankAccount() {
		this.checkingBalance = 0;
		this.savingBalance = 0;
		numberOfAccounts++;
		
	}
	
	public BankAccount(double checkingBalance, double savingBalance) {
		this.checkingBalance = checkingBalance;
		this.savingBalance = savingBalance;
		numberOfAccounts++;
		totalAmountStored +=(this.checkingBalance + this.savingBalance);
	}

	public double getCheckingBalance() {
		return checkingBalance;
	}
	
	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}
	
	public double getSavingBalance() {
		return savingBalance;
	}
	public void setSavingBalance(double savingBalance) {
		this.savingBalance = savingBalance;
	}

    public void depositMoney(double depositAmount, String accountType) {
		if (accountType == "checking") {
			this.checkingBalance += depositAmount;
			totalAmountStored += depositAmount;
			System.out.println("$" + depositAmount  + numberOfAccounts);
		}
		else if (accountType == "saving") {
			this.savingBalance += depositAmount;
			totalAmountStored += depositAmount;
			System.out.println("$" + depositAmount + numberOfAccounts);
		}
		
	}
    public void withdrawMoney(double withdrawAmount) {
        if (withdrawAmount <= this.checkingBalance) {
            this.checkingBalance -= withdrawAmount;
            totalAmountStored -= withdrawAmount;
            System.out.println("$" + withdrawAmount +"Number of Accounts:"+ numberOfAccounts);
        }
        else {
            System.out.println("insufficient funds.");
        }
    }
    public void accountBalance() {
		System.out.println("Total balance is: $" + (getCheckingBalance() + getSavingBalance()));
	}
}
