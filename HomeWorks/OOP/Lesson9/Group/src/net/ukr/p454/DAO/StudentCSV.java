package net.ukr.p454.DAO;
import net.ukr.p454.Sex;
import net.ukr.p454.SortField;
import net.ukr.p454.SortStudent;
import net.ukr.p454.Student;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by user on 18.09.2016.
 */
public class StudentCSV implements IStudentDAO {
    File file;

    public StudentCSV(File file) {
        this.file = file;
    }

    public StudentCSV() {
    }

    @Override
    public void saveStudents(Set<Student> studentSet) {

        TreeSet<Student> students = new TreeSet<>(new SortStudent());
        students.addAll(studentSet);
        if(file == null) {
            file = new File("StudentsGroup"+students.first().getGroup() + ".csv");
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
        if (file == null ||!file.exists()) {
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
    public Set<Student> addStudents() {
        Set<Student> students = new TreeSet<>(new SortStudent());
        String line = "";
        String[] fields;
        int position = 0;

        if (file == null || !file.exists()) {
            throw new IllegalArgumentException();
        }


        try(BufferedReader input = new BufferedReader(new FileReader(file))){
            while ((line = input.readLine()) != null) {
                fields = line.split(";");
                Student student = new Student();
                student.setFullName(fields[0]);
                student.setAge(Integer.valueOf(fields[1]));
                student.setNationality(fields[2]);
                student.setDateOfBirthday(LocalDate.parse(fields[3], DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                student.setPlaceOfBirthday(fields[4]);
                student.setSex((fields[5] == "FEMALE") ? Sex.FEMALE : Sex.MALE);
                student.setFaculty(fields[6]);
                student.setCourse(Integer.valueOf(fields[7]));
                student.setStudentID();
                student.setGroup(fields[8]);
                students.add(student);
            }
        }catch (IOException e) {
            System.err.println("e");
        }
        return students;
    }

    private static Student[] increaseArray(Student[] array) {
        Student[] newArray = new Student[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);

        return  newArray;
    }
}
