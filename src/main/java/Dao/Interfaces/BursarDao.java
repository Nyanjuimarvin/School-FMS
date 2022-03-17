package Dao.Interfaces;

import Models.Bursar;

public interface BursarDao{

    void add(Bursar bursar);

    void getStudent(int id);
    void getBursar(int id);

    void update(int id,String name, String email, int nationalId, String contact,String password);
    void updateStudentFeeBalance(int id);
    void updateStudentPocketMoney(int id);

    void deleteStudent(int id);
    void deleteAll();
}
