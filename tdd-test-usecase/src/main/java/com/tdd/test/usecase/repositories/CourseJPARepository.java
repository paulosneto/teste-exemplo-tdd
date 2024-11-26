package com.tdd.test.usecase.repositories;

import com.tdd.test.usecase.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseJPARepository extends JpaRepository<Course, UUID> {

    public Course findByName(String name);
}
