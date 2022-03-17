package Dao.Interfaces;

import Models.Accountant;

import java.util.List;

public interface AccountingDao {
   void add(Accountant accountant);
    List<Accountant> getall();


}
