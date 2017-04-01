
package pkg15070779drsappsystem;

import java.awt.*;
import javax.swing.*;


public abstract class JPanelReportsAbstract extends JPanel {
    public JPanelReportsAbstract(String paneltitle){
   
// @@@@@@@@@@ all components @@@@@@@@@@        
        JLabel lblMessage = new JLabel (paneltitle);
    
        
        
        JButton btnRunReport = new JButton ("Run report");
        //btnRunReportaddActionListener (new DescribeAction (pane, check));
       
        
        String[] strMonths = {"January", "February","March" ,"April" , "May",
            "June","July" ,"August" ,"September" ,"October" ,"November", "December"};
        JComboBox cmbMonth = new JComboBox(strMonths);

        
        String [] strYears = {"2015", "2016","2017" ,"2018"};
        JComboBox cmbYear = new JComboBox(strYears);
        
 //@@@@@@@@@@ layout @@@@@@@@@@
       setLayout (new BorderLayout ());
       add(lblMessage, BorderLayout.NORTH);
       add(cmbMonth, BorderLayout.WEST);
       add(cmbYear, BorderLayout.CENTER);
       add(btnRunReport, BorderLayout.SOUTH);
       
    }
    
    
}
