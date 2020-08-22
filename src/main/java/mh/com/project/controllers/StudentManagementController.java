package mh.com.project.controllers;

import mh.com.project.data.StudentData;
import mh.com.project.models.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mh on 22/08/2020.
 */
@RestController
@RequestMapping(value = "/management/api/v1/students")
public class StudentManagementController {

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'ADMIN_TRAINEE')")
    public List<Student> getAllStudents() {
        System.out.println("Get all students");
        return StudentData.getAll();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println(String.format("Register new student %s: OK", student.getId()));
    }

    @PutMapping(value = "/{idStudent}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable Integer idStudent, @RequestBody Student student) {
        System.out.println(String.format("Update student %s: OK", idStudent));
    }

    @DeleteMapping(value = "/{idStudent}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable Integer idStudent) {
        System.out.println(String.format("Delete student %s: OK", idStudent));
    }

}
