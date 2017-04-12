
package pkg15070779drsappsystem.JPanels;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
//import pkg15070779drsappsystem.ActionListeners.ActListRunReport;

public class JPartPanelTextAreaMonthReports  extends JPanel{
    
    public static JPartPanelTextAreaMonthReports BtutextAreaSingInst;
    //JButton btnRunReport = new JButton ("Run report");
    JTextArea jtaReportResults = new JTextArea();
    
    
    private JPartPanelTextAreaMonthReports (){
        setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
       // add(btnRunReport);
        add(jtaReportResults);
        
       //btnRunReport.addActionListener (new ActListRunReport(paneltitle));
    }
    
    
    //singleton DP
    public static JPartPanelTextAreaMonthReports getInstance(){
        if(BtutextAreaSingInst == null){
            BtutextAreaSingInst = new JPartPanelTextAreaMonthReports();
            
        }
        
        return BtutextAreaSingInst;
    }
    
    public void setJtextArea(String texttoset){
        jtaReportResults.setText("");
        jtaReportResults.setText(texttoset);
        //jtaReportResults.append(texttoset);
    }
    
}
