import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Random rn = new Random();

		String s = "Summa:";
		double a = rn.nextDouble();
		int b = rn.nextInt();

		concat(s, a, b);

	}
	static double sum (double a, int b) {
		return a + b;
	}

	static void concat(String s, double a, int b) {
		System.out.println(s + sum(a, b));
	}
}