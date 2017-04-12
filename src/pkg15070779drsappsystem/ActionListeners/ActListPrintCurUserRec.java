
package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkg15070779drsappsystem.JPanels.JPartPanelTextAreaMonthReports;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsSystemUserComponent;

public class ActListPrintCurUserRec implements ActionListener {
    
    public ActListPrintCurUserRec(){
        
    }
    
     

    @Override
    public void actionPerformed(ActionEvent e) {
     
        PrintCurrentUserRecord();
        this.outputToWidget();
    }
    
    public void outputToWidget(){
        JPartPanelTextAreaMonthReports JTASingInst = JPartPanelTextAreaMonthReports.getInstance();
           String tempDetails = MainAbsSystemUserComponent.currentSystemUser.toString();
        JTASingInst.setJtextArea(tempDetails);
    }
    
    public static void PrintCurrentUserRecord(){
        //polymorphism - the overridden toString routine will display (which will be overridden in each subclass)
        System.out.println(MainAbsSystemUserComponent.currentSystemUser.toString());
        
       
         
    }
    
}
