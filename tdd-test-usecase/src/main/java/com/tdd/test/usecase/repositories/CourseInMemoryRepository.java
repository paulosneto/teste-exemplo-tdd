package com.tdd.test.usecase.repositories;

import com.tdd.test.usecase.models.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CourseInMemoryRepository implements ICourseRepository {

     // Classe usada para poder testar os metodos da api de cadastro da classe "CourseService"
    private List<Course> courses;

    public CourseInMemoryRepository() {
        this.courses = new ArrayList<>();
    }

    @Override
    public Course save(Course course) {
        // adiciona o curso na lista em
        // memoria para poder validar os testes
        this.courses.add(course);
        course.setId(UUID.randomUUID());
        return course;
    }

    @Override
    public Course findByName(String name) {
        // Faz uma busca na memoria e se caso encontrar algum curso com
        // mesmo nome, retorna o mesmo, caso nao encontre retorna "null"
        Optional<Course> optionalCourse = this.courses.stream().filter(course -> course.getName().equals(name)).findFirst();
        return optionalCourse.orElse(null);

    }
}
