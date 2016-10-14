package net.ukr.p454.DAO;

import net.ukr.p454.Student;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by user on 18.09.2016.
 */
public interface IStudentDAO {

    Student addStudent();

    Set<Student> addStudents();

    void saveStudents(Set<Student> students);

}