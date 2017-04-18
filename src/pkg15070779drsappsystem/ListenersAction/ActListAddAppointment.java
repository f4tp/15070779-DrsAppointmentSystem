
package pkg15070779drsappsystem.ListenersAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import pkg15070779drsappsystem.MainAbstractClasses.SystemUserComponent;
import pkg15070779drsappsystem.MainAbstractClasses.SchedulingAbstract;
import pkg15070779drsappsystem.JPanels.JPanelNewAppointment;
import pkg15070779drsappsystem.MainClasses.SysUserDoctor;
import pkg15070779drsappsystem.MainClasses.SysUserPatient;




public class ActListAddAppointment implements ActionListener {
    //this JPanel will have all the details of teh new appointment on there already
    JPanelNewAppointment tempHolder = JPanelNewAppointment.getInstance();
    
    public ActListAddAppointment(){
  
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
 //when the action listener is fired, the date is set - ready to create the appointment
        String strDoctor = tempHolder.getDoctor();
        String strDay = tempHolder.getDay();
        String strMonth = tempHolder.getMonth();
        String strYear = tempHolder.getYear();
        String strTime= tempHolder.getTime();
        String strSymptoms = tempHolder.getSymptoms();

        //object composition, to ensure the right dr and patient are set
       //sets the main doctor to the doctor we are working with now, to check their appointments list
       SysUserDoctor.currentDoctor = (SysUserDoctor) SystemUserComponent.getSystemUserComponent(strDoctor);
       SysUserDoctor currentDoctorInst = SysUserDoctor.currentDoctor;
       
       //sets the main patient 
       SysUserPatient currentPatientInst = SysUserPatient.currentPatient;
        
       //sets the potential appointment time to check in the main class
         LocalDateTime ldtPotAppDateTime = SchedulingAbstract.getConvStringToDateTime(SchedulingAbstract.getFormattedDate(strDay, strMonth, strYear, strTime));
        //MainDoctor.currentDoctor
        
        //calls the setAddNewAppToPatient routine
        currentPatientInst.setAddNewAppToPatient(ldtPotAppDateTime, currentDoctorInst, currentPatientInst, strSymptoms);
     
    }
    
    
    
    
}
