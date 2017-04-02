package pkg15070779drsappsystem;

import java.awt.event.*;
import javax.swing.*;

public class ActListCheckLogin implements ActionListener {
    //takes the username from a textfield, checks to see if the username exists in the
    //system
   
    private final JTextField INPUTTEXT;
  
    
    public ActListCheckLogin(JTextField InpText){
        this.INPUTTEXT = InpText;
    }
    
    public void actionPerformed(ActionEvent e){
        String lowerCase = INPUTTEXT.getText();
        lowerCase = lowerCase.toLowerCase();
        
        System.out.println(SystemUserComponent.getCheckLogin(lowerCase));
        //further code required here
        //Main.currentUser = new Patient();
        
        //if the login is incorrect, a user will not be found... do nothing
        if (SystemUserComponent.getCheckLogin(lowerCase) == false){
            JOptionPane.showMessageDialog (null,
                "The user has not been found in the system. Please try different details.",
                "User not found",
                JOptionPane.ERROR_MESSAGE);
        }
        
        else{
            SystemUserComponent.currentSystemUser = SystemUserComponent.getSystemUserComponent(lowerCase);
            
              //opens the correct mwnu when the type of object is discovered
              if (SystemUserComponent.currentSystemUser instanceof Secretary){
                //this means there has been a user found and it is  a secretary object
                //polymorphism in action, the SystemUserComponent object is cast to a Patient object
                //make the login screen invisible
                JFrameLoginScreen.setVisibility(false);
                //run teh right login screen
                javax.swing.SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                    JFrameSecretaryMenu SecMenuMain = JFrameSecretaryMenu.getInstance();
                    } 
                });
               
            }
              
              else if (SystemUserComponent.currentSystemUser instanceof Doctor){
                  
              }
              
              else if (SystemUserComponent.currentSystemUser instanceof Pharmacist){
                  
              }
              
              else if (SystemUserComponent.currentSystemUser instanceof Patient){
                  
              }
            
        }
    }
    
  
}
