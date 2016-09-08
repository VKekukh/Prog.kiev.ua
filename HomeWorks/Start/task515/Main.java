public class Main {
	public static void main(String[] args) {
		System.out.print("Amount Words: " + countWords("Hello World!"));				
	}

	static int countWords (String s) {
		String [] array = s.split("[.,; ]");
		return array.length;
	}
}