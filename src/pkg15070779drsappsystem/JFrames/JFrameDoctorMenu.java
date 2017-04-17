
package pkg15070779drsappsystem.JFrames;

import pkg15070779drsappsystem.ListenersAction.ActLisExitProg;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import pkg15070779drsappsystem.ListenersAction.ActListDisplayJPanFindPatDocView;
import pkg15070779drsappsystem.ListenersAction.ActListLogoutSystem;
import pkg15070779drsappsystem.JPanels.JPanelAppAddPrescrip;
import pkg15070779drsappsystem.JPanels.JPanelAppAmendDocView;
import pkg15070779drsappsystem.JPanels.JPanelAppsShowAllForPatientDOC;
import pkg15070779drsappsystem.JPanels.JPanelPatFindDocView;
import pkg15070779drsappsystem.JPanels.JPanelPatRecordDocView;
import static pkg15070779drsappsystem.JPanels.JPartPanelSelDrComboFlow.setDrComboBox;
import pkg15070779drsappsystem.MainClasses.MainPatient;


public class JFrameDoctorMenu extends JFrame {
    
     //singleton DP, only one instance is ever needed as only one sec logs in at once
    private static JFrameDoctorMenu DoctMenSingInst;
    MainPatient currPatientInst;
    
    
    //holds the string to tell the menu which south border to display
    private static String currentDocNorthBordPanel; 
    
    private JFrameDoctorMenu(){
        super ("Doctor's menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar docMenBar = new JMenuBar();
        setJMenuBar(docMenBar);
        
        JMenu fileMenu = new JMenu("File");
        docMenBar.add(fileMenu);
        
         JMenuItem logOutItem = new JMenuItem ("Logout");
        logOutItem.addActionListener(new ActListLogoutSystem());
        fileMenu.add(logOutItem);
        
        JMenuItem exitItem = new JMenuItem ("Exit");
        exitItem.addActionListener(new ActLisExitProg ());
        fileMenu.add(exitItem);
        
        JMenu patientMenu = new JMenu("Patients");
        docMenBar.add(patientMenu);
        
        JMenuItem findPatient = new JMenuItem ("Find Patient");
        findPatient.addActionListener(new ActListDisplayJPanFindPatDocView("FindPatients"));
        patientMenu.add(findPatient);
        
        //lays out the frame using thsi abstract class
        JFrameAbsBorLayFillScreen.applyLayout(this);
    
    }
    
    
    private void setDocNorthBorderPanel(){
        JPanelPatFindDocView JPanelFindPat = JPanelPatFindDocView.getInstance();
        JPanelPatRecordDocView jpanPatRecDocViewSingInst = JPanelPatRecordDocView.getInstance();
        JPanelAppsShowAllForPatientDOC JPanViewAllApps = JPanelAppsShowAllForPatientDOC.getInstance();
         JPanelAppAmendDocView JPanAmendApp = JPanelAppAmendDocView.getInstance();
         JPanelAppAddPrescrip jpanAddPresSingInst = JPanelAppAddPrescrip.getInstance();
                
        
          if (currentDocNorthBordPanel == "FindPatients"){
              jpanPatRecDocViewSingInst.setVisible(false);
             JPanViewAllApps.setVisible(false);
             JPanAmendApp.setVisible(false);
             jpanAddPresSingInst.setVisible(false);
          
             JPanelFindPat.setVisible(true); 
             DoctMenSingInst.add(JPanelFindPat, BorderLayout.NORTH);
         
          }
          
           if (currentDocNorthBordPanel == "DisplayPatientDetails"){
             JPanelFindPat.setVisible(false);
             JPanViewAllApps.setVisible(false);
             JPanAmendApp.setVisible(false);
              jpanAddPresSingInst.setVisible(false);
             
             jpanPatRecDocViewSingInst.setVisible(true);
             jpanPatRecDocViewSingInst.setUpdateTextFields(currPatientInst.getUserName());
             DoctMenSingInst.add(jpanPatRecDocViewSingInst, BorderLayout.NORTH);
          }
           
           
        
           if(currentDocNorthBordPanel == "DispPatientAppointments"){
               jpanPatRecDocViewSingInst.setVisible(false); 
               JPanelFindPat.setVisible(false);
               JPanAmendApp.setVisible(false);
                jpanAddPresSingInst.setVisible(false);
         
            JPanViewAllApps.setVisible(true);
            DoctMenSingInst.add(JPanViewAllApps, BorderLayout.NORTH);
               
           }
           
            if (currentDocNorthBordPanel == "ShowAmendApps"){
           JPanelFindPat.setVisible(false); 
            jpanPatRecDocViewSingInst.setVisible(false);
            JPanViewAllApps.setVisible(false);
            jpanAddPresSingInst.setVisible(false);
        
            JPanAmendApp.setVisible(true);
            
            //updates the combobox on this form with Drs registered on the system (when it is called);
            //this form contains two instances of the same JPanel - dates from and to
            setDrComboBox();
            DoctMenSingInst.add(JPanAmendApp, BorderLayout.NORTH);
      
        }
        

        if (currentDocNorthBordPanel == "DisplayAddPresc"){
           JPanelFindPat.setVisible(false); 
            jpanPatRecDocViewSingInst.setVisible(false);
            JPanViewAllApps.setVisible(false);
            JPanAmendApp.setVisible(false);
            
            jpanAddPresSingInst.setVisible(true);
            DoctMenSingInst.add(jpanAddPresSingInst, BorderLayout.NORTH);
        }
            
      //refreshes teh Swing GUI to display changes
        revalidate();
        repaint();
    }
    
    
    //get single instance so no other instances are created
    public static JFrameDoctorMenu getInstance(){
        if (DoctMenSingInst == null){
            DoctMenSingInst = new JFrameDoctorMenu();
                    }
        return DoctMenSingInst;
    }
    
    //public void setVisibility(boolean vis){
        
    //    this.setVisible(vis);
        
   // }
    
    public void setDocSouthBorderString(String paneltoset){
        currentDocNorthBordPanel = paneltoset;
        DoctMenSingInst.setDocNorthBorderPanel();
    }
    
    public void setDocSouthBorderString(String paneltoset, MainPatient patientinvolved){
        
        currentDocNorthBordPanel = paneltoset;
        currPatientInst = patientinvolved;
        DoctMenSingInst.setDocNorthBorderPanel();
    }
    
    
}
