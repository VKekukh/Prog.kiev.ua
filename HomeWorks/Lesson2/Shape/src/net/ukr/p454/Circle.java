package net.ukr.p454;

public class Circle extends Shape{
	
	private Point a;
	private Point r; 
	private String type;
	
	public Circle(Point a, Point r) {
		super();
		this.a = a;
		this.r = r;
		type = "Circle";
	}

	public Circle() {
		super();
	};
		
	
	@Override
	public double getPerimeter() {
		
		return 2 * Math.PI * a.getLengthSide(r); 
	}

	@Override
	public double getArea() {
		
		return Math.PI * Math.pow(a.getLengthSide(r),2);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(type);
		stringBuilder.append(" with centre:");
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append("a" + a.toString());
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append("Radius = " + r.getLengthSide(a));
		
		return stringBuilder.toString();
	}

	public Point getA() {
		return a;
	}

	public void setA(Point a) {
		this.a = a;
	}

	public Point getR() {
		return r;
	}

	public void setR(Point r) {
		this.r = r;
	}

	public String getType() {
		return type;
	}

	
}
