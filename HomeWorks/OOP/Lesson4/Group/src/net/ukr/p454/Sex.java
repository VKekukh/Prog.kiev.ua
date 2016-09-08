package net.ukr.p454;

public enum Sex {
	
	MALE("man"), FEMALE("woman");
	
	private String inRus;
	
	private Sex(String inRus){
		this.inRus = inRus;
	}

	public String getInRus() {
		return inRus;
	}

	public void setInRus(String inRus) {
		this.inRus = inRus;
	}
	
	
}
