
package pkg15070779drsappsystem.JPanels;

import java.awt.BorderLayout;
import pkg15070779drsappsystem.AbstractClasses.MainAbsSystemUserComponent;
import pkg15070779drsappsystem.MainClasses.MainPatient;
import pkg15070779drsappsystem.MainClasses.MainSecretary;


public abstract class AbsApplyButtonsToPatRecPanel {
    
    
    public static void setButtonsToPatientRecordJPanel(){
        
        
        //gets the buttons to apply them
        JPanelPatientRecButPanSEC secretaryButtons = JPanelPatientRecButPanSEC.getInstance();
        JPanelPatientRecButPanPAT patientButtons = JPanelPatientRecButPanPAT.getInstance();
        JPanelPatientRecordSecView JPanelRef = JPanelPatientRecordSecView.getInstance();
        
          //same screen as secretary sees, so the patient buttons only display if a patient has logged on
        if (MainAbsSystemUserComponent.currentSystemUser instanceof MainPatient){
            
            
            JPanelRef.remove(secretaryButtons);
            
            JPanelRef.add(patientButtons, BorderLayout.CENTER);
            System.out.println("I have fired from patient");
        }
        
        if (MainAbsSystemUserComponent.currentSystemUser instanceof MainSecretary){
            JPanelRef.remove(patientButtons);
            JPanelRef.add(secretaryButtons, BorderLayout.CENTER);
             System.out.println("I have fired from secretary");
        }
        
        
    }
    
}
