package net.ukr.p454.task21;

import java.util.Scanner;

public class GetFiveDigit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter five integer digits from 10000 to 99999 and press Enter:");
		int digits = sc.nextInt();

		System.out.println("The first  digit is:" + digits / 10000);
		System.out.println("The second digit is:" + (digits%10000)/1000);
		System.out.println("The third  digit is:" + (digits%1000)/100);
		System.out.println("The fourth digit is:" + (digits%100)/10);
		System.out.println("The fifth  digit is:" + digits%10);
		
		sc.close();
	}
}
