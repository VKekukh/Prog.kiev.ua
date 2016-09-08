import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class MaxNumber {
	public static void main(String[] args) {

		Random rn = new Random();

		int length = rn.nextInt(10);
		int[] array = new int[length];

		for (int i = 0; i < array.length; i++ ) {
			array[i] = rn.nextInt(10);
		}
		System.out.println("Your array:" + Arrays.toString(array));
		System.out.println("Max number in array: " + getMaxNumber(array));
	}

	static int getMaxNumber (int [] array) {
		int max = array[0];
		for (int i : array) {
			max = (max < i ) ? i : max;
		}
		return max;
	}
}