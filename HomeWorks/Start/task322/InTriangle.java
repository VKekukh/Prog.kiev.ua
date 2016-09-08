package net.ukr.p454.task322;

import java.util.Scanner;

public class InTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double ax = 0;
		double ay = 0;
		double bx = 4;
		double by = 4;
		double cx = 6;
		double cy = 1;

		Scanner sc = new Scanner(System.in);

		System.out.print("Input x:");
		double x = sc.nextDouble();

		System.out.print("Input y:");
		double y = sc.nextDouble();

		sc.close();

		double ab = (ax - x) * (by - ay) - (bx - ax) * (ay - y);
		double bc = (bx - x) * (cy - by) - (cx - bx) * (by - y);
		double ca = (cx - x) * (ay - cy) - (ax - cx) * (cy - y);

		if ((ab >= 0 && bc >= 0 && ca >= 0) || (ab <= 0 && bc <= 0 && ca <= 0)) {
			System.out.println("In the triangle");
		} else {
			System.out.println("Out of  the triangle");
		}

	}

}
