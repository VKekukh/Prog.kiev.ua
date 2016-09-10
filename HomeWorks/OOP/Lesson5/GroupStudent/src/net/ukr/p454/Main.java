package net.ukr.p454;

import net.ukr.p454.DAO.GroupCSV;
import net.ukr.p454.DAO.StudentConsole;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;

public class Main {

  public static void main(String[] args) {

    Human curator = new Human("Ivanova Inna Vladimirovna", 55, "ukrainian", LocalDate.of(1961, Month.JANUARY, 10),
            "Kyiv", Sex.FEMALE);

    Student studentPAI = new Student("Petrov Alexandr Ivanovich", 20, "ukrainian",
            LocalDate.of(1996, Month.FEBRUARY, 5), "Vinnitsa", Sex.MALE, "FEL", 1);

    Student studentIAI = new Student("Ivanov Alexandr Ivanovich", 19, "ukrainian",
            LocalDate.of(1996, Month.MARCH, 5), "Lviv", Sex.MALE, "FEL", 1);

    Student studentLLI = new Student("Lisko Larisa Ivanovna", 20, "ukrainian",
            LocalDate.of(1996, Month.APRIL, 5), "Vinnitsa", Sex.FEMALE, "FEL", 1);

    Student studentLLP = new Student("Lisko Lucas Petrovich", 16, "ukrainian",
            LocalDate.of(1996, Month.AUGUST, 5), "Vinnitsa", Sex.MALE, "FEL", 1);

    Student studentConsole = Student.addStudent(new StudentConsole());


    Group group = new Group("DZ-33", curator);

    group.addStudent(studentPAI);
    group.addStudent(studentIAI);
    group.addStudent(studentLLI);
    group.addStudent(studentLLP);
    group.addStudent(studentConsole);

    group.sortGroup(SortField.FULLNAME);
    System.out.println(group.toString());
    Human[] reservistList = group.getReservists(group.getStudents());


    System.out.println("Recruits:");
    for (Human human : reservistList) {
      System.out.println(human.getFullName());
    }

    group.saveGroup(new GroupCSV());
    Group groupFromCSV = Group.loadGroup(new GroupCSV(new File("DZ-33.csv")));

    groupFromCSV.sortGroup(SortField.DATEOFBIRTHDAY);
    System.out.println("");
    System.out.println("LOAD GROUP:");
    System.out.println(groupFromCSV.toString());
  }

}