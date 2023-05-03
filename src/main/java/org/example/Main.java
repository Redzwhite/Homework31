package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAOImpl();

        int N = 10;
        for (int i = 1; i <= N; i++) {
            Student student = new Student("Student " + i, "student" + i + "@example.com");
            studentDAO.save(student);
            System.out.println("Added student: " + student);
        }

        List<Student> allStudents = studentDAO.findAll();
        System.out.println("\nAll students:");
        allStudents.forEach(System.out::println);

        int studentIdToFind = 3;
        Student studentFound = studentDAO.findById(studentIdToFind);
        System.out.println("\nFound student with ID " + studentIdToFind + ": " + studentFound);

        if (studentFound != null) {
            studentFound.setName("Updated Student");
            studentFound.setEmail("updated.student@example.com");
            studentDAO.update(studentFound);
            System.out.println("Updated student with ID " + studentIdToFind + ": " + studentFound);
        }

        int studentIdToDelete = 5;
        studentDAO.delete(studentIdToDelete);
        System.out.println("\nDeleted student with ID " + studentIdToDelete);

        List<Student> updatedStudents = studentDAO.findAll();
        System.out.println("\nAll students after delete operation:");
        updatedStudents.forEach(System.out::println);
    }
}

