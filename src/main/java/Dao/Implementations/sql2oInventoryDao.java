package Dao.Implementations;

import Dao.Interfaces.InventoryDao;
import Models.Inventory;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class sql2oInventoryDao implements InventoryDao {

    private final Sql2o sql20;
    private Object sql2o;

    public sql2oInventoryDao(Sql2o sql2o) {
        this.sql20 = sql2o;
    }


    @Override
    public void add(Inventory inventory) {
        try (Connection con = (Connection) sql2o) {
            int id;
            id = (int) con.createQuery(String.valueOf(sql2o), true)
                    .bind(inventory)
                    .executeUpdate()
                    .getKey();
            inventory.setid(id);
        } catch (Sql2oException error) {
            System.out.println("Object was not possible to add because of " + error);
        }

    }

    @Override
    public List<Inventory> getall() {
        return null;
    }

//    @Override
//    public List<Inventory> getAll() {
//        return null;
//    }

}