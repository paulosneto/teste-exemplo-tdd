package com.tdd.test.usecase.repositories;

import com.tdd.test.usecase.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceIMP implements ICourseRepository{

    @Autowired
    CourseJPARepository repository;

    @Override
    public Course save(Course course) {
        return this.repository.save(course);
    }

    @Override
    public Course findByName(String name) {
        return this.repository.findByName(name);
    }
}
