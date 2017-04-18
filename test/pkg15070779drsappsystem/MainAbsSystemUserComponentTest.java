package pkg15070779drsappsystem;

import pkg15070779drsappsystem.MainClasses.SysUserPatient;
import pkg15070779drsappsystem.MainAbstractClasses.SystemUserComponent;
import org.junit.Test;
import static org.junit.Assert.*;


public class MainAbsSystemUserComponentTest {
    
    //@@@@@ need to write
    @Test
    public void testSetCurrentSystemUser(){
        SystemUserComponent testUser = new SysUserPatient("Sandra", "BEans", "Mrs", "01011901", "01234 567 890", "01011900");
        SystemUserComponent.setCurrentSystemUser("sandra.beans.01011901");
        assertEquals(true, testUser.getLoginCheckUserExists("sandra.beans.01011901"));
    } 
    
    //called indirectly so testign not needed
    /*
    @Test
    public void testGenerateUserName() {
        SystemUserComponent testUser = new SysUserPatient("Paul", "Treadwell", "Mr", 1983, "More data");
        assertEquals("paul.treadwell.1983", testUser.getGenerateUsername("Paul", "Treadwell", 1983));
                
        SystemUserComponent testUser2 = new Doctor("SAndRA", "BEans", "Mrs", 1922, "More data");
        assertEquals("sandra.beans.1922", testUser2.getGenerateUsername("SAndRA", "BEans", 1922));
    
        SystemUserComponent testUser3 = new Secretary("harold", "BEans", "Mr", 1923, "More data");
        assertEquals("harold.beans.1923", testUser3.getGenerateUsername("harold", "BEans", 1923));
        
        SystemUserComponent testUser4 = new Pharmacist("emMA", "BEans", "Mrs", 1924, "More data");
        assertEquals("emma.beans.1924", testUser4.getGenerateUsername("emMA", "BEans", 1924));
    
    }
*/
        
    //@@@@@ need to write
    @Test
    public void testSetPutInMap(){
    
    }
       

    @Test
    public void testCheckLogin(){
                       
        SystemUserComponent testUser = new SysUserPatient("Miss", "Sandra", "BEans",  "01011901", "01234 567 890", "sandra.beans.01011901");
        assertEquals(true, testUser.getLoginCheckUserExists("sandra.beans.01011901"));
        
       SystemUserComponent testUser2 = new SysUserPatient("Miss", "Emily", "peters",  "01011902", "01234 567 890", "sandra.beans.01011902");
       assertEquals(false, testUser2.getLoginCheckUserExists("norma.peters.01011902"));
    }
    
   
     //@@@@@ need to write
    @Test
    public void testToString(){
    
    }
            
    
}
