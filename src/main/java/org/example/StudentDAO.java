package org.example;
import java.util.List;

public interface StudentDAO {

    void save(Student student);

    void update(Student student);

    void delete(int id);

    Student findById(int id);

    List<Student> findAll();

}
