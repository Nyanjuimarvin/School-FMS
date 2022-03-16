package Dao.Interfaces;

import Models.Student;

import java.util.List;

public interface StudentDao {

    void add(Student student);
    List <Student> getAll();
    void update(int id, String name, String classStream, int admissionNumber, double pocketMoney, double feeBalance);
    void delete(int id);
}
