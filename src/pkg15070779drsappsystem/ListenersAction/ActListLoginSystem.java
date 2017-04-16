package pkg15070779drsappsystem.ListenersAction;

import java.awt.event.*;
import javax.swing.*;
import pkg15070779drsappsystem.JFrames.JFrameDoctorMenu;
import pkg15070779drsappsystem.JFrames.JFrameLoginScreen;
import pkg15070779drsappsystem.JFrames.JFramePatientMenu;
import pkg15070779drsappsystem.JFrames.JFramePharmacistMenu;
import pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsSystemUserComponent;
import pkg15070779drsappsystem.JPanels.JPanelPatRecordPatView;
import pkg15070779drsappsystem.JPanels.JPanelPatRecordSecView;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsLogin;
import pkg15070779drsappsystem.MainClasses.MainDoctor;
import pkg15070779drsappsystem.MainClasses.MainPatient;
import pkg15070779drsappsystem.MainClasses.MainPharmacist;
import pkg15070779drsappsystem.MainClasses.MainSecretary;



public class ActListLoginSystem implements ActionListener {
    //takes the username from a textfield, checks to see if the username exists in the
    //system
   
    //textfield passed in so username can be taken from here
    private JTextField INPUTTEXT;
  
    
    public ActListLoginSystem(JTextField InpText){
        this.INPUTTEXT = InpText;
    }
    
  
    public void actionPerformed(ActionEvent e){
        //gtries to login with the given username
        MainAbsLogin.login(INPUTTEXT.getText());
      
        
    }
    
  
}
