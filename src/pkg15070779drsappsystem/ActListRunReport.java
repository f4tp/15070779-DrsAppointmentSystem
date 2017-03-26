
package pkg15070779drsappsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActListRunReport implements ActionListener {
    private String typeOfReport;
    public ActListRunReport(String typeofreport){
        typeOfReport = typeofreport;
        System.out.println(typeofreport);
    }
    
    public void actionPerformed(ActionEvent e){
        if (typeOfReport == "MonthAppPerDr"){
           
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    JFrameReportsDrsApps run = new JFrameReportsDrsApps();
                    run.setVisible(true);
                } 
            });
        
        }
        else if (typeOfReport == "MonthAppPerDriiiii"){
            
        }
        else if (typeOfReport == "MonthAppPerDriiiiiiiiii"){
            
        }
        
        
    }
    
}
