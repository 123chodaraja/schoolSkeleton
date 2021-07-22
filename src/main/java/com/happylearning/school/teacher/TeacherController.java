package com.happylearning.school.teacher;

import com.happylearning.school.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherRepository repository;

    @GetMapping
    List<Teacher> getAllTeachers(){
        return repository.findAll();
    }

    @PostMapping
    Teacher saveTeacher(@RequestBody Teacher teacher) {
        return repository.save(teacher);
    }

    @DeleteMapping
    ResponseEntity<HttpStatus> deleteTeacher(@PathVariable Long id) {
        Optional<Teacher> optionalSubject = repository.findById(id);
        optionalSubject.ifPresent(subject -> repository.deleteById(subject.getId()));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
