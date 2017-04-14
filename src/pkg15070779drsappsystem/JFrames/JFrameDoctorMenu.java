
package pkg15070779drsappsystem.JFrames;

import pkg15070779drsappsystem.ActionListeners.ActListSetSecJFramePARTofFACTORYsec;
import pkg15070779drsappsystem.ActionListeners.ActLisExitProg;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import pkg15070779drsappsystem.ActionListeners.ActListDisplayFindPatDocView;
import pkg15070779drsappsystem.ActionListeners.ActListLogOut;
import pkg15070779drsappsystem.JPanels.JPanelPatFindDocView;
import pkg15070779drsappsystem.JPanels.JPanelPatRecordDocView;


public class JFrameDoctorMenu extends JFrame {
    
     //singleton DP, only one instance is ever needed as only one sec logs in at once
    private static JFrameDoctorMenu DoctMenSingInst;
    
      
    //private static JFrameSecretaryMenu SecMenuSingInst;
    
    //holds the string to tell the menu which south border to display
    private static String currenDocNorthBordPanel; 
    
    private JFrameDoctorMenu(){
        super ("Doctor's menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar docMenBar = new JMenuBar();
        setJMenuBar(docMenBar);
        
        JMenu fileMenu = new JMenu("File");
        docMenBar.add(fileMenu);
        
         JMenuItem logOutItem = new JMenuItem ("Logout");
        //logOutItem.addActionListener(new ActLisExitProg ());
        logOutItem.addActionListener(new ActListLogOut());
        fileMenu.add(logOutItem);
        
        JMenuItem exitItem = new JMenuItem ("Exit");
        exitItem.addActionListener(new ActLisExitProg ());
        fileMenu.add(exitItem);
        
        JMenu patientMenu = new JMenu("Patients");
        docMenBar.add(patientMenu);
        
        JMenuItem findPatient = new JMenuItem ("Find Patient");
        findPatient.addActionListener(new ActListDisplayFindPatDocView("FindPatients"));
        patientMenu.add(findPatient);
        
        //lays out the frame using thsi abstract class
        JFrameAbsBorLayFillScreen.applyLayout(this);
        /*
        setLayout (new BorderLayout ());
        
         //code below sets the menu to the screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        pack();
        setBounds(0,0,screenSize.width, screenSize.height-40); //minus 40 for the task bar (which we want present)
      
        setVisible(true);
        */
        
        
        
        
        
        
        
    }
    
    
    private void setDocNorthBorderPanel(){
        JPanelPatFindDocView JPanelFindPat = JPanelPatFindDocView.getInstance();
        JPanelPatRecordDocView jpanPatRecDocViewSingInst = JPanelPatRecordDocView.getInstance();
                
                
        
          if (currenDocNorthBordPanel == "FindPatients"){
              jpanPatRecDocViewSingInst.setVisible(false);
              
              
             JPanelFindPat.setVisible(true); 
             DoctMenSingInst.add(JPanelFindPat, BorderLayout.NORTH);
            
            
            
          }
          
           if (currenDocNorthBordPanel == "DisplayPatientDetails"){
             JPanelFindPat.setVisible(false);
             
             
             jpanPatRecDocViewSingInst.setVisible(true);
             jpanPatRecDocViewSingInst.setUpdateTextFields();
            
            DoctMenSingInst.add(jpanPatRecDocViewSingInst, BorderLayout.NORTH);
          }
          
          
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
    
    public void setVisibility(boolean vis){
        
        this.setVisible(vis);
        
    }
    
    public void setDocSouthBorderString(String paneltoset){
        currenDocNorthBordPanel = paneltoset;
        DoctMenSingInst.setDocNorthBorderPanel();
    }
    
    
}
