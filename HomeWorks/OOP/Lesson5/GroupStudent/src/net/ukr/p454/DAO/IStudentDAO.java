package net.ukr.p454.DAO;

import net.ukr.p454.Student;

/**
 * Created by vkekukh on 01.09.2016.
 */
public interface IStudentDAO {

  Student addStudent();
  Student [] addStudents();
  void saveStudents(Student[] students);
}