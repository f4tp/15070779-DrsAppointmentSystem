package pkg15070779drsappsystem;

import org.junit.Test;
import static org.junit.Assert.*;


public class SystemUserTest {
    
    public SystemUserTest() {
    }

      
    @Test
    public void testGenerateUserName() {
        SystemUser testUser = new SystemUser("Paul", "Treadwell", "Mr", 1983);
        assertEquals("paul.treadwell.1983", testUser.generateUserName("Paul", "Treadwell", 1983));
                
        SystemUser testUser2 = new SystemUser("SAndRA", "BEans", "Mrs", 1922);
        assertEquals("sandra.beans.1922", testUser2.generateUserName("SAndRA", "BEans", 1922));
    }
        
       
}
