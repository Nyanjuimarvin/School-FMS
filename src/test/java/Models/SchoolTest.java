package Models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {

    @Test
    @DisplayName("Instantiates Correctly")
    public void School_InstantiatesCorrectly(){
        School school = setUpSchool();
        assertTrue(school instanceof  School);
    }

    @Test
    @DisplayName("Properties are passed")
    public void School_HasProperties(){
        School school = setUpSchool();
        assertEquals("Combine High",school.getName());
        assertEquals("Division 17",school.getRegion());
        assertEquals("combine.high@blackMesa.com",school.getEmail());
    }


    public School setUpSchool(){
        School school = School.getInstance();
        school.setName("Combine High");
        school.setRegion("Division 17");
        school.setEmail("combine.high@blackMesa.com");
        return school;
    }

}