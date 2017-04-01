package pkg15070779drsappsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ActListFindPatient implements ActionListener {
    private JTextField TfFirstName;
    private JTextField TfSurName;
    private JTextField TfDob;
    private String userIdForMap;
    private SystemUserComponent FoundPatient;
    
    public ActListFindPatient(JTextField firstnamepassedin, JTextField surnamepassedin, JTextField dobpassedin){
        this.TfFirstName = firstnamepassedin;
        this.TfSurName = surnamepassedin;
        this.TfDob = dobpassedin;
        
    }
    
    public void actionPerformed(ActionEvent e){
        
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
        
            this.userIdForMap = this.TfFirstName.getText()+ "." + this.TfSurName.getText() + "." + this.TfDob.getText();
            System.out.println(this.userIdForMap);
            this.setAndCheckPatient(this.userIdForMap);
            
        
        }
        
 
    }
    private void setAndCheckPatient(String userid){
        this.FoundPatient.getSystemUserComponent(userid);
        if (this.FoundPatient != null) {
                 
            if (this.FoundPatient instanceof Patient){
                
            }
            else{
                //error message
            }
            
        }
        
        else{
            JOptionPane.showMessageDialog (null,
                "The patient has not been found in the system. Please try different details.",
                "Patient not found",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}
