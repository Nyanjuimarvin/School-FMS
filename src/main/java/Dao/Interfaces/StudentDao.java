package Dao.Interfaces;

import Models.Student;

import java.util.List;

public interface StudentDao {

    void add(Student student);
    List <Student> getAll();
    void update(int id, String name, String stream, int admission, double money, double balance);
    void delete(int id);
    void deleteAll();
}
