package com.example;

public class Counter implements Runnable{
	@Override
    public void run() {
        int count = 0;
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(count++);
                Thread.sleep(1000); 
            }
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted.");
        }
    }
}
