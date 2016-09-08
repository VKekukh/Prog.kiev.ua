package net.ukr.p454;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		Human curator = new Human("Ivanova Inna Vladimirovna", 55, "ukrainian", LocalDate.of(1961, Month.JANUARY, 10),
				"Kyiv", Sex.FEMALE);

		System.out.println(curator.toString());

		Student studentPAI = new Student("Petrov Alexandr Ivanovich", 20, "ukrainian",
				LocalDate.of(1996, Month.FEBRUARY, 5), "Vinnitsa", Sex.MALE, "FEL", 1);
		
		Student studentIAI = new Student("Ivanov Alexandr Ivanovich", 19, "ukrainian",
				LocalDate.of(1996, Month.MARCH, 5), "Lviv", Sex.MALE, "FEL", 1);
		
		Student studentLLI = new Student("Lisko Larisa Ivanovna", 20, "ukrainian",
				LocalDate.of(1996, Month.APRIL, 5), "Vinnitsa", Sex.FEMALE, "FEL", 1);
		
		Student studentLLP = new Student("Lisko Lucas Petrovich", 16, "ukrainian",
				LocalDate.of(1996, Month.AUGUST, 5), "Vinnitsa", Sex.MALE, "FEL", 1);
		
		Student studentConsole = Student.addStudent(new StudentAddConsole());
		System.out.println(studentConsole.toString());

		Group group = new Group("DZ-33", curator);
		
		group.addStudent(studentPAI);
		group.addStudent(studentIAI);
		group.addStudent(studentLLI);
		
		group.addStudent(studentConsole);
		
		group.sortGroup(SortField.FULLNAME);
		
		Human[] reservistList = group.getReservists(group.getStudents());
		
		System.out.println(Arrays.toString(reservistList));

	}

}
