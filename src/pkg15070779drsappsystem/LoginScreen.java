package pkg15070779drsappsystem;

import javax.swing.*;
import java.awt.*;


public class LoginScreen extends JFrame{
    
    public LoginScreen(){
    
    setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setLayout (new BorderLayout());
        add (makeLoginPanel (), BorderLayout.CENTER);
           setSize(400,110);
    }
    
     public JPanel makeLoginPanel () {
        JPanel Loginpanel = new JPanel ();                               // <2>
        Loginpanel.setLayout (new BoxLayout (Loginpanel, BoxLayout.Y_AXIS));  // <3>
      

     
        JLabel loginLabel = new JLabel("Please enter your username to access the system");
        loginLabel.setToolTipText("Your username is in the format firstname.surname.year born - i.e. john.smith.1994");
        //add(loginLabel, BorderLayout.NORTH);
        
        JTextField inpUserName = new JTextField();
        //inpUserName.setBounds(3, 3, 3, 3);
     
        //JScrollPane scrollControl = new JScrollPane(inpUserName); //if you don't add this, you cannot scroll the text
        inpUserName.setToolTipText("Your username is in the format firstname.surname.year born - i.e. john.smith.1994");
        //add(inpUserName, BorderLayout.CENTER); 
     
         
        JButton btnLogin = new JButton("login");
        btnLogin.addActionListener(new CheckUserAction(inpUserName));
        btnLogin.setToolTipText("Your username is in the format firstname.surname.year born - i.e. john.smith.1994");
        //add (btnLogin, BorderLayout.SOUTH);
      
        Loginpanel.add (loginLabel);                           
        Loginpanel.add (inpUserName);
        Loginpanel.add (btnLogin);
        setSize(100,100);

        return Loginpanel;
    }
    
}
