package net.ukr.p454.task613;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//input
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input number in binary system:");
		String str = scanner.nextLine();
		
		char [] array = str.toCharArray();
		
		scanner.close();
		
		System.out.println(getDec(array));
		
	}
	
	static int getDec(char[] array) {
		int result = 0; 
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] == '1') {
				result = result + (int)Math.pow(2, (array.length-1) - i);
			}
		}
		
		return result;
	}

}
