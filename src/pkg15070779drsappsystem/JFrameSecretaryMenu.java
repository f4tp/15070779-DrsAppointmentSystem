package pkg15070779drsappsystem;
import java.awt.*;
import javax.swing.*;

public class JFrameSecretaryMenu extends JFrame {
    
    public JFrameSecretaryMenu(){
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
        //exitItem.addActionListener(new ExitListener ()); 
        appsMenu.add(newApp);
        
        JMenu patientMenu = new JMenu("Patients");
        secMenBar.add(patientMenu);
        
        JMenuItem findPatient = new JMenuItem ("Find Patient");
        //exitItem.addActionListener(new ExitListener ()); 
        patientMenu.add(findPatient);
      
      //code below sets the menu to the screen size
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      pack();
      setBounds(0,0,screenSize.width, screenSize.height-40); //minus 40 for the task bar (which we want present)
      
      setVisible(true);
      
        
        
    }
    
    
}
