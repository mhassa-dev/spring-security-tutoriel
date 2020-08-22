package mh.com.project.controllers;

import mh.com.project.data.StudentData;
import mh.com.project.models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by mh on 19/08/2020.
 * <p>
 * Student Controller
 */
@RestController
@RequestMapping(value = "/api/v1/students")
public class StudentController {

    /**
     * Get all students
     *
     * @return students
     */
    @GetMapping(value = "all")
    public List<Student> getAllStudents() {
        return StudentData.getAll();
    }

    /**
     * Get student with the ID id
     *
     * @param id the id of student to get
     * @return the student
     */
    @GetMapping(value = "/{id}")
    public Student getStudent(@PathVariable Long id) {
        return StudentData.getAll().
                stream().
                filter(student -> id.equals(student.getId())).
                findFirst().
                orElseThrow(() -> new IllegalArgumentException("Student with id " + id + " doesn't exist"));
    }
}
