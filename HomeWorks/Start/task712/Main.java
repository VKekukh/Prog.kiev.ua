package net.ukr.p454.task712;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run();

	}
	
	public static String getArray() {
		
		StringBuilder stringBuilder = new StringBuilder();
		
		int[][] array = new int[5][5];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				array[i][j] = j+i;
			}
		}		
		
		for (int i = 0; i < array.length; i++) {
			stringBuilder.append(Arrays.toString(array[i]));
			stringBuilder.append(System.lineSeparator());			
		}
		return stringBuilder.toString();
	}
	
	public static File createFile(){
		Scanner sc = new Scanner(System.in);	
		
		System.out.print("Input path to file:");
		String filePath = parsePath(sc.nextLine()); 
				
		System.out.print("Input file name:");
		String fileName = checkFolder(filePath)+"/"+sc.nextLine();
		
		File file = new File(fileName);
		try {
			file.createNewFile();
		} catch (IOException e) {
			System.err.println("Can't create file " + e);
		}
				
		return file; 
	}
	
	static String parsePath(String path){

		path = path.replace("\\", "/");
		return path;
		
	}
	
	static String checkFolder (String folderPath) {
		File folder = new File(folderPath);
		if (!folder.exists()){
			folderPath = ".";
		}
		return folderPath;
	}
	
	public static void save (File file, String text) {
		try (PrintWriter printWriter = new PrintWriter(file)){
			printWriter.write(text);
		}catch (IOException e) {
			System.err.println("Can't write to file");
		}					
	}
	
	public static void run(){
		String text  = getArray();
		save(createFile(),text);
		System.out.println("BYE BYE!");
	}

}
