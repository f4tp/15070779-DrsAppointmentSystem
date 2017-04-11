
package pkg15070779drsappsystem.JFrames;

import javax.swing.JFrame;
import pkg15070779drsappsystem.AbstractClasses.MainAppointmentSchedule;
import pkg15070779drsappsystem.JPanels.JPanelSelDataFlow;

public class JFrameUseToTestPanels extends JFrame {
    
    public JFrameUseToTestPanels(){
            super ("Doctor's menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MainAppointmentSchedule.generateSelectDates();
        JPanelSelDataFlow newOne = new JPanelSelDataFlow();
        newOne.setInitialiseWidgets();
        newOne.setVisible(true);
         JFrameAbsBorLayFillScreen.applyLayout(this);
        revalidate();
        repaint();
    }
    

}
