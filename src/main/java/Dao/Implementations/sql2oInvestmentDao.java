package Dao.Implementations;

import Dao.Interfaces.InvestmentDao;
import Models.Investment;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

public class sql2oInvestmentDao implements InvestmentDao {
    private final Sql2o sql2o;

    public sql2oInvestmentDao(Sql2o sql2o){this.sql2o=sql2o;}
    @Override
    public void add(Investment investment) {

        String insert = "INSERT INTO investment ( investment,cash ) VALUES (:investment, :cash,)";


        try(Connection con = sql2o.open()){
            int id;
            id = (int) con.createQuery(insert, true)
                    .bind(investment)
                    .executeUpdate()
                    .getKey();
            investment.setId(id);
        }catch (Sql2oException error){
            System.out.println("Object was not possible to add because of " + error);
        }
    }
}
