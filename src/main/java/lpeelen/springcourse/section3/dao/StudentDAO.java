package lpeelen.springcourse.section3.dao;

import lpeelen.springcourse.section3.entities.Student;

import java.util.List;
import java.util.UUID;

public interface StudentDAO {

    void save(Student student);

    Student findByUuid(UUID uuid);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);
}
