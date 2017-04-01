
package pkg15070779drsappsystem;

import java.awt.*;
import javax.swing.*;
import javax.*;


public abstract class JPanelReportsAbstract extends JPanel {
    public JPanelReportsAbstract(String paneltitle){
   
// @@@@@@@@@@ all components @@@@@@@@@@        
        JLabel lblMessage = new JLabel (paneltitle);
        AddBoxPadUnderComp topDetail = new AddBoxPadUnderComp(lblMessage);
        
        
        JButton btnRunReport = new JButton ("Run report");
        //btnRunReportaddActionListener (new DescribeAction (pane, check));
       
        
        String[] strMonths = {"January", "February","March" ,"April" , "May",
            "June","July" ,"August" ,"September" ,"October" ,"November", "December"};
        JComboBox cmbMonth = new JComboBox(strMonths);

        
        String [] strYears = {"2015", "2016","2017" ,"2018"};
        JComboBox cmbYear = new JComboBox(strYears);
        
        AddBoxPadUnderComp bottomDetail = new AddBoxPadUnderComp(cmbYear);
        AddBoxPadUnderComp westDetail = new AddBoxPadUnderComp(cmbMonth);
        
 //@@@@@@@@@@ layout @@@@@@@@@@
    
 //adds padding for better visual
    setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
    setLayout (new BorderLayout ());
       
     
       add(topDetail, BorderLayout.NORTH);
       //add(cmbMonth, BorderLayout.WEST);
       //add(cmbYear, BorderLayout.CENTER);
       add(westDetail, BorderLayout.WEST);
       add(bottomDetail, BorderLayout.CENTER);
       add(btnRunReport, BorderLayout.SOUTH);
       
       
       
      
       
    }
    
    
}
