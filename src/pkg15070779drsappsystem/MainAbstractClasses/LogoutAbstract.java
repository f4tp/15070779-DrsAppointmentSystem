
package pkg15070779drsappsystem.MainAbstractClasses;

import pkg15070779drsappsystem.JFrames.JFrameDoctorMenu;
import pkg15070779drsappsystem.JFrames.JFrameLoginScreen;
import pkg15070779drsappsystem.JFrames.JFramePatientMenu;
import pkg15070779drsappsystem.JFrames.JFramePharmacistMenu;
import pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu;
import pkg15070779drsappsystem.JPanels.JPanelAppAddPrescrip;
import pkg15070779drsappsystem.JPanels.JPanelAppAmendDocView;
import pkg15070779drsappsystem.JPanels.JPanelAppAmendSecView;
import pkg15070779drsappsystem.JPanels.JPanelAppsShowAvaialble;
import pkg15070779drsappsystem.JPanels.JPanelAppsShowAllForPatientDOC;
import pkg15070779drsappsystem.JPanels.JPanelAppsShowAllForPatientSEC;
import pkg15070779drsappsystem.JPanels.JPanelLoginScreen;
import pkg15070779drsappsystem.JPanels.JPanelNewAppButPan;
import pkg15070779drsappsystem.JPanels.JPanelNewAppointment;
import pkg15070779drsappsystem.JPanels.JPanelPatFindDocView;
import pkg15070779drsappsystem.JPanels.JPanelPatFindSecView;
import pkg15070779drsappsystem.JPanels.JPanelPatRecordDocView;
import pkg15070779drsappsystem.JPanels.JPanelPatRecordSecView;
import pkg15070779drsappsystem.JPanels.JPanelPatientAddDoctor;
import pkg15070779drsappsystem.JPanels.JPanelPresDisplayFromTo;
import pkg15070779drsappsystem.JPanels.JPanelReportsAppAtt;
import pkg15070779drsappsystem.JPanels.JPanelReportsDrsApps;
import pkg15070779drsappsystem.JPanels.JPanelReportsPresrcips;
import pkg15070779drsappsystem.JPanels.JPartPanelTextAreaMonthReports;
import pkg15070779drsappsystem.JPanels.JPartPanelTextAreaPrintPatRec;
import pkg15070779drsappsystem.JPanels.JPartPanelTextAreaPrintPresDetail;
import pkg15070779drsappsystem.MainClasses.Appointment;
import pkg15070779drsappsystem.MainClasses.SysUserDoctor;
import pkg15070779drsappsystem.MainClasses.SysUserPatient;
import pkg15070779drsappsystem.MainClasses.Prescription;
import pkg15070779drsappsystem.MainClasses.SysUserSecretary;

public abstract class LogoutAbstract {
    
