package pkg15070779drsappsystem;

import org.junit.Test;
import static org.junit.Assert.*;


public class SystemUserTest {
    
    //@@@@@ need to write
    @Test
    public void testSetSystemUser(){
        
    } 
    
    @Test
    public void testGenerateUserName() {
        SystemUser testUser = new Patient("Paul", "Treadwell", "Mr", 1983, "More data");
        assertEquals("paul.treadwell.1983", testUser.generateUserName("Paul", "Treadwell", 1983));
                
        SystemUser testUser2 = new Patient("SAndRA", "BEans", "Mrs", 1922, "More data");
        assertEquals("sandra.beans.1922", testUser2.generateUserName("SAndRA", "BEans", 1922));
    }
        
    //@@@@@ need to write
    @Test
    public void testSetPutInMap(){
    
    }
       
    @Test
    public void testGetusername(){
        SystemUser testUser = new Patient("Sandra", "BEans", "Mrs", 1922, "More data");
        assertEquals("sandra.beans.1922", testUser.getUserName(testUser));
    }
    
    
    
    @Test
    public void testCheckLogin(){
                       
        SystemUser testUser = new Patient("Sandra", "BEans", "Mrs", 1922, "More data");
        assertEquals(true, testUser.checkLogin("sandra.beans.1922"));
        
       SystemUser testUser2 = new Patient("Emily", "PETER", "Mrs", 1924, "More data");
       assertEquals(false, testUser2.checkLogin("norma.peters.1924"));
    }
    
   
     //@@@@@ need to write
    @Test
    public void testToString(){
    
    }
            
    
}
