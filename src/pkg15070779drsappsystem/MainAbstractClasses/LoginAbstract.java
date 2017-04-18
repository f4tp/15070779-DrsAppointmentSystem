
package pkg15070779drsappsystem.MainAbstractClasses;

import javax.swing.JOptionPane;
import pkg15070779drsappsystem.JFrames.JFrameDoctorMenu;
import pkg15070779drsappsystem.JFrames.JFrameLoginScreen;
import pkg15070779drsappsystem.JFrames.JFramePatientMenu;
import pkg15070779drsappsystem.JFrames.JFramePharmacistMenu;
import pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu;
import pkg15070779drsappsystem.JPanels.JPanelPatRecordPatView;
import pkg15070779drsappsystem.MainClasses.SysUserDoctor;
import pkg15070779drsappsystem.MainClasses.SysUserPatient;
import pkg15070779drsappsystem.MainClasses.SysUserPharmacist;
import pkg15070779drsappsystem.MainClasses.SysUserSecretary;

public abstract class LoginAbstract {
    SystemUserComponent currentSystemUserInst;
    public static void login(String usernamein){
        
        JFrameLoginScreen jfLoginScrenSingInst = JFrameLoginScreen.getInstance();
        
        //converts all string to lowercase for validation purposes
        String lowerCaseUserName = usernamein.toLowerCase();
        
        //if the login is incorrect, a user will not be found... show error prompt
        if (SystemUserComponent.getLoginCheckUserExists(lowerCaseUserName) == false){
            JOptionPane.showMessageDialog (null,
                "The user has not been found in the system. Please try different details.",
                "User not found",
                JOptionPane.ERROR_MESSAGE);
        }
        
        //if a user is found / exists, it will be one of many different subtypes of MainSystemUserComponent
        //the next part of the code detects which object type it is and reacts accordingly
        else{
                //set the current system user to whoever has just logged in - global static variable which keeps
                //track of who is logged in at all times
                SystemUserComponent.setCurrentSystemUser(lowerCaseUserName); 
                
                //polymorphism here, object is initialised with subtype -
                //this subtype is checked to pull up the correct JFrame adhering to
                //the user type
            
              //opens the correct menu when the type of object is discovered
              if (SystemUserComponent.currentSystemUser instanceof SysUserSecretary){
                    //this means there has been a user found and it is  a secretary object
                    //polymorphism in action, the SystemUserComponent object is cast to a SysUserPatient object
                    //make the login screen invisible
                    
                    jfLoginScrenSingInst.setVisible(false);
                    //run the right login screen
                    javax.swing.SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                         SysUserSecretary.currentSecretary = (SysUserSecretary) SystemUserComponent.currentSystemUser; 
                        JFrameSecretaryMenu SecMenuMain = JFrameSecretaryMenu.getInstance();
                        SecMenuMain.setVisible(true);
                        } 
                    });
            }

              else if (SystemUserComponent.currentSystemUser instanceof SysUserPatient){
                    jfLoginScrenSingInst.setVisible(false);
                    javax.swing.SwingUtilities.invokeLater(new Runnable() {
                      public void run() {
                        
          
                         SysUserPatient.currentPatient = (SysUserPatient) SystemUserComponent.currentSystemUser;     
                        JFramePatientMenu PatMenuMain = JFramePatientMenu.getInstance();
                        JPanelPatRecordPatView tmpInst = JPanelPatRecordPatView.getInstance();
                        tmpInst.setUpdateTextFields();
                        PatMenuMain.setVisible(true);

                      } 
                  });
              }
              
              else if (SystemUserComponent.currentSystemUser instanceof SysUserDoctor){
                    jfLoginScrenSingInst.setVisible(false);

                    javax.swing.SwingUtilities.invokeLater(new Runnable() {
                      public void run() {
                      JFrameDoctorMenu DocMenuMain = JFrameDoctorMenu.getInstance();
                      DocMenuMain.setVisible(true);
                      } 
                  });
              }
              
              else if (SystemUserComponent.currentSystemUser instanceof SysUserPharmacist){
                   jfLoginScrenSingInst.setVisible(false);
                    javax.swing.SwingUtilities.invokeLater(new Runnable() {
                      public void run() {
                      JFramePharmacistMenu PharmMenuMain = JFramePharmacistMenu.getInstance();
                      PharmMenuMain.setVisible(true);
                      } 
                  });
              }
              
            
            
        }
    }
    
}
