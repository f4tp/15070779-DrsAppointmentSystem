
package pkg15070779drsappsystem.JPanels;

import pkg15070779drsappsystem.ListenersAction.ActListPrintCurUserRec;
import javax.swing.*;
import pkg15070779drsappsystem.ListenersAction.ActListPatAttendAppoint;

public class JPartPanelPatRecButPanPAT extends JPanel {
    
    public static JPartPanelPatRecButPanPAT JPanButPatInst;
    
    private JPartPanelPatRecButPanPAT(){
        
        setBorder(BorderFactory.createEmptyBorder(100,0,0,0));
        //default has flow layout, so just add buttons
    
        JButton btnCheckInApp= new JButton("Check into your appointment");
        btnCheckInApp.addActionListener(new ActListPatAttendAppoint());
        
        JButton btnPrintRecord = new JButton("Print My Patient Record");
        btnPrintRecord.addActionListener(new ActListPrintCurUserRec());
       
                
        add(btnCheckInApp);
        add(btnPrintRecord);

    }
    
    //singleton object generation here
    public static JPartPanelPatRecButPanPAT getInstance(){
         if (JPanButPatInst == null){
            JPanButPatInst = new JPartPanelPatRecButPanPAT();
        }
  
        return JPanButPatInst;
    }
    
}
