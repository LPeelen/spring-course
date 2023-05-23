package lpeelen.springcourse.section3;

import lpeelen.springcourse.section3.dao.StudentDAO;
import lpeelen.springcourse.section3.entities.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner -> {
            updateStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        Student newStudent = new Student("Boop", "Snoet", "snoet@student.com");

        studentDAO.save(newStudent);

        System.out.println("New student created with UUID: " + newStudent.getUuid());
    }

    private void getStudent(StudentDAO studentDAO) {
        Student student = studentDAO.findByUuid(UUID.fromString("325683f5-a101-439d-96d1-cce51e3a8349"));

        System.out.println(student);
    }

    private void getAllStudents(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();

        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void getStudentsByLastName(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findByLastName("Peelen");

        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void updateStudent(StudentDAO studentDAO) {
        Student student = studentDAO.findByUuid(UUID.fromString("ac3ee129-7148-494b-8afe-7db3691c522c"));

        student.setLastName("Piep");

        studentDAO.update(student);

        System.out.println("Updated student: " + student);
    }
}
