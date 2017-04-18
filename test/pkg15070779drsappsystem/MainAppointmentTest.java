
package pkg15070779drsappsystem;
import java.time.LocalDateTime;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import pkg15070779drsappsystem.MainAbstractClasses.AppointmentComponent;
import pkg15070779drsappsystem.MainAbstractClasses.SystemUserComponent;
import pkg15070779drsappsystem.MainClasses.Appointment;
import pkg15070779drsappsystem.MainClasses.SysUserDoctor;
import pkg15070779drsappsystem.MainClasses.SysUserPatient;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import pkg15070779drsappsystem.MainAbstractClasses.SchedulingAbstract;



public class MainAppointmentTest {
   /* 
   @Test
   public void testAddAppointmentToDrsList(){
       SysUserDoctor docInst1 = (SysUserDoctor) SystemUserComponent.getSystemUserComponent("gregory.house.01011910");
       SysUserDoctor.currentDoctor = docInst1;
       
       LocalDateTime current = SchedulingAbstract.getDateToday();
       SysUserPatient patcurrInst1 = (SysUserPatient) SystemUserComponent.getSystemUserComponent("alan.turing.01011900");
       SysUserPatient.setCurrentSystemUser(patcurrInst1.getUserName());
       
       Appointment currentAppInst = AppointmentComponent.getAppointment("Appointment3");
       Appointment.currentAppointment = currentAppInst;
       
       currentAppInst.addAppointmentToDrsList(docInst1.getUserName(), current, "Appointment3");
       List <LocalDateTime> list1 = docInst1.getDocsAvailableAppointments();
       List <LocalDateTime> list2 = docInst1.getDocsAvailableAppointments();
       
       assertNotNull("should not be null", list1);
       
   }
*/
    
    /*
   @Test
   public void testgetHasPrescBeenGenerated(){
      SysUserDoctor docInst1 = (SysUserDoctor) SystemUserComponent.getSystemUserComponent("gregory.house.01011910");
       SysUserDoctor.currentDoctor = docInst1;
       
       
  
       SysUserPatient patcurrInst1 = (SysUserPatient) SystemUserComponent.getSystemUserComponent("alan.turing.01011900");
       SysUserPatient.setCurrentSystemUser(patcurrInst1.getUserName());
       
       SysUserPatient pat1 = new SysUserPatient("Mr", "Alan", "Turing", "01011900", "01234 567 890", "gregory.house.01011910");
       // SysUserDoctor dr1 = new SysUserDoctor("Gregory", "House","Dr", "01011910");
        pat1.addNewAppointment(SchedulingAbstract.getConvStringToDateTime("20Apr20171445"), "gregory.house.01011910", "sore back");
        Appointment currentAppInst = AppointmentComponent.getAppointment("Appointment50");
        Appointment.currentAppointment = currentAppInst;
       
       
       assertEquals(false, currentAppInst.getHasPrescBeenGenerated());
   }
    */
    
    
    
    
    @Test
    public void testSetCreateAppointment(){
    
    }
    
    @Test
    public void testSetAppAttend(){
        
    }
    
    @Test
    public void testSetAppCancelled(){
       
    }
    /*
    @Test
    public void testGetAppCancelled(){
       SysUserPatient patcurrInst1 = (SysUserPatient) SystemUserComponent.getSystemUserComponent("alan.turing.01011900");
       SysUserPatient.setCurrentSystemUser(patcurrInst1.getUserName());
       
       SysUserPatient pat1 = new SysUserPatient("Mr", "Alan", "Turing", "01011900", "01234 567 890", "gregory.house.01011910");
        SysUserDoctor dr1 = new SysUserDoctor("Gregory", "House","Dr", "01011910");
        pat1.addNewAppointment(SchedulingAbstract.getConvStringToDateTime("20Apr20171445"), "gregory.house.01011910", "sore back");
        Appointment currentAppInst = AppointmentComponent.getAppointment("Appointment1");
        Appointment.currentAppointment = currentAppInst;
       
       
       assertEquals(false, currentAppInst.getCancelled());
    }
*/
    
    @Test
    public void testGetAppointment(){
        
    }
    
     @Test
    public void testGetAppUniqueKey(){
        
    }
    
}
