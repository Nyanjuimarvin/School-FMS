package Dao.Interfaces;

import Models.Bursar;
import Models.Student;

import java.math.BigDecimal;

public interface BursarDao{

    void add(Bursar bursar);

    Student getStudent(int id);
    Bursar getBursar(int id);

    void update(int id,String name, String email, int nationalId, String contact,String password);
    void updateStudentFeeBalance(int id, BigDecimal feeBalance);
    void updateStudentPocketMoney(int id,BigDecimal pocketMoney);

    void deleteStudent(int id);
    void deleteAll();
}
