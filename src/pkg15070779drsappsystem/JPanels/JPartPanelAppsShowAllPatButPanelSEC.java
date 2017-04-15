
package pkg15070779drsappsystem.JPanels;

import javax.swing.JButton;
import javax.swing.JPanel;
import pkg15070779drsappsystem.ActionListeners.ActListAmendSelPatientRecSECnDOC;
import pkg15070779drsappsystem.ActionListeners.ActListReturnPatientRec;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsAppointmentComponent;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsSystemUserComponent;
import pkg15070779drsappsystem.MainClasses.MainAppointment;
import pkg15070779drsappsystem.MainClasses.MainPatient;

public class JPartPanelAppsShowAllPatButPanelSEC extends JPanel {
    
   public static  JButton btnReturn = new JButton("Back");
    public static   JButton btnAmendSelApp = new JButton("Amend Selected Appointment");
    public static JPartPanelAppsShowAllPatButPanelSEC ButPanSingleInst;
    private JPartPanelAppsShowAllPatButPanelSEC(){
        //flow layout as standard
       
        
        
        btnAmendSelApp.addActionListener(new ActListAmendSelPatientRecSECnDOC(JPanelAppsShowAllForPatientSEC.getComboAppkeys(), "Sec"));
        btnReturn.addActionListener(new ActListReturnPatientRec("Sec"));
        add(btnAmendSelApp);
        add(btnReturn);
        
    }
    
    //singleton DP
    public static JPartPanelAppsShowAllPatButPanelSEC getInstance(){
        if (ButPanSingleInst == null){
            ButPanSingleInst = new JPartPanelAppsShowAllPatButPanelSEC();
        }
        
        return ButPanSingleInst;
    }
    
}
