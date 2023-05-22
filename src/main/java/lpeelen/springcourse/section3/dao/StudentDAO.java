package lpeelen.springcourse.section3.dao;

import lpeelen.springcourse.section3.entities.Student;

import java.util.UUID;

public interface StudentDAO {

    void save(Student student);

    Student findByUuid(UUID uuid);
}
