package net.ukr.p454.task521;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("c:/array.txt");
		String text = readFile(file);
		int[][] array = makeArray(text);
		for (int[] is : array) {
			System.out.println(Arrays.toString(is));
		}
	}

	static String readFile(File file) {
		StringBuilder stringBuilder = new StringBuilder();
		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String text = scanner.nextLine();
				text = text.replace("]", "").replace("[", "");
				stringBuilder.append(text);
				stringBuilder.append(System.lineSeparator());

			}
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("Can't read file");
		}
		return stringBuilder.toString();
	}

	static int[][] makeArray(String text) {
		String[] strings = text.split(System.lineSeparator());
		String[][] arrString = new String[strings.length][];
		for (int i = 0; i < strings.length; i++) {
			arrString[i] = strings[i].split(", ");
		}

		int[][] numArray = new int[strings.length][arrString.length];
		for (int i = 0; i < strings.length; i++) {
			for (int j = 0; j < arrString.length; j++) {
				numArray[i][j] = Integer.valueOf(arrString[i][j]);
			}
		}
		return numArray;
	}
}
