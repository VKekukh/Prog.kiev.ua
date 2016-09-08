package net.ukr.p454.task623;

import java.awt.Paint;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input number: ");
		String string = scanner.nextLine();
		scanner.close();
		System.out.println("Min repeat number:" + getRepeatNumber(string));
	}

	static String getRepeatNumber(String string) {

		String part1 = "";
		String part2 = "";
		String min = "";
		int counter = 0;
		for (int i = string.length() / 2; i >0; i--) {
		
			for (int j = 0; j <= string.length()-i-i; j = j+i) {
				
				part1 = string.substring(j , j+i);
				part2 = string.substring(j+i,j+i+i); 
				
				if (part1.equals(part2)) {
					counter++;
				}

				
				if(counter == (string.length() / i -1) ) {
					min = part1;
				}
				
			}
			counter = 0;
		
		}

		return min;
	}
}
