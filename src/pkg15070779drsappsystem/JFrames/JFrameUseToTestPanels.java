
package pkg15070779drsappsystem.JFrames;

import javax.swing.JFrame;
import pkg15070779drsappsystem.AbstractClasses.MainAbsScheduling;
import pkg15070779drsappsystem.JPanels.JPanelAppsSelDateFlow;
import pkg15070779drsappsystem.JPanels.JPanelAppsShowAllForPatient;

public class JFrameUseToTestPanels extends JFrame {
    
    public JFrameUseToTestPanels(){
            super ("Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
      
        
        JFrameAbsBorLayFillScreen.applyLayout(this);
        
          //MainAbsScheduling.generateSelectDates();
        //JPanelAppsShowAllForPatient newOne = JPanelAppsShowAllForPatient.getInstance();
     
        //newOne.setVisible(true);
        //add(newOne);
        revalidate();
        repaint();
    }
    

}
