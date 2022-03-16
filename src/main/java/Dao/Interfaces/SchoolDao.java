package Dao.Interfaces;

import Models.School;

public interface SchoolDao {
    void add(School school);
    School getById(int id);
    void delete();
}
