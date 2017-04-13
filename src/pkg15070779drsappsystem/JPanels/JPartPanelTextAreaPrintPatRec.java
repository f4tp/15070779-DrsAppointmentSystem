
package pkg15070779drsappsystem.JPanels;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JPartPanelTextAreaPrintPatRec extends JPanel{
    
     public static JPartPanelTextAreaPrintPatRec BtutextAreaSingInst;
    //JButton btnRunReport = new JButton ("Run report");
    JTextArea jtaReportResults = new JTextArea();
    
    
    private JPartPanelTextAreaPrintPatRec (){
        setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
       // add(btnRunReport);
        add(jtaReportResults);
        
       //btnRunReport.addActionListener (new ActListRunReport(paneltitle));
    }
    
    
    //singleton DP
    public static JPartPanelTextAreaPrintPatRec getInstance(){
        if(BtutextAreaSingInst == null){
            BtutextAreaSingInst = new JPartPanelTextAreaPrintPatRec();
            
        }
        
        return BtutextAreaSingInst;
    }
    
    public void setJtextArea(String texttoset){
        jtaReportResults.setText("");
        jtaReportResults.setText(texttoset);
        //jtaReportResults.append(texttoset);
    }
    
}
