
package pkg15070779drsappsystem.JPanels;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import static pkg15070779drsappsystem.JPanels.JPartPanelTextAreaPrintPatRec.BtutextAreaSingInst;

public class JPartPanelTextAreaPrintPresDetail extends JPanel {
    
    public static JPartPanelTextAreaPrintPresDetail BtutextAreaSingInst;
    //JButton btnRunReport = new JButton ("Run report");
    JTextArea jtaReportResults = new JTextArea();
    
        private JPartPanelTextAreaPrintPresDetail (){
        setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
       // add(btnRunReport);
       jtaReportResults.setLineWrap(true);
        add(jtaReportResults);
        
       //btnRunReport.addActionListener (new ActListRunReport(paneltitle));
    }
        
        
          //singleton DP
    public static JPartPanelTextAreaPrintPresDetail getInstance(){
        if(BtutextAreaSingInst == null){
            BtutextAreaSingInst = new JPartPanelTextAreaPrintPresDetail();
            
        }
        
        return BtutextAreaSingInst;
    }
    
    public void setJtextArea(String texttoset){
        jtaReportResults.setText("");
        jtaReportResults.setText(texttoset);
        //jtaReportResults.append(texttoset);
    }
    
}
