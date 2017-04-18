package pkg15070779drsappsystem;

import pkg15070779drsappsystem.MainClasses.SysUserPatient;
import org.junit.Test;
import static org.junit.Assert.*;
import pkg15070779drsappsystem.MainAbstractClasses.AppointmentComponent;
import pkg15070779drsappsystem.MainAbstractClasses.SchedulingAbstract;
import pkg15070779drsappsystem.MainAbstractClasses.SystemUserComponent;
import pkg15070779drsappsystem.MainClasses.Appointment;
import pkg15070779drsappsystem.MainClasses.SysUserDoctor;


public class MainPatientTest {
                
   //method not complete
    @Test
    public void testAddDrRegsWith(){
        //pat1.addDrKeyRegsWith("peter.venkman.1912");
        //String datatoTest = pat1.getDrsRegWithAsStringAsUserNames();
        //assertEquals(true, datatoTest.contains("peter.venkman.1912"));
        
       
    } 
           
    @Test
    public void testAddNewAppointment(){
             SysUserPatient pat1 = new SysUserPatient("Mr", "Alan", "Turing", "01011900", "01234 567 890", "gregory.house.01011910");
    }

    
    
   
    
    @Test
    public void testgetUserName(){
    SysUserPatient pat1 = new SysUserPatient("Mr", "Alan", "Turing", "01011901", "01234 567 890", "gregory.house.01011910");
    assertEquals("alan.turing.01011901", pat1.getUserName()); 
    }
    
    //method not complete
    @Test
    public void testGetDrsRegWithAsStringAsUserNames(){
        SysUserPatient pat1 = new SysUserPatient("Mr", "Alan", "Turing", "01011900", "01234 567 890", "gregory.house.01011910");
        assertEquals("gregory.house.01011910", pat1.getDrsRegWithAsStringAsDrsnames());      
        SysUserDoctor dr2 = new SysUserDoctor("Peter", "Venkman","Dr", "01011911");
        pat1.addDrKeyRegsWith(dr2.getUserName(), pat1.getUserName());
        assertEquals("gregory.house.01011910, peter.venkman.01011911", pat1.getDrsRegWithAsStringAsDrsnames());
    } 
 
    
    
    @Test
    public void testGetCheckPatHasApp(){
        SysUserPatient pat1 = new SysUserPatient("Mr", "Alan", "Turing", "01011901", "01234 567 890", "gregory.house.01011910");
        assertEquals(true, pat1.getCheckPatHasApp());
     
    }
            
    
}
