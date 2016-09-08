package net.ukr.p454;

import java.util.Formatter;

public class Human {

	private String fullName;
	private int age;
	private String nationality;
	private String dateOfBirthday;
	private String placeOfBirthday;

	public Human() {
		super();
	}

	public Human(String fullName, int age, String nationality, String dateOfBirthday, String placeOfBirthday) {
		super();
		this.fullName = fullName;
		this.age = age;
		this.nationality = nationality;
		this.dateOfBirthday = dateOfBirthday;
		this.placeOfBirthday = placeOfBirthday;
	}

	@Override
	public String toString() {
		String str;
		Formatter formatter = new Formatter();
		formatter.format("%-18s %s", "Fullname:", fullName);
		formatter.format(System.lineSeparator());
		formatter.format("%-18s %d", "Age:", age);
		formatter.format(System.lineSeparator());
		formatter.format("%-18s %s", "Nationality:", nationality);
		formatter.format(System.lineSeparator());
		formatter.format("%-18s %s", "Date of birthday:", dateOfBirthday);
		formatter.format(System.lineSeparator());
		formatter.format("%-18s %s", "Place of birthday:", placeOfBirthday);
		formatter.format(System.lineSeparator());
		str = formatter.toString(); 
		formatter.close();
		return str;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getDateOfBirthday() {
		return dateOfBirthday;
	}

	public void setDateOfBirthday(String dateOfBirthday) {
		this.dateOfBirthday = dateOfBirthday;
	}

	public String getPlaceOfBirthday() {
		return placeOfBirthday;
	}

	public void setPlaceOfBirthday(String placeOfBirthday) {
		this.placeOfBirthday = placeOfBirthday;
	}

}
