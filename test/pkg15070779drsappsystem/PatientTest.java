package pkg15070779drsappsystem;

import org.junit.Test;
import static org.junit.Assert.*;


public class PatientTest {
    
    //@indirectly called through testAddDrRegsWith - test not needed
    @Test
    public void testAddDrRegsWith(){
        
    } 
    
   
    @Test
    //@@@@@ this needs lookign at@@@@@
    public void testGetDrsRegWith(){
        Patient testUser = new Patient("Paul", "Treadwell", "Mr", 1983, "More data");
        //testUser.setAddDrRegsWith("Dr Peter Venkman");
        //assertEquals("Dr Peter Venkman", testUser.getDrsRegWith());
        
        Patient testUser2 = new Patient("Paul", "Treadwell", "Mr", 1983, "More data");
        //testUser2.setAddDrRegsWith("Dr Peter Venkman");
        //testUser2.setAddDrRegsWith("Dr Egon Spengler");
        //testUser2.setAddDrRegsWith("Dr Sarah Thompson");
        //assertEquals("Dr Peter Venkman, Dr Egon Spengler, Dr Sarah Thompson", testUser2.getDrsRegWith());
    } 
 
            
    
}
