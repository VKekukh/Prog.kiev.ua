package net.ukr.p454.task412;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Ќаписать код дл€ возможности создани€ массива целых чисел (размер вводитьс€ с
 * клавиатуры) и возможности заполнени€ каждого его элемента вручную. ¬ыведите
 * этот массив на экран
 */
public class ArrayIntNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.print("Input length of the array: ");
		int lengthArray = sc.nextInt();
		int[] array = new int[lengthArray];

		if (lengthArray > 0) {

			for (int i = 0; i < array.length; i++) {
				System.out.print("Input number of the array: ");
				array[i] = sc.nextInt();
			}

			System.out.println("You input array: " + Arrays.toString(array));
		} else {
			System.out.println("Wrong number!");
		}
	}

}
