package net.ukr.p454.task621;

import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);

		Date date = new Date();
		SimpleDateFormat sdFormat = new SimpleDateFormat("dd.MM.yyyy");
		System.out.print("Input the date in the format dd.mm.yyyy(Example:02.08.2016):");
		String string = scanner.nextLine();

		try {
			date = sdFormat.parse(string);
		} catch (ParseException e) {
			System.out.println("Wrong input date!");
		}

		Calendar inputDate = Calendar.getInstance();
		inputDate.setTime(date);

		// system date
		Calendar systemDate = Calendar.getInstance();

		printDifMonthYear(inputDate, systemDate);

		scanner.close();
	}

	static void printDifMonthYear(Calendar inputDate, Calendar systemDate) {
		if (inputDate.get(Calendar.MONTH) != systemDate.get(Calendar.MONTH)) {

			System.out.println("Month of inputed date: " + (inputDate.get(Calendar.MONTH)+1));
			System.out.println("Month of system date: " + (systemDate.get(Calendar.MONTH)+1));
		}
		if (inputDate.get(Calendar.YEAR) != systemDate.get(Calendar.YEAR)) {

			System.out.println("Year of inputed date: " + inputDate.get(Calendar.YEAR));
			System.out.println("Year of system date: " + systemDate.get(Calendar.YEAR));
		}
	}
}
