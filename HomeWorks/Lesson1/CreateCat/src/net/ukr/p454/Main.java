package net.ukr.p454;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat catOne = new Cat("Inokentiy", 3, 7.5, true);
		catOne.askingFood("fish");
		catOne.playWithBall();
		
		Cat catTwo = new Cat("Boris", 3, 3.3, false);
		catTwo.playWithBall();
		
		Cat catThree =  new Cat("Friski", 15, 5.3, true);
		catThree.askingFood("meat");
		catThree.playWithBall();
	
		System.out.println(catOne.toString());
	}

}
