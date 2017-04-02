package pkg15070779drsappsystem;
import java.awt.*;
import javax.swing.*;
//
public class JFrameSecretaryMenu extends JFrame {
    //JDesktopPane desktop;
    //singleton DP, only one instance is ever needed as only one sec logs in at once
    private static JFrameSecretaryMenu SecMenuSingInst;
    
    //holds the string to tell the menu which south border to display
    private static String currentSouthBordPanel; 
    
    
    private JFrameSecretaryMenu(){
        super ("Secretary menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar secMenBar = new JMenuBar();
        setJMenuBar(secMenBar);
        
        JMenu fileMenu = new JMenu("File");
        secMenBar.add(fileMenu);
        
        JMenuItem exitItem = new JMenuItem ("Exit");
        exitItem.addActionListener(new ActLisExitProg ());
        fileMenu.add(exitItem);
        
        
        JMenu appsMenu = new JMenu("Appointments");
        secMenBar.add(appsMenu);
        
        JMenuItem newApp = new JMenuItem ("New Appointment");
        newApp.addActionListener(new ActListRunReport("FindPatients"));
        appsMenu.add(newApp);
        
        JMenuItem showAvailApps = new JMenuItem ("Show All Available Appointments");
        //showAvailApps.addActionListener(new ActListRunReport("FindPatients"));
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
    
    
    public void setSouthBorderString(String paneltoset){
        currentSouthBordPanel = paneltoset;
        SecMenuSingInst.setSouthBorderPanel();
    }
    
    private void setSouthBorderPanel(){
         //@@@@@@@@@@ all this needs to be done dynamically, create the objects when they are called (factory design pattern I think)
        JPanelReportsAppAtt JPanelAppsAtt = JPanelReportsAppAtt.getInstance();
        JPanelReportsDrsApps JPanelDrsApps = JPanelReportsDrsApps.getInstance(); 
        JPanelReportsPresrcips JPanelPrescs= JPanelReportsPresrcips.getInstance();
        JPanelFindPatient JPanelFindPat = JPanelFindPatient.getInstance();
        //"FindPatients"
        if (currentSouthBordPanel == "MonthlyApssAtt"){
            JPanelDrsApps.setVisible(false);
            JPanelPrescs.setVisible(false);
            JPanelFindPat.setVisible(false);
            JPanelAppsAtt.setVisible(true);
            SecMenuSingInst.add(JPanelAppsAtt, BorderLayout.NORTH);
      
        }
       
        if (currentSouthBordPanel == "MonthAppPerDr"){
            JPanelAppsAtt.setVisible(false);
            JPanelPrescs.setVisible(false);
            JPanelFindPat.setVisible(false);
            JPanelDrsApps.setVisible(true);
            SecMenuSingInst.add(JPanelDrsApps, BorderLayout.NORTH);
            
        }
        
        if (currentSouthBordPanel == "MonthlyPrescs"){
            JPanelAppsAtt.setVisible(false);
            JPanelDrsApps.setVisible(false);
            JPanelFindPat.setVisible(false);
            JPanelPrescs.setVisible(true);
            SecMenuSingInst.add(JPanelPrescs, BorderLayout.NORTH);
                
        }
        
        if (currentSouthBordPanel == "FindPatients"){
            JPanelAppsAtt.setVisible(false);
            JPanelDrsApps.setVisible(false);
            JPanelPrescs.setVisible(false);
            JPanelFindPat.setVisible(true);
            
            SecMenuSingInst.add(JPanelFindPat, BorderLayout.NORTH);
            //SecMenuSingInst.add(new JPanelPatientRecord(),BorderLayout.NORTH);
                
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
