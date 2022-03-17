package Dao.Implementations;

import Dao.Interfaces.StudentDao;
import Models.Student;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class StudentImplementation implements StudentDao {

    private final Sql2o sql2o;

    public StudentImplementation(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Student student) {
        String sql = "INSERT INTO students (name,classstream,admissionnumber,pocketmoney,feebalance) VALUES (:name,:classStream,:admissionNumber,:pocketMoney,:feeBalance)";

        try(Connection conn = sql2o.open()){
            int id = (int)conn.createQuery(sql,true)
                    .bind(student)
                    .executeUpdate()
                    .getKey();
            student.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Student> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM STUDENTS")
                    .executeAndFetch(Student.class);
        }
    }

    @Override
    public void update(int id, String name, String stream, int admission, double money, double balance) {
        String sql = "UPDATE students SET (name,classstream,admissionnumber,pocketmoney,feebalance) = (:name,:stream,:admission,:money,:balance) WHERE id = :id";
        try(Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .addParameter("name",name)
                    .addParameter("stream",stream)
                    .addParameter("admission",admission)
                    .addParameter("money",money)
                    .addParameter("balance",balance)
                    .executeUpdate();
        }catch(Sql2oException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM students WHERE id = :id")
                    .executeUpdate();
        }catch(Sql2oException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM students")
                    .executeUpdate();
        }catch(Sql2oException ex){
            System.out.println(ex.getMessage());
        }
    }
}
