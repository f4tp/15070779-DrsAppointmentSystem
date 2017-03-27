
package pkg15070779drsappsystem;

import java.awt.*;
import javax.swing.*;


public abstract class JPanelReportsAbstract extends JPanel {
    public JPanelReportsAbstract(String paneltitle){
        //super(frametitle);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// @@@@@@@@@@ all components @@@@@@@@@@        
        JLabel lblMessage = new JLabel (paneltitle);
        JLabel lblMessage2 = new JLabel ("Select the month you wish to run the report for:");      
        
        
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
       add(lblMessage2, BorderLayout.NORTH);
       add(cmbMonth, BorderLayout.WEST);
       add(cmbYear, BorderLayout.CENTER);
       add(btnRunReport, BorderLayout.SOUTH);
        setSize(400,105);
    }
    
    
}
