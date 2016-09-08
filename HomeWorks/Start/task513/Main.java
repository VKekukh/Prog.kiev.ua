import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Random rn = new Random();
		int x = 4; //rn.nextInt(10);
		int y = 10;//rn.nextInt(10);
		drawRectangleFill(x, y);
		System.out.println("");
		drawRectangleEmpty(x, y);
	}

	static void drawRectangleFill(int x, int y) {
		for (int i = 1; i <= x ; i++) {
			for (int j = 1; j <= y; j++) {
				System.out.print("* ");
			}
			System.out.println("");
		}
	}

	static void drawRectangleEmpty(int x, int y) {
		for (int i = 1; i <= x ; i++) {
			for (int j = 1; j <= y; j++) {
				if (i == 1 || i == x || j == 1|| j == y) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println("");
		}
	}

}
