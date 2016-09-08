package net.ukr.p454.task713;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);	
		
		System.out.print("Input path to folder:");
		String folderPath = parsePath(sc.nextLine()); 
		File file = new File(folderPath);
		printListFolder(file);
		sc.close();
	}

	static String parsePath(String path){

		path = path.replace("\\", "/");
		return path;
		
	}
	
	
	static void printListFolder(File file){
		if (file.exists()){
		File[] files = file.listFiles();
		for (File f : files) {
			if (f.isDirectory()) {
				System.out.println(f.getName());
			}
		}
		}else {
			System.out.println("Folder does not exists");
		}
	} 
}
