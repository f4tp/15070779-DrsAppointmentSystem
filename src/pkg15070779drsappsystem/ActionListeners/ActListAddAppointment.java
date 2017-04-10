
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
        List<LocalDateTime> tempListHolder = new ArrayList<>();
        
        //sets the main doctor to the doctor we are working with now
        MainDoctor.currentDoctor = (MainDoctor) MainAbsSystemUserComponent.getSystemUserComponent(strDoctor);
        
        //list now holds available appointments
        tempListHolder = MainDoctor.currentDoctor.getDocsAvailableAppointments();
        
       String formattedTime =  MainAppointmentSchedule.getFormattedDate(strDay, strMonth, strYear, strTime);
       LocalDateTime ldtPotAppDateTime = MainAppointmentSchedule.getConvStringToDateTime(formattedTime);
        //MainDoctor.currentDoctor
                
        if (tempListHolder.contains(ldtPotAppDateTime)){
            JOptionPane.showMessageDialog (null,
                "available",
                "available",
                JOptionPane.ERROR_MESSAGE);
        }
        else{
            
            JOptionPane.showMessageDialog (null,
                "The selected Doctor doesn't have an available appointment on the selected date / time, please try another date and time",
                "No appointment available",
                JOptionPane.ERROR_MESSAGE);
          
        }
            
        
    }
    
    
    
    
}
