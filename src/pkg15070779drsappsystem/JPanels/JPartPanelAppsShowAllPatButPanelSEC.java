
package pkg15070779drsappsystem.JPanels;

import javax.swing.JButton;
import javax.swing.JPanel;
import pkg15070779drsappsystem.ListenersAction.ActListAmendSelPatientRecSECnDOC;
import pkg15070779drsappsystem.ListenersAction.ActListReturnPatientRec;
import pkg15070779drsappsystem.MainAbstractClasses.AppointmentComponent;
import pkg15070779drsappsystem.MainAbstractClasses.SystemUserComponent;
import pkg15070779drsappsystem.MainClasses.Appointment;
import pkg15070779drsappsystem.MainClasses.SysUserPatient;

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
