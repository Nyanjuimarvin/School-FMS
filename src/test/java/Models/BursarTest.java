package Models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BursarTest {

    @Test
    @DisplayName("Instantiates")
    public void Bursar_InstantiatesCorrectly(){
        Bursar bursar = setUpBursar();
        assertTrue(bursar instanceof  Bursar);
    }

    @Test
    @DisplayName("Instantiates With Properties")
    public void Bursar_InstantiatesWithProperties(){
        Bursar bursar = setUpBursar();

        assertEquals("Mr.House", bursar.getName());
        assertEquals("House.Based@casino87.com", bursar.getEmail());
        assertEquals(392382, bursar.getNationalId());
        assertEquals("123-234-232454", bursar.getContact());
        assertEquals("assdsdsds", bursar.getPassword());
    }


    public Bursar setUpBursar(){
        return new Bursar("Mr.House","House.Based@casino87.com",392382,"123-234-232454","assdsdsds");
    }

}