

import java.util.Arrays;
import java.util.Scanner;

public class Main {


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Input length of array:");
		int length = sc.nextInt();

		
		int[] array = new int[length];


		fillArray(array, length);
		checkMetods(array);
	}

	static void checkMetods(int[] array) {
		if (calcBySubtraction(array) != -1) {
			System.out.println("Next number:" + calcBySubtraction(array));
		} else if (calcByDivision(array) != -1) {
			System.out.println("Next number:" + calcByDivision(array));
		} else if (calcByEvolution2(array) != -1) {
			System.out.println("Next number:" + calcByEvolution2(array));
		} else if (calcByEvolution3(array) != -1) {
			System.out.println("Next number:" + calcByEvolution3(array));
		} else {
			System.out.println("Can't understant regularity in your array. May be you make a mistake in an array.");
		}

	}

	static int calcBySubtraction(int[] array) {
		int result = -1;

		for (int i = 2; i < array.length; i++) {

			if (array[i]-array[i - 1] == array[i - 1]- array[i - 2]) {
				result = array[i] + (array[i]- array[i - 1]);
			} else {
				result = -1;
				break;
			}
		}
		return result;
	}

	static int calcByDivision(int[] array) {
		int result = -1;

		for (int i = 2; i < array.length; i++) {

			if ((array[i]/array[i - 1]) == (array[i - 1]/ array[i - 2])&&
					(array[i]%array[i - 1]) == (array[i - 1]% array[i - 2])) {
				
				result = array[i] * (array[i]/ array[i - 1]);

			} else {
			
				result = -1;
			
				break;
			}
		}
		return result;
	}

	static int calcByEvolution2(int[] array) {
		int result = -1;
		for (int i = 2; i < array.length; i++) {
			if (Math.sqrt(array[i]) == Math.sqrt(array[i - 1]) + 1) {
				result = (int) Math.pow(Math.sqrt(array[i]) + 1, 2);
			} else {
				result = -1;
				break;
			}
		}
		return result;
	}

	static int calcByEvolution3(int[] array) {
		int result = -1;
		for (int i = 2; i < array.length; i++) {
			if (Math.cbrt(array[i]) == Math.cbrt(array[i - 1]) + 1) {
				result = (int) Math.pow(Math.cbrt(array[i]) + 1, 3);
			} else {
				result = -1;
				break;
			}
		}
		return result;
	}



	static void fillArray(int[] array, int length) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < array.length; i++) {
			System.out.print("Input number of array:");
			array[i] = sc.nextInt();			
		}
		System.out.println(Arrays.toString(array));
		sc.close();
	}
}