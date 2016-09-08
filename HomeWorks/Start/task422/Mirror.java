package net.ukr.p454.task422;

import java.util.Arrays;
import java.util.Scanner;

public class Mirror {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Input length array:");
		int length = sc.nextInt();

		int[] array = new int[length];

		// Fill array
		for (int i = 0; i < array.length; i++) {
			System.out.print("Input number of array:");
			array[i] = sc.nextInt();
		}
		System.out.println("Old array: " + Arrays.toString(array));

		// Mirror
		for (int j = 0; j < array.length / 2; j++) {
			int k = (array.length - 1) - j;
			int t = array[j];
			array[j] = array[k];
			array[k] = t;
		}
		System.out.println("Mirror array:" + Arrays.toString(array));
		sc.close();
	}
}
