package net.ukr.p454.DAO;

import net.ukr.p454.Sex;
import net.ukr.p454.Student;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by vkekukh on 01.09.2016.
 */
public class StudentCSV implements IStudentDAO {
  File file;

  public StudentCSV(File file) {
    this.file = file;
  }

  public StudentCSV() {
  }

  @Override
  public void saveStudents(Student[] students) {
    if(file == null) {
      file = new File("StudentsGroup"+students[0].getGroup() + ".csv");
    }

    try(PrintWriter print = new PrintWriter(file)){
      for (Student student : students) {
        print.write(student.getFullName()+ ";");
        print.write(student.getAge() + ";");
        print.write(student.getNationality()+ ";");
        print.write(student.getDateOfBirthday()+ ";");
        print.write(student.getPlaceOfBirthday()+ ";");
        print.write(student.getSex()+ ";");
        print.write(student.getFaculty()+ ";");
        print.write(student.getCourse()+ ";");
        print.write(student.getGroup());
        print.write(System.lineSeparator());

      }
    }catch(IOException e){
      System.err.println(e);
    }
  }

  @Override
  public Student addStudent() {
    String[] line;
    Student newStudent = new Student();
    if (file == null || !file.exists()) {
      throw new IllegalArgumentException();
    }

    try(BufferedReader input = new BufferedReader(new FileReader(file))){
      line = input.readLine().split(";");
      newStudent.setFullName(line[0]);
      newStudent.setAge(Integer.valueOf(line[1]));
      newStudent.setNationality(line[2]);
      newStudent.setDateOfBirthday( LocalDate.parse(line[3], DateTimeFormatter.ofPattern("yyyy-MM-dd")));
      newStudent.setPlaceOfBirthday(line[4]);
      newStudent.setSex(( line[5] == "FEMALE") ? Sex.FEMALE : Sex.MALE);
      newStudent.setFaculty(line[6]);
      newStudent.setStudentID();
      newStudent.setGroup(line[7]);
      newStudent.setCourse(Integer.valueOf(line[7]));
    }catch (IOException e) {
      System.err.println("e");
    }
    return newStudent;
  }

  @Override
  public Student[] addStudents() {

    String line = "";
    String[] fields;
    int position = 0;

    Student[] newStudents = new Student[1];
    if (file == null || !file.exists()) {
      throw new IllegalArgumentException();
    }
    try(BufferedReader input = new BufferedReader(new FileReader(file))){
      while ((line = input.readLine()) != null) {
        fields = line.split(";");

        if (position > 0){
          newStudents = increaseArray(newStudents);
        }

        newStudents[position] = new Student();
        newStudents[position].setFullName(fields[0]);
        newStudents[position].setAge(Integer.valueOf(fields[1]));
        newStudents[position].setNationality(fields[2]);
        newStudents[position].setDateOfBirthday(LocalDate.parse(fields[3], DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        newStudents[position].setPlaceOfBirthday(fields[4]);
        newStudents[position].setSex((fields[5] == "FEMALE") ? Sex.FEMALE : Sex.MALE);
        newStudents[position].setFaculty(fields[6]);
        newStudents[position].setCourse(Integer.valueOf(fields[7]));
        newStudents[position].setStudentID();
        newStudents[position].setGroup(fields[8]);
        position++;
      }
    }catch (IOException e) {
      System.err.println("e");
    }

    return newStudents;
  }

  private static Student[] increaseArray(Student[] array) {
    Student[] newArray = new Student[array.length + 1];
    System.arraycopy(array, 0, newArray, 0, array.length);

    return  newArray;
  }
}