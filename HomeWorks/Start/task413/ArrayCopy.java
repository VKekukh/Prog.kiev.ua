package net.ukr.p454.task413;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Input length array: ");
		int arrayLength = sc.nextInt();

		if (arrayLength > 0) {
			double[] array = new double[arrayLength];

			for (int i = 0; i < array.length; i++) {
				array[i] = Math.round(Math.random() * 100);
			}
			System.out.println("The first array : " + Arrays.toString(array));

			double[] nextArray = new double[arrayLength * 2];

			System.arraycopy(array, 0, nextArray, 0, array.length);

			for (int i = array.length; i < nextArray.length; i++) {

				nextArray[i] = array[i - array.length] * 2;
			}

			System.out.println("The second array: " + Arrays.toString(nextArray));

		} else {
			System.out.println("Wrong number!");
		}
		sc.close();

	}

}
