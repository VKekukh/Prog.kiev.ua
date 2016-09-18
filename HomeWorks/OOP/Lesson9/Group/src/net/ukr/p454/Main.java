package net.ukr.p454;

import net.ukr.p454.DAO.GroupCSV;
import net.ukr.p454.DAO.StudentCSV;
import net.ukr.p454.DAO.StudentConsole;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;

/**
 * Created by user on 18.09.2016.
 */
public class Main {
    public static void main(String[] args) {

        Human curator = new Human("Ivanova Inna Vladimirovna", 55, "ukrainian", LocalDate.of(1961, Month.JANUARY, 10),
                "Kyiv", Sex.FEMALE);
        System.out.println(curator);

        Student studentPAI = new Student("Petrov Alexandr Ivanovich", 20, "ukrainian",
                LocalDate.of(1996, Month.FEBRUARY, 5), "Vinnitsa", Sex.MALE, "FEL", 1);

        Student studentIAI = new Student("Ivanov Alexandr Ivanovich", 19, "ukrainian",
                LocalDate.of(1997, Month.MARCH, 5), "Lviv", Sex.MALE, "FEL", 1);

        Student studentLLI = new Student("Lisko Larisa Ivanovna", 20, "ukrainian",
                LocalDate.of(1996, Month.APRIL, 5), "Vinnitsa", Sex.FEMALE, "FEL", 1);

        Student studentLLP = new Student("Lisko Lucas Petrovich", 16, "ukrainian",
                LocalDate.of(1996, Month.AUGUST, 5), "Vinnitsa", Sex.MALE, "FEL", 1);

        Student console = Student.addStudent(new StudentConsole());

        Group group = new Group("DZ-33", curator);

        try {
            group.addStudent(studentPAI);
            group.addStudent(studentIAI);
            group.addStudent(studentLLI);
            group.addStudent(studentLLP);
            group.addStudent(console);
        } catch (GroupExeption groupExeption) {
            groupExeption.showMessage("Group is full");
        }
        group.exludStudent("Lisko Lucas Petrovich");
        group.exludStudent(studentLLP);

        //Mistake ... Age not uniq and Collection doesn't take this student....
        //group.sortGroup(SortField.AGE);


        System.out.println(group);
        System.out.println("-----------Reservist------------");
        for (Student student : group.getReservist(group.getStudents())) {
            System.out.println(student.getFullName());
        }

        group.saveStudents(new StudentCSV());
        group.saveGroup(new GroupCSV());

        Group newGroup = Group.loadGroup(new GroupCSV(new File("DZ-33.csv")));
        System.out.println("--------New group--------");
        System.out.println(newGroup);
    }
}
