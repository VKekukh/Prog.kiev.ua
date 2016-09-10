package net.ukr.p454.DAO;

import net.ukr.p454.Group;
import net.ukr.p454.Human;
import net.ukr.p454.Student;

import java.io.*;

/**
 * Created by vkekukh on 01.09.2016.
 */
public class GroupCSV implements IGroupDAO{
  File file;

  public GroupCSV(File file) {
    this.file = file;
  }

  public GroupCSV() {
  }

  @Override
  public  void saveGroup(Group group) {
    String studentsFileName = "StudentsGroup"+ group.getName() + ".csv";
    if (file == null){
      file = new File(group.getName() + ".csv");
    }

    try(PrintWriter print = new PrintWriter(file)){
      print.write(group.getName() + ";");

      StudentCSV studentCSV = new StudentCSV(new File(studentsFileName));
      group.saveStudents(studentCSV);
      print.write(studentsFileName + ";");

      print.write(group.getGroupCurator().getFullName() + ";");



    }catch(IOException e) {
      System.out.println(e);
    }
  }

  @Override
  public Group loadGroup() {
    Group group = new Group();
    String [] fields;

    if (file == null || !file.exists()) {
      throw new IllegalArgumentException();
    }
    try(BufferedReader input = new BufferedReader(new FileReader(file))){
      fields = input.readLine().split(";");

      group.setName(fields[0]);
      if (fields[1].length()>0){
        group.setStudents(new StudentCSV(new File(fields[1])));
      }

      group.setGroupCurator(new Human(fields[2]));
    }catch (IOException e) {
      System.err.println("e");
    }
    return group;
  }
}