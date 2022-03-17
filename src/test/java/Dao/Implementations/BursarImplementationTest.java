package Dao.Implementations;

import Models.Bursar;
import Models.Student;
import org.junit.jupiter.api.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.math.BigDecimal;

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
        bursar = setUpBursar();
        int initialId = bursar.getId();
        bursarImplementation.add(bursar);
        assertNotEquals(initialId,bursar.getId());
    }

    @Test
    public void update_UpdatesProperties() {
        bursar = setUpBursar();
        String initialName = bursar.getName();
        String initialEmail = bursar.getEmail();
        int initialId = bursar.getNationalId();
        bursarImplementation.add(bursar);
        bursarImplementation.update(bursar.getId(),"Chewbaca", "wookie@resistance.com",4646,"123-223-122332","gdssdd67wds");

        assertNotEquals(initialName,bursarImplementation.getBursar(bursar.getId()).getName());
        assertNotEquals(initialEmail, bursarImplementation.getBursar(bursar.getId()).getEmail());
        assertNotEquals(initialId,bursarImplementation.getBursar(bursar.getId()).getNationalId());
    }

    @Test
    public void updateStudentFeeBalance_UpdatesFeeBalance() {
        student = setUpStudent();
        BigDecimal initialMoney = student.getFeeBalance();
        studentImplementation.add(student);
        bursar = setUpBursar();
        BigDecimal newMoney = new BigDecimal("3434");
        bursarImplementation.updateStudentFeeBalance(student.getId(),newMoney);
        assertNotEquals(initialMoney, bursarImplementation.getStudent(student.getId()).getFeeBalance());
    }

    @Test
    public void updateStudentPocketMoney_UpdatesPocketMoney() {
        student = setUpStudent();
        BigDecimal initialMoney = student.getPocketMoney();
        studentImplementation.add(student);
        bursar = setUpBursar();
        BigDecimal newMoney = new BigDecimal("3434");
        bursarImplementation.updateStudentPocketMoney(student.getId(),newMoney);
        assertNotEquals(initialMoney, bursarImplementation.getStudent(student.getId()).getPocketMoney());
    }

    @Test
    public void getStudent_ReturnsStudent(){
        student = setUpStudent();
        studentImplementation.add(student);

        assertEquals(student, bursarImplementation.getStudent(student.getId()));
    }

    @Test
    public void deleteStudent_DeletesStudent() {
        student = setUpStudent();
        studentImplementation.add(student);
        bursarImplementation.deleteStudent(student.getId());
        assertFalse(studentImplementation.getAll().contains(student));
    }

    public Bursar setUpBursar(){
        return new Bursar("D'arby","realgamnle@call.com",46373,"123-453-432112","wygdydgeyd");
    }

    public Student setUpStudent(){
        return new Student("Van Fem","2s",1800,7857d,12345d);
    }

}