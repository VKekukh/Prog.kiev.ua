package net.ukr.p454.task622;


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		System.out.print("Input first number:");
		int number1 = scanner.nextInt();

		System.out.print("Input second number:");
		int number2 = scanner.nextInt();
		
		scanner.close();
		
		getDistanceByHaming(number1, number2);
		
	};
	
	static void getDistanceByHaming (int number1, int number2){
		String  number = Integer.toBinaryString( number1^number2);

		char[] array = number.toCharArray();
		
		int distance  = 0;
		
		for (char c : array) {
			if (c == '1'){
				distance ++;
			}
		}
		
		System.out.println("Distance by Haming:" + distance);
	}

}
