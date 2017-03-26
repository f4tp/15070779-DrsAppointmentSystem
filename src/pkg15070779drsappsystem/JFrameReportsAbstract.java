
package pkg15070779drsappsystem;

import java.awt.*;
import javax.swing.*;


public abstract class JFrameReportsAbstract extends JFrame {
    public JFrameReportsAbstract(String frametitle){
        super(frametitle);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// @@@@@@@@@@ all components @@@@@@@@@@        
        JLabel lblMessage = new JLabel ("Which month would you like the report for?");      
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
        setSize(400,105);
    }
    
    
}
