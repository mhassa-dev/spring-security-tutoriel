package mh.com.project.controllers;

import mh.com.project.data.StudentData;
import mh.com.project.models.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mh on 22/08/2020.
 */
@RestController
@RequestMapping(value = "/management/api/v1/students")
public class StudentManagementController {

    @GetMapping
    public List<Student> getAllStudents() {
        System.out.println("Get all students");
        return StudentData.getAll();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println(String.format("Register new student %s: OK", student.getId()));
    }

    @PutMapping(value = "/{idStudent}")
    public void updateStudent(@PathVariable Integer idStudent, @RequestBody Student student) {
        System.out.println(String.format("Update student %s: OK", idStudent));
    }

    @DeleteMapping(value = "/{idStudent}")
    public void deleteStudent(@PathVariable Integer idStudent) {
        System.out.println(String.format("Delete student %s: OK", idStudent));
    }

}
