
package pkg15070779drsappsystem.JFrames;

import javax.swing.JFrame;
import pkg15070779drsappsystem.AbstractClasses.MainAbsScheduling;
import pkg15070779drsappsystem.JPanels.JPanelSelDataFlow;

public class JFrameUseToTestPanels extends JFrame {
    
    public JFrameUseToTestPanels(){
            super ("Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
      
        
        JFrameAbsBorLayFillScreen.applyLayout(this);
        
          MainAbsScheduling.generateSelectDates();
        JPanelSelDataFlow newOne = new JPanelSelDataFlow("Select Date's from");
        
        newOne.setVisible(true);
        add(newOne);
        revalidate();
        repaint();
    }
    

}
