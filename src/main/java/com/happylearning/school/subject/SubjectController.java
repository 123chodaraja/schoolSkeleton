package com.happylearning.school.subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private SubjectRepository repository;

    @GetMapping
    List<Subject> getAllSubjects() {
        return repository.findAll();
    }

    @PostMapping
    Subject saveSubject(@RequestBody Subject subject) {
        return repository.save(subject);
    }

    @DeleteMapping
    ResponseEntity<HttpStatus> deleteSubject(@PathVariable Long id) {
        Optional<Subject> optionalSubject = repository.findById(id);
        optionalSubject.ifPresent(subject -> repository.deleteById(subject.getId()));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
