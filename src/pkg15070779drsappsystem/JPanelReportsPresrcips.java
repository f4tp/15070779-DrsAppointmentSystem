package pkg15070779drsappsystem;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
public class JPanelReportsPresrcips extends JPanelReportsAbstract {
    //only one menu will ever need be generated so singleton DP has been setup
    //the single instance should be accessed using the getInstance() method
    private static JPanelReportsPresrcips panelRepPresSingInst;
    
    private JPanelReportsPresrcips(){
        super("ALL MONTHS PRESCRIPTIONS");
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
