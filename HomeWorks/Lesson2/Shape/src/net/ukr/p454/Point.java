package net.ukr.p454;

public class Point {
	private double x;
	private double y;
	
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Point() {
		super();
	}

	public double getLengthSide(Point b) {
		double length;
		length = Math.sqrt(Math.pow((this.x - b.getX()), 2) + Math.pow((this.y - b.getY()), 2));
		return length;
	}
	
	@Override
	public String toString() {
		return "(x=" + x + ", y=" + y + ")";
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	
}
