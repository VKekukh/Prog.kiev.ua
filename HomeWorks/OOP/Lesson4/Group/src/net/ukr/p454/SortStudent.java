package net.ukr.p454;

import java.util.Comparator;

public class SortStudent implements Comparator<Student> {
	SortField sortField = SortField.FULLNAME ;

	public SortStudent(SortField sortField) {
		super();
		this.sortField = sortField;
	}

	public SortStudent() {
		super();
	}

	public SortField getSortField() {
		return sortField;
	}

	public void setSortField(SortField sortField) {
		this.sortField = sortField;
	}

	@Override
	public int compare(Student studentOne, Student studentTwo) {

		if (studentOne == null && studentTwo == null) {
			return 0;
		} else if (studentOne == null) {
			return 1;
		} else if (studentTwo == null) {
			return -1;
		}

		switch (sortField) {

		case AGE:
			return studentOne.getAge() > studentTwo.getAge() ? 1 : studentOne.getAge() < studentTwo.getAge() ? -1 : 0;

		case PLACEOFBIRTHDAY:
			return studentOne.getPlaceOfBirthday().compareToIgnoreCase(studentTwo.getPlaceOfBirthday());

		case DATEOFBIRTHDAY:
			return studentOne.getDateOfBirthday().isBefore(studentTwo.getDateOfBirthday()) ? 1
					: studentOne.getDateOfBirthday().isAfter(studentTwo.getDateOfBirthday()) ? -1 : 0;

		case SEX:
			return studentOne.getSex().compareTo(studentTwo.getSex());
		// default is sort by FullName
		default:
			return studentOne.getFullName().compareToIgnoreCase(studentTwo.getFullName());
		}
	}

}
