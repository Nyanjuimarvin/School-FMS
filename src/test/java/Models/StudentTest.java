package Models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    @DisplayName("Instantiates correctly")
    public void Student_InstantiatesCorrectly(){
        Student student = setUpStudent();
        assertTrue(student instanceof Student);
    }

    @Test
    @DisplayName("Instantiates with properties")
    public void Student_InstantiatesWithProperties(){
        Student student = setUpStudent();

        BigDecimal pMoney = new BigDecimal(3456);
        BigDecimal fBalance = new BigDecimal(9678.56);

        assertEquals("Arcueid",student.getName());
        assertEquals("3L", student.getClassStream());
        assertEquals(34522, student.getAdmissionNumber());
        assertEquals(pMoney, student.getPocketMoney());
        assertEquals(fBalance, student.getFeeBalance());
    }

    public Student setUpStudent(){
        return new Student("Arcueid","3L",34522,3456d,9678.56d);
    }

}