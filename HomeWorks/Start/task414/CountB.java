package net.ukr.p454.task414;

import java.util.Scanner;

public class CountB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your text:");
		String str = sc.nextLine();

		char[] array = str.toCharArray();

		int counter = 0;

		for (char c : array) {
			if (c == 'b') {
				counter++;
			}
		}
		System.out.println("The number of letters in your text:" + counter);
		sc.close();
	}

}
