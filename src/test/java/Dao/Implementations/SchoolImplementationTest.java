package Dao.Implementations;

import Models.School;
import org.junit.jupiter.api.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class SchoolImplementationTest {
    private static Connection conn;
    private static SchoolImplementation schoolImplementation;

    @BeforeAll
    public static void setUp() {
        String connectionString = "jdbc:postgresql://localhost:5432/school_finance_test";
        Sql2o sql2o = new Sql2o(connectionString,"marvin","nrvnqsr13");
        schoolImplementation = new SchoolImplementation(sql2o);
        conn = sql2o.open();

    }

    @AfterEach
    public void tearDown() {
        schoolImplementation.delete();
    }

    @AfterAll
    public static void shutDown() {
        conn.close();
    }

    @Test
    @DisplayName("Adding sets id")
    public void add_SetsId() {
        School school = setUpSchool();
        int initialId = school.getId();
        schoolImplementation.add(school);
        assertNotEquals(initialId, school.getId());
    }


    public School setUpSchool(){
        School school = School.getInstance();
        school.setName("Combine High");
        school.setRegion("Division 17");
        school.setEmail("combine.high@blackMesa.com");
        return school;
    }
}