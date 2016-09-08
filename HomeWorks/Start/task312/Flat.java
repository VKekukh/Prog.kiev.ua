package net.ukr.p454.task312;

import java.util.Scanner;

public class Flat {

	/**
	 * Есть девятиэтажный дом, в котором 4 подъезда. Номер подъезда начинается с
	 * единицы. На одном этаже 4 квартиры. Напишите программу которая получит
	 * номер квартиры с клавиатуры, и выведет на экран на каком этаже, какого
	 * подъезда расположенна эта квартира. Если такой квартиры нет в этом доме
	 * то нужно сообщить об этом пользователю.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		System.out.print("Input number of flat from 1 to 144:");

		int flat = sc.nextInt();

		sc.close();

		if (flat > 0 && flat <= 144) {


			int porch = flat / 36;

			if (flat%36 == 0 ) {
				porch = flat / 36;
			} else {
				porch = flat / 36 + 1;
			}
			
			int tmp = flat - 36 * (porch - 1);			
			int floor;
			
			if (tmp%4 == 0) 
			{
				floor = tmp / 4;
			}else 
			{
				floor = tmp / 4+1;
			}
			
			System.out.println("Flat in the " + porch + " porch" + " on the " + floor + " floor");
		} else {
			System.out.println("Wrong number of flat.");
		}
	}
}
