package pkg15070779drsappsystem.ListenersAction;

import java.awt.event.*;
import javax.swing.*;
import pkg15070779drsappsystem.MainAbstractClasses.LoginAbstract;



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
        LoginAbstract.login(INPUTTEXT.getText());
      
        
    }
    
  
}
