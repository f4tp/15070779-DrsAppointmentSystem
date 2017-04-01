package pkg15070779drsappsystem;

import java.awt.BorderLayout;
import javax.swing.*;


public class JPanelFindPatient extends JPanel {
    public static JPanelFindPatient FindPatSingInst;
    
    private JPanelFindPatient(){
       JLabel lblMessage = new JLabel ("ENTER THE DETAILS OF A PATIENT YOU ARE TRYING TO FIND");
       JButton btnRunReport = new JButton ("Run report");
       JTextField JTFSurname = new JTextField("test");
        
       setLayout (new BorderLayout ());
       add(lblMessage, BorderLayout.NORTH);
       add(JTFSurname, BorderLayout.CENTER);
       add(btnRunReport, BorderLayout.SOUTH);
    }
    
    public static JPanelFindPatient getInstance(){
         if (FindPatSingInst == null){
            FindPatSingInst = new JPanelFindPatient();
        }
        //panelRepDrsAppsSingInst.setVisible(true);
        return FindPatSingInst;
    }
    
    
    
}
