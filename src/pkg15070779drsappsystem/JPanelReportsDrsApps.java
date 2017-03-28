
package pkg15070779drsappsystem;

import java.awt.BorderLayout;
import javax.swing.*;
import java.util.*;
//different report border layout, specialised version as we have to have Drs as well
public class JPanelReportsDrsApps extends JPanelReportsAbstract {
    
    public JPanelReportsDrsApps(){
        super("DRs MONTHLY APPOINTMENT REPORT");
        JComboBox cmbDrs = new JComboBox(Doctor.getListAllDoctors().toArray());
        super.add(cmbDrs, BorderLayout.EAST);
        
    }
}
