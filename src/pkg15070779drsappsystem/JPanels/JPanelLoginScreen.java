
package pkg15070779drsappsystem.JPanels;


import pkg15070779drsappsystem.ActionListeners.ActListLogUSerIn;
import java.awt.BorderLayout;
import javax.swing.*;


public class JPanelLoginScreen extends JPanel {
    JTextField inpUserName = new JTextField("elizabeth.moore.01011915 | alan.turing.01011900 | gregory.house.01011910 | donald.knuth.01011901");
    
    public static JPanelLoginScreen LoginScreenSingleInst;
    
    private JPanelLoginScreen(){
                   
        //setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
        setLayout (new BorderLayout ());
      
        JLabel loginLabel = new JLabel("Please enter your username to access the system");
        loginLabel.setToolTipText("Your username is in the format firstname.surname.year born - i.e. john.smith.1994");
        //add(loginLabel, BorderLayout.NORTH);
        
        JPartPanelPadding northDetail = new JPartPanelPadding(loginLabel);
        
        
        inpUserName.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        JPartPanelPadding centerDetail = new JPartPanelPadding(inpUserName);
     
        //JScrollPane scrollControl = new JScrollPane(inpUserName); //if you don't add this, you cannot scroll the text
        inpUserName.setToolTipText("Your username is in the format firstname.surname.year born - i.e. john.smith.1994");
        //add(inpUserName, BorderLayout.CENTER); 
              
        JButton btnLogin = new JButton("login");
        btnLogin.addActionListener(new ActListLogUSerIn(inpUserName));
        btnLogin.setToolTipText("Your username is in the format firstname.surname.year born - i.e. john.smith.1994");
        btnLogin.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        //add (btnLogin, BorderLayout.SOUTH);
      
        add (northDetail,BorderLayout.NORTH);                           
        add (centerDetail, BorderLayout.CENTER);
        add (btnLogin, BorderLayout.SOUTH);
        //setSize(400,100);
        
    }
    
    public static JPanelLoginScreen getInstance(){
        if (LoginScreenSingleInst == null){
            LoginScreenSingleInst = new JPanelLoginScreen();
        
        }
        return LoginScreenSingleInst;
    }
    
    //to set  defautl users to test the system
    public void updateLogintext(){
        inpUserName.setText("elizabeth.moore.01011915 | alan.turing.01011900 | gregory.house.01011910 | donald.knuth.01011901");
    }
}
