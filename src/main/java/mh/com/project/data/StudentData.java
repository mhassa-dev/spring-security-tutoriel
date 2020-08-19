package mh.com.project.data;

import mh.com.project.models.Student;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mh on 19/08/2020.
 * <p>
 * Student Data
 */
public class StudentData {

    private final static Student student1 = Student.builder().id(1L).name("Student 1").build();
    private final static Student student2 = Student.builder().id(2L).name("Student 2").build();
    private final static Student student3 = Student.builder().id(3L).name("Student 3").build();
    private final static Student student4 = Student.builder().id(4L).name("Student 4").build();

    public static List<Student> getAll() {
        return Arrays.asList(student1, student2, student3, student4);
    }
}
