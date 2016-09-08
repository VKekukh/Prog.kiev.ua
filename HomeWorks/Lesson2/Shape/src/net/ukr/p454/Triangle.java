package net.ukr.p454;

public class Triangle extends Shape {
	private Point a;
	private Point b;
	private Point c;
	private String type;
	

	public Triangle(Point a, Point b, Point c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		type = "Triangle";
	}

	public Triangle() {
		super();
	}

	@Override
	public double getPerimeter() {
		double ab = a.getLengthSide(b);
		double ac = a.getLengthSide(c);
		double bc = b.getLengthSide(c);
		return ab + ac + bc;
	}

	@Override
	public double getArea() {

		double ab = a.getLengthSide(b);
		double ac = a.getLengthSide(c);
		double bc = b.getLengthSide(c);

		double semiPerimeter = getPerimeter() / 2;
		double area = Math.sqrt(semiPerimeter * (semiPerimeter - ab) * (semiPerimeter - ac) * (semiPerimeter - bc));
		return area;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(type);
		stringBuilder.append(" with points:");
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append("a" + a.toString());
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append("b" + b.toString());
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append("c" + c.toString());
		
		return stringBuilder.toString();
	}

	public Point getA() {
		return a;
	}

	public void setA(Point a) {
		this.a = a;
	}

	public Point getB() {
		return b;
	}

	public void setB(Point b) {
		this.b = b;
	}

	public Point getC() {
		return c;
	}

	public void setC(Point c) {
		this.c = c;
	}

	public String getType() {
		return type;
	}

	

}
