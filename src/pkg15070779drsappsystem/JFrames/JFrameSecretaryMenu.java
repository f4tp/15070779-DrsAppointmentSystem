package pkg15070779drsappsystem.JFrames;
import pkg15070779drsappsystem.ListenersAction.ActListSetSecJFramePARTofFACTORYsec;
import pkg15070779drsappsystem.ListenersAction.ActLisExitProg;
import java.awt.*;
import javax.swing.*;
import pkg15070779drsappsystem.ListenersAction.ActListDisplayJPanAllAvailAppsSec;
import pkg15070779drsappsystem.ListenersAction.ActListLogoutSystem;
import pkg15070779drsappsystem.JPanels.JPanelAppAmendSecView;
import pkg15070779drsappsystem.JPanels.JPanelPatFindSecView;
import pkg15070779drsappsystem.JPanels.JPanelNewAppButPan;
import pkg15070779drsappsystem.JPanels.JPanelNewAppointment;
import pkg15070779drsappsystem.JPanels.JPanelPatientAddDoctor;
import pkg15070779drsappsystem.JPanels.JPanelPatRecordSecView;
import pkg15070779drsappsystem.JPanels.JPanelReportsAppAtt;
import pkg15070779drsappsystem.JPanels.JPanelReportsDrsApps;
import pkg15070779drsappsystem.JPanels.JPanelReportsPresrcips;
import pkg15070779drsappsystem.JPanels.JPanelAppsShowAvaialble;
import pkg15070779drsappsystem.JPanels.JPanelAppsShowAllForPatientSEC;
import static pkg15070779drsappsystem.JPanels.JPartPanelSelDrComboFlow.setDrComboBox;
import pkg15070779drsappsystem.JPanels.JPartPanelTextAreaMonthReports;
import pkg15070779drsappsystem.MainClasses.MainPatient;
//
public class JFrameSecretaryMenu extends JFrame {
    //singleton DP, only one instance is ever needed as only one sec logs in at once
    private static JFrameSecretaryMenu SecMenuSingInst;
    MainPatient currPatientInst;
    
