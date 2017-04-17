
package pkg15070779drsappsystem.ListenersAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import pkg15070779drsappsystem.JFrames.JFrameDoctorMenu;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsAppointmentComponent;
import pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu;
import pkg15070779drsappsystem.JPanels.JPanelAppsShowAllForPatientDOC;
import pkg15070779drsappsystem.JPanels.JPanelAppsShowAllForPatientSEC;
import static pkg15070779drsappsystem.JPanels.JPanelAppsShowAllForPatientSEC.getInstance;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsSystemUserComponent;
import pkg15070779drsappsystem.MainClasses.MainAppointment;
import pkg15070779drsappsystem.MainClasses.MainPatient;

public class ActListDisplayJPanPatientApps implements ActionListener{
    MainPatient currPatInst;
    String calledFrom;
    public ActListDisplayJPanPatientApps(String calledfrom){
        //currPatInst = (MainPatient) MainAbsSystemUserComponent.getSystemUserComponent(userid);
        this.calledFrom = calledfrom;
    }

    
    //shows appointments for a particular patient, updates a combo box on the form
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (this.calledFrom =="Sec"){
                 if (MainPatient.currentPatient.getAppointmentExist() == true){
                       JOptionPane.showMessageDialog (null,
                       "The patient has no appointments yet.",
                       "No appointment on file",
                       JOptionPane.ERROR_MESSAGE);
                }

                else {


                       JPanelAppsShowAllForPatientSEC.clearAppointmentTextArea();
                       JPanelAppsShowAllForPatientSEC.updateLabelTitleForShowPatApps();

                       //loop through the appointment list, retrieve the appointment, set to text then add to JTextArea on panel
                       List <String> tempAppKeys= MainPatient.currentPatient.getPatientAppointmentKeys();
                       JPanelAppsShowAllForPatientSEC.setClearCombo();
                       for (String temp : tempAppKeys){
                           JPanelAppsShowAllForPatientSEC.updateAppointmentsTextArea(MainAbsAppointmentComponent.getAppointment(temp).toString());

                           //if the appointment also has a prescription issued, print this to screen also, or pritn no prescription for this app
                           JPanelAppsShowAllForPatientSEC.updateAppointmentsTextArea(MainAbsAppointmentComponent.getAppointment(temp).getAllPresDetailsForAppAsString());



                           JPanelAppsShowAllForPatientSEC.updateComboAppKeys(temp);
                       }


                       JFrameSecretaryMenu secMenPointer = JFrameSecretaryMenu.getInstance();
                       secMenPointer.setSecNorthBorderString("DispPatientAppointments");
                }

        } 
        
        else if (this.calledFrom == "Doc"){
            
                if (MainPatient.currentPatient.getAppointmentExist() == true){
                       JOptionPane.showMessageDialog (null,
                       "The patient has no appointments yet.",
                       "No appointment on file",
                       JOptionPane.ERROR_MESSAGE);
                }

                else {


                       JPanelAppsShowAllForPatientDOC.clearAppointmentTextArea();
                       JPanelAppsShowAllForPatientDOC.updateLabelTitleForShowPatApps();

                       //loop through the appointment list, retrieve the appointment, set to text then add to JTextArea on panel
                       List <String> tempAppKeys= MainPatient.currentPatient.getPatientAppointmentKeys();
                       JPanelAppsShowAllForPatientDOC.setClearCombo();
                       for (String temp : tempAppKeys){
                           JPanelAppsShowAllForPatientDOC.updateAppointmentsTextArea(MainAbsAppointmentComponent.getAppointment(temp).toString());

                           //if the appointment also has a prescription issued, print this to screen also, or pritn no prescription for this app
                           JPanelAppsShowAllForPatientDOC.updateAppointmentsTextArea(MainAbsAppointmentComponent.getAppointment(temp).getAllPresDetailsForAppAsString());



                           JPanelAppsShowAllForPatientDOC.updateComboAppKeys(temp);
                       }


                       JFrameDoctorMenu docMenPointer = JFrameDoctorMenu.getInstance();
                       docMenPointer.setDocSouthBorderString("DispPatientAppointments", MainPatient.currentPatient);
                }

            
        }
    
     
    }
    
}
