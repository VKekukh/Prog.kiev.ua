package net.ukr.p454;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point aPoint = new Point(0, 0);
		Point bPoint = new Point(0, 4);
		Point cPoint = new Point(5, 4);
		Point dPoint = new Point(5, 0);

		Triangle triangle = new Triangle(aPoint, bPoint, cPoint);
		Circle circle = new Circle(aPoint, bPoint);
		Quadrangle quadrangle = new Quadrangle(aPoint, bPoint, cPoint, dPoint);

		Board board = new Board();
		board.addShape(triangle, 1);
		board.addShape(circle, 1);
		board.addShape(circle, 2);
		board.addShape(quadrangle, 3);
		board.addShape(circle, 5);

		System.out.println(board.toString());

		board.erasePlace(1);
		board.erasePlace(1);

		board.remShape(circle);

	}

}
