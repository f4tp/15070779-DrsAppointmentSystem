package pkg15070779drsappsystem;

import java.awt.event.*;
import javax.swing.*;

public class CheckUserAction implements ActionListener {
    private final JTextField INPUTTEXT;
  
    
    public CheckUserAction(JTextField InpText){
        this.INPUTTEXT = InpText;
    }
    
    public void actionPerformed(ActionEvent e){
        String lowerCase = INPUTTEXT.getText();
        lowerCase = lowerCase.toLowerCase();
        System.out.println(SystemUser.checkLogin(lowerCase)); 
    }
}
