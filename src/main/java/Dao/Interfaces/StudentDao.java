package Dao.Interfaces;

import Models.Student;

import java.math.BigDecimal;
import java.util.List;

public interface StudentDao {

    void add(Student student);
    List <Student> getAll();
    void update(int id, String name, String stream, int admission, BigDecimal money, BigDecimal balance);
    void delete(int id);
    void deleteAll();
}
