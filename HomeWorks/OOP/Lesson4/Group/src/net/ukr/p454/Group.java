package net.ukr.p454;

import java.util.Arrays;

public class Group implements IReservists {
	private String name;
	private Human groupCurator;
	private Student[] students = new Student[1];

	public Group(String name, Human groupCurator) {
		super();
		this.name = name;
		this.groupCurator = groupCurator;
	}

	public Group() {
		super();
	}

	public void addStudent(Student student) {
		int position = checkVacancyPlace();

		if (checkStudentInGroup(student.getFullName()) != -1) {
			System.out.println("Student " + student.getFullName() + " is in group " + this.name);
			return;
		}

		try {
			// Check may be somebody was excluded
			if (position != -1) {
				students[position] = student;
				student.setGroup(this.name);
				System.out.println(student.getFullName() + " enrolled in the group " + this.name);
			} else {
				increaseArray();
				students[students.length - 1] = student;
				student.setGroup(this.name);
				System.out.println(student.getFullName() + " enrolled in the group " + this.name);
			}

		} catch (GroupExeption e) {

			e.showMessage("Sorry, this group is full!");
		}

	}

	public void exludStudent(String fullname) {

		int position = checkStudentInGroup(fullname);

		if (position != -1) {
			System.out.println(students[position].getFullName() + " was excluded from group " + this.name);
			students[position] = null;
		} else {
			System.out.println(fullname + " is not group " + this.name);
		}
	}

	public void searchStudent(String fullname) {
		int position = checkStudentInGroup(fullname);
		if (position != -1) {
			System.out.println(students[position].toString());
		} else {
			System.out.println("Student " + fullname + " is not group " + this.name);
		}
	}

	private void increaseArray() throws GroupExeption {
		if (students.length < 10) {
			Student[] array = new Student[students.length + 1];
			System.arraycopy(students, 0, array, 0, students.length);
			students = array;
		} else {
			throw new GroupExeption();
		}
	}

	private int checkVacancyPlace() {
		int position = -1;
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				position = i;
				break;
			}
		}
		return position;
	}

	private int checkStudentInGroup(String fullname) {
		int exists = -1;
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && students[i].getFullName().equalsIgnoreCase(fullname)) {
				exists = i;
			}
		}
		return exists;
	}

	public void sortGroup(SortField sortField) {
		Arrays.sort(students,new SortStudent(sortField));
	}
	
	@Override
	public String toString() {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Group Name:" + this.name);
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append("Curator of group:" + this.groupCurator.getFullName());
		stringBuilder.append(System.lineSeparator());
		stringBuilder.append("Students:");
		stringBuilder.append(System.lineSeparator());
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				stringBuilder.append("The vacant position");
				stringBuilder.append(System.lineSeparator());
			} else {
				stringBuilder.append(students[i].getFullName());
				stringBuilder.append(System.lineSeparator());
			}
		}
		return stringBuilder.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Human getGroupCurator() {
		return groupCurator;
	}

	public void setGroupCurator(Human groupCurator) {
		this.groupCurator = groupCurator;
	}

	public Student[] getStudents() {
		return students;
	}
	
	

}
