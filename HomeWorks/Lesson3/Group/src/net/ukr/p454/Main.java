package net.ukr.p454;

public class Main {

	public static void main(String[] args) {

		Human curator = new Human("Ivanova Svetlana B.", 55, "ukrainian", "01.04.1961", "Kiev");

		Student studentIAI = new Student("Ivanov Aleksandr Ivanovich", 20, "ukrainian", "05.01.1996", "Vinnitsa", "FEL",
				1000001, 1);
		Student studentPAI = new Student("Petrov Aleksandr Ivanovich", 20, "ukrainian", "05.02.1996", "Kovel", "FEL",
				1000002, 1);
		Student studentBAI = new Student("Bujnov Aleksandr Ivanovich", 20, "ukrainian", "05.03.1996", "Zhitomir", "FEL",
				1000003, 1);
		Student studentCAI = new Student("Smirnov Aleksandr Ivanovich", 20, "ukrainian", "05.04.1996", "Zaporozhye", "FEL",
				1000004, 1);
		Student studentDAI = new Student("Dimitrov Aleksandr Ivanovich", 20, "ukrainian", "05.05.1996", "Dnieper", "FEL",
				1000005, 1);
		Student studentGAI = new Student("Grabowski Aleksandr Ivanovich", 20, "ukrainian", "05.06.1996", "Gaspra", "FEL",
				1000006, 1);
		Student studentMAI = new Student("Manilow Aleksandr Ivanovich÷", 20, "ukrainian", "05.07.1996", "Cherkassy", "FEL",
				1000007, 1);
		Student studentNAI = new Student("Nikolaev Aleksandr Ivanovich", 20, "ukrainian", "05.08.1996", "Chernihiv", "FEL",
				1000008, 1);
		Student studentIPI = new Student("Ivanov Aleksandr Ivanovich", 19, "ukrainian", "05.09.1996", "Kharkiv", "FEL",
				1000009, 1);
		Student studentKAI = new Student("Kraevoy Aleksandr Ivanovich", 19, "ukrainian", "05.10.1996", "Lviv", "FEL",
				1000010, 1);
		Student studentLAI = new Student("Lunkov Aleksandr Ivanovich", 19, "ukrainian", "05.11.1996", "Kharkiv", "FEL",
				1000011, 1);

		Group group = new Group("DZ-33", curator);

		group.addStudent(studentIAI);
		// try the same student
		group.addStudent(studentIAI);

		group.addStudent(studentPAI);
		group.addStudent(studentBAI);
		group.addStudent(studentCAI);
		group.addStudent(studentDAI);
		group.addStudent(studentGAI);
		group.addStudent(studentMAI);
		group.addStudent(studentNAI);
		group.addStudent(studentIPI);
		group.addStudent(studentKAI);

		// Group is full
		group.addStudent(studentLAI);

		// Ivanov shirked all pairs
		group.exludStudent("ivanov petr sergeevich");
		group.exludStudent("ivanov petr ivanovich");
		group.exludStudent("Manilow Aleksandr Ivanovich÷");

		// Add new students
		// group.addStudent(studentLAI);

		// search
		group.searchStudent("Kraevoy Aleksandr Ivanovich");

		// try to recover
		// group.addStudent(studentIPI);

		System.out.println(group.toString());
	}

}
