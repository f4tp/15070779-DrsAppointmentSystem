
package pkg15070779drsappsystem.JPanels;

import java.awt.BorderLayout;
import javax.swing.*;
import java.util.*;
import pkg15070779drsappsystem.MainClasses.MainDoctor;
//different report border layout, specialised version as we have to have Drs as well
public class JPanelReportsDrsApps extends JPartPanelAbsReports {
    
    //only one menu will ever need be generated so singleton DP has been setup
    //the single instance should be accessed using the getInstance() method
    private static JPanelReportsDrsApps panelRepDrsAppsSingInst;
    
    private JPanelReportsDrsApps(){
        super("Report Doctor's appointments for the month of...");
        //updates the combobox with all Drs that are registered
        JComboBox cmbDrs = new JComboBox(MainDoctor.getListAllDoctors().toArray());
        JPartPanelPadding eastDetail = new JPartPanelPadding(cmbDrs);
            

//adds the combobox to the abstract 
        super.add(eastDetail, BorderLayout.EAST);   
        
    }
    
    public static JPanelReportsDrsApps getInstance(){
        if (panelRepDrsAppsSingInst == null){
            panelRepDrsAppsSingInst = new JPanelReportsDrsApps();
        }
        //panelRepDrsAppsSingInst.setVisible(true);
        return panelRepDrsAppsSingInst;
    }
    
}
