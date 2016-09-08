package net.ukr.p454.task323;

import java.util.Scanner;

public class Wallpapers2 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Input the height of the figure:");
		int height = sc.nextInt();
		sc.close();
		
		int i = (height * 2) - 1;
		int counter = 0;
		int j = 0;

		do {
			if (i > height) {
				if (counter == j) {
					System.out.println("*");
					j = j + 1;
					i--;
					counter = 0;
				} else {
					System.out.print("*");
					counter++;
				}
			}else {
				if (counter == j)
				{
					System.out.println("*");
					j = j - 1;
					i--;
					counter = 0;
				}else {
					System.out.print("*");
					counter++;
				}
			}
		} while (i > 0);
	}
}
