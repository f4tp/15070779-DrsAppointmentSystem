
package pkg15070779drsappsystem.MainAbstractClasses;

import java.awt.BorderLayout;
import pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu;
import pkg15070779drsappsystem.JPanels.JPanelAppAmendSecView;
import pkg15070779drsappsystem.JPanels.JPanelAppsShowAllForDoctor;
import pkg15070779drsappsystem.JPanels.JPanelAppsShowAllForPatient;
import pkg15070779drsappsystem.JPanels.JPanelNewAppButPan;
import pkg15070779drsappsystem.JPanels.JPanelNewAppointment;
import pkg15070779drsappsystem.JPanels.JPanelPatRecordSecView;
import pkg15070779drsappsystem.JPanels.JPanelPatientAddDoctor;
import pkg15070779drsappsystem.JPanels.JPanelReportsAppAtt;
import pkg15070779drsappsystem.JPanels.JPanelReportsDrsApps;
import pkg15070779drsappsystem.JPanels.JPanelReportsPresrcips;
import pkg15070779drsappsystem.JPanels.JPanelSecretaryFindPat;
import pkg15070779drsappsystem.JPanels.JPartPanelTextAreaMonthReports;

public abstract class MainAbsFactoryJPanel {
    
       // JFrameSecretaryMenu jfSecmenuRefHolder;
    
    //all different panels - variable created for each, but will be null until ordered
        JPanelReportsAppAtt JPanelAppsAtt;
        JPanelReportsDrsApps JPanelDrsApps;
        JPanelReportsPresrcips JPanelPrescs;
        JPanelSecretaryFindPat JPanelFindPat;
        JPanelPatRecordSecView JPanelPatrecNorth;
        
        JPanelPatientAddDoctor JPanelPatAddDoc;
        JPanelNewAppointment JPanNewApp;
        JPanelNewAppButPan JPanNewAppButPanel;
        JPanelAppsShowAllForPatient JPanViewAllApps;
        JPanelAppsShowAllForDoctor JpanShowApps;
        JPartPanelTextAreaMonthReports JPanTextFieldForReports;
        JPanelAppAmendSecView JPanAmendApp;
    
    //order a panel by passing teh right panel name into this method
        //NTD - shoudl this be a static method and variables be static? otherwise will have to use polymorphism and make 
        //other classes subclasses to make sure they are the right data type (JPanel I think)
        //when ordered - instatiate the variable so it now exists - lazy instantiation
        //after creating set the visibility of all of the panels, but only if they exists (are not null)
        //then update the correct JFrame
    public void getOrderCurrentPanel(String setuppanal){
         if (setuppanal == "MonthAppPerDr"){
            
            //JPanelAppsAtt.setVisible(false);
           // JPanelPrescs.setVisible(false);
           // JPanelFindPat.setVisible(false);
           // JPanelPatrecNorth.setVisible(false);
           // JPanelPatAddDoc.setVisible(false);
           // JPanNewApp.setVisible(false);
           // JPanNewAppButPanel.setVisible(false);
           // JPanViewAllApps.setVisible(false);
           // JpanShowApps.setVisible(false);
           // JPanAmendApp.setVisible(false);
             
            JPanelDrsApps = JPanelReportsDrsApps.getInstance();
            JPanTextFieldForReports = JPartPanelTextAreaMonthReports.getInstance();
            
            
            //JPanelDrsApps.setVisible(true);
            //JPanTextFieldForReports.setVisible(true);
            
            setPanelVisibleStatus(true, true);
           
            JFrameSecretaryMenu.getInstance().add(JPanelDrsApps, BorderLayout.NORTH);
            JFrameSecretaryMenu.getInstance().add(JPanTextFieldForReports, BorderLayout.CENTER);
             
         }
                
    }
    
    //pass this routine all of the panel visibility status'
    //if the instance variable is not null (exists) it will set the visibility status of it correctly, if no tit will leave it alone so 
    //no runtime errors
    public void setPanelVisibleStatus(Boolean JPanelDrsAppsVis, Boolean JPanTextFieldForReportsVis){
        
        if (JPanelDrsApps != null){
            JPanelDrsApps.setVisible(JPanelDrsAppsVis);
        }
        
        if (JPanTextFieldForReports != null){
            JPanTextFieldForReports.setVisible(JPanTextFieldForReportsVis);
        }
    
    }
    
    //only called when the JPanel is being updated on the Secretary JFrame Menu
    public void setJFrameSecMenu(String paneltoset){
         //jfSecmenuRefHolder. setSecSouthBorderString(paneltoset);
    }
    
    //only called when the JPanel is being updated on the Patient JFrame Menu
     public void setJFramePatient(String paneltoset){
         //jfSecmenuRefHolder. setSecSouthBorderString(paneltoset);
    }
     
      //only called when the JPanel is being updated on the Doctor JFrame Menu
     public void setJFrameDoctor(String paneltoset){
         //jfSecmenuRefHolder. setSecSouthBorderString(paneltoset);
    }
     
      //only called when the JPanel is being updated on the Doctor JFrame Menu
     public void setJFramePharmacist(String paneltoset){
         //jfSecmenuRefHolder. setSecSouthBorderString(paneltoset);
    }
    
}
