package com.example.client;

import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class NetworkClientCallable implements Callable<RequestResponse>{
	private final RequestResponse request;
	
	public NetworkClientCallable(RequestResponse request) {
		this.request = request;
	}
	
	@Override
	public RequestResponse call() throws Exception {
		// TODO Auto-generated method stub
		
		try(Socket socket = new Socket(request.host, request.port);
				InputStream input = socket.getInputStream();
				Scanner scanner = new Scanner(input)){
			request.response = scanner.next();
			
		}catch (Exception e) {
			request.response = "Error: " + e.getMessage();
		}
				
		return request;
	}
	
	
	
}