    //holds the string to tell the menu which north border to display
    private static String currenSecNorthBordPanel; 
    
    
    private JFrameSecretaryMenu(){
        super ("Secretary menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar secMenBar = new JMenuBar();
        setJMenuBar(secMenBar);
        
        JMenu fileMenu = new JMenu("File");
        secMenBar.add(fileMenu);
        
        JMenuItem logOutItem = new JMenuItem ("Logout");
        logOutItem.addActionListener(new ActListLogoutSystem());
        fileMenu.add(logOutItem);
        
        JMenuItem exitItem = new JMenuItem ("Exit");
        exitItem.addActionListener(new ActLisExitProg ());
        fileMenu.add(exitItem);
        
        
        JMenu appsMenu = new JMenu("Appointments");
        secMenBar.add(appsMenu);
        
        JMenuItem newApp = new JMenuItem ("New Appointment");
        newApp.addActionListener(new ActListSetSecJFramePARTofFACTORYsec("FindPatients"));
        appsMenu.add(newApp);
        
        JMenuItem showAvailApps = new JMenuItem ("Show All Available Appointments");
        showAvailApps.addActionListener(new ActListDisplayJPanAllAvailAppsSec());
        appsMenu.add(showAvailApps);
        
        JMenu patientMenu = new JMenu("Patients");
        secMenBar.add(patientMenu);
        
        JMenuItem findPatient = new JMenuItem ("Find Patient");
        findPatient.addActionListener(new ActListSetSecJFramePARTofFACTORYsec("FindPatients"));
        patientMenu.add(findPatient);
        
        JMenu reportMenu = new JMenu("Reports");
        secMenBar.add(reportMenu);
       
        JMenuItem runReportAppsPerDoc = new JMenuItem ("Monthly Appointments per Dr Reports");
        runReportAppsPerDoc.addActionListener(new ActListSetSecJFramePARTofFACTORYsec("MonthAppPerDr")); 
        reportMenu.add(runReportAppsPerDoc);
        
        JMenuItem runReportAppsAtt = new JMenuItem ("Monthly Appointment Attendence Reports");
        runReportAppsAtt.addActionListener(new ActListSetSecJFramePARTofFACTORYsec("MonthlyApssAtt")); 
        reportMenu.add(runReportAppsAtt);
        
        JMenuItem runReportPrescs = new JMenuItem ("Monthly Prescriptions Reports");
        runReportPrescs.addActionListener(new ActListSetSecJFramePARTofFACTORYsec("MonthlyPrescs"));
        reportMenu.add(runReportPrescs);        
                
        setLayout (new BorderLayout ());
        
        
         //code below sets the menu to match the screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        pack();
        setBounds(0,0,screenSize.width, screenSize.height-40); //minus 40 for the task bar (which we want present)
      
        setVisible(true);
        
    }
 
    //singleton design pattern 
    public static JFrameSecretaryMenu getInstance(){
        if (SecMenuSingInst == null){
            SecMenuSingInst = new JFrameSecretaryMenu();
        }
        return SecMenuSingInst;
    }
    
    
    public void setSecNorthBorderString(String paneltoset){
        currenSecNorthBordPanel = paneltoset;
        SecMenuSingInst.setSecNorthBorderPanel();
    }
    
    public void setSecNorthBorderStringPatient(String paneltoset, MainPatient patientinvolved){
        
        currenSecNorthBordPanel = paneltoset;
        currPatientInst = patientinvolved;
        SecMenuSingInst.setSecNorthBorderPanel();
    }
    
    private void setSecNorthBorderPanel(){
         //NTD -  refactoring all this needs to be done dynamically, 
         //create the objects when they are called (factory design pattern I think)
         //NTD - create factory from this QUESTION - will visibility be affected if the instance hasn;t been created yet?
         
         //different jpanel objects - all single instances, called then made visible / invisible with user interaction
         //as the user pirplines through the program
        JPanelReportsAppAtt JPanelAppsAtt = JPanelReportsAppAtt.getInstance();
        JPanelReportsDrsApps JPanelDrsApps = JPanelReportsDrsApps.getInstance(); 
        JPanelReportsPresrcips JPanelPrescs= JPanelReportsPresrcips.getInstance();
        JPanelPatFindSecView JPanelFindPat = JPanelPatFindSecView.getInstance();
        JPanelPatRecordSecView JPanelPatrecNorth = JPanelPatRecordSecView.getInstance();
        JPanelPatientAddDoctor JPanelPatAddDoc = JPanelPatientAddDoctor.getInstance();
        JPanelNewAppointment JPanNewApp = JPanelNewAppointment.getInstance();
        JPanelNewAppButPan JPanNewAppButPanel = JPanelNewAppButPan.getInstance();
        JPanelAppsShowAllForPatientSEC JPanViewAllApps = JPanelAppsShowAllForPatientSEC.getInstance();
        JPanelAppsShowAvaialble JpanShowApps = JPanelAppsShowAvaialble.getInstance();
        JPartPanelTextAreaMonthReports JPanTextFieldForReports = JPartPanelTextAreaMonthReports.getInstance();
        JPanelAppAmendSecView JPanAmendApp = JPanelAppAmendSecView.getInstance();
        

        if (currenSecNorthBordPanel == "MonthlyApssAtt"){
            JPanelDrsApps.setVisible(false);
            JPanelPrescs.setVisible(false);
            JPanelFindPat.setVisible(false);
            JPanelPatrecNorth.setVisible(false);
            JPanelPatAddDoc.setVisible(false);
            JPanNewApp.setVisible(false);
            JPanNewAppButPanel.setVisible(false);
            JPanViewAllApps.setVisible(false);
            JpanShowApps.setVisible(false);
            JPanAmendApp.setVisible(false);
            
            JPanelAppsAtt.setVisible(true);
            JPanTextFieldForReports.setVisible(true);
            SecMenuSingInst.add(JPanelAppsAtt, BorderLayout.NORTH);
            SecMenuSingInst.add(JPanTextFieldForReports, BorderLayout.CENTER);
        }
       
        if (currenSecNorthBordPanel == "MonthAppPerDr"){
    
            JPanelAppsAtt.setVisible(false);
            JPanelPrescs.setVisible(false);
            JPanelFindPat.setVisible(false);
            JPanelPatrecNorth.setVisible(false);
             JPanelPatAddDoc.setVisible(false);
             JPanNewApp.setVisible(false);
             JPanNewAppButPanel.setVisible(false);
             JPanViewAllApps.setVisible(false);
             JpanShowApps.setVisible(false);
             JPanAmendApp.setVisible(false);
             
            JPanelDrsApps.setVisible(true);
            JPanTextFieldForReports.setVisible(true);
            SecMenuSingInst.add(JPanelDrsApps, BorderLayout.NORTH);
            SecMenuSingInst.add(JPanTextFieldForReports, BorderLayout.CENTER);
            
        }
        
        if (currenSecNorthBordPanel == "MonthlyPrescs"){
            JPanelAppsAtt.setVisible(false);
            JPanelDrsApps.setVisible(false);
            JPanelFindPat.setVisible(false);
            JPanelPatrecNorth.setVisible(false);
             JPanelPatAddDoc.setVisible(false);
             JPanNewApp.setVisible(false);
             JPanNewAppButPanel.setVisible(false);
             JPanViewAllApps.setVisible(false);
             JpanShowApps.setVisible(false);
             JPanAmendApp.setVisible(false);
             JPanAmendApp.setVisible(false);
             
            JPanelPrescs.setVisible(true);
            JPanTextFieldForReports.setVisible(true);
            SecMenuSingInst.add(JPanelPrescs, BorderLayout.NORTH);
            SecMenuSingInst.add(JPanTextFieldForReports, BorderLayout.CENTER);
                
        }
        
        if (currenSecNorthBordPanel == "FindPatients"){
            JPanelAppsAtt.setVisible(false);
            JPanelDrsApps.setVisible(false);
            JPanelPrescs.setVisible(false);
            JPanelPatrecNorth.setVisible(false);
             JPanelPatAddDoc.setVisible(false);
             JPanNewApp.setVisible(false);
             JPanNewAppButPanel.setVisible(false);
             JPanViewAllApps.setVisible(false);
             JpanShowApps.setVisible(false);
             JPanTextFieldForReports.setVisible(false);
             JPanAmendApp.setVisible(false);
             
            JPanelFindPat.setVisible(true);
            SecMenuSingInst.add(JPanelFindPat, BorderLayout.NORTH);
            
                
        }
   
        if (currenSecNorthBordPanel == "DisplayPatientDetails"){
            JPanelAppsAtt.setVisible(false);
            JPanelPrescs.setVisible(false);
            JPanelFindPat.setVisible(false);
            JPanelDrsApps.setVisible(false);
            JPanelPatAddDoc.setVisible(false);
            JPanNewAppButPanel.setVisible(false);
            JPanNewApp.setVisible(false);
            JPanViewAllApps.setVisible(false);
            JpanShowApps.setVisible(false);
            JPanTextFieldForReports.setVisible(false);
            JPanAmendApp.setVisible(false);
            
            JPanelPatrecNorth.setVisible(true);
            JPanelPatrecNorth.setUpdateTextFields(currPatientInst.getUserName());
            SecMenuSingInst.add(JPanelPatrecNorth, BorderLayout.NORTH);
            //SecMenuSingInst.add(JPanelPatrecSouth, BorderLayout.CENTER);
            
            
        }
        
         if (currenSecNorthBordPanel == "AddDocsPanel"){
            JPanelDrsApps.setVisible(false);
            JPanelPrescs.setVisible(false);
            JPanelFindPat.setVisible(false);
            JPanelPatrecNorth.setVisible(false);
            JPanelAppsAtt.setVisible(false);
            JPanNewApp.setVisible(false);
            JPanNewAppButPanel.setVisible(false);
            JPanViewAllApps.setVisible(false);
            JpanShowApps.setVisible(false);
            JPanTextFieldForReports.setVisible(false);
            JPanAmendApp.setVisible(false);
            
            JPanelPatAddDoc.setVisible(true);
            SecMenuSingInst.add(JPanelPatAddDoc, BorderLayout.NORTH);
      
        }
         
          if (currenSecNorthBordPanel == "AddnewAppointmentPanel"){
             JPanelDrsApps.setVisible(false);
            JPanelPrescs.setVisible(false);
            JPanelFindPat.setVisible(false);
            JPanelPatrecNorth.setVisible(false);
            JPanelAppsAtt.setVisible(false);
            JPanelPatAddDoc.setVisible(false);
            JPanViewAllApps.setVisible(false);
            JpanShowApps.setVisible(false);
            JPanTextFieldForReports.setVisible(false);
            JPanAmendApp.setVisible(false);
       
            JPanNewApp.setVisible(true);
            JPanNewAppButPanel.setVisible(true);
            JPanNewApp.updateForm();
            SecMenuSingInst.add(JPanNewApp, BorderLayout.NORTH);
            SecMenuSingInst.add(JPanNewAppButPanel, BorderLayout.CENTER);
            
      
        }
          
          if (currenSecNorthBordPanel == "DispPatientAppointments"){
            JPanelDrsApps.setVisible(false);
            JPanelPrescs.setVisible(false);
            JPanelFindPat.setVisible(false);
            JPanelPatrecNorth.setVisible(false);
            JPanelAppsAtt.setVisible(false);
            JPanNewApp.setVisible(false);
            JPanNewAppButPanel.setVisible(false);
            JPanelPatAddDoc.setVisible(false);
            JpanShowApps.setVisible(false);
            JPanTextFieldForReports.setVisible(false);
            JPanAmendApp.setVisible(false);
            
            JPanViewAllApps.setVisible(true);
            SecMenuSingInst.add(JPanViewAllApps, BorderLayout.NORTH);
      
        }
          
           if (currenSecNorthBordPanel == "ShowAvailApps"){
            JPanelDrsApps.setVisible(false);
            JPanelPrescs.setVisible(false);
            JPanelFindPat.setVisible(false);
            JPanelPatrecNorth.setVisible(false);
            JPanelAppsAtt.setVisible(false);
            JPanNewApp.setVisible(false);
            JPanNewAppButPanel.setVisible(false);
            JPanelPatAddDoc.setVisible(false);
            JPanTextFieldForReports.setVisible(false);
            JPanViewAllApps.setVisible(false);
            JPanAmendApp.setVisible(false);
            JpanShowApps.setVisible(true);
            
            //updates the combobox on this form with Drs registered on the system (when it is called);
            //this form contains two instances of the same JPanel - dates from and to
            setDrComboBox();
            SecMenuSingInst.add(JpanShowApps, BorderLayout.NORTH);
      
        }
           
           if (currenSecNorthBordPanel == "ShowAmendApps"){
            JPanelDrsApps.setVisible(false);
            JPanelPrescs.setVisible(false);
            JPanelFindPat.setVisible(false);
            JPanelPatrecNorth.setVisible(false);
             JPanelAppsAtt.setVisible(false);
            JPanNewApp.setVisible(false);
            JPanNewAppButPanel.setVisible(false);
            JPanelPatAddDoc.setVisible(false);
            JPanTextFieldForReports.setVisible(false);
            JPanViewAllApps.setVisible(false);
            JpanShowApps.setVisible(false);
            
            JPanAmendApp.setVisible(true);
            //updates the combobox on this form with Drs registered on the system (when it is called);
            //this form contains two instances of the same JPanel - dates from and to
            setDrComboBox();
            SecMenuSingInst.add(JPanAmendApp, BorderLayout.NORTH);
      
        }
           
       
        revalidate();
        repaint();
      
    }
   
}
