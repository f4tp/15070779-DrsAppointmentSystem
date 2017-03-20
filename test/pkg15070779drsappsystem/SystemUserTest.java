package pkg15070779drsappsystem;

import org.junit.Test;
import static org.junit.Assert.*;


public class SystemUserTest {
    
    //@@@@@ need to write
    @Test
    public void testSetSystemUser(){
        
    } 
    
    //called indirectly so testign not needed
    /*
    @Test
    public void testGenerateUserName() {
        SystemUserComponent testUser = new Patient("Paul", "Treadwell", "Mr", 1983, "More data");
        assertEquals("paul.treadwell.1983", testUser.setGenerateUsername("Paul", "Treadwell", 1983));
                
        SystemUserComponent testUser2 = new Doctor("SAndRA", "BEans", "Mrs", 1922, "More data");
        assertEquals("sandra.beans.1922", testUser2.setGenerateUsername("SAndRA", "BEans", 1922));
    
        SystemUserComponent testUser3 = new Secretary("harold", "BEans", "Mr", 1923, "More data");
        assertEquals("harold.beans.1923", testUser3.setGenerateUsername("harold", "BEans", 1923));
        
        SystemUserComponent testUser4 = new Pharmacist("emMA", "BEans", "Mrs", 1924, "More data");
        assertEquals("emma.beans.1924", testUser4.setGenerateUsername("emMA", "BEans", 1924));
    
    }
*/
        
    //@@@@@ need to write
    @Test
    public void testSetPutInMap(){
    
    }
       
    @Test
    public void testGetusername(){
        SystemUserComponent testUser = new Patient("Sandra", "BEans", "Mrs", 1922, "More data");
        assertEquals("sandra.beans.1922", testUser.getUserName(testUser));
    }
    
    
    
    @Test
    public void testCheckLogin(){
                       
        SystemUserComponent testUser = new Patient("Sandra", "BEans", "Mrs", 1922, "More data");
        assertEquals(true, testUser.checkLogin("sandra.beans.1922"));
        
       SystemUserComponent testUser2 = new Patient("Emily", "PETER", "Mrs", 1924, "More data");
       assertEquals(false, testUser2.checkLogin("norma.peters.1924"));
    }
    
   
     //@@@@@ need to write
    @Test
    public void testToString(){
    
    }
            
    
}
