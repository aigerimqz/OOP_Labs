package com.example.client;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class NetworkClientMain {

    public static void main(String[] args) {
        String host = "localhost";
        ExecutorService executor = Executors.newCachedThreadPool();
        Map<RequestResponse, Future<RequestResponse>> callables = new HashMap<>();
        for (int port = 10000; port < 10010; port++) {
            RequestResponse lookup = new RequestResponse(host, port);
            NetworkClientCallable task = new NetworkClientCallable(lookup);
            Future<RequestResponse> future = executor.submit(task);
            callables.put(lookup, future);
//            try (Socket sock = new Socket(lookup.host, lookup.port);
//                    Scanner scanner = new Scanner(sock.getInputStream());) {
//                lookup.response = scanner.next();
//                System.out.println(lookup.host + ":" + lookup.port + " " + lookup.response);
//            } catch (NoSuchElementException | IOException ex) {
//                System.out.println("Error talking to " + host + ":" + port);
//            }
        }
        executor.shutdown();
        try {
        	executor.awaitTermination(5,TimeUnit.SECONDS);
        	
        }catch (InterruptedException e) {
			System.out.println("Interrupted while waiting for tasks to finish.");
		}
        
        for (Map.Entry<RequestResponse, Future<RequestResponse>> entry: callables.entrySet()) {
        	try {
        		RequestResponse response = entry.getValue().get();
        		System.out.println(response.host + ":" + response.port + " " + response.response);
        	}catch (Exception e) {
				System.out.println("Error getting result from server " + entry.getKey().port);
			}
        }
    }
}