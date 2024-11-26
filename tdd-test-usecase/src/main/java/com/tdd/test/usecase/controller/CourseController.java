package com.tdd.test.usecase.controller;

import com.tdd.test.usecase.models.Course;
import com.tdd.test.usecase.repositories.CourseServiceIMP;
import com.tdd.test.usecase.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

    // Faz a instância do repository
    // implementando implicitamente
    // os metodos do JPA
    @Autowired
    private CourseServiceIMP repository;

    // Recebe requisição para cadastrar o "Course"
    @PostMapping
    public Course createCourse(@RequestBody Course course){
        CourseService courseService = new CourseService(repository);
        return courseService.saveCourse(course);
    }
}
