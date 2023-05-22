package lpeelen.springcourse.section3;

import lpeelen.springcourse.section3.dao.StudentDAO;
import lpeelen.springcourse.section3.entities.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {
            readStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        Student newStudent = new Student("Lucas", "Peelen", "peelen@student.com");

        studentDAO.save(newStudent);

        System.out.println("New student created with UUID: " + newStudent.getUuid());
    }

    private void readStudent(StudentDAO studentDAO) {
        Student student = studentDAO.findByUuid(UUID.fromString("325683f5-a101-439d-96d1-cce51e3a8349"));

        System.out.println(student);
    }
}
