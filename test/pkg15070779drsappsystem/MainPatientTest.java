package pkg15070779drsappsystem;

import pkg15070779drsappsystem.MainClasses.MainPatient;
import org.junit.Test;
import static org.junit.Assert.*;


public class MainPatientTest {
                
   //method not complete
    @Test
    public void testAddDrRegsWith(){
        //pat1.addDrRegsWith("peter.venkman.1912");
        //String datatoTest = pat1.getDrsRegWithAsStringAsUserNames();
        //assertEquals(true, datatoTest.contains("peter.venkman.1912"));
        
       
    } 
           
    @Test
    public void testAddNewAppointment(){
            
    }
    
    @Test
    public void testgetDoctorNameWithKy(){
        //Patient pat1 = new MainPatient("Alan", "Turing","Mr", 1900, "gregory.house.1911");
        //assertEquals("Dr Gregory House", pat1.testgetDoctorNameWithKy("gregory.house.1911")); 
    }
    
    
   
    
    @Test
    public void testgetUserName(){
    MainPatient pat1 = new MainPatient("Mr", "Alan", "Turing", "01011901", "01234 567 890", "gregory.house.01011910");
    assertEquals("alan.turing.01011901", pat1.getUserName()); 
    }
    
    //method not complete
    @Test
    public void testGetDrsRegWithAsStringAsUserNames(){
        //Patient pat6 = new MainPatient("Tony", "Hoare","Mr", 1905, "winstone.zeddermore.1915");
        //assertEquals("Dr Winstone Zeddermore", pat6.getDrsRegWithAsStringAsUserNames());      
    } 
 
    @Test
    public void getAppointment(){
    
    }
            
    
}
