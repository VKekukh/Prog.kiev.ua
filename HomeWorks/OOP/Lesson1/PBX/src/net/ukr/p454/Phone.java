package net.ukr.p454;

import java.util.Scanner;

public class Phone {
	private String model;
	private ExtNumber extNumber;
	
	Phone(String model, ExtNumber extNumber) {
		super();
		this.model = model;
		this.extNumber = extNumber;
	}

	Phone() {
		super();
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public ExtNumber getExtNumber() {
		return extNumber;
	}

	public void setExtNumber(ExtNumber extNumber) {
		this.extNumber = extNumber;
	}

	@Override
	public String toString() {
		return "Model of the phone:" + model + "; net.ukr.p454.ExtNumber:" + extNumber.getExtNumber();
	}
	
	public void makeCall(BaseStation baseStation){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Who are you calling?" + "\n"+ "Input phone number:");
		baseStation.commutation(this.extNumber.getExtNumber(), scanner.nextInt());
	}
	
	public void putPhoneDown(BaseStation baseStation){
		baseStation.disconnect(this.getExtNumber().getExtNumber());
	}
}
