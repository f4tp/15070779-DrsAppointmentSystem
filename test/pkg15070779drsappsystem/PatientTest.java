package pkg15070779drsappsystem;

import org.junit.Test;
import static org.junit.Assert.*;


public class PatientTest {
                
   //method not complete
    @Test
    public void testSetAddDrRegsWith(){
        //pat1.setAddDrRegsWith("peter.venkman.1912");
        //String datatoTest = pat1.getDrsRegWith();
        //assertEquals(true, datatoTest.contains("peter.venkman.1912"));
        
       
    } 
           
    @Test
    public void testSetAddNewAppointment(){
            
    }
    
    @Test
    public void testgetDoctorNameWithKy(){
        //Patient pat1 = new Patient("Alan", "Turing","Mr", 1900, "gregory.house.1911");
        //assertEquals("Dr Gregory House", pat1.testgetDoctorNameWithKy("gregory.house.1911")); 
    }
    
    
    @Test
    public void testgetFullName(){
    Patient pat1 = new Patient("Alan", "Turing","Mr", 1900, "gregory.house.1911");
    assertEquals("Alan Turing", pat1.getFullName()); 
    }
    
    @Test
    public void testgetUserName(){
    Patient pat1 = new Patient("Alan", "Turing","Mr", 1900, "gregory.house.1911");
    assertEquals("alan.turing.1900", pat1.getUserName(pat1)); 
    }
    
    //method not complete
    @Test
    public void testGetDrsRegWith(){
        //Patient pat6 = new Patient("Tony", "Hoare","Mr", 1905, "winstone.zeddermore.1915");
        //assertEquals("Dr Winstone Zeddermore", pat6.getDrsRegWith());      
    } 
 
    @Test
    public void getAppointment(){
    
    }
            
    
}
