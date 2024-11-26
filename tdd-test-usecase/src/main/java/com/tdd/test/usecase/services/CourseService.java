package com.tdd.test.usecase.services;

import com.tdd.test.usecase.models.Course;
import com.tdd.test.usecase.repositories.ICourseRepository;
import org.springframework.stereotype.Service;


@Service
public class CourseService {


    //Interface
    private ICourseRepository repository;

    // Cria instancia de construtor passando a interface
    public CourseService(ICourseRepository repository) {
        this.repository = repository;
    }

    public Course saveCourse(Course course){

        // Pesquisa se existe um curso com o nome informado
        Course courseExisted = repository.findByName(course.getName());

        //Se o curso existir retorna exceção
        if(courseExisted != null){
            throw new Error("Curso já existe!");
        }

        // Se o curso não existir salva e retorna o objeto
        return  repository.save(course);
    }
}
