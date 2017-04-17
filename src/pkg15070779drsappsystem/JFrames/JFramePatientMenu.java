
package pkg15070779drsappsystem.JFrames;
import pkg15070779drsappsystem.ListenersAction.ActListLogoutSystem;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import pkg15070779drsappsystem.JPanels.JPanelPatRecordPatView;
public class JFramePatientMenu extends JFrame {
    private static JFramePatientMenu PatMenuSingInst;
    
    
    public JFramePatientMenu(){
        super ("Patient's menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanelPatRecordPatView JPanelPatrecMenNorth = JPanelPatRecordPatView.getInstance();
        JPanelPatrecMenNorth.setUpdateTextFields();
        
        JMenuBar pharmMenBar = new JMenuBar();
        setJMenuBar(pharmMenBar);
        
        JMenu fileMenu = new JMenu("File");
        pharmMenBar.add(fileMenu);
        
        JMenuItem logOutItem = new JMenuItem ("Logout");
        logOutItem.addActionListener(new ActListLogoutSystem());
        fileMenu.add(logOutItem);

        JFrameAbsBorLayFillScreen.applyLayout(this);

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

}
