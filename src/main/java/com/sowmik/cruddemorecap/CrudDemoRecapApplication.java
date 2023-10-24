package com.sowmik.cruddemorecap;

import com.sowmik.cruddemorecap.dao.StudentDAO;
import com.sowmik.cruddemorecap.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoRecapApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoRecapApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            // createStudent(studentDAO);
            createMultipleStudents(studentDAO);
        };
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
