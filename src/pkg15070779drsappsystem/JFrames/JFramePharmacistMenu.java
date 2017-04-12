package pkg15070779drsappsystem.JFrames;

import pkg15070779drsappsystem.ActionListeners.ActListSetSecJFramePARTofFACTORYsec;
import pkg15070779drsappsystem.ActionListeners.ActLisExitProg;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import pkg15070779drsappsystem.ActionListeners.ActListLogOut;

public class JFramePharmacistMenu extends JFrame {
    
    
    public JFramePharmacistMenu(){
        super ("Pharmacist's menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JMenuBar pharmMenBar = new JMenuBar();
        setJMenuBar(pharmMenBar);
        
        JMenu fileMenu = new JMenu("File");
        pharmMenBar.add(fileMenu);
        

        
        JMenuItem exitItem = new JMenuItem ("Exit");
        exitItem.addActionListener(new ActLisExitProg ());
        fileMenu.add(exitItem);
        
        JMenu patientMenu = new JMenu("Patients");
        pharmMenBar.add(patientMenu);
        
        JMenuItem findPatient = new JMenuItem ("Find Patient");
        findPatient.addActionListener(new ActListSetSecJFramePARTofFACTORYsec("FindPatients"));
        patientMenu.add(findPatient);
        
        JMenu reportMenu = new JMenu("Reports");
        pharmMenBar.add(reportMenu);
        
        JMenuItem runReportPrescs = new JMenuItem ("Monthly Prescriptions Reports");
        runReportPrescs.addActionListener(new ActListSetSecJFramePARTofFACTORYsec("MonthlyPrescs"));
        reportMenu.add(runReportPrescs);
        
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
    
}
