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
        
    @Test
    public void testCheckLogin(){
                       
        SystemUser testUser = new SystemUser("Sandra", "BEans", "Mrs", 1922);
        assertEquals(true, testUser.checkLogin("sandra.beans.1922"));
        
       SystemUser testUser2 = new SystemUser("Emily", "PETER", "Mrs", 1924);
       assertEquals(false, testUser2.checkLogin("norma.peters.1924"));
    }
       
}
