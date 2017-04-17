
package pkg15070779drsappsystem.JPanels;


import pkg15070779drsappsystem.ListenersAction.ActListLoginSystem;
import java.awt.BorderLayout;
import javax.swing.*;


public class JPanelLoginScreen extends JPanel {
    JTextField inpUserName = new JTextField("elizabeth.moore.01011915 | alan.turing.01011900 | gregory.house.01011910 | donald.knuth.01011901 | Pharm.Asutical.01011918");
    
    public static JPanelLoginScreen LoginScreenSingleInst;
    
    private JPanelLoginScreen(){
                   
        //setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
        setLayout (new BorderLayout ());
      
        JLabel loginLabel = new JLabel("Please enter your username to access the system");
        loginLabel.setToolTipText("Your username is in the format firstname.surname.year born - i.e. john.smith.1994");

        
        JPartPanelPadding northDetail = new JPartPanelPadding(loginLabel);
        
        
        inpUserName.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        JPartPanelPadding centerDetail = new JPartPanelPadding(inpUserName);

        inpUserName.setToolTipText("Your username is in the format firstname.surname.year born - i.e. john.smith.1994");

        JButton btnLogin = new JButton("login");
        btnLogin.addActionListener(new ActListLoginSystem(inpUserName));
        btnLogin.setToolTipText("Your username is in the format firstname.surname.year born - i.e. john.smith.1994");
        btnLogin.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
      
        add (northDetail,BorderLayout.NORTH);                           
        add (centerDetail, BorderLayout.CENTER);
        add (btnLogin, BorderLayout.SOUTH);
        
    }
    
    public static JPanelLoginScreen getInstance(){
        if (LoginScreenSingleInst == null){
            LoginScreenSingleInst = new JPanelLoginScreen();
        
        }
        return LoginScreenSingleInst;
    }
    
    //to set  default users to test the system when someone logs out
    public void updateLogintext(){
        inpUserName.setText("elizabeth.moore.01011915 | alan.turing.01011900 | gregory.house.01011910 | donald.knuth.01011901 | Pharm.Asutical.01011918");
    }
}
