package Dao.Implementations;

import Dao.Interfaces.AccountingDao;
import Models.Accountant;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class sql2oAccountingDao implements AccountingDao {

    private  final Sql2o sql2o;

    public sql2oAccountingDao(Sql2o sql2o){
        this.sql2o= sql2o;
    }



    @Override
    public void add(Accountant accountant) {
        String sql = "INSERT INTO financiers (name,email,nationalid,contact,password,type) VALUES (:name,:email,:nationalId,:contact,:password,:type)";
        try(Connection con = sql2o.open()){
            int id;
            id = (int) con.createQuery(sql, true)
                    .bind(accountant)
                    .executeUpdate()
                    .getKey();
            accountant.setId(id);
        }catch (Sql2oException error){
            System.out.println("Object was not possible to add because of " + error);
        }
    }


    @Override
    public List<Accountant> getall() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM financiers WHERE type = 'accuntant'").executeAndFetch(Accountant.class);

        }
    }
}
