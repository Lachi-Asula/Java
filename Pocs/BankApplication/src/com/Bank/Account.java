package com.Bank;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Iterator;

class InvalidAmountException extends Exception {
	
	InvalidAmountException(String str){
		super(str);
	}
}

class InsufficientFundsException extends Exception {
	InsufficientFundsException(String ex){
		super(ex);
	}
}

public class Account {
	private long accNo;
	private String accHolderName;
	static String bankName = "HDFC";
	static String ifsc = "HDFC0000023";
	private double balance = 0;
	private char gender;
	private long aadharNo;
	List<String> transactions = new ArrayList();
	
	void createAccount(long accNo, String accHolderName, char gender, long aadharNo) {		
		this.accNo = accNo;
		this.accHolderName = accHolderName;
		this.gender = gender;
		this.aadharNo = aadharNo;
		System.out.println("Account Created successfully");
	}

	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", accHolderName=" + accHolderName + ", BankName= " + bankName + ", IFSC= " + ifsc + ", balance= " + balance + ", gender="
				+ gender + ", adhaarNo=" + aadharNo + "]";
	}

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}
	
	void deposit(int amount) {
		try {
			if(amount <= 0) {
				throw new InvalidAmountException("Give valid Amount");
			}
			else {
				this.balance += amount; 
				System.out.println("Deposit Successful");
				this.transactions.add("Deposit amount: " + amount);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	void withdraw(int amount) {
		try {
			if(this.balance <= 0 || amount > this.balance) {
				throw new InsufficientFundsException("Insufficient Balance");
			}
			else {
				this.balance -= amount;
				System.out.println("Withdrawl successful");
				this.transactions.add("Withdrawl amount: " + amount);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	void displayAllAcc(List<Account> s) {
		
		for(Account a : s) {
			System.out.println(a);
		}
	}
	
	public void getAccDetailes(long accNo, List<Account> li) {
		for(Account a : li) {
			if(a.getAccNo() == accNo) {
				System.out.println(a);
			}
		}
		
	}
	
	void transactionList() {
		int size = this.transactions.size();
		
		if(size == 0) {
			System.out.println("No Transactions");
		}
		else if(size >= 10) {
			for(int i = size - 1; i >= size - 10; i--) {
				System.out.println(this.transactions.get(i));
			}
		}
		else {
			for(int i = size -1; i >= 0; i--) {
				System.out.println(this.transactions.get(i));
			}
		}
	}
	
}
