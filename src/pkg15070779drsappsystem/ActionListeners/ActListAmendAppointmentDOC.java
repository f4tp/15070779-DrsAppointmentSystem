
package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import pkg15070779drsappsystem.JFrames.JFrameDoctorMenu;
import pkg15070779drsappsystem.JPanels.JPanelAppAmendDocView;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsAppointmentComponent;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsScheduling;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsSystemUserComponent;
import pkg15070779drsappsystem.MainClasses.MainAppointment;
import pkg15070779drsappsystem.MainClasses.MainDoctor;

public class ActListAmendAppointmentDOC implements ActionListener {
 //component variables hold components passe din from previous form(s)
    JComboBox cmbDayIn;
    JComboBox cmbMonthin;
    JComboBox cmbYearIn;
    JComboBox cmbTimeIn;
            
    JLabel patUserNameIn;
    JLabel AppKeyIn;
    JLabel drUserNameIn;
                    
    JLabel attendedIn;
    JLabel cancelledIn;
    JLabel missedIn;
    
    JLabel symptomsIn;
    JTextField DrsCommentsIn;
    
     public ActListAmendAppointmentDOC(JLabel patusername, JLabel appid, JLabel dridin, JComboBox cmbdayin, 
             JComboBox cmbmonthin, JComboBox cmbyearin, JComboBox cmbtimein, JLabel symptomsin, 
             JTextField drscommentsin, JLabel attendedin, JLabel cancelledin, JLabel missedin ){
    this.cmbDayIn = cmbdayin;
        
    this.cmbMonthin = cmbmonthin;
    this.cmbYearIn = cmbyearin;
    this.cmbTimeIn = cmbtimein;
            
   this.patUserNameIn = patusername;
    this.AppKeyIn = appid;
    this.drUserNameIn =dridin;
    
    this.symptomsIn = symptomsin;
    this.DrsCommentsIn = drscommentsin;
                    
    this.attendedIn =attendedin;
    this.cancelledIn = cancelledin;
    this.missedIn = missedin;
        System.out.println("I am here" + cmbdayin.getSelectedItem());
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        //these are the objects that are needed to interact with an appointment when changing it
        //only the Doctor and appointment will need updating
        MainAppointment currentAppointmentInst = MainAbsAppointmentComponent.getAppointment(AppKeyIn.getText());
       // MainDoctor currentDoctorInst = (MainDoctor) MainAbsSystemUserComponent.getSystemUserComponent(drUserNameIn.getText());
        //MainPatient currentPatientInst;
        
           //get the date and time of original appointment as a LDT object
      // LocalDateTime currentDateTimeOfInst = currentAppointmentInst.getAPPDateAndTime();
       //get the date and time of the proposed appointment as a LDT object - if it needs to change
       // LocalDateTime newDateTimeOfApp = MainAbsScheduling.getConvStringToDateTime(cmbDayIn.getSelectedItem().toString() + cmbMonthin.getSelectedItem().toString() +cmbYearIn.getSelectedItem().toString() + cmbTimeIn.getSelectedItem().toString());
     
        
        JPanelAppAmendDocView amendAppFormInst = JPanelAppAmendDocView.getInstance();
        
        //if false, just display a message saying no updates found:
        if (amendAppFormInst.getFormUpdatedNotDateTime() == false){
            JOptionPane.showMessageDialog (null,
                "The form hasn't been updated. Please press 'Back' or make the changes to the appointment",
                "No Changes Made",
                JOptionPane.ERROR_MESSAGE);
        }
        
        else{
         
                    currentAppointmentInst.setDrsComments(DrsCommentsIn.getText());

                  //put the appointment back in the map
                   // MainAbsAppointmentComponent.setPutInMap(AppKeyIn.getText(), currentAppointmentInst);

                           //output message to tell you that the appointment has been updated
                callPromptAppupdated();
                 //go back to patient record screen
                JFrameDoctorMenu DocMenuRef = JFrameDoctorMenu.getInstance();
                DocMenuRef.setDocSouthBorderString("DisplayPatientDetails");
                
                 amendAppFormInst.setFormUpdatedNotDateTime(false);

                }
        


    }
    
    private void callPromptAppupdated(){
        JOptionPane.showMessageDialog (null,
                "The appointment has been successfully updated",
                "Appointment Amended",
                JOptionPane.ERROR_MESSAGE);
    }
    
}
