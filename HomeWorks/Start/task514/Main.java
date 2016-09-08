import java.util.Random;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Random rn = new Random();
		int length = rn.nextInt(10);
		int[] array = new int[length];
		int searchNumber = 3;

		fillArray(array, length);
		System.out.println("Index: " + indexOf(array, searchNumber));
	}

	static int indexOf (int [] array, int searchNumber) {
		int index = - 1;
		for (int i = 0; i < array.length ; i++) {
			if (array[i] == searchNumber) {
				index = i;
				break;
			}
		}
		return index;
	}

	static void fillArray (int[] array, int length)  {
		Random rn = new Random();
		for (int i = 0; i < array.length ; i++ ) {
			array[i] = rn.nextInt(4);
		}
		System.out.println(Arrays.toString(array));
	}
}
