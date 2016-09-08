package net.ukr.p454.task321;

import java.util.Scanner;

public class Circle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r = 4;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Input x:");		
		int x = sc.nextInt();
		
		System.out.print("Input y:");
		int y = sc.nextInt();
		
		sc.close();
		
		double c = Math.pow(x,2) + Math.pow(y, 2);
		if (r >= Math.sqrt(c))
		{
			System.out.println("In circle");
		}else {
			System.out.println("Out of circle");
		}
		
	}

}
