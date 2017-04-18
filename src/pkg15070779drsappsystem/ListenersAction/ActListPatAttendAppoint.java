
package pkg15070779drsappsystem.ListenersAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import pkg15070779drsappsystem.MainAbstractClasses.AppointmentComponent;
import pkg15070779drsappsystem.MainAbstractClasses.SchedulingAbstract;
import pkg15070779drsappsystem.MainClasses.Appointment;
import pkg15070779drsappsystem.MainClasses.SysUserPatient;

public class ActListPatAttendAppoint implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        //holds current date to check if the current system user / current SysUserPatient has an appointment today
        LocalDateTime currentDate = SchedulingAbstract.getDateToday();
        
        //holds the keys of all of the current system users appointments
        List <String> tempAppKeys= SysUserPatient.currentPatient.getPatientAppKeysAsList();
        
        
        //holds the appointments that have have been resolved using the keys
        List <Appointment> allAppoints = new ArrayList<>();

        //loop through the current patient's appointment list and for each string in their resolve the appointment into a temporary list
        
        for (String temp : tempAppKeys ){
                   allAppoints.add(AppointmentComponent.getAppointment(temp));
        }
        
        
        //see if the temporary list contains an appointment on todays date, if it does - mark the attended as true
            
        //if it doesn't, display a message sayign they don;t have an appointment today, and detail all appointments marked as not attended
        
        Boolean appFound = false;
        for (Appointment temp : allAppoints ){
           //if they have an appointment on the same day they have arrived in the Doctors and logged into the system        
            if (temp.getAPPDateAndTime().getDayOfMonth() == currentDate.getDayOfMonth() && 
                temp.getAPPDateAndTime().getMonth()== currentDate.getMonth() &&
                    temp.getAPPDateAndTime().getYear() == currentDate.getYear()){

                //get the key of the appointment that is on the day
                //get the appointment out of the map using the key
                Appointment.currentAppointment = temp;
                
                //setthe appointment to attended
                
                Appointment.currentAppointment.setAppAttendPatientResponse();
                 //put the Appointment objetc back in the map
                AppointmentComponent.setPutInMap(Appointment.currentAppointment.getAppUniqueKey(), Appointment.currentAppointment);
                
                appFound = true;
            }
            
            
        }
        
        if (appFound == false) {
                JOptionPane.showMessageDialog (null,
                "There does not seem to be an appointment on the system for you today. Please see the receptionist for help",
                "Appointment not on the system",
                JOptionPane.ERROR_MESSAGE);
            }
   

    }
    
}
