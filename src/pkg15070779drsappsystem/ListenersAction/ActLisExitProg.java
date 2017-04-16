package pkg15070779drsappsystem.ListenersAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ActLisExitProg implements ActionListener {
    
    public ActLisExitProg(){
        super();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
         if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(null,"Are you sure you wish to exit?",
         "Do you wish to exit?",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)) {
            System.exit(0);
         } 
         
       else {
             //do nothing 
       }

    
    
}}
