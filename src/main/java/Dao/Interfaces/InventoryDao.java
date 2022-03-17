package Dao.Interfaces;

import Models.Inventory;

import java.util.List;

public interface InventoryDao {
    void add (Inventory inventory);
   List<Inventory> getall();

    List<Inventory> getAll();
}
