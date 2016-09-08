package net.ukr.p454;

public class ExtNumber {
	private int extNumber; // External number
	private boolean used; // Used or not
	private String owner; // Who is owner this number

	ExtNumber(int extNumber, String owner, boolean used) {

		this.extNumber = extNumber;
		this.owner = owner;
		this.used = used;
	}

	ExtNumber() {
		super();
	}

	public int getExtNumber() {
		return extNumber;
	}

	public void setExtNumber(int extNumber) {
		this.extNumber = extNumber;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "External number:" + extNumber + "\n" + "Owner:" + owner + "\n" + "Used:" + ((used) ? "Yes" : "No");
	}

}
