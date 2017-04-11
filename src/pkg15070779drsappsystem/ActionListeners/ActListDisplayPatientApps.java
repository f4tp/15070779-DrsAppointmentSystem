
package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import pkg15070779drsappsystem.AbstractClasses.MainAbsAppointmentComponent;
import pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu;
import pkg15070779drsappsystem.JPanels.JPanelAppsViewAllAvailable;
import pkg15070779drsappsystem.MainClasses.MainPatient;

public class ActListDisplayPatientApps implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent ae) {
        
                
        JPanelAppsViewAllAvailable.clearAppointmentTextArea();
        JPanelAppsViewAllAvailable.updateTextFields();
        
        //loop through the appointment list, retrieve the appointment, set to text then add to JTextArea on panel
        List <String> tempAppKeys= MainPatient.currentPatient.getPatientAppointmentKeys();
        for (String temp : tempAppKeys){
            JPanelAppsViewAllAvailable.updateAppointmentsTextArea(MainAbsAppointmentComponent.getAppointment(temp).toString());
        }
        
        
        JFrameSecretaryMenu secMenPointer = JFrameSecretaryMenu.getInstance();
        secMenPointer.setSecSouthBorderString("DispPatientAppointments");
       
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        
        
        
        
    }
    
}
