package pkg15070779drsappsystem;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;


public class MainAbsAppointmentComponentTest {
    
    //@indirectly called through testAddDrRegsWith - test not needed
    @Test
    public void testGenerateAppUniqueKey(){
        
    } 
    
    @Test
    public void testGetAppointment(){
        MainPatient pat1 = new MainPatient("Alan", "Turing","Mr", "01011900", "01234 567 890","gregory.house.01011911");
        MainPatient pat2 = new MainPatient("Donald", "Knuth","Mr", "01011901", "01234 567 890","peter.venkman.0101");
        MainPatient pat3 = new MainPatient("Grace", "Hopper","Mrs", "01011902", "01234 567 890","egon.spengler.0101");
        MainPatient pat4 = new MainPatient("Ada", "Lovelace","Miss", "01011903", "01234 567 890","ray.stance.0101");
        MainPatient pat5 = new MainPatient("Tim", "Berners-Lee","Mr", "01011904", "01234 567 890","winstone.zeddermore.1915");
        
        MainDoctor dr1 = new MainDoctor("Gregory", "House","Dr", "01011910", "Test");
        MainDoctor dr2 = new MainDoctor("Peter", "Venkman","Dr", "01011911", "Test");
        MainDoctor dr3 = new MainDoctor("Egon", "Spengler","Dr", "01011912", "Test");
        MainDoctor dr4 = new MainDoctor("Ray", "Stance","Dr", "01011913", "Test");
        MainDoctor dr5 = new MainDoctor("Winstone", "Zeddermore","Dr", "01011914", "Test");
        
       // pat1.addNewAppointment(pat1.getFullName(), new Date(1001001), 99200029, "gregory.house.01011910");
       // pat2.addNewAppointment(pat2.getFullName(), new Date(1991001), 99449595, "peter.venkman.01011911");
       // pat3.addNewAppointment(pat3.getFullName(), new Date(9022992), 67578584, "egon.spengler.01011912");
        //pat4.addNewAppointment(pat4.getFullName(), new Date(45563667), 33883883, "ray.stance.01011913");
       // pat5.addNewAppointment(pat5.getFullName(), new Date(33938837), 27728872, "winstone.zeddermore.01011914");
        
        //assertEquals("hello", pat1.getAppointment("Appointment1")); needs looking at
    }
    
   
    
 
            
    
}