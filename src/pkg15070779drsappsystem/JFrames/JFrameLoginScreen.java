package pkg15070779drsappsystem.JFrames;

import javax.swing.*;
import java.awt.*;
import pkg15070779drsappsystem.JPanels.JPanelLoginScreen;


public class JFrameLoginScreen extends JFrame{
     
    
    private static JFrameLoginScreen LoginScreenSingInst;
    private JFrameLoginScreen(){
    super ("Login to the Doctor's Surgery System: ");
    setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    setLayout (new BorderLayout());
        
        
        /*
        //code below sets the menu to the screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        pack();
        setBounds(0,0,screenSize.width, screenSize.height-40); //minus 40 for the task bar (which we want present)
      
        setVisible(true);
        */
        
        //lays out the frame using this abstract class
        JFrameAbsBorLayFillScreen.applyLayout(this);
        add (JPanelLoginScreen.getInstance(), BorderLayout.NORTH);
    }
    
    //get single instance so no other instances are created
    public static JFrameLoginScreen getInstance(){
        if (LoginScreenSingInst == null){
            LoginScreenSingInst = new JFrameLoginScreen();
                    }
        return LoginScreenSingInst;
    }
    
    public static void setVisibility(boolean vis){
        
        LoginScreenSingInst.setVisible(vis);
        
    }
    
}
