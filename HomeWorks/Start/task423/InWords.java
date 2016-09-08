package net.ukr.p454.task423;

import java.util.Arrays;
import java.util.Scanner;

public class InWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Input amount: ");

		String amount = sc.nextLine();
		String[] parts = amount.split("[,.]");

		String output = "";
		sc.close();

		String[] simpleNumbres = { "zero", "one", "two", "three", "four",
				"five", "six", "seven", "eight", "nine", "ten", "eleven",
				"twelve", "thirteen", "fourteen", "fifteen", "sixteen",
				"seventeen", "eighteen", "nineteen" };

		String[] tyNumbres = { "", "", "twenty", "thirty", "forty", "fifty",
				"sixty", "seventy", "eighty", "ninety" };

		String[] arrayNumbers = new String[100];

		for (int i = 0; i < 100; i++) {
			if (i < 20) {
				arrayNumbers[i] = simpleNumbres[i];
			} else {
				if (i % 10 == 0) {
					arrayNumbers[i] = tyNumbres[i / 10];
				} else {
					arrayNumbers[i] = tyNumbres[i / 10] + " "
							+ simpleNumbres[i % 10];
				}
			}
		}

		int toNumber = Integer.parseInt(parts[0]);

		if (toNumber / 1000000 > 0) {
			if (toNumber / 100000000 >= 1) {
				output = arrayNumbers[toNumber / 100000000] + " hundred and ";
			}

			output = output + arrayNumbers[toNumber / 1000000 % 100]
					+ " million ";
		}

		if (toNumber / 1000 > 0) {
			if (toNumber / 1000 % 1000 / 100 >= 1) {
				output = output + arrayNumbers[toNumber / 1000 % 1000 / 100]
						+ " hundred and ";
			}

			output = output + arrayNumbers[toNumber / 1000 % 1000 % 100]
					+ " thousand ";
		}

		if (toNumber % 1000 / 100 >= 1) {

			output = output + arrayNumbers[toNumber % 1000 / 100]
					+ " hundred and ";
		}
		output = output + arrayNumbers[toNumber % 100] + " dollars ";

		if (parts[1].length() == 1) {
			toNumber = Integer.parseInt(parts[1] + "0");
		} else {
			toNumber = Integer.parseInt(parts[1]);
		}
		output = output + arrayNumbers[toNumber] + " cents";
		System.out.println(output);

	}

}
