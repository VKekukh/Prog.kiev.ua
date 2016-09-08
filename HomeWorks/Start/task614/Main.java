package net.ukr.p454.task614;

import java.util.Formatter;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printPI(10);
	}

	static void printPI (int count ) {
		Formatter formatter = new Formatter();

		for (int i = 2; i <= count + 1; i++) {
			formatter.flush();
			formatter.format("PI = %." + i + "f\n", Math.PI);
		}
		System.out.println(formatter.toString());

	}

}
