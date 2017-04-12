package pkg15070779drsappsystem.JPanels;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
public class JPanelReportsPresrcips extends JPartPanelAbsReports {
    //only one menu will ever need be generated so singleton DP has been setup
    //the single instance should be accessed using the getInstance() method
    private static JPanelReportsPresrcips panelRepPresSingInst;
    
    private JPanelReportsPresrcips(){
        super("Report all prescriptions issued for the month of...");
        //String[]  ArrAppStat = {"Attended", "Cancelled", "Missed"};
        //JComboBox cmbAppStatus = new JComboBox(ArrAppStat);
        //super.add(cmbAppStatus, BorderLayout.EAST);
        
        
    }
    
    public static JPanelReportsPresrcips getInstance(){
        if (panelRepPresSingInst == null){
            panelRepPresSingInst = new JPanelReportsPresrcips();
        }
        return panelRepPresSingInst;
    }
    
    
    
    
}
