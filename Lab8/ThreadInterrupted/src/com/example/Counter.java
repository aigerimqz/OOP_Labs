package com.example;

public class Counter implements Runnable{
	int x = 0;
	
	while(!Thread.currentThread().isInterrupted()) {
		System.out.println("The curent value of x is: " + x++);
		
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			return;
		}
	}
}
