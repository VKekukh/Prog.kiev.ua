package net.ukr.p454.task324;

public class SimpleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 100; i++) {

			for (int j = 2; j <= i; j++) {

				if (i % j == 0 && i != j) {
					break;

				} else {

					if (i == j) {
						System.out.print(j + " ");
					}
				}
			}
		}
	}

}
