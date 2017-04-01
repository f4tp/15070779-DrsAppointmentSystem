
package pkg15070779drsappsystem;

import java.awt.BorderLayout;
import javax.swing.*;
import java.util.*;
//different report border layout, specialised version as we have to have Drs as well
public class JPanelReportsDrsApps extends JPanelReportsAbstract {
    
    //only one menu will ever need be generated so singleton DP has been setup
    //the single instance should be accessed using the getInstance() method
    private static JPanelReportsDrsApps panelRepDrsAppsSingInst;
    
    private JPanelReportsDrsApps(){
        super("DRs MONTHLY APPOINTMENT REPORT");
        //updates the combobox with all Drs that are registered
        JComboBox cmbDrs = new JComboBox(Doctor.getListAllDoctors().toArray());
        //adds the combobox to the abstract 
        super.add(cmbDrs, BorderLayout.EAST);
        
    }
    
    public static JPanelReportsDrsApps getInstance(){
        if (panelRepDrsAppsSingInst == null){
            panelRepDrsAppsSingInst = new JPanelReportsDrsApps();
        }
        //panelRepDrsAppsSingInst.setVisible(true);
        return panelRepDrsAppsSingInst;
    }
    
}
