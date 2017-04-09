
package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu;

public class ActListNewAppointment implements ActionListener {
    
    public ActListNewAppointment(){
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrameSecretaryMenu SecMenuRef = JFrameSecretaryMenu.getInstance();
         SecMenuRef.setSecSouthBorderString("AddnewAppointmentPanel");
    }
    
}
