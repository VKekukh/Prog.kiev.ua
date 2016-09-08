package net.ukr.p454.task311;

import java.util.Scanner;

public class MaxNumber {

	/**
	 * Написать программу которая считает 4 числа c клавиатуры и выведет на экран самое большое из них.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int max;
		
		System.out.print("Input the first  digit:");
		int a = sc.nextInt();
		
		System.out.print("Input the second digit:");
		int b = sc.nextInt();
		
		System.out.print("Input the third  digit:");
		int c = sc.nextInt();
		
		System.out.print("Input the fourth digit:");
		int d = sc.nextInt();
		
		sc.close();
		
		max = a;
		
		max = (max>b)?max:b;
		max = (max>c)?max:c;
		max = (max>d)?max:d;
		
		System.out.println("The max number is:"+max);
				
	}

}
