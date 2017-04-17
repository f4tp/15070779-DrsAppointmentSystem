
package pkg15070779drsappsystem.ListenersAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsSystemUserComponent;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsScheduling;
import pkg15070779drsappsystem.JPanels.JPanelNewAppointment;
import pkg15070779drsappsystem.MainClasses.MainDoctor;
import pkg15070779drsappsystem.MainClasses.MainPatient;




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
       MainDoctor.currentDoctor = (MainDoctor) MainAbsSystemUserComponent.getSystemUserComponent(strDoctor);
       MainDoctor currentDoctorInst = MainDoctor.currentDoctor;
       
       //sets the main patient 
       MainPatient currentPatientInst = MainPatient.currentPatient;
        
       //sets the potential appointment time to check in the main class
         LocalDateTime ldtPotAppDateTime = MainAbsScheduling.getConvStringToDateTime(MainAbsScheduling.getFormattedDate(strDay, strMonth, strYear, strTime));
        //MainDoctor.currentDoctor
        
        //calls the setAddNewAppToPatient routine
        currentPatientInst.setAddNewAppToPatient(ldtPotAppDateTime, currentDoctorInst, currentPatientInst, strSymptoms);
     
    }
    
    
    
    
}
