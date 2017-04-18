package pkg15070779drsappsystem;

import pkg15070779drsappsystem.MainClasses.SysUserPatient;
import pkg15070779drsappsystem.MainClasses.SysUserDoctor;
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
        SysUserPatient pat1 = new SysUserPatient("Alan", "Turing","Mr", "01011900", "01234 567 890","gregory.house.01011911");
        SysUserPatient pat2 = new SysUserPatient("Donald", "Knuth","Mr", "01011901", "01234 567 890","peter.venkman.0101");
        SysUserPatient pat3 = new SysUserPatient("Grace", "Hopper","Mrs", "01011902", "01234 567 890","egon.spengler.0101");
        SysUserPatient pat4 = new SysUserPatient("Ada", "Lovelace","Miss", "01011903", "01234 567 890","ray.stance.0101");
        SysUserPatient pat5 = new SysUserPatient("Tim", "Berners-Lee","Mr", "01011904", "01234 567 890","winstone.zeddermore.1915");
        
        SysUserDoctor dr1 = new SysUserDoctor("Gregory", "House","Dr", "01011910");
        SysUserDoctor dr2 = new SysUserDoctor("Peter", "Venkman","Dr", "01011911");
        SysUserDoctor dr3 = new SysUserDoctor("Egon", "Spengler","Dr", "01011912");
        SysUserDoctor dr4 = new SysUserDoctor("Ray", "Stance","Dr", "01011913");
        SysUserDoctor dr5 = new SysUserDoctor("Winstone", "Zeddermore","Dr", "01011914");
        
       // pat1.addNewAppointment(pat1.getFullName(), new Date(1001001), 99200029, "gregory.house.01011910");
       // pat2.addNewAppointment(pat2.getFullName(), new Date(1991001), 99449595, "peter.venkman.01011911");
       // pat3.addNewAppointment(pat3.getFullName(), new Date(9022992), 67578584, "egon.spengler.01011912");
        //pat4.addNewAppointment(pat4.getFullName(), new Date(45563667), 33883883, "ray.stance.01011913");
       // pat5.addNewAppointment(pat5.getFullName(), new Date(33938837), 27728872, "winstone.zeddermore.01011914");
        
        //assertEquals("hello", pat1.getAppointment("Appointment1")); needs looking at
    }
    
   
    
 
            
    
}