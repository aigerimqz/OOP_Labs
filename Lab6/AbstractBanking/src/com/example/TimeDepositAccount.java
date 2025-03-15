package com.example;
import java.util.Date;

public class TimeDepositAccount extends Account{
	public TimeDepositAccount(double balance, Date maturityDate) {
        super(balance);
        this.maturityDate = maturityDate;
    }
	//time deposit account specific code
    private final Date maturityDate;
//    //generic account code
//    private double balance;
    
    @Override
    public String toString() {
        return getDescription() + ": current balance is " + balance;
    }

    //get description specific code
    @Override
    public String getDescription() {
        return "Time Deposit Account " + maturityDate;
    }

    //withdraw specific code
	@Override
	public boolean withdraw(double amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
