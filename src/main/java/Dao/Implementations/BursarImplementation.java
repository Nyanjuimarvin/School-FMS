package Dao.Implementations;

import Dao.Interfaces.BursarDao;
import Models.Bursar;
import Models.Student;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.math.BigDecimal;
import java.sql.SQLException;

public class BursarImplementation implements BursarDao {

    private final Sql2o sql2o;

    public BursarImplementation(Sql2o sql2o){
        this.sql2o = sql2o;
    }


    @Override
    public void add(Bursar bursar) {
        String sql = "INSERT INTO financiers (name,email,nationalid,contact,password,type) VALUES (:name,:email,:nationalId,:contact,:password,:type)";
        try(Connection conn = sql2o.open()){
            int id = (int)conn.createQuery(sql,true)
                    .bind(bursar)
                    .executeUpdate()
                    .getKey();
            bursar.setId(id);
        }catch(Sql2oException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void update(int id, String name, String email, int nationalId, String contact, String password) {
        String sql = "UPDATE financiers SET (name,email,nationalid,contact,password) = (:name,:email,:nationalId,:contact,:password) WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .addParameter("name",name)
                    .addParameter("email",email)
                    .addParameter("nationalId",nationalId)
                    .addParameter("contact",contact)
                    .addParameter("password",password)
                    .executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void updateStudentFeeBalance(int id,BigDecimal feeBalance) {
        String sql = "UPDATE students SET feebalance = :feeBalance WHERE id = :id ";
        try(Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .addParameter("feeBalance",feeBalance)
                    .executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void updateStudentPocketMoney(int id, BigDecimal pocketMoney) {
        String sql = "UPDATE students SET pocketmoney = :pocketMoney WHERE id = :id ";
        try(Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .addParameter("pocketMoney",pocketMoney)
                    .executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Student getStudent(int id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM students WHERE id = :id")
                    .addParameter("id",id)
                    .executeAndFetchFirst(Student.class);
        }
    }

    @Override
    public Bursar getBursar(int id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM financiers WHERE id = :id AND type = 'bursar'")
                    .addParameter("id",id)
                    .executeAndFetchFirst(Bursar.class);
        }
    }

    @Override
    public void deleteStudent(int id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM students WHERE id = :id")
                    .addParameter("id",id)
                    .executeUpdate();
        }
    }

    @Override
    public void deleteAll() {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM financiers")
                    .executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex.getMessage());
        }
    }
}
