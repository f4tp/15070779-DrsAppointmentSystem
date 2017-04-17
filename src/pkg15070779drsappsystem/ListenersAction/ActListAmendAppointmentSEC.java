
package pkg15070779drsappsystem.ListenersAction;

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

public class ActListAmendAppointmentSEC implements ActionListener {
    
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
    public ActListAmendAppointmentSEC(JLabel patusername, JLabel appid, JLabel dridin, JComboBox cmbdayin, JComboBox cmbmonthin, JComboBox cmbyearin, JComboBox cmbtimein, JTextField symptomsin, JCheckBox attendedin, JCheckBox cancelledin, JCheckBox missedin ){
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

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //these are the objects that are needed to interact with an appointment when changing it
        //only the Doctor and appointment will need updating
        MainAppointment currentAppointmentInst = MainAbsAppointmentComponent.getAppointment(AppKeyIn.getText());
        MainDoctor currentDoctorInst = (MainDoctor) MainAbsSystemUserComponent.getSystemUserComponent(drUserNameIn.getText());
            
        //get the date and time of original appointment as a LDT object
       LocalDateTime currentDateTimeOfInst = currentAppointmentInst.getAPPDateAndTime();
       //get the date and time of the proposed appointment as a LDT object - if it needs to change
        LocalDateTime newDateTimeOfApp = MainAbsScheduling.getConvStringToDateTime(cmbDayIn.getSelectedItem().toString() + cmbMonthin.getSelectedItem().toString() +cmbYearIn.getSelectedItem().toString() + cmbTimeIn.getSelectedItem().toString());
 
        JPanelAppAmendSecView amendAppFormInst = JPanelAppAmendSecView.getInstance();
        
        
        //if false, just display a message saying no updates found:
        if (amendAppFormInst.getFormUpdatedNotDateTime() == false && amendAppFormInst.getFormUpdatedDateTime() == false
                && amendAppFormInst.getFormUpdatedNotDateTimeButAppAndDoc() == false){
            JOptionPane.showMessageDialog (null,
                "The form hasn't been updated. Please press 'Back' or make the changes to the appointment",
                "No Changes Made",
                JOptionPane.ERROR_MESSAGE);
        }
        //this means at least one change has been made on teh user form but a change to teh appointment might 
        //not be made - if the appointment the person wan'ts is not available:
        //the test is if the date and time has changed and teh new time is not available... display error message
        else if (amendAppFormInst.getFormUpdatedDateTime() == true && currentDoctorInst.getDocsAvailableAppointments().contains(newDateTimeOfApp) == false){
            JOptionPane.showMessageDialog (null,
                                                            "The doctor is busy on this date and time, please select an alternative date",
                                                            "Appointment date & time Not available",
                                                            JOptionPane.ERROR_MESSAGE);
        }
        
        //this means there is a change to make as all criteria for change have been met
        else{
                        //this means that the date and time has changed, it is amore complicated routine involving more objects
                        if (amendAppFormInst.getFormUpdatedDateTime() == true){
              
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



                           }

                    }
            
            
        
                //if the form has been altered in any way, one of two variables will be set at true. One involves teh date and time being 
                //interacted with which means more objects are involved and is more complicated. One involves just the appointment
                //object being interacted with

                //program needs updating because somethign on the form other than the date and time has been updated
                //this means only the appointment needs updating
                if (amendAppFormInst.getFormUpdatedNotDateTime() == true){
         
                     //set appointment attended status
                    currentAppointmentInst.setAppAttend(attendedIn.isSelected());

                    //set appointment missed status
                    currentAppointmentInst.setAppMissed(missedIn.isSelected());
                    //set any new symptoms
                    currentAppointmentInst.setSymptoms(symptomsIn.getText());

                  //put the appointment back in the map
                   // MainAbsAppointmentComponent.setPutInMap(AppKeyIn.getText(), currentAppointmentInst);


                }
        
        
        
                //this means the app has been cancelled, it needs to be marked as cancelled, and the doctor's schdule lists
                //need updating (the appointment time taking out of theri taken list, and putting back in the available
                //list
                if(amendAppFormInst.getFormUpdatedNotDateTimeButAppAndDoc() == true){
                    //get the date and time of appointment as an object
                   currentDateTimeOfInst = currentAppointmentInst.getAPPDateAndTime();
                   //set appointment cancelled status - need doctor to update and teh date to remove from appointment take list & 
                   //to update the appointments available list with too
                    currentAppointmentInst.setAppCancelled(cancelledIn.isSelected(), currentDoctorInst, currentDateTimeOfInst);

                    //*appointment still stays on file so no further action

                }
  
                
                //output message to tell you that the appointment has been updated
                callPromptAppupdated();
                 //go back to patient record screen
                JFrameSecretaryMenu SecMenuRef = JFrameSecretaryMenu.getInstance();
                SecMenuRef.setSecNorthBorderString("DisplayPatientDetails");
                
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
