package pkg15070779drsappsystem;

import org.junit.Test;
import static org.junit.Assert.*;


public class MainAbsSystemUserComponentTest {
    
    //@@@@@ need to write
    @Test
    public void testSetSystemUser(){
        
    } 
    
    //called indirectly so testign not needed
    /*
    @Test
    public void testGenerateUserName() {
        MainAbsSystemUserComponent testUser = new MainPatient("Paul", "Treadwell", "Mr", 1983, "More data");
        assertEquals("paul.treadwell.1983", testUser.setGenerateUsername("Paul", "Treadwell", 1983));
                
        MainAbsSystemUserComponent testUser2 = new Doctor("SAndRA", "BEans", "Mrs", 1922, "More data");
        assertEquals("sandra.beans.1922", testUser2.setGenerateUsername("SAndRA", "BEans", 1922));
    
        MainAbsSystemUserComponent testUser3 = new Secretary("harold", "BEans", "Mr", 1923, "More data");
        assertEquals("harold.beans.1923", testUser3.setGenerateUsername("harold", "BEans", 1923));
        
        MainAbsSystemUserComponent testUser4 = new Pharmacist("emMA", "BEans", "Mrs", 1924, "More data");
        assertEquals("emma.beans.1924", testUser4.setGenerateUsername("emMA", "BEans", 1924));
    
    }
*/
        
    //@@@@@ need to write
    @Test
    public void testSetPutInMap(){
    
    }
       
    @Test
    public void testGetusername(){
        MainAbsSystemUserComponent testUser = new MainPatient("Sandra", "BEans", "Mrs", "01011901", "01234 567 890", "More data");
        assertEquals("sandra.beans.01011901", testUser.getUserName(testUser));
    }
    
    
    
    @Test
    public void testCheckLogin(){
                       
        MainAbsSystemUserComponent testUser = new MainPatient("Sandra", "BEans", "Mrs", "01011901", "01234 567 890", "More data");
        assertEquals(true, testUser.getCheckLogin("sandra.beans.01011901"));
        
       MainAbsSystemUserComponent testUser2 = new MainPatient("Emily", "PETER", "Mrs", "01011901", "01234 567 890", "More data");
       assertEquals(false, testUser2.getCheckLogin("norma.peters.01011901"));
    }
    
   
     //@@@@@ need to write
    @Test
    public void testToString(){
    
    }
            
    
}
