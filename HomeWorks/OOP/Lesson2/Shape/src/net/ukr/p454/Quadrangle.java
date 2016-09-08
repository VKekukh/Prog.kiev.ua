package net.ukr.p454;

public class Quadrangle extends Shape{
	
	private Point a;
	private Point b;
	private Point c;
	private Point d;
	private String type;
	
	
	public Quadrangle(Point a, Point b, Point c, Point d) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		type = "Quadrangle";
	}

	public Quadrangle() {
		super();
	}

	
	@Override
	public double getPerimeter() {
		double ab = a.getLengthSide(b);
		double bd = b.getLengthSide(d);
		double cd = c.getLengthSide(d);
		double ac = a.getLengthSide(c); 
		
		double perimeter = ab + bd + cd + ac; 
		
		return perimeter;
	}

	@Override
	public double getArea() {
		double ab = a.getLengthSide(b);
		double bd = b.getLengthSide(d);
		double cd = c.getLengthSide(d);
		double ac = a.getLengthSide(c); 
		
		double semiPerimeter = getPerimeter()/2;
		double area = Math.sqrt((semiPerimeter - ab)*(semiPerimeter - bd)*(semiPerimeter - cd)*(semiPerimeter - ac));
		
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
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append("d" + d.toString());
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

	public Point getD() {
		return d;
	}

	public void setD(Point d) {
		this.d = d;
	}

	public String getType() {
		return type;
	}
	
}
