
package pkg15070779drsappsystem;

import java.awt.BorderLayout;
import javax.swing.JComboBox;

public class JPanelReportsAppAtt extends JPanelReportsAbstract {
    //only one menu will ever need be generated so singleton DP has been setup
    //the single instance should be accessed using the getInstance() method
    private static JPanelReportsAppAtt panelRepAppAttSingInst;
    
    private JPanelReportsAppAtt(){
        super("Report all Appointments for the month of...");
        String[]  ArrAppStat = {"All Appointments","Attended", "Cancelled", "Missed"};
        JComboBox cmbAppStatus = new JComboBox(ArrAppStat);
        JPanelAddBoxPadUnderComp eastDetail = new JPanelAddBoxPadUnderComp(cmbAppStatus);
        super.add(eastDetail, BorderLayout.EAST);
        
        
    }
    
    public static JPanelReportsAppAtt getInstance(){
        if (panelRepAppAttSingInst == null){
            panelRepAppAttSingInst = new JPanelReportsAppAtt();
        }
        return panelRepAppAttSingInst;
    }
    
}
