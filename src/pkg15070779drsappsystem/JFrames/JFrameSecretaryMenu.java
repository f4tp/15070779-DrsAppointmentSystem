package pkg15070779drsappsystem.JFrames;
import pkg15070779drsappsystem.ActionListeners.ActListRunReport;
import pkg15070779drsappsystem.ActionListeners.ActLisExitProg;
import java.awt.*;
import javax.swing.*;
import pkg15070779drsappsystem.ActionListeners.ActListDispAllAvailApps;
import pkg15070779drsappsystem.ActionListeners.ActListLogOut;
import pkg15070779drsappsystem.JPanels.JPanelSecretaryFindPat;
import pkg15070779drsappsystem.JPanels.JPanelNewAppButPan;
import pkg15070779drsappsystem.JPanels.JPanelNewAppointment;
import pkg15070779drsappsystem.JPanels.JPanelPatientAddDoctor;
import pkg15070779drsappsystem.JPanels.JPartPanelPatRecButPanSEC;
import pkg15070779drsappsystem.JPanels.JPanelPatRecordSecView;
import pkg15070779drsappsystem.JPanels.JPanelReportsAppAtt;
import pkg15070779drsappsystem.JPanels.JPanelReportsDrsApps;
import pkg15070779drsappsystem.JPanels.JPanelReportsPresrcips;
import pkg15070779drsappsystem.JPanels.JPanelAppsShowAllForPatient;
import pkg15070779drsappsystem.JPanels.JPanelAppsShowAllAvailable;
import static pkg15070779drsappsystem.JPanels.JPartPanelSelDrComboFlow.setDrComboBox;
//
public class JFrameSecretaryMenu extends JFrame {
    //JDesktopPane desktop;
    //singleton DP, only one instance is ever needed as only one sec logs in at once
    private static JFrameSecretaryMenu SecMenuSingInst;
    
