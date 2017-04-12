
package pkg15070779drsappsystem.JPanels;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import pkg15070779drsappsystem.ActionListeners.ActListRunReport;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsScheduling;

public class JPanelReportsAppAtt extends JPanel {
    //only one menu will ever need be generated so singleton DP has been setup
    //the single instance should be accessed using the getInstance() method
    private static JPanelReportsAppAtt panelRepAppAttSingInst;
    
         //gets months from the abstract scheduling class to keep consistency, some routines rely on the date 
        //given as Jan Feb Mar etc
      JComboBox cmbMonth = new JComboBox(MainAbsScheduling.getMonthsArr());

        //gets years from the abstract scheduling class to keep consistency
       JComboBox cmbYear = new JComboBox(MainAbsScheduling.getYearArr());
       
        String[]  ArrAppStat = {"All Appointments","Attended", "Cancelled", "Missed"};
        JComboBox cmbAppStatus = new JComboBox(ArrAppStat);
    
    private JPanelReportsAppAtt(){
        
        JLabel lblMessage = new JLabel ("Report all Appointments for the month of...");
        JPartPanelPadding topDetail = new JPartPanelPadding(lblMessage);
        
        JButton btnRunReport = new JButton ("Run report");
      //act listener called with the text out of the title label (to identify which report is being run), the selected month and year from
      //the current panel being worked on... which is passed into this class as an object
      //the current panel is a singleton dp
        btnRunReport.addActionListener (new ActListRunReport(lblMessage.getText(), cmbMonth.getSelectedItem().toString(), cmbYear.getSelectedItem().toString()));
        
         JPartPanelPadding bottomDetail = new JPartPanelPadding(cmbYear);
        JPartPanelPadding westDetail = new JPartPanelPadding(cmbMonth);
        
        
        
        //created with the instance of it so that its components such as comboboxes etc can be accessed
        //super("Report all Appointments for the month of...", JPanelReportsAppAtt.getInstance());
       
        JPartPanelPadding eastDetail = new JPartPanelPadding(cmbAppStatus);
        
        
         setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
    setLayout (new BorderLayout ());
       
     
       add(topDetail, BorderLayout.NORTH);
       //add(cmbMonth, BorderLayout.WEST);
       //add(cmbYear, BorderLayout.CENTER);
       add(eastDetail, BorderLayout.EAST);
       add(westDetail, BorderLayout.WEST);
       add(bottomDetail, BorderLayout.CENTER);
       add(btnRunReport, BorderLayout.SOUTH);
       //add(butAndJText, BorderLayout.SOUTH);
        
       // super.add(eastDetail, BorderLayout.EAST);
        
        
    }
    
    public static JPanelReportsAppAtt getInstance(){
        if (panelRepAppAttSingInst == null){
            panelRepAppAttSingInst = new JPanelReportsAppAtt();
        }
        return panelRepAppAttSingInst;
    }
    
}
