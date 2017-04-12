
package pkg15070779drsappsystem.JPanels;

import java.awt.*;
import javax.swing.*;
import pkg15070779drsappsystem.AbstractClasses.MainAbsScheduling;
import pkg15070779drsappsystem.ActionListeners.ActListRunReport;


//this is abstract because it is never instantiated, it is  a component part of other JPanels, other classes
//extend this class and we instantiate them
//@@@@@ NTD - change this out to singleton DP and use get instance, change subclasses to reflect this
public abstract class JPartPanelAbsReports extends JPanel {
    
            //gets months from the abstract scheduling class to keep consistency, some routines rely on the date 
        //given as Jan Feb Mar etc
        JComboBox cmbMonth = new JComboBox(MainAbsScheduling.getMonthsArr());

        //gets years from the abstract scheduling class to keep consistency
       JComboBox cmbYear = new JComboBox(MainAbsScheduling.getYearArr());
    public JPartPanelAbsReports(String paneltitle){
   
// @@@@@@@@@@ all components @@@@@@@@@@        
        JLabel lblMessage = new JLabel (paneltitle);
        JPartPanelPadding topDetail = new JPartPanelPadding(lblMessage);
        
        JPartPanelTextAreaMonthReports butAndJText = JPartPanelTextAreaMonthReports.getInstance();
        
      JButton btnRunReport = new JButton ("Run report");
     btnRunReport.addActionListener (new ActListRunReport(paneltitle));
       

        JPartPanelPadding bottomDetail = new JPartPanelPadding(cmbYear);
        JPartPanelPadding westDetail = new JPartPanelPadding(cmbMonth);
        
 //@@@@@@@@@@ layout @@@@@@@@@@
    
 //adds padding for better visual, sometimes doesn;t work so created JPartPanelPadding
    setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
    setLayout (new BorderLayout ());
       
     
       add(topDetail, BorderLayout.NORTH);
       //add(cmbMonth, BorderLayout.WEST);
       //add(cmbYear, BorderLayout.CENTER);
       add(westDetail, BorderLayout.WEST);
       add(bottomDetail, BorderLayout.CENTER);
       add(btnRunReport, BorderLayout.SOUTH);
       //add(butAndJText, BorderLayout.SOUTH);
       
       
       
       
      
       
    }
    

    
    public String getMonthString(){
        return this.cmbMonth.getSelectedItem().toString();
    }
    
     public  String getYearString(){
        return this.cmbYear.getSelectedItem().toString();
    }
    
    
}
