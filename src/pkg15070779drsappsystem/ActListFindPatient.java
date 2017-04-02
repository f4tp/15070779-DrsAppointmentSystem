package pkg15070779drsappsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ActListFindPatient implements ActionListener {
    private JTextField TfFirstName;
    private JTextField TfSurName;
    private JTextField TfDob;
    private String userIdForMap;
    private MainAbsSystemUserComponent FoundPatient;
    
    public ActListFindPatient(JTextField firstnamepassedin, JTextField surnamepassedin, JTextField dobpassedin){
        this.TfFirstName = firstnamepassedin;
        this.TfSurName = surnamepassedin;
        this.TfDob = dobpassedin;
        
    }
    //checks to see if the patient exists in teh map by generating the map id and using it to look for the user
    @Override
    public void actionPerformed(ActionEvent e){
        
        
        
        //validation - makign sure none of the text fields are empty
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
            setGenerateUserName();
        
           //searches for user
            this.setAndCheckPatientFindPatient(this.userIdForMap);
            
        
        }
        
 
    }
    //generates the username to search for
    private void setGenerateUserName(){
            this.userIdForMap = this.TfFirstName.getText().toLowerCase()+ "." + this.TfSurName.getText().toLowerCase() + "." + this.TfDob.getText().toLowerCase();
            System.out.println(this.userIdForMap);
    
    }
    
    //this checks the user id, and object type... it will set the MainPatient.currentPatient field 
    //as the current patient to work on if the user exists and it is of type MainPatient
    private void setAndCheckPatientFindPatient(String userid){
        this.FoundPatient = MainAbsSystemUserComponent.getSystemUserComponent(userid);
        
        //if a user has been found...
        if (this.FoundPatient != null) {
            
            //only if it is an instance of the MainPatient class will it set the currentPatient field
            if (this.FoundPatient instanceof MainPatient){
                //this means there has been a user found and it is  a patient object
                //polymorphism in action, the MainAbsSystemUserComponent object is cast to a MainPatient object
                MainPatient.currentPatient = (MainPatient) this.FoundPatient;
                System.out.println(MainPatient.currentPatient);
                
                JFrameSecretaryMenu SecMenuRef = JFrameSecretaryMenu.getInstance();
                SecMenuRef.setSouthBorderString("DisplayPatientDetails");
                
                
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
    //exist or user found may not be MainPatient object
    private static void runGenericErrorMessage(){
        JOptionPane.showMessageDialog (null,
                "The patient has not been found in the system. Please try different details.",
                "Patient not found",
                JOptionPane.ERROR_MESSAGE);
    }
    
    
}
