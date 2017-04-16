
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
        /*
        //if the Dr selected (which is held in currentDoctor variable) has the date in their appointment
        //instance list, it means they have that appointment free... so the patient can have that appointment
        if (currentDoctorInst.getDocsAvailableAppointments().contains(ldtPotAppDateTime)){

            //add the appointment via the patient
            currentPatientInst.addNewAppointment(ldtPotAppDateTime, strDoctor, strSymptoms);
  
            //put the patient back in the right map - updates the existing entry if teh key exists
             MainAbsSystemUserComponent.setPutInMap(currentPatientInst.getUserName(), currentPatientInst);
            
            //remove the date object from the Doctors instance list
            currentDoctorInst.getDocsAvailableAppointments().remove(ldtPotAppDateTime);
            
            
            //put the doctor back in the right map
            MainAbsSystemUserComponent.setPutInMap(currentDoctorInst.getUserName(), MainDoctor.currentDoctor);
            
            
            JOptionPane.showMessageDialog (null,
                "The appointment has been added for: " +ldtPotAppDateTime.toString() ,
                "No appointment available",
                JOptionPane.ERROR_MESSAGE);
            
            JFrameSecretaryMenu instHolder = getInstance();
            instHolder.setSecSouthBorderString("DisplayPatientDetails");
     
            
            
        }
        else if (ldtPotAppDateTime.getDayOfWeek() == DayOfWeek.SATURDAY|| ldtPotAppDateTime.getDayOfWeek() == DayOfWeek.SUNDAY){
            JOptionPane.showMessageDialog (null,
                "The selected date is either on a Saturday or Sunday, please select another date",
                "No appointment available",
                JOptionPane.ERROR_MESSAGE);
        }
        
        else{
            
            JOptionPane.showMessageDialog (null,
                "This Doctor doesn't have an  appointment available on the selected date / time, please try another date / time",
                "No appointment available",
                JOptionPane.ERROR_MESSAGE);
          
        }
            */
        
    }
    
    
    
    
}
