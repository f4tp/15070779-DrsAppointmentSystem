package pkg15070779drsappsystem.ListenersAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import javax.swing.JPanel;
import pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu;
import pkg15070779drsappsystem.MainClasses.MainDoctor;

public class ActListSetSecJFramePARTofFACTORYsec implements ActionListener {
    private String typeOfSecJPanToSet;
        
    public ActListSetSecJFramePARTofFACTORYsec(String typeofjpantoset){
        this.typeOfSecJPanToSet = typeofjpantoset;
       
        
    }
   
    
    public void actionPerformed(ActionEvent e){
         //get the single instance of the Sec menu and call the method on it 
        //with the right border to set - passed in from the menu option
        JFrameSecretaryMenu holder = JFrameSecretaryMenu.getInstance();
        holder.setSecSouthBorderString(this.typeOfSecJPanToSet);
        
        
        
        
    }
    

    
}

