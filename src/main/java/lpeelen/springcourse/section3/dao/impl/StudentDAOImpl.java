package lpeelen.springcourse.section3.dao.impl;

import jakarta.persistence.EntityManager;
import lpeelen.springcourse.section3.dao.StudentDAO;
import lpeelen.springcourse.section3.entities.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findByUuid(UUID uuid) {
        return entityManager.find(Student.class, uuid);
    }
}
