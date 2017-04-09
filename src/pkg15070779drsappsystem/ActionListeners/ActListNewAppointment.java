
package pkg15070779drsappsystem.ActionListeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pkg15070779drsappsystem.JFrames.JFrameSecretaryMenu;

public class ActListNewAppointment implements ActionListener {
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrameSecretaryMenu menRef = JFrameSecretaryMenu.getInstance();
         menRef.setSecSouthBorderString("AddnewAppointmentPanel");
    }
    
}
