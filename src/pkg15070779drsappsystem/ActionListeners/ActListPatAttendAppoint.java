
package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import pkg15070779drsappsystem.AbstractClasses.MainAbsAppointmentComponent;
import pkg15070779drsappsystem.AbstractClasses.MainAbsScheduling;
import pkg15070779drsappsystem.MainClasses.MainAppointment;
import pkg15070779drsappsystem.MainClasses.MainPatient;

public class ActListPatAttendAppoint implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        //holds current date to check if the current system user / current Patient has an appointment today
        LocalDateTime currentDate = MainAbsScheduling.getDateToday();
        
        //holds the keys of all of the current system users appointments
        List <String> tempAppKeys= MainPatient.currentPatient.getPatientAppointmentKeys();
        
        
        //holds the appointments that have have been resolved using the keys
        List <MainAppointment> allAppoints = new ArrayList<>();

        //loop through the current patient's appointment list and for each string in their resolve the appointment into a temnporary list
        
        for (String temp : tempAppKeys ){
                   allAppoints.add(MainAbsAppointmentComponent.getAppointment(temp));
        }
        
        
        //see if the temporary list contains an appointment on todays date, if it does - mark the attended as true
            
        //if it doesn't, display a message sayign they don;t have an appointment today, and detail all appointments marked as not attended
        
        for (MainAppointment temp : allAppoints ){
           //if they have an appointment on the same day they have arrived in the Doctors and logged into the system        
            if (temp.getAPPDateAndTime().getDayOfMonth() == currentDate.getDayOfMonth() && 
                temp.getAPPDateAndTime().getMonth()== currentDate.getMonth() &&
                    temp.getAPPDateAndTime().getYear() == currentDate.getYear()){

                //get the key of the appointment that is on the day
                //get the appointment out of the map using the key
                MainAppointment.currentAppointment = temp;
                
                //setthe appointment to attended
                
                MainAppointment.currentAppointment.setAppAttend();
                 //put the MainAppointment objetc back in the map
                MainAbsAppointmentComponent.setPutInMap(MainAppointment.currentAppointment.getAppUniqueKey(), MainAppointment.currentAppointment);
                
            }
            
            else {
                JOptionPane.showMessageDialog (null,
                "There does not seem to be an appointment on the system for you today. Please see the receptionist for help",
                "Appointment not on the system",
                JOptionPane.ERROR_MESSAGE);
            }
        }
   

    }
    
}
