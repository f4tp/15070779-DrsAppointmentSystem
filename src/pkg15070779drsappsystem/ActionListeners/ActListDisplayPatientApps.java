
package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsAppointmentComponent;
import pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu;
import pkg15070779drsappsystem.JPanels.JPanelAppsShowAllForPatient;
import static pkg15070779drsappsystem.JPanels.JPanelAppsShowAllForPatient.getInstance;
import pkg15070779drsappsystem.MainClasses.MainPatient;

public class ActListDisplayPatientApps implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent ae) {
        
                
        JPanelAppsShowAllForPatient.clearAppointmentTextArea();
        JPanelAppsShowAllForPatient.updateTextFields();
        
        //loop through the appointment list, retrieve the appointment, set to text then add to JTextArea on panel
        List <String> tempAppKeys= MainPatient.currentPatient.getPatientAppointmentKeys();
        JPanelAppsShowAllForPatient.setClearCombo();
        for (String temp : tempAppKeys){
            JPanelAppsShowAllForPatient.updateAppointmentsTextArea(MainAbsAppointmentComponent.getAppointment(temp).toString());
            JPanelAppsShowAllForPatient.updateComboAppKeys(temp);
        }
        
        
        JFrameSecretaryMenu secMenPointer = JFrameSecretaryMenu.getInstance();
        secMenPointer.setSecSouthBorderString("DispPatientAppointments");

        
    }
    
}
