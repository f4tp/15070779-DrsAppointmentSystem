
package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import pkg15070779drsappsystem.AbstractClasses.MainAbsSystemUserComponent;
import pkg15070779drsappsystem.AbstractClasses.MainAppointmentSchedule;
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
        //List<LocalDateTime> tempListHolder = new ArrayList<>();
        
        //sets the main doctor to the doctor we are working with now, to check their appointments list
        MainDoctor.currentDoctor = (MainDoctor) MainAbsSystemUserComponent.getSystemUserComponent(strDoctor);
   
        
       String formattedTime =  MainAppointmentSchedule.getFormattedDate(strDay, strMonth, strYear, strTime);
       LocalDateTime ldtPotAppDateTime = MainAppointmentSchedule.getConvStringToDateTime(formattedTime);
        //MainDoctor.currentDoctor
        
        //if the Dr selected (which is held in currentDoctor variable) has the date in their appointment
        //instance list, it means the yhave that appointment free... so the patient can have that appointment
        if (MainDoctor.currentDoctor.getDocsAvailableAppointments().contains(ldtPotAppDateTime)){
            System.out.println("found!");
            
            //add the appointment via the patient
            MainPatient.currentPatient.addNewAppointment(ldtPotAppDateTime, strDoctor);
  
            //put the patient back in the right map - updates the existing entry if teh key exists
             MainAbsSystemUserComponent.setPutInMap(MainPatient.currentPatient.getUserName(), MainPatient.currentPatient);
            
            //remove the date object from the Doctors instance list
            MainDoctor.currentDoctor.getDocsAvailableAppointments().remove(ldtPotAppDateTime);
            
            
            //put the doctor back in the right map
            MainAbsSystemUserComponent.setPutInMap(MainDoctor.currentDoctor.getUserName(), MainDoctor.currentDoctor);
            
        }
        else{
            
            JOptionPane.showMessageDialog (null,
                "The selected Doctor doesn't have an available appointment on the selected date / time, please try another date and time",
                "No appointment available",
                JOptionPane.ERROR_MESSAGE);
          
        }
            
        
    }
    
    
    
    
}
