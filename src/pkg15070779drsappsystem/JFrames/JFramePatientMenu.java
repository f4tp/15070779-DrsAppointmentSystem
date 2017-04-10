
package pkg15070779drsappsystem.JFrames;
import pkg15070779drsappsystem.ActionListeners.ActListLogOut;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import pkg15070779drsappsystem.JPanels.JPanelPatientRecordPatView;
import pkg15070779drsappsystem.JPanels.JPanelPatientRecordSecView;
public class JFramePatientMenu extends JFrame {
    private static JFramePatientMenu PatMenuSingInst;
    
    
    public JFramePatientMenu(){
        super ("Patient's menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanelPatientRecordPatView JPanelPatrecMenNorth = JPanelPatientRecordPatView.getInstance();
        JPanelPatrecMenNorth.setUpdateTextFields();
        
        JMenuBar pharmMenBar = new JMenuBar();
        setJMenuBar(pharmMenBar);
        
        JMenu fileMenu = new JMenu("File");
        pharmMenBar.add(fileMenu);
        
        JMenuItem logOutItem = new JMenuItem ("Logout");
        //logOutItem.addActionListener(new ActLisExitProg ());
        logOutItem.addActionListener(new ActListLogOut());
        fileMenu.add(logOutItem);
        
        
        
        
        
        
        
        JFrameAbsBorLayFillScreen.applyLayout(this);
 
        
        
        
        /*
        setLayout (new BorderLayout ());
         //code below sets the menu to the screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        pack();
        setBounds(0,0,screenSize.width, screenSize.height-40); //minus 40 for the task bar (which we want present)
      
        setVisible(true);
        */
        //JPanelPatrecMenNorth.setUpdateTextFields();
        
        add(JPanelPatrecMenNorth, BorderLayout.NORTH);
   
        
        //these have to be called otherwise the Jframe doesn't refresh and
         //the menu doesn't display
        setVisible(true);
      
        revalidate();
        repaint();
   
    }
    
    
    
     public static JFramePatientMenu getInstance(){
        if (PatMenuSingInst == null){
            PatMenuSingInst = new JFramePatientMenu();
        }
        return PatMenuSingInst;
    }
    
    
    public void setVisibility(boolean vis){
        
        this.setVisible(vis);
        
    }
    
}
