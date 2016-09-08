package net.ukr.p454.task711;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run();
	}
	
	public static void run(){
		String text  = inputText();
		save(createFile(),text);
		System.out.println("BYE BYE!");
	}
	
	public static String inputText() {
		
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;

		StringBuilder stringBuilder = new StringBuilder();
		System.out.println("Input your text and type 'q' for exit");
		while (!exit) {
			String inputLine = scanner.nextLine();

			if (inputLine.equalsIgnoreCase("q")) {
				exit = true;
			} else {
				stringBuilder.append(inputLine);
				stringBuilder.append(System.lineSeparator());
			}

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
	
	public static void save (File file, String text) {
		try (PrintWriter printWriter = new PrintWriter(file)){
			printWriter.write(text);
		}catch (IOException e) {
			System.err.println("Can't write to file");
		}					
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

}
