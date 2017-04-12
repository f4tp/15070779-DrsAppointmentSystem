
package pkg15070779drsappsystem.JPanels;

import javax.swing.JButton;
import javax.swing.JPanel;
import pkg15070779drsappsystem.ActionListeners.ActListAmendSelPatientRec;
import pkg15070779drsappsystem.ActionListeners.ActListReturnPatientRec;

public class JPartPanelAppsShowAllPatButPanel extends JPanel {
    
    JButton btnReturn = new JButton("Back");
    JButton btnAmendSelApp = new JButton("Amend Selected Appointment");
    public static JPartPanelAppsShowAllPatButPanel ButPanSingleInst;
    private JPartPanelAppsShowAllPatButPanel(){
        //flow layout as standard
       
        btnAmendSelApp.addActionListener(new ActListAmendSelPatientRec(JPanelAppsShowAllForPatient.getComboAppkeys()));
        btnReturn.addActionListener(new ActListReturnPatientRec());
        add(btnAmendSelApp);
        add(btnReturn);
        
    }
    
    //singleton DP
    public static JPartPanelAppsShowAllPatButPanel getInstance(){
        if (ButPanSingleInst == null){
            ButPanSingleInst = new JPartPanelAppsShowAllPatButPanel();
        }
        
        return ButPanSingleInst;
    }
    
}
