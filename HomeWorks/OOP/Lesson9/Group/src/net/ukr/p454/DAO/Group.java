package net.ukr.p454.DAO;

import net.ukr.p454.*;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by user on 18.09.2016.
 */
public class Group implements IReservists{

    private String name;
    private Human curator;
    private TreeSet<Student> students = new TreeSet<>(new SortStudent());
    private int groupSize = 10;

    public Group() {
    }

    public Group(String name, Human curator, TreeSet<Student> students) {
        this.name = name;
        this.curator = curator;
        this.students = students;
    }

    public Group(String name, Human curator) {
        this.name = name;
        this.curator = curator;
    }

    public Group(String name) {
        this.name = name;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(int groupSize) {
        this.groupSize = groupSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Human getCurator() {
        return curator;
    }

    public void setCurator(Human curator) {
        this.curator = curator;
    }

    public TreeSet<Student> getStudents() {
        return students;
    }

    public void setStudents(TreeSet<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Group Name:" + this.name);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("Curator of group:" + this.curator.getFullName());
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("Students:");
        stringBuilder.append(System.lineSeparator());

        for (Student student : students) {
            stringBuilder.append(student.getFullName());
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    public void addStudent(Student student) throws GroupExeption {
        if (students.size() >= getGroupSize() ){
            throw new GroupExeption();
        }
        students.add(student);
        student.setGroup(this.name);
        System.out.println(student.getFullName() + " enrolled in the group " + this.name);
    }

    public Student searchStudent(String fullName){
        Student st = new Student();
        for (Student student : students) {
            if(fullName.equalsIgnoreCase(student.getFullName())){
                st = student;
                break;
            }
        }
        return st;
    }

    public void exludStudent(String fullName){
        Student student = searchStudent(fullName);
        if(student != null){
            students.remove(student);
            System.out.println(student.getFullName() + " was excluded from group " + this.name);
        }
        else {
            System.out.println(fullName + " is not group " + this.name);
        }
    }

    public void exludStudent(Student student){
        if (student == null){
            throw new IllegalArgumentException();
        }

        if(students.contains(student)){
            students.remove(student);
        }else {
            System.out.println(student.getFullName() + " is not group " + this.name);
        }
    }

    public void sortGroup(SortField field){
        TreeSet<Student> students = new TreeSet<>(new SortStudent(field));
        students.addAll(this.students);
        this.students = students;
    }

    public void saveStudents(IStudentDAO students){
        students.saveStudents(this.students);
    }

    public void setStudents(IStudentDAO students){
        TreeSet<Student> studentSet = new TreeSet<>(new SortStudent());
        studentSet.addAll(students.addStudents());
        this.students = studentSet;
    }

    public void saveGroup(IGroupDAO group){
        group.saveGroup(this);
    }

    public static Group loadGroup(IGroupDAO group){
        return group.loadGroup();
    }
}
