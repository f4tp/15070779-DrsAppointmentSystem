
package pkg15070779drsappsystem.ListenersAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import pkg15070779drsappsystem.JFrames.JFrameDoctorMenu;
import pkg15070779drsappsystem.JPanels.JPanelAppAmendDocView;
import pkg15070779drsappsystem.MainAbstractClasses.AppointmentComponent;
import pkg15070779drsappsystem.MainClasses.Appointment;

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

    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        //these are the objects that are needed to interact with an appointment when changing it
        //only the Doctor and appointment will need updating
        Appointment currentAppointmentInst = AppointmentComponent.getAppointment(AppKeyIn.getText());
       
        
        JPanelAppAmendDocView amendAppFormInst = JPanelAppAmendDocView.getInstance();
        
        //if false, just display a message saying no updates found:
        if (amendAppFormInst.getFormUpdatedNotDateTime() == false){
            JOptionPane.showMessageDialog (null,
                "The form hasn't been updated. Please press 'Back' or make the changes to the appointment",
                "No Changes Made",
                JOptionPane.ERROR_MESSAGE);
        }
        
        else{
         
                    currentAppointmentInst.setProfessionalsComments(DrsCommentsIn.getText());
                 //go back to patient record screen
                JFrameDoctorMenu DocMenuRef = JFrameDoctorMenu.getInstance();
                DocMenuRef.setDocSouthBorderString("DisplayPatientDetails");
                amendAppFormInst.setFormUpdatedNotDateTime(false);

                }

    }

}
