
package pkg15070779drsappsystem.JFrames;

import javax.swing.JFrame;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsScheduling;
import pkg15070779drsappsystem.JPanels.JPartPanelAppsSelDateFlow;
import pkg15070779drsappsystem.JPanels.JPanelAppsShowAllForDoctor;

public class JFrameUseToTestPanels extends JFrame {
    
    public JFrameUseToTestPanels(){
            super ("Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
      
        
        JFrameAbsBorLayFillScreen.applyLayout(this);
        
          //MainAbsScheduling.generateSelectDates();
        //JPanelAppsShowAllForPatient newOne = JPanelAppsShowAllForDoctor.getInstance();
     
        //newOne.setVisible(true);
        //add(newOne);
        revalidate();
        repaint();
    }
    

}
