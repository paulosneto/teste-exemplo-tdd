package com.tdd.test.usecase.repositories;

import com.tdd.test.usecase.models.Course;

public interface ICourseRepository {

    public Course save(Course course);

    public Course findByName(String name);
}
