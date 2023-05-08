package com.crudDemoStudent.crudDemo;

import com.crudDemoStudent.crudDemo.DAO.StudentDao;
import com.crudDemoStudent.crudDemo.Entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

/*
//Excute imm after spring beans are loaded
	@Bean
	public CommandLineRunner getConnCommandLineRunner(String[] arg){
     return runner-> System.out.println("Hello World");
	}
*/

    @Bean //studentDao Bean is created by CONST ARGU
    public CommandLineRunner getConnCommandLineRunner(StudentDao studentDao) {
        return runner ->
				//deleteAll(studentDao);
				//removeData(studentDao);
				//updateStudent(studentDao);
				//findByLastName(studentDao);
				//queryForStudent(studentDao);
				//readStudent(studentDao);
				createMultipleStudent(studentDao);
				//createStudent(studentDao);

    }

	private int deleteAll(StudentDao studentDao) {
		int rowsDeleted = studentDao.deleteAll();
		return rowsDeleted;
	}

	private void removeData(StudentDao studentDao) {
		int studenId=3;
		studentDao.remove(studenId);


	}

	private void updateStudent(StudentDao studentDao) {
		int studentId =1;
		Student student = studentDao.findById(studentId);
		System.out.println("Updating Student");
		student.setFirstName("DHAR");
		student.setLastName("KUMAR");
		studentDao.updateStudent(student);
	}

	private void findByLastName(StudentDao studentDao) {
		List<Student> lastNameStudent = studentDao.findByLastName("CHAUDHRY3");

		for (Student list:
		lastNameStudent) {
			System.out.println("Last Name Matches"+list);

		}

	}

	private List<Student> queryForStudent(StudentDao studentDao) {
		List<Student> listStudent = studentDao.findAll();
		for (Student l:listStudent) {
			System.out.println("Data from student Table :"+l);
		}

		return listStudent;
	}

	private void readStudent(StudentDao studentDao) {
		System.out.println("Creating Studdent");
		Student studentObj = new Student("Student", "CHAUDHRY", "student@gmail.com");
		studentDao.save(studentObj);
		System.out.println("Student Saved : "+studentObj.getGetId());
		studentDao.findById(studentObj.getGetId());
		System.out.println("My Student"+studentObj);
	}

	private void createMultipleStudent(StudentDao studentDao) {
		System.out.println("Creating Studdent");
		Student studentObj1 = new Student("DREKSHA1", "CHAUDHRY1", "chaudh1@gmail.com");
		Student studentObj2 = new Student("DREKSHA2", "CHAUDHRY2", "chaudh2@gmail.com");
		Student studentObj3 = new Student("DREKSHA3", "CHAUDHRY3", "chaudh3@gmail.com");
		Student studentObj4 = new Student("DREKSHA4", "CHAUDHRY4", "chaudh4@gmail.com");

		studentDao.save(studentObj1);
		studentDao.save(studentObj2);
		studentDao.save(studentObj3);
		studentDao.save(studentObj4);


		System.out.println("Student Saved : "+studentObj1);
		System.out.println("Student Saved : "+studentObj2);
		System.out.println("Student Saved : "+studentObj3);
		System.out.println("Student Saved : "+studentObj4);

		//ALTER TABLE student_tracker.student AUTO_INCREMENT=4000
		//TRUNCAT student_tracker.Student : again run code it will start from fresh with id 1

	}

	private void createStudent(StudentDao studentDao) {
        System.out.println("Creating Studdent");
        Student studentObj = new Student("DREKSHA", "CHAUDHRY", "chaudh@gmail.com");
		studentDao.save(studentObj);
		System.out.println("Student Saved : "+studentObj);
    }

}


