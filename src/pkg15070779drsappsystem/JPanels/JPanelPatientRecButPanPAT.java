
package pkg15070779drsappsystem.JPanels;

import pkg15070779drsappsystem.ActionListeners.ActListPrintCurUserRec;
import javax.swing.*;

public class JPanelPatientRecButPanPAT extends JPanel {
    
    public static JPanelPatientRecButPanPAT JPanButPatInst;
    
    private JPanelPatientRecButPanPAT(){
        
        setBorder(BorderFactory.createEmptyBorder(100,0,0,0));
        //default has flow layout, so just add buttons
    
        JButton btnCheckInApp= new JButton("Check into your appointment");
        JButton btnPrintRecord = new JButton("Print My Patient Record");
        btnPrintRecord.addActionListener(new ActListPrintCurUserRec());
       
                
        add(btnCheckInApp);
        add(btnPrintRecord);

    }
    
    //singleton object generation here
    public static JPanelPatientRecButPanPAT getInstance(){
         if (JPanButPatInst == null){
            JPanButPatInst = new JPanelPatientRecButPanPAT();
        }
  
        return JPanButPatInst;
    }
    
}
