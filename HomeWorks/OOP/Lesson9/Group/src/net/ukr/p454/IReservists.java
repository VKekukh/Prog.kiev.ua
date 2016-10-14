package net.ukr.p454;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by user on 18.09.2016.
 */
public interface IReservists {
    default TreeSet<Student> getReservist(Set<Student> students){
        TreeSet<Student> reservist = new TreeSet<>(new SortStudent());
        for (Student student : students) {
            if (student.getAge() >=18 && student.getSex() == Sex.MALE ){
                reservist.add(student);
            }
        }
        return reservist;
    }
}
