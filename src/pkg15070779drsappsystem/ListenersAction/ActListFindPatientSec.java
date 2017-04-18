package pkg15070779drsappsystem.ListenersAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu;
import pkg15070779drsappsystem.JPanels.JPanelPatRecordSecView;
import pkg15070779drsappsystem.MainAbstractClasses.SystemUserComponent;
import pkg15070779drsappsystem.MainClasses.SysUserPatient;


public class ActListFindPatientSec implements ActionListener {
    private JTextField TfFirstName; //holds text field passed in
    private JTextField TfSurName;  //holds text field passed in
    private JTextField TfDob;  //holds text field passed in
    private String userIdForMap;  //holds user id to search for in the SystemUserComp map
    private static SystemUserComponent FoundPatient; //holds the reference to the system user if / when found
    SysUserPatient currentPatientInst;
    
    public ActListFindPatientSec(JTextField firstnamepassedin, JTextField surnamepassedin, JTextField dobpassedin){
        this.TfFirstName = firstnamepassedin;
        this.TfSurName = surnamepassedin;
        this.TfDob = dobpassedin;
        
    }
    //checks to see if the patient exists in teh map by generating the map id and using it to look for the user
    @Override
    public void actionPerformed(ActionEvent e){
        
        //validation - making sure none of the text fields are empty
        if (this.TfFirstName.getText().isEmpty()){
            JOptionPane.showMessageDialog (null,
                "You haven't entered a FIRSTNAME to search for, please enter one in the corresponding text box",
                "Missing Data",
                JOptionPane.ERROR_MESSAGE);
        }
        
        else if (this.TfSurName.getText().isEmpty()){
            JOptionPane.showMessageDialog (null,
                "You haven't entered a SURNAME to search for, please enter one in the corresponding text box",
                "Missing Data",
                JOptionPane.ERROR_MESSAGE);
        }
        
        else if (this.TfDob.getText().isEmpty()){
            JOptionPane.showMessageDialog (null,
                "You haven't entered a DOB to search for, please enter one in the corresponding text box",
                "Missing Data",
                JOptionPane.ERROR_MESSAGE);
        }
        
        else{
            //if they are all full it will generate the username to search for
            //setGenerateUserName(TfFirstName.getText(),TfSurName.getText(),TfDob.getText());
        
           //...then searches the map of all users with te hgenerated user id as the key
            this.setAndCheckPatientFindPatient(setGenerateUserName(TfFirstName.getText(),TfSurName.getText(),TfDob.getText()));
            
        
        }
        
 
    }
    //generates the username to search for
    private String setGenerateUserName(String firstname, String surname, String dob){
            //this.userIdForMap = this.TfFirstName.getText().toLowerCase()+ "." + this.TfSurName.getText().toLowerCase() + "." + this.TfDob.getText().toLowerCase();
           return firstname.toLowerCase()+"."+surname.toLowerCase()+"."+dob;
            
    }
    
    //this checks the user id, and object type... it will set the SysUserPatient.currentPatient field 
    //as the current patient to work on if the user exists and it is of type SysUserPatient
    private void setAndCheckPatientFindPatient(String userid){
        
        //MainAbsSystemUserComponent.setFoundSystemUser(userid);
        
        FoundPatient = SystemUserComponent.getSystemUserComponent(userid);
                //MainAbsSystemUserComponent.getSystemUserComponent(userid);
      
        //if a user has been found...
        if (FoundPatient != null) {
            
            //only if it is an instance of the SysUserPatient class will it set the currentPatient field
            if (FoundPatient instanceof SysUserPatient){
                //this means there has been a user found and it is  a patient object
                //polymorphism in action, the SystemUserComponent object is cast to a SysUserPatient object
                //MainPatient.currentPatient = (SysUserPatient) FoundPatient; //convert to patient object
                currentPatientInst = (SysUserPatient) SystemUserComponent.getSystemUserComponent(userid);
                SysUserPatient.currentPatient = (SysUserPatient) SystemUserComponent.getSystemUserComponent(userid);
       
               //the patient details are updated in the Secretary JFrame - when the setSecSouthBorderStrins is set...
               //it sets the visibility of the right JPanel so we can see the pateint record, but not before updatign all 
               //of teh details usign the setUpdateTextFields(); method from the JPanelPatRecordSecView class
                
                JFrameSecretaryMenu SecMenuRef = JFrameSecretaryMenu.getInstance();
                SecMenuRef.setSecNorthBorderStringPatient("DisplayPatientDetails", currentPatientInst);
                
                
            }
            else{
                //error message
                runGenericErrorMessage();
            }
            
        }
        
        else{
            runGenericErrorMessage();
        }
    }
    
    //generic error message when user is not found for what ever reason (may not 
    //exist or user found may not be SysUserPatient object
    private static void runGenericErrorMessage(){
        JOptionPane.showMessageDialog (null,
                "The patient has not been found in the system. Please try different details.",
                "Patient not found",
                JOptionPane.ERROR_MESSAGE);
    }
    
    
}
