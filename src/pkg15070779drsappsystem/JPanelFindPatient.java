package pkg15070779drsappsystem;

import java.awt.BorderLayout;
import javax.swing.*;


public class JPanelFindPatient extends JPanel {
    public static JPanelFindPatient FindPatSingInst;
    
    private JPanelFindPatient(){
       JLabel lblMessage = new JLabel ("ENTER THE SURNAME OF THE PATIENT");
       lblMessage.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
       
       JButton btnRunReport = new JButton ("Find Patient");
       btnRunReport.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
       
       JTextField JTFSurname = new JTextField();
       JTFSurname.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
       
       AddBoxPadUnderComp pad = new AddBoxPadUnderComp(JTFSurname);
       
       
       setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
       setLayout (new BorderLayout ());
       add(lblMessage, BorderLayout.NORTH);
       //add(JTFSurname, BorderLayout.CENTER);
       add(pad, BorderLayout.CENTER);
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
