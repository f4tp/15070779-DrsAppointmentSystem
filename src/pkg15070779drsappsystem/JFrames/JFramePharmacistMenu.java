package pkg15070779drsappsystem.JFrames;

import pkg15070779drsappsystem.ListenersAction.ActListSetSecJFramePARTofFACTORYsec;
import pkg15070779drsappsystem.ListenersAction.ActLisExitProg;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import pkg15070779drsappsystem.JPanels.JPanelPresDisplayFromTo;
import pkg15070779drsappsystem.ListenersAction.ActListLogoutSystem;
import pkg15070779drsappsystem.ListenersAction.ActListSetSecJFramePARTofFACTORYpharm;

public class JFramePharmacistMenu extends JFrame {
    public static JFramePharmacistMenu jfPharmMenSingInst;
    
        //holds the string to tell the menu which North border to display
    private static String currentPharmNorthBordPanel; 
    
    private  JFramePharmacistMenu(){
        super ("Pharmacist's menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar pharmMenBar = new JMenuBar();
        setJMenuBar(pharmMenBar);
        
        JMenu fileMenu = new JMenu("File");
        pharmMenBar.add(fileMenu);
        

        JMenuItem logOutItem = new JMenuItem ("Logout");
        //logOutItem.addActionListener(new ActLisExitProg ());
        logOutItem.addActionListener(new ActListLogoutSystem());
        fileMenu.add(logOutItem);
        
        JMenuItem exitItem = new JMenuItem ("Exit");
        exitItem.addActionListener(new ActLisExitProg ());
        fileMenu.add(exitItem);
        
        
        JMenu prescriptionMenu = new JMenu("Prescriptions");
        pharmMenBar.add(prescriptionMenu);
        
        JMenuItem resolvePrescriptions = new JMenuItem ("Resolve");
        resolvePrescriptions.addActionListener(new ActListSetSecJFramePARTofFACTORYpharm("ViewPresToResolve"));
        prescriptionMenu.add(resolvePrescriptions);
        
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
    
    public void setVisibility(boolean vis){
        
        this.setVisible(vis);
        
    }
    
    //singleton DP
    public static JFramePharmacistMenu getInstance(){
        if (jfPharmMenSingInst == null){
            jfPharmMenSingInst = new JFramePharmacistMenu();
        }
        
        return jfPharmMenSingInst;
    }
    
    //the string that is passed in tells teh menu what to make visible and display in the North border
     public void setPharmNorthBorderString(String paneltoset){
        currentPharmNorthBordPanel = paneltoset;
        jfPharmMenSingInst.setPharmNorthBorderPanel();
    }
     
     private void setPharmNorthBorderPanel(){
         
         JPanelPresDisplayFromTo presToResolvSingInst = JPanelPresDisplayFromTo.getInstance();
         
         if (currentPharmNorthBordPanel == "ViewPresToResolve"){
             presToResolvSingInst.setVisible(true);
             
              jfPharmMenSingInst.add(presToResolvSingInst, BorderLayout.NORTH);
             
         }
         
         
         //repopulates the GUI
        revalidate();
        repaint();
      
     
     }
    
  
    
}
