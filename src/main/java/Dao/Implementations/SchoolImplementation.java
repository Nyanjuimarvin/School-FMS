package Dao.Implementations;

import Dao.Interfaces.SchoolDao;
import Models.School;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

public class SchoolImplementation implements SchoolDao {

    private final Sql2o sql2o;
    public SchoolImplementation(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(School school) {
        String sql = "INSERT INTO school (name,region,email) VALUES (:name,:region,:email)";
        try(Connection conn = sql2o.open()){
            int id = (int) conn.createQuery(sql,true)
                    .addParameter("name",school.getName())
                    .addParameter("region",school.getRegion())
                    .addParameter("email", school.getEmail())
                    .bind(school)
                    .executeUpdate()
                    .getKey();
            school.setId(id);
        }catch(Sql2oException ex){
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public School getById(int id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("SELECT * FROM school WHERE id = :id")
                    .addParameter("id",id)
                    .executeAndFetchFirst(School.class);
        }
    }


    @Override
    public void delete() {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE FROM school")
                    .executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex.getMessage());
        }
    }
}
