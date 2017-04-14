
package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import pkg15070779drsappsystem.JPanels.JPanelAppAmendSecView;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsAppointmentComponent;
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
        
        MainAppointment currentAppointmentInst;
        MainDoctor currentDoctorInst;
        MainPatient currentPatientInst;
        
        
        System.out.println("woo hoo" + cmbDayIn.getSelectedItem());
        System.out.println("woo hoohhh" + cmbTimeIn.getSelectedItem());
        JPanelAppAmendSecView amendAppFormInst = JPanelAppAmendSecView.getInstance();
        
        
        //if false, just display a message sayign no updates found:
        if (amendAppFormInst.getFormUpdatedNotDateTime() == false && amendAppFormInst.getFormUpdatedDateTime() == false){
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
        else if (amendAppFormInst.getFormUpdatedNotDateTime() == true){
            //get the appointment, patient and doctor out of the map
            //lazy instantiation
            currentAppointmentInst= MainAbsAppointmentComponent.getAppointment(AppKeyIn.getText());
            
          
             //set appointment attended status
            currentAppointmentInst.setAppAttendSec(attendedIn.isSelected());
                     
            //set appointment missed status
            currentAppointmentInst.setAppMissed(missedIn.isSelected());
           
          currentAppointmentInst.setSymptoms(symptomsIn.getText());
        
          //put the appointment back in the map
        MainAbsAppointmentComponent.setPutInMap(AppKeyIn.getText(), currentAppointmentInst);

        }
        
        
        //this means that the date and time has changed, it is amore complicated routine involving more objects
        else if(amendAppFormInst.getFormUpdatedDateTime() == true){
            
            //lazy instantiation
            currentAppointmentInst= MainAbsAppointmentComponent.getAppointment(AppKeyIn.getText());
            currentDoctorInst  = (MainDoctor) MainAbsSystemUserComponent.getSystemUserComponent(drUserNameIn.getText());
            currentPatientInst = (MainPatient) MainAbsSystemUserComponent.getSystemUserComponent(patUserNameIn.getText());
            
              //check date and time for doctor to make sure they are available
            
            
            //Change appointment date and time
           //change the appointment date and time
            //update Doctors appointment schedule – take out old appointment
            //take out appointment from their taken list
            //put it back in their available list
            //update Doctors appointment schedule – book new appointment
            //put new time and date in in their taken list
            //take out appointment from their available list
            //*no new appointment made, original stays on file – no other needs to be created, just update this appointment object
            
            
              //set appointment cancelled status
            currentAppointmentInst.setAppMissed(missedIn.isSelected());
            
            //if the appointment has been cancelled, the appoint time becomes available - this takes care of that
            if (currentAppointmentInst.getCancelled() == true){
               
                //THIS IS CALLED TWICE - CREATE METHOD IN MAINDOCTOR - updateDrScheduleLists
            
                //get the doctors taken appointment list
                
                
                //take out this particular date
            
                
            //put it back in their available list
            
            
            
            //*appointment still stays on file so no further action
            }
        }
        
        //variables check whether the form has been updated or not set back to false for a new update
            amendAppFormInst.setFormUpdatedNotDateTime(false);
            amendAppFormInst.setFormUpdatedDateTime(false);
            
            //NTDgo back to another screen
    }
    
}
