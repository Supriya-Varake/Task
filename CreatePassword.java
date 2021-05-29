package com.password;

import java.util.Random;

public class CreatePassword {
	
		private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
		private static final String UPPER_CASE = LOWER_CASE.toUpperCase();
		private static final String DIGITS = "0123456789";
		private static final String SPECIAL_CHAR = "!@#$%*{}[]()";
		
		
		public String getPassword(int length , int strength) {
			String password = null;
			if((length >= 4) &&(length<=10) &&(strength >0) && (strength <4)) {
				if(strength ==1) {
					password= generatePassword(length , (LOWER_CASE.concat(UPPER_CASE)));
				}
				else if(strength ==2) {
					
					password= generatePassword(length , (LOWER_CASE.concat(UPPER_CASE).concat(DIGITS)));
				}
				else if(strength ==3) {
					password= generatePassword(length , (LOWER_CASE.concat(UPPER_CASE).concat(DIGITS).concat(SPECIAL_CHAR)));
				}
			}
			
			else {
					System.out.println("length of password should be 4 to 10 characters and Strength should be 1 , 2 or 3\n\n"); 
			}
			return password;
			
		}
		
		private String generatePassword(int length, String refer) {
			Random r = new Random();
			char [] referChars = refer.toCharArray();
			char[] passChars = new char [length]; 
			for(int i=0 ; i<length ; i++) {
				passChars[i] = referChars[r.nextInt(referChars.length)];
			}
			String password = new String(passChars);
			return password;
		}
		
		
		public static void main(String[] args) {
		System.out.println("Password of weak strength : " + new CreatePassword().getPassword(8,3));	
		}
		
	}