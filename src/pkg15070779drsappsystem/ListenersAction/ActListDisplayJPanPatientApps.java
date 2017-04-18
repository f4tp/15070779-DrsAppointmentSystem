
package pkg15070779drsappsystem.ListenersAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import pkg15070779drsappsystem.JFrames.JFrameDoctorMenu;
import pkg15070779drsappsystem.MainAbstractClasses.AppointmentComponent;
import pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu;
import pkg15070779drsappsystem.JPanels.JPanelAppsShowAllForPatientDOC;
import pkg15070779drsappsystem.JPanels.JPanelAppsShowAllForPatientSEC;
import pkg15070779drsappsystem.MainClasses.SysUserPatient;

public class ActListDisplayJPanPatientApps implements ActionListener{
    SysUserPatient currPatInst;
    String calledFrom;
    public ActListDisplayJPanPatientApps(String calledfrom){
        //currPatInst = (SysUserPatient) MainAbsSystemUserComponent.getSystemUserComponent(userid);
        this.calledFrom = calledfrom;
    }

    
    //shows appointments for a particular patient, updates a combo box on the form
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (this.calledFrom =="Sec"){
                 if (SysUserPatient.currentPatient.getCheckPatHasApp() == true){
                       JOptionPane.showMessageDialog (null,
                       "The patient has no appointments yet.",
                       "No appointment on file",
                       JOptionPane.ERROR_MESSAGE);
                }

                else {


                       JPanelAppsShowAllForPatientSEC.clearAppointmentTextArea();
                       JPanelAppsShowAllForPatientSEC.updateLabelTitleForShowPatApps();

                       //loop through the appointment list, retrieve the appointment, set to text then add to JTextArea on panel
                       List <String> tempAppKeys= SysUserPatient.currentPatient.getPatientAppKeysAsList();
                       JPanelAppsShowAllForPatientSEC.setClearCombo();
                       for (String temp : tempAppKeys){
                           JPanelAppsShowAllForPatientSEC.updateAppointmentsTextArea(AppointmentComponent.getAppointment(temp).toString());

                           //if the appointment also has a prescription issued, print this to screen also, or pritn no prescription for this app
                           JPanelAppsShowAllForPatientSEC.updateAppointmentsTextArea(AppointmentComponent.getAppointment(temp).getAllPresDetailsForAppAsString());



                           JPanelAppsShowAllForPatientSEC.updateComboAppKeys(temp);
                       }


                       JFrameSecretaryMenu secMenPointer = JFrameSecretaryMenu.getInstance();
                       secMenPointer.setSecNorthBorderString("DispPatientAppointments");
                }

        } 
        
        else if (this.calledFrom == "Doc"){
            
                if (SysUserPatient.currentPatient.getCheckPatHasApp() == true){
                       JOptionPane.showMessageDialog (null,
                       "The patient has no appointments yet.",
                       "No appointment on file",
                       JOptionPane.ERROR_MESSAGE);
                }

                else {


                       JPanelAppsShowAllForPatientDOC.clearAppointmentTextArea();
                       JPanelAppsShowAllForPatientDOC.updateLabelTitleForShowPatApps();

                       //loop through the appointment list, retrieve the appointment, set to text then add to JTextArea on panel
                       List <String> tempAppKeys= SysUserPatient.currentPatient.getPatientAppKeysAsList();
                       JPanelAppsShowAllForPatientDOC.setClearCombo();
                       for (String temp : tempAppKeys){
                           JPanelAppsShowAllForPatientDOC.updateAppointmentsTextArea(AppointmentComponent.getAppointment(temp).toString());

                           //if the appointment also has a prescription issued, print this to screen also, or pritn no prescription for this app
                           JPanelAppsShowAllForPatientDOC.updateAppointmentsTextArea(AppointmentComponent.getAppointment(temp).getAllPresDetailsForAppAsString());



                           JPanelAppsShowAllForPatientDOC.updateComboAppKeys(temp);
                       }


                       JFrameDoctorMenu docMenPointer = JFrameDoctorMenu.getInstance();
                       docMenPointer.setDocSouthBorderString("DispPatientAppointments", SysUserPatient.currentPatient);
                }

            
        }
    
     
    }
    
}
