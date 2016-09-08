package net.ukr.p454.task314;

import java.util.Scanner;

public class Factorial {

	/**
	 * Вычислить с помощью цикла факториал числа - n введенного с клавиатуры
	 * (4<n<16). Факториал числа это произведение всех чисел от этого числа до
	 * 1. Например 5!=5*4*3*2*1=120
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Input number between 4 and 16:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int factorial = 1;

		if (n >= 4 && n <= 16) {
			for (int i = n; i > 0; i--) {
				factorial = factorial * i;
			}

			System.out.println(factorial);
		} else {
			System.out.println("Wrong number!");
		}
	}

}
