
package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu;
import pkg15070779drsappsystem.JPanels.JPanelAppAmendSecView;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsAppointmentComponent;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsScheduling;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsSystemUserComponent;
import pkg15070779drsappsystem.MainClasses.MainAppointment;
import pkg15070779drsappsystem.MainClasses.MainDoctor;
import pkg15070779drsappsystem.MainClasses.MainPatient;

public class ActListAmendAppointment implements ActionListener {
    
    //component variables hold components passe din from previous form(s)
    JComboBox cmbDayIn;
    JComboBox cmbMonthin;
    JComboBox cmbYearIn;
    JComboBox cmbTimeIn;
            
    JLabel patUserNameIn;
    JLabel AppKeyIn;
    JLabel drUserNameIn;
                    
    JCheckBox attendedIn;
    JCheckBox cancelledIn;
    JCheckBox missedIn;
    
    JTextField symptomsIn;
    public ActListAmendAppointment(JLabel patusername, JLabel appid, JLabel dridin, JComboBox cmbdayin, JComboBox cmbmonthin, JComboBox cmbyearin, JComboBox cmbtimein, JTextField symptomsin, JCheckBox attendedin, JCheckBox cancelledin, JCheckBox missedin ){
    this.cmbDayIn = cmbdayin;
        
    this.cmbMonthin = cmbmonthin;
    this.cmbYearIn = cmbyearin;
    this.cmbTimeIn = cmbtimein;
            
   this.patUserNameIn = patusername;
    this.AppKeyIn = appid;
    this.drUserNameIn =dridin;
    
    this.symptomsIn = symptomsin;
                    
    this.attendedIn =attendedin;
    this.cancelledIn = cancelledin;
    this.missedIn = missedin;
        System.out.println("I am here" + cmbdayin.getSelectedItem());
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //these are the objects that are needed to interact with an appointment when changing it
        //only the Doctor and appointment will need updating
        MainAppointment currentAppointmentInst;
        MainDoctor currentDoctorInst;
        MainPatient currentPatientInst;
        
        
        System.out.println("woo hoo" + cmbDayIn.getSelectedItem());
        System.out.println("woo hoohhh" + cmbTimeIn.getSelectedItem());
        JPanelAppAmendSecView amendAppFormInst = JPanelAppAmendSecView.getInstance();
        
        
        //if false, just display a message sayign no updates found:
        if (amendAppFormInst.getFormUpdatedNotDateTime() == false && amendAppFormInst.getFormUpdatedDateTime() == false
                && amendAppFormInst.getFormUpdatedNotDateTimeButAppAndDoc() == false){
            JOptionPane.showMessageDialog (null,
                "The form hasn't been updated. Please press 'Back' or make the changes to the appointment",
                "No Changes Made",
                JOptionPane.ERROR_MESSAGE);
        }
        
        //if the form has been altered in any way, one of two variables will be set at true. One involves teh date and time being 
        //interacted with which means more objects are involved and is more complicated. One involves just the appointment
        //object being interacted with
        
        //program needs updating because somethign on the form other than the date and time has been updated
        //this means only the appointment needs updating
        if (amendAppFormInst.getFormUpdatedNotDateTime() == true){
            //get the appointment, patient and doctor out of the map
            //lazy instantiation
            currentAppointmentInst= MainAbsAppointmentComponent.getAppointment(AppKeyIn.getText());
            
             //set appointment attended status
            currentAppointmentInst.setAppAttendSec(attendedIn.isSelected());
                     
            //set appointment missed status
            currentAppointmentInst.setAppMissed(missedIn.isSelected());
            //set any new symptoms
            currentAppointmentInst.setSymptoms(symptomsIn.getText());
        
          //put the appointment back in the map
           // MainAbsAppointmentComponent.setPutInMap(AppKeyIn.getText(), currentAppointmentInst);
           
           callPromptAppupdated();
           
           //NTDgo back to patient record screen
                     JFrameSecretaryMenu SecMenuRef = JFrameSecretaryMenu.getInstance();
                    SecMenuRef.setSecSouthBorderString("DisplayPatientDetails");

        }
        
        
        
        //this means the app has been cancelled, it needs to be marked as cancelled, and the doctor's schdule lists
        //need updating (the appointment time taking out of theri taken list, and putting back in the available
        //list
        if(amendAppFormInst.getFormUpdatedNotDateTimeButAppAndDoc() == true){
            
            //lazy instantiation
            currentAppointmentInst= MainAbsAppointmentComponent.getAppointment(AppKeyIn.getText());
            currentDoctorInst  = (MainDoctor) MainAbsSystemUserComponent.getSystemUserComponent(drUserNameIn.getText());
            //currentPatientInst = (MainPatient) MainAbsSystemUserComponent.getSystemUserComponent(patUserNameIn.getText());
         
              //set appointment cancelled status
            currentAppointmentInst.setAppCancelled(cancelledIn.isSelected());
            
            //get the date and time of appointment as an object
            LocalDateTime currentDateTimeOfInst = currentAppointmentInst.getAPPDateAndTime();
            
            //remove the appointment time from the doctors appointment time staken list
            currentDoctorInst.setRemoveLDTFromAppTimesTakenList(currentDateTimeOfInst);
            
            //add the appointment time to the doctors appointments available list
            currentDoctorInst.setAddLDTToAppTimesAvailableList(currentDateTimeOfInst);
   
            //*appointment still stays on file so no further action
     
        }
        //this means that the date and time has changed, it is amore complicated routine involving more objects
        if(amendAppFormInst.getFormUpdatedDateTime() == true){
             //lazy instantiation
            currentAppointmentInst= MainAbsAppointmentComponent.getAppointment(AppKeyIn.getText());
            currentDoctorInst  = (MainDoctor) MainAbsSystemUserComponent.getSystemUserComponent(drUserNameIn.getText());
            
            
            //get the date and time of original appointment as a LDT object
            LocalDateTime currentDateTimeOfInst = currentAppointmentInst.getAPPDateAndTime();
            
            //get the date and time of the proposed appointment as a LDT object
            
            LocalDateTime newDateTimeOfApp = MainAbsScheduling.getConvStringToDateTime(cmbDayIn.getSelectedItem().toString() + cmbMonthin.getSelectedItem().toString() +cmbYearIn.getSelectedItem().toString() + cmbTimeIn.getSelectedItem().toString());
         
            //check the proposed date and time in the Docotrs available list
            
            //this means that the Doctor has this appointment available, so the change can go ahead
            if (currentDoctorInst.getDocsAvailableAppointments().contains(newDateTimeOfApp)){
                        //remove the appointment time from the doctors appointment times taken list
                   currentDoctorInst.setRemoveLDTFromAppTimesTakenList(currentDateTimeOfInst);

                   //put the appointment back in their available appointment lists
                   currentDoctorInst.setAddLDTToAppTimesAvailableList(currentDateTimeOfInst);
                   
                   
                   //remove the new time from the doctor's available list
                   currentDoctorInst.setRemoveLDTFromAppTimesAvailableList(newDateTimeOfApp);

                   //add the new appointment time to the doctors appointments taken time list
                   currentDoctorInst.setAddLDTToAppTimesTakenList(newDateTimeOfApp);
                   
                   //set the appointment's date and time to the new date and time
                   currentAppointmentInst.setAppDateTime(newDateTimeOfApp);
                   
                   callPromptAppupdated();
                   
            }
            
            //this means the appointment is not in the doctor's available appointments list, so the change can't go ahead
            else{
                JOptionPane.showMessageDialog (null,
                "The doctor is busy on this date and time, please select an alternative date",
                "Appointment date & time Not available",
                JOptionPane.ERROR_MESSAGE);
            }
            
            
                //Change appointment date and time
               //change the appointment date and time
                //update Doctors appointment schedule – take out old appointment
                //take out appointment from their taken list
                //put it back in their available list
                //update Doctors appointment schedule – book new appointment
                //put new time and date in in their taken list
                //take out appointment from their available list
                //*no new appointment made, original stays on file – no other needs to be created, just update this appointment object
       
        
            }
        
                //variables check whether the form has been updated or not set back to false for a new update
                    amendAppFormInst.setFormUpdatedNotDateTime(false);
                    amendAppFormInst.setFormUpdatedDateTime(false);
                    amendAppFormInst.setFormUpdatedNotDateTimeButAppAndDoc(false);

                    
                    
    
        }
    
    private void callPromptAppupdated(){
        JOptionPane.showMessageDialog (null,
                "The appointment has been successfully updated",
                "Appointment Amended",
                JOptionPane.ERROR_MESSAGE);
    }
}
