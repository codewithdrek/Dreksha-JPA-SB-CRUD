package com.crudDemoStudent.crudDemo.DAO;

import com.crudDemoStudent.crudDemo.Entity.Student;

import java.util.List;

public interface StudentDao {

    public void save(Student student) ;
    public Student findById(int id);



    List<Student> findAll();
    List<Student> findByLastName(String theLastName);

    void updateStudent(Student stu);
     void remove(Integer id);

     int deleteAll();
}
