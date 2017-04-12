
package pkg15070779drsappsystem.JPanels;

import java.awt.BorderLayout;
import javax.swing.*;
import java.util.*;
import pkg15070779drsappsystem.ActionListeners.ActListRunReport;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsScheduling;
import pkg15070779drsappsystem.MainClasses.MainDoctor;
//different report border layout, specialised version as we have to have Drs as well
public class JPanelReportsDrsApps extends JPanel {
    
    //only one menu will ever need be generated so singleton DP has been setup
    //the single instance should be accessed using the getInstance() method
    private static JPanelReportsDrsApps panelRepDrsAppsSingInst;
    public JComboBox cmbDrs = new JComboBox(MainDoctor.getListAllDoctors().toArray());
    
         //gets months from the abstract scheduling class to keep consistency, some routines rely on the date 
        //given as Jan Feb Mar etc
      JComboBox cmbMonth = new JComboBox(MainAbsScheduling.getMonthsArr());

        //gets years from the abstract scheduling class to keep consistency
       JComboBox cmbYear = new JComboBox(MainAbsScheduling.getYearArr());
    
    
    private JPanelReportsDrsApps(){
        //super("Report Doctor's appointments for the month of...", JPanelReportsDrsApps.getInstance());
        //updates the combobox with all Drs that are registered
        JLabel lblMessage = new JLabel ("Report Doctor's appointments for the month of...");
        JPartPanelPadding topDetail = new JPartPanelPadding(lblMessage);
        
       JButton btnRunReport = new JButton ("Run report");
      //act listener called with the text out of the title label (to identify which report is being run), the selected month and year from
      //the current panel being worked on... which is passed into this class as an object
      //the current panel is a singleton dp
        btnRunReport.addActionListener (new ActListRunReport(lblMessage.getText(), cmbMonth.getSelectedItem().toString(), cmbYear.getSelectedItem().toString()));
        
        JPartPanelPadding eastDetail = new JPartPanelPadding(cmbDrs);
        JPartPanelPadding bottomDetail = new JPartPanelPadding(cmbYear);
        JPartPanelPadding westDetail = new JPartPanelPadding(cmbMonth);
        
        
            


 setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
    setLayout (new BorderLayout ());
       
     
       add(topDetail, BorderLayout.NORTH);
       //add(cmbMonth, BorderLayout.WEST);
       //add(cmbYear, BorderLayout.CENTER);
       add(westDetail, BorderLayout.WEST);
       add(eastDetail, BorderLayout.EAST);
       add(bottomDetail, BorderLayout.CENTER);
       add(btnRunReport, BorderLayout.SOUTH);
       //add(butAndJText, BorderLayout.SOUTH);


//adds the combobox to the abstract 
        //super.add(eastDetail, BorderLayout.EAST);   
        
    }
    
    public static JPanelReportsDrsApps getInstance(){
        if (panelRepDrsAppsSingInst == null){
            panelRepDrsAppsSingInst = new JPanelReportsDrsApps();
        }
        //panelRepDrsAppsSingInst.setVisible(true);
        return panelRepDrsAppsSingInst;
    }
    
    public String getSelectedDr(){
        
        return cmbDrs.getSelectedItem().toString();
    }
    
}
