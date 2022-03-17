package Dao.Implementations;

import Models.Student;
import org.junit.jupiter.api.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class StudentImplementationTest {

    Student student;

    private static Connection conn;
    private static StudentImplementation studentImplementation;

    @BeforeAll
    public static void setUp() {
        String connectionString = "jdbc:postgresql://localhost:5432/school_finance_test";
        Sql2o sql2o = new Sql2o(connectionString,"marvin","nrvnqsr13");
        studentImplementation = new StudentImplementation(sql2o);
        conn = sql2o.open();
    }

    @AfterEach
    public void tearDown() {
        studentImplementation.deleteAll();
    }

    @AfterAll
    public static void shutDown(){
        conn.close();

    }

    @Test
    public void add_setsId() {
        student = setUpStudent();
        int initialId = student.getId();
        studentImplementation.add(student);
        assertNotEquals(initialId,student.getId());
    }

    @Test
    public void getAll_ReturnsAllStudents(){
        student = setUpStudent();
        Student student1 = new Student("Roa","7d",35353,262552d,23232d);
        studentImplementation.add(student);
        studentImplementation.add(student1);
        assertEquals(2,studentImplementation.getAll().size());
    }

    @Test
    public void deleteAll_deletesAllStudents() {
        student = setUpStudent();
        Student student1 = new Student("Roa","7d",35353,262552d,23232d);
        studentImplementation.add(student);
        studentImplementation.add(student1);
        studentImplementation.deleteAll();
        assertEquals(0,studentImplementation.getAll().size());
    }

    public Student setUpStudent(){
        return new Student("Van Fem","2s",1800,7857d,12345d);
    }
}