    public static void Logout(){
//set all static global users and people objetcs that were being worked on to null
        
        SystemUserComponent.currentSystemUser = null;
        SysUserPatient.currentPatient = null;
        Appointment.currentAppointment = null;
        SysUserDoctor.currentDoctor = null;
        SysUserSecretary.currentSecretary = null;
        Prescription.currentPrescriptionList = null;
    
        
 //set all JFrames to invisible
        JFrameSecretaryMenu instHolder = JFrameSecretaryMenu.getInstance();
        instHolder.setVisible(false);
        
        JFrameDoctorMenu instHolderr = JFrameDoctorMenu.getInstance();
        instHolderr.setVisible(false);
        
        JFramePatientMenu instHolderrr = JFramePatientMenu.getInstance();
        instHolderrr.setVisible(false);
        
        JFramePharmacistMenu instHolderrrr = JFramePharmacistMenu.getInstance();
        instHolderrrr.setVisible(false);
        
        
 //all secretary screens to make invisible
        
        JPanelReportsAppAtt JPanelAppsAtt = JPanelReportsAppAtt.getInstance();
        JPanelAppsAtt.setVisible(false);
        JPanelReportsDrsApps JPanelDrsApps = JPanelReportsDrsApps.getInstance(); 
        JPanelDrsApps.setVisible(false);
        JPanelReportsPresrcips JPanelPrescs= JPanelReportsPresrcips.getInstance();
        JPanelPrescs.setVisible(false);
        JPanelPatFindSecView JPanelFindPat = JPanelPatFindSecView.getInstance();
       JPanelFindPat .setVisible(false);
        JPanelPatRecordSecView JPanelPatrecNorth = JPanelPatRecordSecView.getInstance();
        JPanelPatrecNorth.setVisible(false);
        JPanelPatientAddDoctor JPanelPatAddDoc = JPanelPatientAddDoctor.getInstance();
        JPanelPatAddDoc.setVisible(false);
        JPanelNewAppointment JPanNewApp = JPanelNewAppointment.getInstance();
        JPanNewApp.setVisible(false);
        JPanelNewAppButPan JPanNewAppButPanel = JPanelNewAppButPan.getInstance();
        JPanNewAppButPanel.setVisible(false);
        JPanelAppsShowAllForPatientSEC JPanViewAllApps = JPanelAppsShowAllForPatientSEC.getInstance();
       JPanViewAllApps .setVisible(false);
        JPanelAppsShowAvaialble JpanShowApps = JPanelAppsShowAvaialble.getInstance();
        JpanShowApps.setVisible(false);
        JPartPanelTextAreaMonthReports JPanTextFieldForReports = JPartPanelTextAreaMonthReports.getInstance();
        JPanTextFieldForReports.setVisible(false);
        JPanelAppAmendSecView JPanAmendApp = JPanelAppAmendSecView.getInstance();
        JPanelPatFindDocView inst = JPanelPatFindDocView.getInstance();
         JPanTextFieldForReports.setVisible(false);
         JPanelAppAddPrescrip jpanAddpresSingInst = JPanelAppAddPrescrip.getInstance();
     
 //doctors screens to make invisible
        JPanelPatFindDocView JPanelFindPatDoc = JPanelPatFindDocView.getInstance();
        JPanelPatRecordDocView jpanPatRecDocViewSingInst = JPanelPatRecordDocView.getInstance();
        JPanelAppsShowAllForPatientDOC JPanViewAllAppsDoc = JPanelAppsShowAllForPatientDOC.getInstance();
         JPanelAppAmendDocView JPanAmendAppDoc = JPanelAppAmendDocView.getInstance();
          jpanPatRecDocViewSingInst.setVisible(false);
         JPanViewAllAppsDoc.setVisible(false);
          JPanAmendAppDoc.setVisible(false);
          JPanelFindPatDoc.setVisible(false); 
        jpanAddpresSingInst.setVisible(false);
        
//pharmacist panels make invisible
        JPanelPresDisplayFromTo presDis = JPanelPresDisplayFromTo.getInstance();
        presDis.setVisible(false);
        JPartPanelTextAreaPrintPresDetail textarsingins = JPartPanelTextAreaPrintPresDetail.getInstance();
        textarsingins.setVisible(false);
   
        
 //clears the Jtextholder that updates with the patient's record details, when they logout
        JPartPanelTextAreaPrintPatRec refHolder = JPartPanelTextAreaPrintPatRec.getInstance();
        refHolder.setJtextArea("");
        
//clears the Jtextholder that updates with the report details, when the sec logs out
        JPartPanelTextAreaMonthReports refHoldersec = JPartPanelTextAreaMonthReports.getInstance();
        refHoldersec.setJtextArea("");
    
//set login screen back to visible
        JFrameLoginScreen loginInstance = JFrameLoginScreen.getInstance();
        loginInstance.setVisible(true);
        JPanelLoginScreen tempLoginJPan = JPanelLoginScreen.getInstance();
        tempLoginJPan.updateLogintext();
    }
    
}
