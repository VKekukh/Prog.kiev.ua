package net.ukr.p454.task23;

import java.util.Scanner;
 

public class GetCircumFerence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter radius and press Enter:");
		
		double radius = sc.nextDouble();
		
		double circumFerence = 2 * Math.PI * radius;
		System.out.println("The circumference is: "+ circumFerence);
		
		sc.close();
		
	}

}
