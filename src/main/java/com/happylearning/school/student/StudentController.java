package com.happylearning.school.student;

import com.happylearning.school.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @GetMapping
    List<Student> getAllStudents() {
        return repository.findAll();
    }

    @PostMapping
    Student createStudent(@RequestBody Student student) {
        return repository.save(student);
    }

    @DeleteMapping
    ResponseEntity<HttpStatus> deleteStudent(@PathVariable Long id) {
        Optional<Student> optionalSubject = repository.findById(id);
        optionalSubject.ifPresent(subject -> repository.deleteById(subject.getId()));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
