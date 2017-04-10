
package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Date;
import pkg15070779drsappsystem.AbstractClasses.MainAppointmentSchedule;

public class ActListPatAttendAppoint implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        LocalDateTime currentDate = MainAppointmentSchedule.getDateToday();
        
       // LocalDateTime appointmentDate = new Date(); //@@@@@ CHANGE ME!!! to the appointment date of the person logged in
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
