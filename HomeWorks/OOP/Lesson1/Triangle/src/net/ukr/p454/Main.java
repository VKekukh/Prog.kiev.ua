package net.ukr.p454;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triangle triangleOne = new Triangle(2.0, 2.5, 3.2);
		System.out.println(triangleOne.toString());
		System.out.println("The area of the triangle " + triangleOne.calcArea() + "\n");		
		
		Triangle triangleTwo = new Triangle(3.0, 4.5, 5.2);
		System.out.println(triangleTwo.toString());
		System.out.println("The area of the triangle " + triangleTwo.calcArea()+ "\n");
		
		Triangle triangleThree = new Triangle(5.0, 4.5, 3.2);
		System.out.println(triangleThree.toString());
		System.out.println("The area of the triangle " + triangleThree.calcArea()+ "\n");
	}

}
