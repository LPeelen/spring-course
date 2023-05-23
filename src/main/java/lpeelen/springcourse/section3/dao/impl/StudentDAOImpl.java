package lpeelen.springcourse.section3.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lpeelen.springcourse.section3.dao.StudentDAO;
import lpeelen.springcourse.section3.entities.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private final EntityManager entityManager;

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

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);

        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query  = entityManager.createQuery(
                "FROM Student WHERE lastName=:lastName", Student.class);

        query.setParameter("lastName", lastName);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }
}
