package net.ukr.p454.task722;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run();
	}

	static void run() {

		File file = openFile();
		if (!file.exists()) {
			System.err.println("File does't exists!");
			return;
		}

		String text = readFile(file);
		countLetters(text);

	}

	static String readFile(File file) {
		StringBuilder stringBuilder = new StringBuilder();

		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				stringBuilder.append(scanner.nextLine());
			}

		} catch (Exception e) {
			System.err.println("Can not read the file!");
		}

		return stringBuilder.toString();

	}

	static File openFile() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input path to file:");
		String path = scanner.nextLine();
		File file = new File(parsePath(path));
		scanner.close();
		return file;
	}

	static String parsePath(String path) {
		return path.replace("\\", "/");

	}

	static void countLetters(String text) {

		
	    /* 1. All letters to lower case
		 * 2. To array and then sorts array
		 * 3. Do arrays with letters without symbols
		 * 4. Sort by length*/		
		
		text = text.toLowerCase();
		
		char[] array = text.toCharArray();
		Arrays.sort(array);
		
		StringBuilder sortedText = new StringBuilder();

		String symbols = "+-., ()1234567890";

		for (int i = array.length - 1; i > 0; i--) {

			if (symbols.indexOf(array[i]) == -1) {
				
				if (array[i] == array[i - 1]) {
					sortedText.append(array[i]);
				} else {
					sortedText.append(array[i]);
					sortedText.append(System.lineSeparator());
				}
				
			}
		}

		String[] arrayLetters = sortedText.toString().split(System.lineSeparator());
		sortArray(arrayLetters);
		printStatistics(arrayLetters);
	}

	static void sortArray(String[] strings) {

		for (int i = 0; i < strings.length; i++) {
			String maxString = strings[i];
			int maxPosition = i;

			for (int j = i + 1; j < strings.length; j++) {

				if (strings[j].length() > maxString.length()) {
					maxString = strings[j];
					maxPosition = j;
				}

			}
			if (i != maxPosition) {
				String tmp = strings[i];
				strings[i] = strings[maxPosition];
				strings[maxPosition] = tmp;
			}
		}

	}

	static void printStatistics(String[] array) {

		for (int i = 0; i < array.length; i++) {
			System.out.println("Letters \"" + array[i].substring(0,1) + "\" in text: " + array[i].length());
		}
	}

}
