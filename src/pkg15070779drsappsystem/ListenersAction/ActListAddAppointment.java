
package pkg15070779drsappsystem.ListenersAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsSystemUserComponent;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsScheduling;
import pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu;
import static pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu.getInstance;
import pkg15070779drsappsystem.JPanels.JPanelNewAppointment;
import pkg15070779drsappsystem.MainClasses.MainDoctor;
import pkg15070779drsappsystem.MainClasses.MainPatient;




public class ActListAddAppointment implements ActionListener {
    JPanelNewAppointment tempHolder = JPanelNewAppointment.getInstance();
    
    public ActListAddAppointment(){
  
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
 
        String strDoctor = tempHolder.getDoctor();
        String strDay = tempHolder.getDay();
        String strMonth = tempHolder.getMonth();
        String strYear = tempHolder.getYear();
        String strTime= tempHolder.getTime();
        String strSymptoms = tempHolder.getSymptoms();

        
        //sets the main doctor to the doctor we are working with now, to check their appointments list
        MainDoctor.currentDoctor = (MainDoctor) MainAbsSystemUserComponent.getSystemUserComponent(strDoctor);
   
        
       String formattedTime =  MainAbsScheduling.getFormattedDate(strDay, strMonth, strYear, strTime);
       LocalDateTime ldtPotAppDateTime = MainAbsScheduling.getConvStringToDateTime(formattedTime);
        //MainDoctor.currentDoctor
        
        //if the Dr selected (which is held in currentDoctor variable) has the date in their appointment
        //instance list, it means they have that appointment free... so the patient can have that appointment
        if (MainDoctor.currentDoctor.getDocsAvailableAppointments().contains(ldtPotAppDateTime)){
            System.out.println("found!");
            
            //add the appointment via the patient
            MainPatient.currentPatient.addNewAppointment(ldtPotAppDateTime, strDoctor, strSymptoms);
  
            //put the patient back in the right map - updates the existing entry if teh key exists
             MainAbsSystemUserComponent.setPutInMap(MainPatient.currentPatient.getUserName(), MainPatient.currentPatient);
            
            //remove the date object from the Doctors instance list
            MainDoctor.currentDoctor.getDocsAvailableAppointments().remove(ldtPotAppDateTime);
            
            
            //put the doctor back in the right map
            MainAbsSystemUserComponent.setPutInMap(MainDoctor.currentDoctor.getUserName(), MainDoctor.currentDoctor);
            
            
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
            
        
    }
    
    
    
    
}
