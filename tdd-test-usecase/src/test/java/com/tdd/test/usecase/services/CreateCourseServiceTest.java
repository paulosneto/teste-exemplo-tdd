package com.tdd.test.usecase.services;

import com.tdd.test.usecase.models.Course;
import com.tdd.test.usecase.repositories.CourseInMemoryRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreateCourseServiceTest {

    @Test
    public void shouldBeAbleToCreateANewCourse(){
        // Criar um novo curso
        Course course = new Course();
        course.setName("Name_Course_Test");
        course.setDescription("Description_Course_Test");
        course.setWorkload(360);

        //Cria um repositorio para poder testar o cadastro do curso
        CourseInMemoryRepository courseInMemoryRepository = new CourseInMemoryRepository();

        // Criar um novo service
        CourseService courseService = new CourseService(courseInMemoryRepository);
        Course courseCreated = courseService.saveCourse(course);

        //Verifica se tem um "id" de retorno após a criação, se existir, o teste passou
        assertNotNull(courseCreated.getId());
    }

    @Test
    public void shouldBeAbleErrorToCreateACourse(){

        // Cria o objeto do tipo Course
        Course couser = new Course();
        couser.setName("name_course_error");
        couser.setDescription("description_course_error");
        couser.setWorkload(140);

        //Cria um repositorio para poder fazer a tentativa de cadastro do course
        CourseInMemoryRepository courseInMemoryRepository = new CourseInMemoryRepository();

        //Cria o serviço para tentar salvar o objeto course
        CourseService service = new CourseService(courseInMemoryRepository);
        service.saveCourse(couser);

        // Faz a tentativa de cadastro do mesmo course para poder capturar a exceção
        Error error = assertThrows(Error.class, () -> { service.saveCourse(couser);});

        //Verifica se realmente foi lançada a exceção com a mesagem esperada
        assertEquals("Curso já existe!", error.getMessage());
    }

}

