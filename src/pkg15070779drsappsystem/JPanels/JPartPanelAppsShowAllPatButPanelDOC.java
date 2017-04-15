
package pkg15070779drsappsystem.JPanels;

import javax.swing.JButton;
import javax.swing.JPanel;
import pkg15070779drsappsystem.ActionListeners.ActListAmendSelPatientRecSECnDOC;
import pkg15070779drsappsystem.ActionListeners.ActListReturnPatientRec;

public class JPartPanelAppsShowAllPatButPanelDOC extends JPanel {
     public static  JButton btnReturn = new JButton("Back");
    public static   JButton btnAmendSelApp = new JButton("Amend Selected Appointment");
    public static JPartPanelAppsShowAllPatButPanelDOC ButPanSingleInst;
    
    private JPartPanelAppsShowAllPatButPanelDOC(){
          //flow layout as standard

        btnAmendSelApp.addActionListener(new ActListAmendSelPatientRecSECnDOC(JPanelAppsShowAllForPatientDOC.getComboAppkeys(), "Doc"));
       //NTD - retun
        btnReturn.addActionListener(new ActListReturnPatientRec("Doc"));
        add(btnAmendSelApp);
        add(btnReturn);
    }
    
     //singleton DP
    public static JPartPanelAppsShowAllPatButPanelDOC getInstance(){
        if (ButPanSingleInst == null){
            ButPanSingleInst = new JPartPanelAppsShowAllPatButPanelDOC();
        }
        
        return ButPanSingleInst;
    }
    
}
