package net.ukr.p454.task22;

import java.util.Scanner;

public class GetTriangleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter length first side of triangle and press Enter:");
		double a = sc.nextDouble();

		System.out.print("Enter length second side of triangle and press Enter:");
		double b = sc.nextDouble();

		System.out.print("Enter length third side of triangle and press Enter:");
		double c = sc.nextDouble();

		double p = (a + b + c) / 2;

		System.out.println("The half-perimeter of the triangle " + p);
		System.out.println("The area of the triangle "
				+ Math.sqrt(p * (p - a) * (p - b) * (p - c)));
		sc.close();

	}
}
