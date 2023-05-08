package com.crudDemoStudent.crudDemo.DAO;

import com.crudDemoStudent.crudDemo.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    //define filed for EM
    EntityManager entityManager;
    //inject EM by Const

    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement SAVE
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override //NO TRANSACTION ANN REQUIRED
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override //NO TRANSACTION ANN REQUIRED
    public List<Student> findAll() {                           //Student Name of JPA ENTITY NOT THE NAME FROM DB ALL FROM ENTITY CLASS
        // TypedQuery<Student> studentTypedQuery =  entityManager.createQuery("From Student",Student.class);
        TypedQuery<Student> studentTypedQuery = entityManager.createQuery("From Student order By lastName Desc", Student.class);
        return studentTypedQuery.getResultList();
    }


    //NO TRANSACTION ANN REQUIRED
    public List<Student> findByLastName(String giventLastName) {                           //Student Name of JPA ENTITY NOT THE NAME FROM DB ALL FROM ENTITY CLASS
        // TypedQuery<Student> studentTypedQuery =  entityManager.createQuery("From Student",Student.class);
        TypedQuery<Student> studentTypedQuery = entityManager.createQuery("From Student where lastName =: theData", Student.class);
        //Set QueryParameter "theData " key for out model class lastName filed vaue will be which is cmng from method parameter
        studentTypedQuery.setParameter("theData", giventLastName);

        return studentTypedQuery.getResultList();
    }

    @Transactional //now ann needed
    public void updateStudent(Student stu) {
        entityManager.merge(stu); //merge is use to UPDATE
    }

    @Override
    @Transactional
    public void remove(Integer id) {
        Student student = entityManager.find(Student.class, id);
        // int noOfRows = entityManager.createQuery("DELETE from Student").executeUpdate();
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {

        int noofRows=entityManager.createQuery("DELETE from Student").executeUpdate();
        return noofRows;
    }

    //Typed Query === JPQL
}
