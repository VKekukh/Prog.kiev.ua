package net.ukr.p454.task612;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//input  
		Scanner sc = new Scanner(System.in);		
		System.out.print("Input length of array:");
		int length = sc.nextInt();		
		sc.close();
		
		int [] array = new int[length];		
		fillArray(array);
		
		System.out.println("Your array: "+ toString(array));						
	}
	
	static void fillArray(int [] array){
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] =random.nextInt(10);
		}
	}
	
	static String toString(int[] array){
		StringBuilder sb = new StringBuilder();
			sb.append("[");
			
		for (int i = 0; i < array.length; i++) {
			if (i != array.length - 1) {
				sb.append(array[i]).append(", ");
			}else {
				sb.append(array[i]).append("]");
			}
		}
		return sb.toString();
	}

}
