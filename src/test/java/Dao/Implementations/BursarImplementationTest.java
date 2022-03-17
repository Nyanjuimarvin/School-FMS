package Dao.Implementations;

import Models.Bursar;
import Models.Student;
import org.junit.jupiter.api.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class BursarImplementationTest {

    Bursar bursar;
    Student student;

    private static Connection conn;
    private static BursarImplementation bursarImplementation;
    private static StudentImplementation studentImplementation;

    @BeforeAll
    public static void setUp() {
        String connectionString = "jdbc:postgresql://localhost:5432/school_finance_test";
        Sql2o sql2o = new Sql2o(connectionString,"marvin","nrvnqsr13");
        bursarImplementation= new BursarImplementation(sql2o);
        studentImplementation = new StudentImplementation(sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    public void tearDown() {
        bursarImplementation.deleteAll();
        studentImplementation.deleteAll();
    }

    @AfterAll
    public static void shutDown(){
        conn.close();
    }



    @Test
    public void add_setsId() {

    }

    @Test
    void update() {
    }

    @Test
    void updateStudentFeeBalance() {
    }

    @Test
    void updateStudentPocketMoney() {
    }

    @Test
    void deleteStudent() {
    }

    public Bursar setUpBursar(){
        return new Bursar("D'arby","realgamnle@call.com",46373,"123-453-432112","wygdydgeyd");
    }

    public Student setUpStudent(){
        return new Student("Van Fem","2s",1800,7857d,12345d);
    }

}