    //holds the string to tell the menu which south border to display
    private static String currenSecNorthBordPanel; 
    
    
    private JFrameSecretaryMenu(){
        super ("Secretary menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar secMenBar = new JMenuBar();
        setJMenuBar(secMenBar);
        
        JMenu fileMenu = new JMenu("File");
        secMenBar.add(fileMenu);
        
        JMenuItem logOutItem = new JMenuItem ("Logout");
        //logOutItem.addActionListener(new ActLisExitProg ());
        logOutItem.addActionListener(new ActListLogOut());
        fileMenu.add(logOutItem);
        
        JMenuItem exitItem = new JMenuItem ("Exit");
        exitItem.addActionListener(new ActLisExitProg ());
        fileMenu.add(exitItem);
        
        
        JMenu appsMenu = new JMenu("Appointments");
        secMenBar.add(appsMenu);
        
        JMenuItem newApp = new JMenuItem ("New Appointment");
        newApp.addActionListener(new ActListRunReport("FindPatients"));
        appsMenu.add(newApp);
        
        JMenuItem showAvailApps = new JMenuItem ("Show All Available Appointments");
        showAvailApps.addActionListener(new ActListDispAllAvailApps());
        appsMenu.add(showAvailApps);
        
        JMenu patientMenu = new JMenu("Patients");
        secMenBar.add(patientMenu);
        
        JMenuItem findPatient = new JMenuItem ("Find Patient");
        findPatient.addActionListener(new ActListRunReport("FindPatients"));
        patientMenu.add(findPatient);
        
        JMenu reportMenu = new JMenu("Reports");
        secMenBar.add(reportMenu);
        
        
        
        JMenuItem runReportAppsPerDoc = new JMenuItem ("Monthly Appointments per Dr Reports");
        runReportAppsPerDoc.addActionListener(new ActListRunReport("MonthAppPerDr")); 
        reportMenu.add(runReportAppsPerDoc);
        
        JMenuItem runReportAppsAtt = new JMenuItem ("Monthly Appointment Attendence Reports");
        runReportAppsAtt.addActionListener(new ActListRunReport("MonthlyApssAtt")); 
        reportMenu.add(runReportAppsAtt);
        
        JMenuItem runReportPrescs = new JMenuItem ("Monthly Prescriptions Reports");
        runReportPrescs.addActionListener(new ActListRunReport("MonthlyPrescs"));
        reportMenu.add(runReportPrescs);        
                
        setLayout (new BorderLayout ());
        
     
        
         //code below sets the menu to the screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        pack();
        setBounds(0,0,screenSize.width, screenSize.height-40); //minus 40 for the task bar (which we want present)
      
        setVisible(true);
        
    }
 
    //singleton design pattern as was struggling working with the instance created in
    //the AAAmain class
    public static JFrameSecretaryMenu getInstance(){
        if (SecMenuSingInst == null){
            SecMenuSingInst = new JFrameSecretaryMenu();
        }
        return SecMenuSingInst;
    }
    
    
    public void setSecSouthBorderString(String paneltoset){
        currenSecNorthBordPanel = paneltoset;
        SecMenuSingInst.setSecNorthBorderPanel();
    }
    
    private void setSecNorthBorderPanel(){
         //@@@@@@@@@@ TO DO - refactoring all this needs to be done dynamically, 
         //create the objects when they are called (factory design pattern I think)
        JPanelReportsAppAtt JPanelAppsAtt = JPanelReportsAppAtt.getInstance();
        JPanelReportsDrsApps JPanelDrsApps = JPanelReportsDrsApps.getInstance(); 
        JPanelReportsPresrcips JPanelPrescs= JPanelReportsPresrcips.getInstance();
        JPanelSecretaryFindPat JPanelFindPat = JPanelSecretaryFindPat.getInstance();
        JPanelPatRecordSecView JPanelPatrecNorth = JPanelPatRecordSecView.getInstance();
        //JPanelPatientRecButPanSEC JPanelPatrecSouth = JPartPanelPatRecButPanSEC.getInstance();
        JPanelPatientAddDoctor JPanelPatAddDoc = JPanelPatientAddDoctor.getInstance();
        JPanelNewAppointment JPanNewApp = JPanelNewAppointment.getInstance();
        JPanelNewAppButPan JPanNewAppButPanel = JPanelNewAppButPan.getInstance();
        JPanelAppsShowAllAvailable JPanViewAllApps = JPanelAppsShowAllAvailable.getInstance();
        JPanelAppsShowAllForPatient JpanShowApps = JPanelAppsShowAllForPatient.getInstance();
        
        //"FindPatients"
        if (currenSecNorthBordPanel == "MonthlyApssAtt"){
            JPanelDrsApps.setVisible(false);
            JPanelPrescs.setVisible(false);
            JPanelFindPat.setVisible(false);
            JPanelPatrecNorth.setVisible(false);
            //JPanelPatrecSouth.setVisible(false);
            JPanelPatAddDoc.setVisible(false);
            JPanNewApp.setVisible(false);
            JPanNewAppButPanel.setVisible(false);
            JPanViewAllApps.setVisible(false);
            JpanShowApps.setVisible(false);
            JPanelAppsAtt.setVisible(true);
            
            SecMenuSingInst.add(JPanelAppsAtt, BorderLayout.NORTH);
      
        }
       
        if (currenSecNorthBordPanel == "MonthAppPerDr"){
            JPanelAppsAtt.setVisible(false);
            JPanelPrescs.setVisible(false);
            JPanelFindPat.setVisible(false);
            JPanelPatrecNorth.setVisible(false);
            //JPanelPatrecSouth.setVisible(false);
             JPanelPatAddDoc.setVisible(false);
             JPanNewApp.setVisible(false);
             JPanNewAppButPanel.setVisible(false);
             JPanViewAllApps.setVisible(false);
             JpanShowApps.setVisible(false);
            JPanelDrsApps.setVisible(true);
           
            SecMenuSingInst.add(JPanelDrsApps, BorderLayout.NORTH);
            
        }
        
        if (currenSecNorthBordPanel == "MonthlyPrescs"){
            JPanelAppsAtt.setVisible(false);
            JPanelDrsApps.setVisible(false);
            JPanelFindPat.setVisible(false);
            JPanelPatrecNorth.setVisible(false);
           // JPanelPatrecSouth.setVisible(false);
             JPanelPatAddDoc.setVisible(false);
             JPanNewApp.setVisible(false);
             JPanNewAppButPanel.setVisible(false);
             JPanViewAllApps.setVisible(false);
             JpanShowApps.setVisible(false);
            JPanelPrescs.setVisible(true);
            
            SecMenuSingInst.add(JPanelPrescs, BorderLayout.NORTH);
                
        }
        
        if (currenSecNorthBordPanel == "FindPatients"){
            JPanelAppsAtt.setVisible(false);
            JPanelDrsApps.setVisible(false);
            JPanelPrescs.setVisible(false);
            JPanelPatrecNorth.setVisible(false);
           // JPanelPatrecSouth.setVisible(false);
             JPanelPatAddDoc.setVisible(false);
             JPanNewApp.setVisible(false);
             JPanNewAppButPanel.setVisible(false);
             JPanViewAllApps.setVisible(false);
             JpanShowApps.setVisible(false);
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
            
            JPanelPatrecNorth.setVisible(true);
            JPanelPatrecNorth.setUpdateTextFields();
            //JPanelPatrecSouth.setVisible(true);
            SecMenuSingInst.add(JPanelPatrecNorth, BorderLayout.NORTH);
            //SecMenuSingInst.add(JPanelPatrecSouth, BorderLayout.CENTER);
            
            
        }
        
         if (currenSecNorthBordPanel == "AddDocsPanel"){
            JPanelDrsApps.setVisible(false);
            JPanelPrescs.setVisible(false);
            JPanelFindPat.setVisible(false);
            JPanelPatrecNorth.setVisible(false);
            //JPanelPatrecSouth.setVisible(false);
            JPanelAppsAtt.setVisible(false);
            JPanNewApp.setVisible(false);
            JPanNewAppButPanel.setVisible(false);
            JPanViewAllApps.setVisible(false);
            JpanShowApps.setVisible(false);
            
            JPanelPatAddDoc.setVisible(true);
            SecMenuSingInst.add(JPanelPatAddDoc, BorderLayout.NORTH);
      
        }
         
          if (currenSecNorthBordPanel == "AddnewAppointmentPanel"){
             JPanelDrsApps.setVisible(false);
            JPanelPrescs.setVisible(false);
            JPanelFindPat.setVisible(false);
            JPanelPatrecNorth.setVisible(false);
            //JPanelPatrecSouth.setVisible(false);
            JPanelAppsAtt.setVisible(false);
            JPanelPatAddDoc.setVisible(false);
            JPanViewAllApps.setVisible(false);
            JpanShowApps.setVisible(false);
             
             
            
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
            //JPanelPatrecSouth.setVisible(false);
            JPanelAppsAtt.setVisible(false);
            JPanNewApp.setVisible(false);
            JPanNewAppButPanel.setVisible(false);
            JPanelPatAddDoc.setVisible(false);
            JpanShowApps.setVisible(false);
            
            JPanViewAllApps.setVisible(true);
            SecMenuSingInst.add(JPanViewAllApps, BorderLayout.NORTH);
      
        }
          
           if (currenSecNorthBordPanel == "ShowAvailApps"){
            JPanelDrsApps.setVisible(false);
            JPanelPrescs.setVisible(false);
            JPanelFindPat.setVisible(false);
            JPanelPatrecNorth.setVisible(false);
            //JPanelPatrecSouth.setVisible(false);
            JPanelAppsAtt.setVisible(false);
            JPanNewApp.setVisible(false);
            JPanNewAppButPanel.setVisible(false);
            JPanelPatAddDoc.setVisible(false);
            
            
            JPanViewAllApps.setVisible(false);
            JpanShowApps.setVisible(true);
            
            //updates teh combobox on this form with Drs registered on teh system (when it is called);
            //this form contains two instances of the same JPanel - dates from and to
            setDrComboBox();
            SecMenuSingInst.add(JpanShowApps, BorderLayout.NORTH);
      
        }
        
        //these have to be called otherwise the Jframe doesn't refresh and
         //the menu doesn't display
        revalidate();
        repaint();
      
    }
    public static void setVisibility(boolean vis){
        
        SecMenuSingInst.setVisible(vis);
        
    }
    
      
    
}
