package net.ukr.p454.task421;

import java.util.Arrays;

public class Transposing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = new int[6][6];

		// Fill array
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				array[i][j] = j + 1;
			}
		}

		// Transposing
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (j > i) {
					int t = array[i][j];
					array[i][j] = array[j][i];
					array[j][i] = t;
				}
			}
		}
		/* Output */
		for (int i = 0; i < 6; i++) {
			System.out.println(Arrays.toString(array[i]));
		}

	}
}
