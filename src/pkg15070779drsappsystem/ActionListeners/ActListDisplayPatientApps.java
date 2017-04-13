
package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsAppointmentComponent;
import pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu;
import pkg15070779drsappsystem.JPanels.JPanelAppsShowAllForPatient;
import static pkg15070779drsappsystem.JPanels.JPanelAppsShowAllForPatient.getInstance;
import pkg15070779drsappsystem.MainClasses.MainAppointment;
import pkg15070779drsappsystem.MainClasses.MainPatient;

public class ActListDisplayPatientApps implements ActionListener{

    
    //shows appointments for a particular patient, updates a combo box on the form
    @Override
    public void actionPerformed(ActionEvent ae) {
        
         if (MainPatient.currentPatient.getAppointmentExist() == true){
                JOptionPane.showMessageDialog (null,
                "The patient has no appointments yet.",
                "No appointment on file",
                JOptionPane.ERROR_MESSAGE);
         }
         
         else {
             

                JPanelAppsShowAllForPatient.clearAppointmentTextArea();
                JPanelAppsShowAllForPatient.updateLabelTitleForShowPatApps();

                //loop through the appointment list, retrieve the appointment, set to text then add to JTextArea on panel
                List <String> tempAppKeys= MainPatient.currentPatient.getPatientAppointmentKeys();
                JPanelAppsShowAllForPatient.setClearCombo();
                for (String temp : tempAppKeys){
                    JPanelAppsShowAllForPatient.updateAppointmentsTextArea(MainAbsAppointmentComponent.getAppointment(temp).toString());
                    
                    //if the appointment also has a prescription issued, print this to screen also, or pritn no prescription for this app
                    JPanelAppsShowAllForPatient.updateAppointmentsTextArea(MainAbsAppointmentComponent.getAppointment(temp).getPrescriptionID());
                    
                    
                    
                    JPanelAppsShowAllForPatient.updateComboAppKeys(temp);
                }


                JFrameSecretaryMenu secMenPointer = JFrameSecretaryMenu.getInstance();
                secMenPointer.setSecSouthBorderString("DispPatientAppointments");
         }
        
    }
    
}
