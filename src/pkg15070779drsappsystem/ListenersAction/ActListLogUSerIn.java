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
import pkg15070779drsappsystem.MainClasses.MainDoctor;
import pkg15070779drsappsystem.MainClasses.MainPatient;
import pkg15070779drsappsystem.MainClasses.MainPharmacist;
import pkg15070779drsappsystem.MainClasses.MainSecretary;



public class ActListLogUSerIn implements ActionListener {
    //takes the username from a textfield, checks to see if the username exists in the
    //system
   
    //textfield passed in so username can be taken from here
    private JTextField INPUTTEXT;
  
    
    public ActListLogUSerIn(JTextField InpText){
        this.INPUTTEXT = InpText;
    }
    
    public void actionPerformed(ActionEvent e){
        //gets username and converts to lower case for validation purposes
        String lowerCaseUserName = INPUTTEXT.getText().toLowerCase();
        
        //if the login is incorrect, a user will not be found... show error prompt
        if (MainAbsSystemUserComponent.getCheckLogin(lowerCaseUserName) == false){
            JOptionPane.showMessageDialog (null,
                "The user has not been found in the system. Please try different details.",
                "User not found",
                JOptionPane.ERROR_MESSAGE);
        }
        
        //if a user is found, it will be one of many different subtypes of MainSystemUserComponent
        //the next part of the code detects which object type it is and reacts accordingly
        else{
            //set the current system user to whoever has just logged in
                MainAbsSystemUserComponent.setCurrentSystemUser(lowerCaseUserName); 
                    

                //polymorphism here, object is initialised with subtype -
                //this subtype is checked to pull up the correct JFrame adhering to
                //the user type
            
              //opens the correct menu when the type of object is discovered
              if (MainAbsSystemUserComponent.currentSystemUser instanceof MainSecretary){
                    //this means there has been a user found and it is  a secretary object
                    //polymorphism in action, the MainAbsSystemUserComponent object is cast to a MainPatient object
                    //make the login screen invisible
                    JFrameLoginScreen.setVisibility(false);
                    //run teh right login screen
                    javax.swing.SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                          
                         MainSecretary.currentSecretary = (MainSecretary) MainAbsSystemUserComponent.currentSystemUser; 
                         
                        JFrameSecretaryMenu SecMenuMain = JFrameSecretaryMenu.getInstance();
                        
                        //sets the Patient Record JPanel to have the right buttons on as the patient sees the same JPanel
                        //as the secretary, just with fewer options
                        //AbsApplyButtonsToPatRecPanel.setButtonsToPatientRecordJPanel();  
                        
                        //JPanelPatientRecordSecView tmpInst = JPanelPatRecordSecView.getInstance();
                        //tmpInst.setUpdateTextFields();
                        SecMenuMain.setVisible(true);
                        } 
                    });
               
            }
              
              
              else if (MainAbsSystemUserComponent.currentSystemUser instanceof MainPatient){
                    JFrameLoginScreen.setVisibility(false);
                    javax.swing.SwingUtilities.invokeLater(new Runnable() {
                      public void run() {
                        
          
                         MainPatient.currentPatient = (MainPatient) MainAbsSystemUserComponent.currentSystemUser;     
                        JFramePatientMenu PatMenuMain = JFramePatientMenu.getInstance();
                        
                        //sets the Patient Record JPanel to have the right buttons on as the patient sees the same JPanel
                        //as the secretary, just with fewer options
                        //AbsApplyButtonsToPatRecPanel.setButtonsToPatientRecordJPanel();  
                        
                        JPanelPatRecordPatView tmpInst = JPanelPatRecordPatView.getInstance();
                        tmpInst.setUpdateTextFields();
                        
                        PatMenuMain.setVisible(true);
                        
                        //JFramePatientMenu PatMenuMain = new JFramePatientMenu();
                       //SecMenuSingInst
                       
                       
                      //PatMenuMain.setVisibility(true);
                      } 
                  });
              }
              
              
              
              
              
              
              else if (MainAbsSystemUserComponent.currentSystemUser instanceof MainDoctor){
                    JFrameLoginScreen.setVisibility(false);

                    javax.swing.SwingUtilities.invokeLater(new Runnable() {
                      public void run() {
                      JFrameDoctorMenu DocMenuMain = JFrameDoctorMenu.getInstance();
                      DocMenuMain.setVisibility(true);
                      } 
                  });
              }
              
              else if (MainAbsSystemUserComponent.currentSystemUser instanceof MainPharmacist){
                    JFrameLoginScreen.setVisibility(false);
                    javax.swing.SwingUtilities.invokeLater(new Runnable() {
                      public void run() {
                      JFramePharmacistMenu PharmMenuMain = new JFramePharmacistMenu();
                      PharmMenuMain.setVisibility(true);
                      } 
                  });
              }
              
            
            
        }
    }
    
  
}
