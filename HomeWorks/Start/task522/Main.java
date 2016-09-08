import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		int[] array = new int[6];
		getPolindrom(array);
	}

	static void getPolindrom (int [] array) {
		int maxPolindrom = 0;
		int a = 0;
		int b = 0;

		for (int i = 100; i <= 999 ; i++ ) {
			for (int j = 100; j <= 999; j++ ) {

				setArray(array, i * j);

				if (checkPolindrom(array)) {
					if (i * j > maxPolindrom) {
						maxPolindrom = i * j;

						a = i;
						b = j;
					}
				}
			}
		}

		System.out.println(a + " * " + b + " is maxPolindrom:" + maxPolindrom);
	}

	static boolean checkPolindrom(int [] array) {
		int counter = 0;

		boolean check = false;
		if (array[0] != 0) {

			for (int i = 0; i < array.length / 2 ; i++ ) {
				if (array[i] == array[array.length - i - 1]) {
					counter ++;
				} else {
					break;
				}
			}

		}
		check = (counter == 3 ) ? true : false;

		return check;
	}

	static void setArray (int[] array, int number) {

		array[0] = number / 100000;
		array[1] = number / 10000 % 10;
		array[2] = number / 1000 % 10;
		array[3] = number / 100 % 10;
		array[4] = number / 10 % 10;
		array[5] = number % 10;

	}

}