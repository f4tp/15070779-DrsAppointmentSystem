
package pkg15070779drsappsystem.JFrames;

import javax.swing.JFrame;
import pkg15070779drsappsystem.AbstractClasses.MainAbsScheduling;
import pkg15070779drsappsystem.JPanels.JPanelSelDateFlow;
import pkg15070779drsappsystem.JPanels.JPanelShowAvailApps;

public class JFrameUseToTestPanels extends JFrame {
    
    public JFrameUseToTestPanels(){
            super ("Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
      
        
        JFrameAbsBorLayFillScreen.applyLayout(this);
        
          MainAbsScheduling.generateSelectDates();
        JPanelShowAvailApps newOne = JPanelShowAvailApps.getInstance();
     
        newOne.setVisible(true);
        add(newOne);
        revalidate();
        repaint();
    }
    

}
