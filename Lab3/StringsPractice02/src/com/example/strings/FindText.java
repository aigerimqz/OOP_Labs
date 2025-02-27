package com.example.strings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FindText {

//    private String fileName = "D:/OOP_labworks/Lab3/StringsPractice02/gettys.html";
    // Create Pattern
    private Pattern pattern;
    
    // Create Matcher
    private Matcher m;

    public static void main(String[] args) {
//    	if(args.length < 2) {
//    		System.out.println("java FindText <filename> <regex>");
//    		return;
//    	}
    	String fileName = args[0];
    	String regex = args[1];
        FindText find = new FindText();
        find.run(fileName, regex);
    }
    
    public void run(String fileName, String regex) {
//    	File file = new File(fileName);
    	if(!new File(fileName).exists()) {
    		System.out.println("File not found((");
    		return;
    	}
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        	
            String line = "";
            int c = 1;
            pattern = Pattern.compile(regex);
//            pattern = Pattern.compile("<h4>");
//            pattern = Pattern.compile("\\bto\\b");
//            pattern = Pattern.compile("^\\s{4}");
//            pattern = Pattern.compile("^<[p|d]");
//            pattern = Pattern.compile("^</.*?>$");
            while ((line = reader.readLine()) != null) {
                // Generate a matcher based on Pattern
            	m = pattern.matcher(line);
                // Search for text
            	if(m.find()) {
            		System.out.println(" " + c + " " + line);
            	}
                // Print results
                c++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
