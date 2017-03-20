package pkg15070779drsappsystem;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;


public class AppointmentComponentTest {
    
    //@indirectly called through testAddDrRegsWith - test not needed
    @Test
    public void testGenerateAppUniqueKey(){
        
    } 
    
    @Test
    public void testGetAppointment(){
        Patient pat1 = new Patient("Alan", "Turing","Mr", 1900, "Test");
        Patient pat2 = new Patient("Donald", "Knuth","Mr", 1901, "Test");
        Patient pat3 = new Patient("Grace", "Hopper","Mrs", 1902, "Test");
        Patient pat4 = new Patient("Ada", "Lovelace","Miss", 1903, "Test");
        Patient pat5 = new Patient("Tim", "Berners-Lee","Mr", 1904, "Test");
        
        Doctor dr1 = new Doctor("Gregory", "House","Dr", 1911, "Test");
        Doctor dr2 = new Doctor("Peter", "Venkman","Dr", 1912, "Test");
        Doctor dr3 = new Doctor("Egon", "Spengler","Dr", 1913, "Test");
        Doctor dr4 = new Doctor("Ray", "Stance","Dr", 1914, "Test");
        Doctor dr5 = new Doctor("Winstone", "Zeddermore","Dr", 1915, "Test");
        
        pat1.setAddNewAppointment(pat1.getFullName(), new Date(1001001), 99200029, "gregory.house.1911");
        pat2.setAddNewAppointment(pat2.getFullName(), new Date(1991001), 99449595, "peter.venkman.1912");
        pat3.setAddNewAppointment(pat3.getFullName(), new Date(9022992), 67578584, "egon.spengler.1913");
        pat4.setAddNewAppointment(pat4.getFullName(), new Date(45563667), 33883883, "ray.stance.1914");
        pat5.setAddNewAppointment(pat5.getFullName(), new Date(33938837), 27728872, "winstone.zeddermore.1915");
        
        //assertEquals("hello", pat1.getAppointment("Appointment1")); needs looking at
    }
    
   
    
 
            
    
}