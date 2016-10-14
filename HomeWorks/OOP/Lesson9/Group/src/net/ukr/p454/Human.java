package net.ukr.p454;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

/**
 * Created by user on 18.09.2016.
 */
public class Human {
    private String fullName;
    private int age;
    private String nationality;
    private LocalDate dateOfBirthday;
    private String placeOfBirthday;
    private Sex sex;

    public Human(String fullName, int age, String nationality, LocalDate dateOfBirthday, String placeOfBirthday, Sex sex) {
        super();
        this.fullName = fullName;
        this.age = age;
        this.nationality = nationality;
        this.dateOfBirthday = dateOfBirthday;
        this.placeOfBirthday = placeOfBirthday;
        this.sex = sex;
    }

    public Human(Human human) {
        super();
        this.fullName = human.fullName;
        this.age = human.age;
        this.nationality = human.nationality;
        this.dateOfBirthday = human.dateOfBirthday;
        this.placeOfBirthday = human.placeOfBirthday;
        this.sex = human.sex;
    }

    public Human(String fullName) {
        this.fullName = fullName;
    }

    public Human() {
        super();
    }

    @Override
    public String toString() {
        String str;

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Formatter formatter = new Formatter();

        formatter.format("%-18s %s", "Fullname:", fullName);
        formatter.format(System.lineSeparator());
        formatter.format("%-18s %d", "Age:", age);
        formatter.format(System.lineSeparator());
        formatter.format("%-18s %s", "Nationality:", nationality);
        formatter.format(System.lineSeparator());
        formatter.format("%-18s %s", "Date of birthday:", dateOfBirthday.format(dateFormat));
        formatter.format(System.lineSeparator());
        formatter.format("%-18s %s", "Place of birthday:", placeOfBirthday);
        formatter.format(System.lineSeparator());
        formatter.format("%-18s %s", "Sex:", sex.getSex());
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

    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(LocalDate dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getPlaceOfBirthday() {
        return placeOfBirthday;
    }

    public void setPlaceOfBirthday(String placeOfBirthday) {
        this.placeOfBirthday = placeOfBirthday;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
