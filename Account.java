import java.util.Scanner;

public class Account {
	double balance;
	double previousTransaction;
	String customerName;
	String customerID;
	Scanner input = new Scanner(System.in);
	Account(String name, String id){
		customerName = name;
		customerID = id;
	}

	public void balance() {
		System.out.println("===========================");
		System.out.println("Your current balance is: "+balance);
		System.out.println("===========================");
	}
	
	public void newBalance() {
		System.out.println("===========================");
		System.out.println("Your new balance is: "+balance);
		System.out.println("===========================");
	}
	
	public void deposit() {
		System.out.println("===========================");
		System.out.print("Please enter the amount you want to deposit into your account: ");
		double deposit = input.nextInt();
		balance += deposit;
		previousTransaction = deposit;
		System.out.println("Amount DEPOSITED: " + deposit);
		System.out.println("===========================");
		newBalance();
	}
	
	public void withdrawal() {
		System.out.println("===========================");
		System.out.print("Please enter the amount you want to withdraw from your account: ");
		double withdrawal = input.nextInt();
		balance -= withdrawal;
		previousTransaction = -withdrawal;
		System.out.println("Amount withdrawed: " + withdrawal);
		System.out.println("===========================");
		newBalance();

	}

	public void previousTransaction() {
		if(previousTransaction > 0) {
			System.out.println("Deposited "+ previousTransaction);
		} else if(previousTransaction < 0) {
			System.out.println("Withdrawan "+ Math.abs(previousTransaction));
		} else {
			System.out.println("No transaction occured.");
		}
	}
	
	public void interest() {
		System.out.println("===========================");
		System.out.println("How many years of interest would you like to calculate:");
		double years = input.nextDouble();
		System.out.println("The current interest rate is: 1.9% annual");
		double afterInterest = balance + (balance * years * 0.019);
		System.out.println("After "+years+" years, at a interest rate of 1.9%, your balance will be: "+afterInterest);
		System.out.println("===========================");
	}
	
	public void getMenu() {
		System.out.println(customerName + ", Welcome to the poorest bank on the planet!");
		System.out.println("Your ID is: " + customerID);
		System.out.println("We are ready to take all of your money!\n");
		System.out.println("What would you like to do today, sir?\n");
		System.out.println("A:\tCheck your balance");
		System.out.println("B;\tMake a Deposit");
		System.out.println("C:\tMake a withdrawal");
		System.out.println("D:\tView previous transaction");
		System.out.println("E:\tCalculate Interest");
		System.out.println("F:\tExit");
		char option;
		
		do {
			System.out.println("\nENTER OPTION\n");
			
			option = Character.toUpperCase(input.next().charAt(0));
			System.out.println();
			if(option == 'A') {
				balance();
				continue;
			}
			else if(option == 'B') {
				deposit();
				continue;
			}
			else if(option == 'C') {
				withdrawal();
				continue;
			}
			else if(option == 'D') {
				previousTransaction();
				continue;
			}
			else if(option == 'E') {
				interest();
				continue;
			}
			else {
				System.out.println("PLEASE ENTER A CORRECT OPTION");
				continue;
			}
		
		
		} while(option != 'F');
		
		if(option == 'F') System.out.println("Looks like you found out this was a scam.");
		System.out.println("Thank you for stopping by, we doubt you'll come back again.");
	
	
	}
}
