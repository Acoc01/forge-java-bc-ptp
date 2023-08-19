package vergara_rodolfo_bank_account;

import java.util.Random;

public class BankAccount {
	private String AccountNumber;
	private double Balance;
	private double Savings;
	private static int NumberOfAccounts;
	private static double TotalBalance;
	
	private long AccountNumber() {
		Random rnd = new Random();
		return (rnd.nextInt(Integer.MAX_VALUE-1000000000) + 1000000000);
	}

	public BankAccount() {
		this.AccountNumber = Long.toString(AccountNumber());
		addNewAccount();
	}

	public double checkBalance() {
		return Balance;
	}
	
	public double checkSavings() {
		return Savings;
	}
	
	public static double checkTotalBalance() {
		return TotalBalance;
	}
	
	private static void addNewAccount() {
		NumberOfAccounts++;
	}
	
	private static void calculateTotalBalance(double num) {
		TotalBalance+=num;
	}

	public void depositInCheckingAccount(double balance) {
		Balance += balance;
		calculateTotalBalance(balance);
	}
	
	public void depositInSavingAccount(double balance) {
		Savings += balance;
		calculateTotalBalance(balance);
	}
	
	public double withdrawFromCheckingAccount(double ammount) {
		if(ammount > this.Balance) {
			System.out.println("You don't have enough money.");
			return -1.0;
		}else if(ammount < 0) {
			System.out.println("You can't withdraw a negative ammount.");
		}else {
			this.Balance-=ammount;
			return ammount;
		}
		return -1.0;
	}

	public double withdrawFromSavingAccount(double ammount) {
		if(ammount > this.Savings) {
			System.out.println("You don't have enough money.");
			return -1.0;
		}else if(ammount < 0) {
			System.out.println("You can't withdraw a negative ammount.");
		}else {
			this.Savings-=ammount;
			return ammount;
		}
		return -1.0;
	}
}
