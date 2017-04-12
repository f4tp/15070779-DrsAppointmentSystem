
package pkg15070779drsappsystem.JPanels;

import java.awt.BorderLayout;
import pkg15070779drsappsystem.MainAbstractClasses.MainAbsSystemUserComponent;
import pkg15070779drsappsystem.MainClasses.MainPatient;
import pkg15070779drsappsystem.MainClasses.MainSecretary;


public abstract class ZDELETE_AbsApplyButtonsToPatRecPanel {
    
    
    public static void setButtonsToPatientRecordJPanel(){
        
   //@@@@@NTD - this is a redundant panel - delete     
        //gets the buttons to apply them
        JPartPanelPatRecButPanSEC secretaryButtons = JPartPanelPatRecButPanSEC.getInstance();
        JPartPanelPatRecButPanPAT patientButtons = JPartPanelPatRecButPanPAT.getInstance();
        JPanelPatRecordSecView JPanelRef = JPanelPatRecordSecView.getInstance();
        
          //same screen as secretary sees, so the patient buttons only display if a patient has logged on
        if (MainAbsSystemUserComponent.currentSystemUser instanceof MainPatient){
            
            
            JPanelRef.remove(secretaryButtons);
            
            JPanelRef.add(patientButtons, BorderLayout.CENTER);
           
        }
        
        if (MainAbsSystemUserComponent.currentSystemUser instanceof MainSecretary){
            JPanelRef.remove(patientButtons);
            JPanelRef.add(secretaryButtons, BorderLayout.CENTER);

        }
        
        
    }
    
}
