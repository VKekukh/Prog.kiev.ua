package net.ukr.p454.task313;

import java.util.Scanner;

public class Wallpapers {

	/**
	 * С помощью циклов нарисовать «обои». Причем количество полос должно
	 * вводиться с клавиатуры. В примере 7 полос. 
	 * ***+++***+++***+++***
	 * ***+++***+++***+++*** 
	 * ***+++***+++***+++*** 
	 * ***+++***+++***+++***
	 * ***+++***+++***+++***
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String part1 = "***";
		String part2 = "+++";
		String fullPart = "";

		Scanner sc = new Scanner(System.in);
		System.out.print("Input length of wallpapers:");
		int length = sc.nextInt();
		sc.close();

		if (length >= 1) {
			for (int i = 1; i <= 5; i++) {
				for (int j = 1; j <= length; j++) {

					if (j % 2 == 0) {
						fullPart += part2;
					} else {
						fullPart += part1;
					}
				}
				System.out.println(fullPart);
				fullPart = "";
			}
		} else {
			System.out.println("Wrong number!");
		}
	}
}
