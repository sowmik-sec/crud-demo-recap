package com.sowmik.cruddemorecap;

import com.sowmik.cruddemorecap.dao.StudentDAO;
import com.sowmik.cruddemorecap.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoRecapApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoRecapApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            // createStudent(studentDAO);
            // createMultipleStudents(studentDAO);
            // readStudent(studentDAO);
            // queryForStudents(studentDAO);
            queryForStudentsByLastName(studentDAO);
        };
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        // get a list of students
        List<Student> theStudents = studentDAO.findByLastName("Burger");

        // display list of students
        for(Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        // get a list of students
        List<Student> theStudents = studentDAO.findAll();
        // display list of students
        for(Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        // create a student object
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Alison", "Burger", "alison@burger.com");

        // save the student
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        int theId = tempStudent.getId();
        System.out.println("The id of the saved student: "+theId);

        // retrieve student based on the id: primary key
        System.out.println("Retrieving student with id: " + theId);
        Student myStudent = studentDAO.findById(theId);

        // display student
        System.out.println(myStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        // create multiple students
        System.out.println("Creating 3 student objects...");
        Student tempStudent1 = new Student("Adam", "Smith", "adam@smith.com");
        Student tempStudent2 = new Student("Eva", "Braun", "eva@braun.com");
        Student tempStudent3 = new Student("Adolf", "Hitler", "adlof@hitler.com");

        // save the student objects
        System.out.println("Saving teh students...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

    }

    private void createStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("John", "Doe", "john@doe.com");

        // save the student object
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }
}
