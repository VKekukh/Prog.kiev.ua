package net.ukr.p454;

import net.ukr.p454.DAO.IStudentDAO;

import java.time.LocalDate;
import java.util.Formatter;

/**
 * Created by user on 18.09.2016.
 */


    public class Student extends Human {
        public static int id = 10000;

        private String faculty;
        private String group;
        private int studentID;
        private int course;


        public Student(String fullName, int age, String nationality, LocalDate dateOfBirthday, String placeOfBirthday, Sex sex,
                       String faculty, int course) {
            super(fullName, age, nationality, dateOfBirthday, placeOfBirthday, sex);
            this.faculty = faculty;
            this.studentID = setId();
            this.course = course;
        }

        public Student(Human human) {
            super(human.getFullName(), human.getAge(), human.getNationality(), human.getDateOfBirthday(),
                    human.getPlaceOfBirthday(), human.getSex());
        }

        public Student(Human human, String faculty, int course) {
            super(human.getFullName(), human.getAge(), human.getNationality(), human.getDateOfBirthday(),
                    human.getPlaceOfBirthday(), human.getSex());
            this.faculty = faculty;
            this.studentID = setId();
            this.course = course;
        }

        @Override
        public String toString() {
            String str;
            Formatter formatter = new Formatter();
            formatter.format(super.toString());
            formatter.format("%-18s %s", "Faculty:", faculty);
            formatter.format(System.lineSeparator());
            formatter.format("%-18s %s", "Group:", group);
            formatter.format(System.lineSeparator());
            formatter.format("%-18s %d", "StudentID:", studentID);
            formatter.format(System.lineSeparator());
            formatter.format("%-18s %d", "Course:", course);
            formatter.format(System.lineSeparator());
            str = formatter.toString();
            formatter.close();
            return str;
        }

        public Student() {
            super();
        }

        public final static int setId(){
            return id++;
        }

        public String getFaculty() {
            return faculty;
        }

        public void setFaculty(String faculty) {
            this.faculty = faculty;
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) {
            this.group = group;
        }


        public static int getId() {
            return id;
        }

        public void setStudentID() {
            this.studentID = Student.setId();
        }

        public int getStudentID() {
            return studentID;
        }

        public int getCourse() {
            return course;
        }

        public void setCourse(int course) {
            this.course = course;
        }

        public static Student addStudent (IStudentDAO student){
            return student.addStudent();
        }
}
