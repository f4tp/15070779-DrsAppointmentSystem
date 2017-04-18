
package pkg15070779drsappsystem.ListenersAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkg15070779drsappsystem.JPanels.JPartPanelTextAreaMonthReports;
import pkg15070779drsappsystem.JPanels.JPartPanelTextAreaPrintPatRec;
import pkg15070779drsappsystem.MainAbstractClasses.SystemUserComponent;

public class ActListPrintCurUserRec implements ActionListener {
    
    public ActListPrintCurUserRec(){
        
    }
    
     

    @Override
    public void actionPerformed(ActionEvent e) {
     
        PrintCurrentUserRecord();
        this.outputToWidget();
    }
    
    public void outputToWidget(){
        JPartPanelTextAreaPrintPatRec JTASingInst = JPartPanelTextAreaPrintPatRec.getInstance();
           String tempDetails = SystemUserComponent.currentSystemUser.toString();
           JTASingInst.setVisible(true);
        JTASingInst.setJtextArea(tempDetails);
    }
    
    public static void PrintCurrentUserRecord(){
        //polymorphism - the overridden toString routine will display (which will be overridden in each subclass)
        System.out.println(SystemUserComponent.currentSystemUser.toString());
        
       
         
    }
    
}
