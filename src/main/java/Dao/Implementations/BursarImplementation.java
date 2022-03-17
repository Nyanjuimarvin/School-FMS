package Dao.Implementations;

import Dao.Interfaces.BursarDao;
import Models.Bursar;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class BursarImplementation implements BursarDao {

    private final Sql2o sql2o;

    public BursarImplementation(Sql2o sql2o){
        this.sql2o = sql2o;
    }


    @Override
    public void add(Bursar bursar) {

    }

    @Override
    public void update(int id, String name, String email, int nationalId, String contact, String password) {

    }

    @Override
    public void updateStudentFeeBalance(int id) {

    }

    @Override
    public void updateStudentPocketMoney(int id) {

    }

    @Override
    public void getStudent(int id) {

    }

    @Override
    public void getBursar(int id) {

    }

    @Override
    public void deleteStudent(int id) {

    }

    @Override
    public void deleteAll() {

    }
}
