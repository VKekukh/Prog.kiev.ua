package net.ukr.p454;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		demo();
		
	}
	
	static void demo (){
		//Register base station
		BaseStation baseStation = new BaseStation(16);
		//Set number plan of our office	
		System.out.println("Example our innner numbers starts from 100");
		baseStation.setNumberPlan();

		// assign number
		ExtNumber extNumber1 = new ExtNumber(baseStation.getNextNumber(), "Ivanov Ivan", true);
		ExtNumber extNumber2 = new ExtNumber(baseStation.getNextNumber(), "Petrov Petro", true);
		ExtNumber extNumber3 = new ExtNumber(baseStation.getNextNumber(), "Bogdanov Bogdan", true);
		ExtNumber extNumber4 = new ExtNumber(baseStation.getNextNumber(), "Tarasov Taras", true);
		
		//Create new phone
		Phone phone1 = new Phone("Cisco A000", extNumber1);
		Phone phone2 = new Phone("Cisco A000", extNumber2);
		Phone phone3 = new Phone("Cisco A100v2", extNumber3);
		Phone phone4 = new Phone("Cisco A100v2", extNumber4);

		// register phone in our network		
		baseStation.registerNumber(phone1);
		baseStation.registerNumber(phone2);
		baseStation.registerNumber(phone3);

		// Try to register the same number one more time
		System.out.println("Try to register the same number");
		baseStation.registerNumber(phone3);

		// net.ukr.p454.Phone number 102
		System.out.println("Try to phone. Example number 101");
		phone1.makeCall(baseStation);
		System.out.println("Try to phone. Example number 102");
		phone2.makeCall(baseStation);

		System.out.println("Try to phone the same number. Example number 102");
		// net.ukr.p454.Phone the same number 102
		phone2.makeCall(baseStation);

		
		System.out.println(baseStation.getStats());
		
		System.out.println("Finish call");
		phone1.putPhoneDown(baseStation);
		
		// Try to phone to number 104
		System.out.println("Try to phone not register number. Example 104");
		phone1.makeCall(baseStation);

		System.out.println("Try to phone number not in our network. Example 140");
		// Try to phone to number 125
		phone1.makeCall(baseStation);
	}

}
