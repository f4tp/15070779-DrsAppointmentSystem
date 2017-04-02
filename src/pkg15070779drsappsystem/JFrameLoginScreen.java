package pkg15070779drsappsystem;

import javax.swing.*;
import java.awt.*;


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
        
        //lays out the frame using thsi abstract class
        JFrameBorLaytFillScreen.applyLayout(this);
        add (new JPanelLoginScreen(), BorderLayout.NORTH);
    }
    
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
