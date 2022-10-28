package com.Bank;

import java.util.*;
import java.util.Scanner;
import java.util.Set;

public class BankApplication {
	
	public static boolean isExist(long accNo, List<Account> li) {
		boolean b = false;
		
		for(Account a : li) {
			if(a.getAccNo() == accNo) {
				b = true;
				break;
			}
		}
		return b;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Account> accounts = new ArrayList();
		
		String menu = "\n*`````Bank Application Menu: ``````````*\n";
		menu += "*``````1. Create Account```````````````*\n";
		menu += "*``````2. Deposit``````````````````````*\n";
		menu += "*``````3. Withdraw`````````````````````*\n";
		menu += "*``````4. Balance``````````````````````*\n";
		menu += "*``````5. Display All Accounts`````````*\n";
		menu += "*``````6. Display Account detailes`````*\n";
		menu += "*``````7. History``````````````*\n";
		menu += "*``````8. Exit`````````````````````````*\n";
		menu += "Enter any Option:";
		
		while(true) {
			System.out.println(menu);
			int opt = sc.nextInt();
			
			switch(opt) {
				case 1:
					System.out.println("Enter Account Number: ");
					long accNo = sc.nextInt();
					Account	acc1 = new Account();
					
					if(!isExist(accNo, accounts)) {
						System.out.println("Enter Account Holder Name");
						String name = sc.next();
						System.out.println("Enter Gender: ");
						char gender = sc.next().charAt(0);
						System.out.println("Enter Aadhar Number: ");
						long aadhar = sc.nextLong();
						acc1.createAccount(accNo, name, gender, aadhar);
						accounts.add(acc1);
					}
					else {
						System.out.println("Account was already existed on this Number");
					}
					
					break;
				case 2:
					System.out.println("Enter Account Number: ");
					long accNo1 = sc.nextInt();
					boolean b1 = true; 
					
					for(Account a : accounts) {
						if(a.getAccNo() == accNo1) {
							System.out.println("Enter Amount");
							int amount = sc.nextInt();
							a.deposit(amount);
							b1 = false;
						}
					}
					
					if(b1) {
						System.out.println("Account Number is Not Found");
					}
					
					break;
				case 3:
					System.out.println("Enter Account Number: ");
					long accNo2 = sc.nextInt();
					boolean b2 = true; 
					
					for(Account a : accounts) {
						if(a.getAccNo() == accNo2) {
							System.out.println("Enter Amount");
							int amount = sc.nextInt();
							a.withdraw(amount);
							b2 = false;
						}
					}
					
					if(b2) {
						System.out.println("Account Number is Not Found");
					}
					
					break;
				case 4:
					System.out.println("Enter Account Number: ");
					long accNo3 = sc.nextInt();
					
					if(isExist(accNo3, accounts)) {
						for(Account a : accounts) {
							if(a.getAccNo() == accNo3) {
								System.out.println(a.getAccHolderName() + " " + a.getBalance());
							}
						}
					}
					else {
						System.out.println("Account Number is Not Found");
					}
					
					break;
				case 5:
					System.out.println("Account detailes are: \n");
					Account acc = new Account();
					acc.displayAllAcc(accounts);
					break;
				case 6:
					System.out.println("Enter Account Number: ");
					int accN = sc.nextInt();
					if(isExist(accN, accounts)) {
						Account acc2 = new Account();
						acc2.getAccDetailes(accN, accounts);
					}
					else {
						System.out.println("Account Number does not Exist");
					}
					break;
				case 7:
					System.out.println("Enter Account Number");
					long accNo4 = sc.nextLong();
					
					if(isExist(accNo4, accounts)) {
						for(Account a : accounts) {
							if(a.getAccNo() == accNo4) {
								System.out.println("Last 10 Transactions are: ");
								a.transactionList();
							}
						}
					}
					else {
						System.out.println("Account Number is Not found");
					}
					
					break;
				case 8:
					System.exit(0);
			}
			
		}
			
	}
	
}
